/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.controller;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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

    private Recrutamento recrutamento;
    private RecrutamentoDAO dao = new RecrutamentoDAO();
    private DataModel recrutamentos;
    private boolean showNewButton = true;  
  

    public RecrutamentoBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Recrutamento getRecrutamento() {
        if (recrutamento==null){
            recrutamento = new Recrutamento();
            recrutamento.setRecInicio(new Date());
        }
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
        this.recrutamentos = new ListDataModel(dao.findAll());
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
    
    public String altera_status(int status, Recrutamento r) {
        this.setRecrutamento(r);
        recrutamento.setRecStatus(status);
        dao.update(recrutamento);
        return "recrutamentolst";
    }

    public String delete(Recrutamento r) {
        dao.delete(r);
        return "recrutamentolst";
    }

    public String salvar(String pagina) {
        if (recrutamento.getRecCodigo() > 0) {
            dao.update(recrutamento);
        } else {
            dao.insert(recrutamento);
        }
        return pagina;
    }

    public String listar() {
        return "recrutamentolst";
    }
public boolean getShowNewButton(){  
   return showNewButton;  
}  
  
public void showForm(){  
    this.showNewButton = false;  
}  
  
public void saveForm(){  
     this.showNewButton = true;  
}  
  }
