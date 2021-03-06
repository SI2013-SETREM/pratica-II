package ad.controller;

import ad.dao.AvaliacaoDAO;
import ad.dao.PerguntaPessoaAvaliacaoDAO;
import ad.dao.PessoasAvaliacaoDAO;
import ad.model.Avaliacao;
import ad.model.PerguntaPessoaAvaliacao;
import ad.model.PessoasAvaliacao;
import cfg.controller.LoginBean;
import cfg.dao.LogDAO;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import rs.dao.QuestionarioDAO;
import rs.model.Pergunta;
import rs.model.PerguntaOpcao;
import util.Utilidades;

@ManagedBean
@SessionScoped
public class PerguntaPessoaAvaliacaoBean {

    private final String sTitle = "Avaliado";
    private final String pTitle = "Avaliados";
    private String Detail = "Detalhes";
    private String ErroMsg = "";
    private String Desempenho = "0%";
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
    private int userId = UserCod();
    private int idAvaliacao;
    private int idColaborador;

    private int UserCod() {
        LoginBean loginB = (LoginBean) Utilidades.getSessionObject("loginBean");
        if (loginB != null && loginB.getUsuario() != null && loginB.getUsuario().getPessoa() != null) {
            return loginB.getUsuario().getPessoa().getPes_codigo();
        } else {
            return -1;
        }
    }

    public PerguntaPessoaAvaliacaoBean() {
    }

//    public DataModel getLsPerguntasAvaliacao() {
//        return LsPerguntasAvaliacao;
//    }
//
//    public void setLsPerguntasAvaliacao(DataModel LsPerguntasAvaliacao) {
//        this.LsPerguntasAvaliacao = LsPerguntasAvaliacao;
//    }
//    public String GetPerguntasAvaliacao(Avaliacao avalicao) {
//        Questionario questionario = questDao.findById(avalicao.getQuestionario().getQstCodigo());
//        LsPerguntasAvaliacao = new ListDataModel(questionario.getPerguntas());
//        return "pessoasavaliacaodls";
//    }
    public List<PerguntaPessoaAvaliacao> getLsPerguntasP() {//Lista questões para avaliar
        return lsPerguntasP;
    }

    public String salvar() {
        if (lsPerguntasP != null && !lsPerguntasP.isEmpty()) {
            int media = 0;
            int length = 0;
            for (PerguntaPessoaAvaliacao PergResp : lsPerguntasP) {
                length += 1;
                if (PergResp.getPergunta().getPrgTipo() == 2) {
                    for (PerguntaOpcao opt : PergResp.getPergunta().getPerguntaOpcoes()) {
                        if (opt.getOpcCodigo() == Integer.parseInt(PergResp.getPpa_resposta())) {
                            PergResp.setPpa_resposta(opt.getOpcNome());
                            PergResp.setPpa_pontuacao(opt.getOpcPontuacao());
                            //media += Integer.parseInt(PergResp.getPpa_resposta());
                            break;
                        }
                    }
                }
                PergResp.setPpa_pergunta(PergResp.getPergunta().getPrgPergunta());
                media += PergResp.getPpa_pontuacao();
                dao.insert(PergResp);
                LogDAO.insert("PerguntaPessoaAvaliacao", "Cadastrou Pergunta Pessoa Avaliacao");
            }
            PessoasAvaliacao pessoA = PesAvaldao.GetListPessoasAvaliacao(avaliacao.getAva_codigo(), avaliado.getPes_codigo(), userId, true, false).get(0);
            pessoA.setPea_datahora_resposta(new Date());
            pessoA.setPea_media(length > 0 ? Math.round(media / length) : 0);
            PesAvaldao.update(pessoA);
        }
        //LsPerguntas();
        return "pessoasavaliacaofrm";
    }

    private void LsPerguntas() {
        List<PerguntaPessoaAvaliacao> lsPergPes = new ArrayList<>();
        List<PessoasAvaliacao> lsPessoas = PesAvaldao.GetListPessoasAvaliacao(idAvaliacao, 0, userId, true, false);
        avaliacao = avaDao.findById(idAvaliacao);
        if (lsPessoas != null && !lsPessoas.isEmpty()) {
            avaliado = lsPessoas.get(0).getColaboradorAvaliado();
            ErroMsg = "";
        } else {
            ErroMsg = "Não tem mais colaboradores para avaliar nesta avaliação!";
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
                    PergPes.setPpa_pergunta(pergunt.getPrgPergunta());
                    lsPergPes.add(PergPes);
                }
            }
            lsPerguntasP = lsPergPes;
        }
    }

    public Pessoa getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(Pessoa avaliado) {
        this.avaliado = avaliado;
    }

    public void GetAvaliados() {
//        List<PessoasAvaliacao> lsPessoas = PesAvaldao.GetListPessoasAvaliacao(idAvaliacao, 0, userId, true, false);
//        if (lsPessoas != null && !lsPessoas.isEmpty()) {
//            avaliado = lsPessoas.get(0).getColaboradorAvaliado();
//        }
        LsPerguntas();
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
        int atual = 0;
        if (lsPPA2 != null && !lsPPA2.isEmpty()) {
            for (PerguntaPessoaAvaliacao ppa : lsPPA2) {
                if (!ids.contains(ppa.getPergunta().getPrgCodigo())) {
                    ids.add(ppa.getPergunta().getPrgCodigo());
                    lsPPA1.add(ppa);
                }
                atual += ppa.getPpa_pontuacao();
            }
            int max = lsPPA2.get(0).getPergunta().getQuestionario().getQstPontuacaomax();
            float maxSize = max * lsPPA2.size();
            float des = atual / maxSize;
            float des2 = des * 100;
            Desempenho = Math.round(des2) + "%";
        }
        this.lsPerguntasP = lsPPA1;
        this.lsRespostasDetail = lsPPA2;
        this.avaliado = pesDao.findById(idColaborador);
        this.avaliacao = avaDao.findById(idAvaliacao);
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

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setDesempenho(String Desempenho) {
        this.Desempenho = Desempenho;
    }

    public String getDesempenho() {
        return Desempenho;
    }

}
