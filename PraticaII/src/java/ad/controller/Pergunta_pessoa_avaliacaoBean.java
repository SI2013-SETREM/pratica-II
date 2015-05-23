/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad.controller;

import ad.dao.Pergunta_pessoa_avaliacaoDAO;
import ad.model.Pergunta_pessoa_avaliacao;
import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class Pergunta_pessoa_avaliacaoBean {

    Pergunta_pessoa_avaliacao perguntaPessoaAvaliacao = new Pergunta_pessoa_avaliacao();
    Pergunta_pessoa_avaliacaoDAO DAO = new Pergunta_pessoa_avaliacaoDAO();

    public Pergunta_pessoa_avaliacaoBean() {
    }

}
