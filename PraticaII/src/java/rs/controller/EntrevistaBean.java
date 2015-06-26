/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import rs.dao.EntrevistaDAO;
import rs.model.Entrevista;
import rs.model.Recrutamento;
import rs.model.RecrutamentoPessoa;

/**
 *
 * @author NADINE
 */
@ManagedBean
@SessionScoped
public class EntrevistaBean {

    private final String sTitleEntrevista = Entrevista.sTitle;
    private final String pTitleEntrevistas = Entrevista.pTitle;
    
    private Entrevista entrevista = new Entrevista();
    private EntrevistaDAO dao = new EntrevistaDAO();
    private DataModel entrevistas;

    public EntrevistaBean() {
    }

    public Entrevista getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(Entrevista entrevista) {
        this.entrevista = entrevista;
    }

    public EntrevistaDAO getDaoEntrevista() {
        return dao;
    }

    public void setDaoEntrevista(EntrevistaDAO dao) {
        this.dao = dao;
    }

    public DataModel getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(DataModel entrevistas) {
        this.entrevistas = entrevistas;
    }

    
    public String insertEntrevista() {
        dao.insert(entrevista);
        return "recrutamentoEntrevistafrm?faces-redirect=true";
    }

    public String editEntrevista(Entrevista e) {
        entrevista = (Entrevista) entrevistas.getRowData();
        return "recrutamentoEntrevistafrm?faces-redirect=true";
    }

    public String updateEntrevista() {
        dao.update(entrevista);
        return "recrutamentoEntrevistafrm?faces-redirect=true";
    }

    public String deleteEntrevista(Entrevista i) {
        dao.delete(i);
        return "recrutamentoEntrevistafrm?faces-redirect=true";
    }

    public String salvarEntrevista() {
        if (entrevista.getEntCodigo()> 0) {
            dao.update(entrevista);
        } else {
            dao.insert(entrevista);
        }
        return "recrutamentoEntrevistafrm?faces-redirect=true";
    }

    public String listar() {
        return "idiomalst";
    }

}
