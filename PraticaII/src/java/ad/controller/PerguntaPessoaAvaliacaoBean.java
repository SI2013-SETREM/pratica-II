package ad.controller;

import ad.dao.PerguntaPessoaAvaliacaoDAO;
import ad.model.Avaliacao;
import ad.model.PerguntaPessoaAvaliacao;
import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.dao.QuestionarioDAO;
import rs.model.Questionario;

@ManagedBean
@RequestScoped
public class PerguntaPessoaAvaliacaoBean {

    PerguntaPessoaAvaliacao perguntaPessoaAvaliacao = new PerguntaPessoaAvaliacao();
    PerguntaPessoaAvaliacaoDAO DAO = new PerguntaPessoaAvaliacaoDAO();

    private DataModel LsPerguntasAvaliacao;

    public PerguntaPessoaAvaliacaoBean() {
    }

    public DataModel getLsPerguntasAvaliacao() {
        return LsPerguntasAvaliacao;
    }

    public void setLsPerguntasAvaliacao(DataModel LsPerguntasAvaliacao) {
        this.LsPerguntasAvaliacao = LsPerguntasAvaliacao;
    }

    public String GetPerguntasAvaliacao(Avaliacao avalicao) {

        QuestionarioDAO questionarioDAO =new QuestionarioDAO();
        Questionario questionario = questionarioDAO.findById(avalicao.getQuestionario().getQstCodigo());
        ///List<Pergunta>lsPerg
//        if(!questionario.getPerguntas().isEmpty()){
//            for (Pergunta pergnta : questionario.getPerguntas() ) {
//            }
//        }
        
        LsPerguntasAvaliacao = new ListDataModel(questionario.getPerguntas());
        
        return "pessoasavaliacaodls";
    }

}
