/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad.controller;

import ad.dao.Pessoas_avaliacaoDAO;
import ad.model.Pessoas_avaliacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class Pessoas_avaliacaoBean {

    private Pessoas_avaliacao pessoas_avaliacao = new Pessoas_avaliacao();
    private Pessoas_avaliacaoDAO dao = new Pessoas_avaliacaoDAO();
    private DataModel pessoas_avaliacoes;

    public Pessoas_avaliacaoBean() {
    }

    public Pessoas_avaliacao getPessoas_avaliacao() {
        return pessoas_avaliacao;
    }

    public void setPessoas_avaliacao(Pessoas_avaliacao pessoas_avaliacao) {
        this.pessoas_avaliacao = pessoas_avaliacao;
    }

    public DataModel getAvaliacoes() {
        this.pessoas_avaliacoes = new ListDataModel(dao.findAll());
        return pessoas_avaliacoes;
    }

    public void setAvaliacoes(DataModel avaliacoes) {
        this.pessoas_avaliacoes = avaliacoes;
    }

    public String insert() {
        dao.insert(pessoas_avaliacao);
        return " pessoas_avaliacaolst";
    }

    public String edit(Pessoas_avaliacao i) {
        pessoas_avaliacao = (Pessoas_avaliacao) pessoas_avaliacoes.getRowData();
        return " pessoas_avaliacaofrm";
    }

    public String update() {
        dao.update(pessoas_avaliacao);
        return " pessoas_avaliacaolst";
    }

    public String delete(Pessoas_avaliacao i) {
        dao.delete(i);
        return "pessoas_avaliacaolst";
    }

    public String salvar() {
        if (true) {
            dao.update(pessoas_avaliacao);
        } else {
            dao.insert(pessoas_avaliacao);
        }

        return "pessoas_avaliacaolst";
    }

    public String listar() {
        return "pessoas_avaliacaolst";
    }

}
