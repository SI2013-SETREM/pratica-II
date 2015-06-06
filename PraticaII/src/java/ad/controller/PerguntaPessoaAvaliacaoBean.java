package ad.controller;

import ad.dao.PerguntaPessoaAvaliacaoDAO;
import ad.model.PerguntaPessoaAvaliacao;
import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PerguntaPessoaAvaliacaoBean {

    PerguntaPessoaAvaliacao perguntaPessoaAvaliacao = new PerguntaPessoaAvaliacao();
    PerguntaPessoaAvaliacaoDAO DAO = new PerguntaPessoaAvaliacaoDAO();

    public PerguntaPessoaAvaliacaoBean() {
    }
    
    
    
    

}
