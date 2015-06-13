package ad.controller;

import ad.dao.AvaliacaoDAO;
import ad.dao.PerguntaPessoaAvaliacaoDAO;
import ad.dao.PessoasAvaliacaoDAO;
import ad.model.Avaliacao;
import ad.model.PerguntaPessoaAvaliacao;
import ad.model.PessoasAvaliacao;
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

@ManagedBean
@SessionScoped
public class PerguntaPessoaAvaliacaoBean {

    private final String sTitle = "Avaliado";
    private final String pTitle = "Avaliado";
    PerguntaPessoaAvaliacao perguntaPessoaAvaliacao = new PerguntaPessoaAvaliacao();
    PerguntaPessoaAvaliacaoDAO dao = new PerguntaPessoaAvaliacaoDAO();
    private PessoasAvaliacaoDAO PesAvaldao = new PessoasAvaliacaoDAO();
    private Pessoa avaliado;
    private Avaliacao avaliacao;
    private AvaliacaoDAO avaDao = new AvaliacaoDAO();
    private List<PerguntaPessoaAvaliacao> lsPerguntasP;
    private DataModel lsPerguntasPessoa;
    private DataModel LsPerguntasAvaliacao;
    private int userId = 3;

    public PerguntaPessoaAvaliacaoBean() {
    }

    public DataModel getLsPerguntasAvaliacao() {
        return LsPerguntasAvaliacao;
    }

    public void setLsPerguntasAvaliacao(DataModel LsPerguntasAvaliacao) {
        this.LsPerguntasAvaliacao = LsPerguntasAvaliacao;
    }

    public String GetPerguntasAvaliacao(Avaliacao avalicao) {
        QuestionarioDAO questionarioDAO = new QuestionarioDAO();
        Questionario questionario = questionarioDAO.findById(avalicao.getQuestionario().getQstCodigo());
        ///List<Pergunta>lsPerg
//        if(!questionario.getPerguntas().isEmpty()){
//            for (Pergunta pergnta : questionario.getPerguntas() ) {
//            }
//        }

        LsPerguntasAvaliacao = new ListDataModel(questionario.getPerguntas());
        return "pessoasavaliacaodls";
    }

    public String salvar() {
        if (lsPerguntasP != null && !lsPerguntasP.isEmpty()) {
            int media = 0;
            int length = 0;
            for (PerguntaPessoaAvaliacao PergResp : lsPerguntasP) {
                length += 1;
                media += PergResp.getPpa_pontuacao();
                dao.insert(PergResp);
            }
            PessoasAvaliacao pessoA = PesAvaldao.GetListPessoasAvaliacao(avaliacao.getAva_codigo(), avaliado.getPes_codigo(), userId, true).get(0);
            pessoA.setPea_datahora_resposta(new Date());
            pessoA.setPea_media(Math.ceil(media / length));
            PesAvaldao.update(pessoA);
        }
        return "pessoasavaliacaofrm";
    }

    public List<PerguntaPessoaAvaliacao> getLsPerguntasPessoa() {
        LsPerguntas();
        return lsPerguntasP;
    }

    private void LsPerguntas() {
        if (lsPerguntasP == null) {
            List<PerguntaPessoaAvaliacao> lsPergPes = new ArrayList<>();
            List<PessoasAvaliacao> lsPessoas = PesAvaldao.GetListPessoasAvaliacao(avaliacao.getAva_codigo(), 0, userId, true);
            if (lsPessoas != null && !lsPessoas.isEmpty()) {
                avaliado = lsPessoas.get(0).getColaboradorAvaliado();
            }
            if (avaliacao.getQuestionario() != null && avaliacao.getQuestionario().getPerguntas() != null && !avaliacao.getQuestionario().getPerguntas().isEmpty()) {
                for (Pergunta pergunt : avaliacao.getQuestionario().getPerguntas()) {
                    PerguntaPessoaAvaliacao PergPes = new PerguntaPessoaAvaliacao();
                    PergPes.setAvaliacao(avaliacao);
                    PergPes.setAvaliador(avaliado);
                    PergPes.setColaboradorAvaliado(avaliado);
                    PergPes.setPergunta(pergunt);
                    lsPergPes.add(PergPes);
                }
                lsPerguntasP = lsPergPes;
            }
        }
    }

    public Pessoa getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(Pessoa avaliado) {
        this.avaliado = avaliado;
    }

    public String GetAvaliados(Avaliacao a) {
        avaliacao = a;
        List<PessoasAvaliacao> lsPessoas = PesAvaldao.GetListPessoasAvaliacao(avaliacao.getAva_codigo(), 0, userId, true);
        if (lsPessoas != null && !lsPessoas.isEmpty()) {
            avaliado = lsPessoas.get(0).getColaboradorAvaliado();
        }
        return "pessoasavaliacaofrm";
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

}
