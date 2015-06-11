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

    private Recrutamento recrutamento = new Recrutamento();
    private RecrutamentoDAO dao = new RecrutamentoDAO();
    private DataModel recrutamentos;
    private String rec_tipoDesc;
    private String rec_statusDesc;

    public RecrutamentoBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Recrutamento getRecrutamento() {
        if (recrutamento == null) {
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

    public String delete(Recrutamento r) {
        dao.delete(r);
        return "recrutamentolst";
    }

    public String salvar() {
        if (recrutamento.getRecCodigo() > 0) {
            dao.update(recrutamento);
        } else {
            dao.insert(recrutamento);
        }

        return "recrutamentolst";
    }

    public String listar() {
        return "recrutamentolst";
    }

    public String getRec_tipoDesc() {
        if (recrutamento.getRecTipo() == 1) {
            rec_tipoDesc = "Interno";
        } else if (recrutamento.getRecTipo() == 2) {
            rec_tipoDesc = "Externo";
        } else if (recrutamento.getRecTipo() == 3) {
            rec_tipoDesc = "Misto";
        }
        return rec_tipoDesc;
    }

    public void setRec_tipoDesc(String rec_tipoDesc) {
        this.rec_tipoDesc = rec_tipoDesc;
    }

    public String getRec_statusDesc() {
        if (recrutamento.getRecStatus() == 1) {
            rec_statusDesc = "Aguardando início";
        } else if (recrutamento.getRecStatus() == 2) {
            rec_statusDesc = "Buscando candidatos";
        } else if (recrutamento.getRecStatus() == 3) {
            rec_statusDesc = "Avaliando candidatos";
        } else if (recrutamento.getRecStatus() == 4) {
            rec_statusDesc = "Candidatos selecionados";
        } else if (recrutamento.getRecStatus() == 5) {
            rec_statusDesc = "Treinamento";
        } else if (recrutamento.getRecStatus() == 6) {
            rec_statusDesc = "Concluído";
        } else if (recrutamento.getRecStatus() == 7) {
            rec_statusDesc = "Cancelado";
        }
        return rec_statusDesc;
    }

    public void setRec_statusDesc(String rec_statusDesc) {
        this.rec_statusDesc = rec_statusDesc;
    }
}
