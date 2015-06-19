package ad.controller;

import ad.dao.AvaliacaoDAO;
import ad.dao.PerguntaPessoaAvaliacaoDAO;
import ad.dao.PessoasAvaliacaoDAO;
import ad.model.Avaliacao;
import ad.model.PerguntaPessoaAvaliacao;
import ad.model.PessoasAvaliacao;
import cfg.controller.LoginBean;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.dao.QuestionarioDAO;
import rs.model.Pergunta;
import rs.model.Questionario;
import util.Utilidades;

@ManagedBean
@SessionScoped
public class PerguntaPessoaAvaliacaoBean {

    private final String sTitle = "Avaliado";
    private final String pTitle = "Avaliados";
    private String Detail = "Detalhes";
    private String ErroMsg = "";
    private PerguntaPessoaAvaliacao perguntaPessoaAvaliacao = new PerguntaPessoaAvaliacao();
    private PerguntaPessoaAvaliacaoDAO dao = new PerguntaPessoaAvaliacaoDAO();
    private PessoasAvaliacaoDAO PesAvaldao = new PessoasAvaliacaoDAO();
    private Pessoa avaliado;
    private PessoaDAO pesDao = new PessoaDAO();
    private Avaliacao avaliacao;
    private AvaliacaoDAO avaDao = new AvaliacaoDAO();
    private QuestionarioDAO questDao = new QuestionarioDAO();
    private List<PerguntaPessoaAvaliacao> lsPerguntasP;
    private List<PerguntaPessoaAvaliacao> lsRespostasDetail;
    private List<PessoasAvaliacao> lsPessoasAvaliacao;
    private DataModel lsPerguntasPessoa;
    private DataModel LsPerguntasAvaliacao;
    private LoginBean loginB = (LoginBean) Utilidades.getSessionObject("loginBean");
    private int userId = UserCod();

    private int idAvaliacao;
    private int idColaborador;

    private int UserCod() {
        if (loginB != null && loginB.getUsuario() != null && loginB.getUsuario().getPessoa() != null) {
            return loginB.getUsuario().getPessoa().getPes_codigo();
        } else {
            return -1;
        }
    }

    public PerguntaPessoaAvaliacaoBean() {
    }

    public DataModel getLsPerguntasAvaliacao() {
        return LsPerguntasAvaliacao;
    }

    public void setLsPerguntasAvaliacao(DataModel LsPerguntasAvaliacao) {
        this.LsPerguntasAvaliacao = LsPerguntasAvaliacao;
    }

    public List<PerguntaPessoaAvaliacao> getLsPerguntasPessoa() {//Lista questões para avaliar
        System.out.println("GetLsPerguntaPessoas");
        LsPerguntas();//Cria lista de PerguntasPessoasAvaliação a partir de avaliação
        return lsPerguntasP;
    }

    public String salvar() {
        System.out.println("SALVAR");
        if (lsPerguntasP != null && !lsPerguntasP.isEmpty()) {
            int media = 0;
            int length = 0;
            for (PerguntaPessoaAvaliacao PergResp : lsPerguntasP) {
                length += 1;
//                if (PergResp.getPergunta().getPrgTipo() == 2) {
//                    media += Integer.parseInt(PergResp.getPpa_resposta());
//                } else {
                media += PergResp.getPpa_pontuacao();
                //}
                dao.insert(PergResp);
            }
            PessoasAvaliacao pessoA = PesAvaldao.GetListPessoasAvaliacao(avaliacao.getAva_codigo(), avaliado.getPes_codigo(), userId, true).get(0);
            pessoA.setPea_datahora_resposta(new Date());
            if (length > 0) {
                pessoA.setPea_media(media / length);
            } else {
                pessoA.setPea_media(0);
            }
            PesAvaldao.update(pessoA);
        }
        LsPerguntas();
        return "pessoasavaliacaofrm";
    }

    public String GetPerguntasAvaliacao(Avaliacao avalicao) {
        Questionario questionario = questDao.findById(avalicao.getQuestionario().getQstCodigo());
        ///List<Pergunta>lsPerg
//        if(!questionario.getPerguntas().isEmpty()){
//            for (Pergunta pergnta : questionario.getPerguntas() ) {
//            }
//        }

        LsPerguntasAvaliacao = new ListDataModel(questionario.getPerguntas());
        return "pessoasavaliacaodls";
    }

    private void LsPerguntas() {
        //if (lsPerguntasP == null) {
        //lsPerguntasP = new ArrayList<>();
        List<PerguntaPessoaAvaliacao> lsPergPes = new ArrayList<>();
        List<PessoasAvaliacao> lsPessoas = PesAvaldao.GetListPessoasAvaliacao(idAvaliacao, 0, userId, true);
        avaliacao = avaDao.findById(idAvaliacao);
        if (lsPessoas != null && !lsPessoas.isEmpty()) {
            avaliado = lsPessoas.get(0).getColaboradorAvaliado();
            ErroMsg = "";
        } else {
            ErroMsg = "Não tem mais colaboradores para avalair nesta avaliação!";
            avaliado = null;
        }
        if (avaliacao.getQuestionario() != null && avaliacao.getQuestionario().getPerguntas() != null && !avaliacao.getQuestionario().getPerguntas().isEmpty()) {
            for (Pergunta pergunt : avaliacao.getQuestionario().getPerguntas()) {
                if (pergunt.isPrgExibircandidato()) {
                    PerguntaPessoaAvaliacao PergPes = new PerguntaPessoaAvaliacao();
                    PergPes.setAvaliacao(avaliacao);
                    Pessoa AvaUser = new Pessoa();
                    AvaUser.setPes_codigo(userId);
                    PergPes.setAvaliador(AvaUser);
                    PergPes.setColaboradorAvaliado(avaliado);
                    PergPes.setPergunta(pergunt);
                    lsPergPes.add(PergPes);
                }
            }
            lsPerguntasP = lsPergPes;
//                lsPerguntasPessoa = new ListDataModel(lsPerguntasP);
            // }
        }
    }

    public Pessoa getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(Pessoa avaliado) {
        this.avaliado = avaliado;
    }

    public void GetAvaliados() {
        List<PessoasAvaliacao> lsPessoas = PesAvaldao.GetListPessoasAvaliacao(idAvaliacao, 0, userId, true);
        if (lsPessoas != null && !lsPessoas.isEmpty()) {
            avaliado = lsPessoas.get(0).getColaboradorAvaliado();
        }
        //return "pessoasavaliacaofrm";
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public String listar() {
        return "avaliacoespendenteslst";
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getErroMsg() {
        return ErroMsg;
    }

    public void getDetails() {
        List<PerguntaPessoaAvaliacao> lsPPA1 = new ArrayList();
        List<PerguntaPessoaAvaliacao> lsPPA2 = dao.ListPerguntasPessoasAvaliacao(idAvaliacao, idColaborador, 0);
        List<Integer> ids = new ArrayList();
        if (lsPPA2 != null && !lsPPA2.isEmpty()) {
            for (PerguntaPessoaAvaliacao ppa : lsPPA2) {
                if (!ids.contains(ppa.getPergunta().getPrgCodigo())) {
                    ids.add(ppa.getPergunta().getPrgCodigo());
                    lsPPA1.add(ppa);
                }
            }
        }
        this.lsRespostasDetail = lsPPA1;
        this.avaliado = pesDao.findById(idColaborador);
    }

    public List<PerguntaPessoaAvaliacao> DadosPessoa(int per_id) {
        return dao.ListPerguntasPessoasAvaliacao(idAvaliacao, idColaborador, per_id);
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public List<PerguntaPessoaAvaliacao> getLsRespostasDetail() {
        return lsRespostasDetail;
    }

    public List<PessoasAvaliacao> getLsPessoasAvaliacao() {
        return lsPessoasAvaliacao;
    }

    public String getDetail() {
        return Detail;
    }

}
