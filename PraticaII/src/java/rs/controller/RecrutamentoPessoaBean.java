/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.dao.RecrutamentoPessoasDAO;
import rs.model.Recrutamento;
import rs.model.RecrutamentoPessoa;

/**
 *
 * @author NADINE
 */
@ManagedBean
@RequestScoped
public class RecrutamentoPessoaBean {

    private final String sTitle = RecrutamentoPessoa.sTitle;
    private final String pTitle = RecrutamentoPessoa.pTitle;

    private RecrutamentoPessoa recrutamentoPessoa;
    private RecrutamentoPessoasDAO dao = new RecrutamentoPessoasDAO();
    private DataModel recrutamentoPessoas;
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO daoPes = new PessoaDAO();
    private DataModel pessoas;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public DataModel getPessoas() {
        this.pessoas = new ListDataModel(daoPes.findAll());
        return pessoas;
    }

    public void setPessoas(DataModel pessoas) {
        this.pessoas = pessoas;
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public RecrutamentoPessoa getRecrutamentoPessoa() {
        recrutamentoPessoa = new RecrutamentoPessoa();
        return recrutamentoPessoa;
    }

    public void setRecrutamentoPessoa(RecrutamentoPessoa recrutamentoPessoa) {
        this.recrutamentoPessoa = recrutamentoPessoa;
    }

    public RecrutamentoPessoasDAO getDao() {
        return dao;
    }

    public void setDao(RecrutamentoPessoasDAO dao) {
        this.dao = dao;
    }

    public DataModel getRecrutamentosPessoa() {
        this.recrutamentoPessoas = new ListDataModel(dao.findAll());
        return recrutamentoPessoas;
    }

    public void setRecrutamentosPessoa(DataModel recrutamentosPessoa) {
        this.recrutamentoPessoas = recrutamentosPessoa;
    }

    public String insert() {
        dao.insert(recrutamentoPessoa);
        return "recrutamentolst";
    }

    public String edit(Recrutamento r, String pagina) {
        recrutamentoPessoa = (RecrutamentoPessoa) recrutamentoPessoas.getRowData();
        return pagina;
    }

    public String update() {
        dao.update(recrutamentoPessoa);
        return "recrutamentolst";
    }

    public String delete(RecrutamentoPessoa r) {
        dao.delete(r);
        return "recrutamentolst";
    }

    public String salvar(String pagina) {
        if (recrutamentoPessoa != null) {
            dao.update(recrutamentoPessoa);
        } else {
            dao.insert(recrutamentoPessoa);
        }
        return pagina;
    }

    public String listar() {
        return "recrutamentolst";
    }

}
