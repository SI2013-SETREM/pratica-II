/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad.controller;

import ad.dao.PessoasAvaliacaoDAO;
import ad.model.PessoasAvaliacao;
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
public class PessoasAvaliacaoBean {

    private PessoasAvaliacao pessoas_avaliacao = new PessoasAvaliacao();
    private PessoasAvaliacaoDAO dao = new PessoasAvaliacaoDAO();
    private DataModel pessoas_avaliacoes;

    public PessoasAvaliacaoBean() {
    }

    public PessoasAvaliacao getPessoas_avaliacao() {
        return pessoas_avaliacao;
    }

    public void setPessoas_avaliacao(PessoasAvaliacao pessoas_avaliacao) {
        this.pessoas_avaliacao = pessoas_avaliacao;
    }

    public DataModel getPessoaAvaliacoes() {
        this.pessoas_avaliacoes = new ListDataModel(dao.findAll());
        return pessoas_avaliacoes;
    }

    public void setPessoaAvaliacoes(DataModel pessoas_avaliacoes) {
        this.pessoas_avaliacoes = pessoas_avaliacoes;
    }

    public String insert() {
        dao.insert(pessoas_avaliacao);
        return "pessoasavaliacaolst";
    }

    public String edit(PessoasAvaliacao i) {
        pessoas_avaliacao = (PessoasAvaliacao) pessoas_avaliacoes.getRowData();
        return "pessoasavaliacaofrm";
    }

    public String details(PessoasAvaliacao i) {
        pessoas_avaliacao = (PessoasAvaliacao) pessoas_avaliacoes.getRowData();
        return "pessoasavaliacaodls";
    }

    public String update() {
        dao.update(pessoas_avaliacao);
        return "pessoasavaliacaolst";
    }

    public String delete(PessoasAvaliacao i) {
        dao.delete(i);
        return "pessoasavaliacaolst";
    }

    public String salvar() {
        if (true) {
            dao.update(pessoas_avaliacao);
        } else {
            dao.insert(pessoas_avaliacao);
        }

        return "pessoasavaliacaolst";
    }

    public String listar() {

        return "pessoasavaliacaolst";
    }

}
