/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import rs.dao.RecrutamentoDAO;
import rs.model.Recrutamento;

/**
 *
 * @author NADINE
 */
@ManagedBean
@RequestScoped
public class RecrutamentoBean {
     private final String sTitle = Recrutamento.sTitle;
    private final String pTitle = Recrutamento.pTitle;
    
    private Recrutamento recrutamento = new Recrutamento();
    private RecrutamentoDAO dao = new RecrutamentoDAO();
    private DataModel recrutamentos;
    
    public RecrutamentoBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Recrutamento getRecrutamento() {
        return recrutamento;
    }

    public void setRecrutamento(Recrutamento recrutamento) {
        this.recrutamento = recrutamento;
    }

    public RecrutamentoDAO getDao() {
        return dao;
    }

    public void setDao(RecrutamentoDAO dao) {
        this.dao = dao;
    }

    public DataModel getRecrutamentos() {
        return recrutamentos;
    }

    public void setRecrutamentos(DataModel recrutamentos) {
        this.recrutamentos = recrutamentos;
    }
        
    
    public String insert() {
        dao.insert(recrutamento);
        return "recrutamentolst";
    }
    
    public String edit(Recrutamento r) {
        recrutamento = (Recrutamento) recrutamentos.getRowData();
        return "recrutamentolst";
    }
    
    public String update() {
        dao.update(recrutamento);
        return "recrutamentolst";
    }
    
    public String delete(Recrutamento r) {
        dao.delete(r);
        return "recrutamentolst";
    }
    
    public String salvar() {
        if (recrutamento.getRecCodigo()> 0)
            dao.update(recrutamento);
        else 
            dao.insert(recrutamento);
        
        return "recrutamentolst";
    }
    
    public String listar() {
        return "recrutamentolst";
    }
    
}
