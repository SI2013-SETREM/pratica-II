/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad.controller;

import ad.dao.PerguntaPessoaAvaliacaoDAO;
import ad.model.PerguntaPessoaAvaliacao;
import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class PerguntaPessoaAvaliacaoBean {

    PerguntaPessoaAvaliacao perguntaPessoaAvaliacao = new PerguntaPessoaAvaliacao();
    PerguntaPessoaAvaliacaoDAO DAO = new PerguntaPessoaAvaliacaoDAO();

    public PerguntaPessoaAvaliacaoBean() {
    }
    
    
    
    

}
