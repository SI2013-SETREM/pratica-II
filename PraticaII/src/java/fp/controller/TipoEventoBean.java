/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.controller;


import fp.dao.TipoEventoDAO;
import fp.model.TipoEvento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Edivan
 */
@ManagedBean
@RequestScoped
public class TipoEventoBean {
     
    
    private final String sTitle = TipoEvento.sTitle;
    private final String pTitle = TipoEvento.pTitle;
    
    private TipoEvento tipoevento = new TipoEvento();
    private TipoEventoDAO dao = new TipoEventoDAO();
    private DataModel tiposdeevento;
    
    public TipoEventoBean(){

}
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public TipoEvento getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(TipoEvento tipoevento) {
        this.tipoevento = tipoevento;
    }

    public TipoEventoDAO getDao() {
        return dao;
    }

    public void setDao(TipoEventoDAO dao) {
        this.dao = dao;
    }
    
     public DataModel getTiposDeEvento() {
        this.tiposdeevento = new ListDataModel(dao.findAll());
        return tiposdeevento;
    }
    
    public void setTiposDeEvento(DataModel tiposdeevento) {
        this.tiposdeevento = tiposdeevento;
    }
    
    public String insert() {
        dao.insert(tipoevento);
        return "tpeventolst";
    }
    
    public String edit(TipoEvento t) {
        tipoevento = (TipoEvento) tiposdeevento.getRowData();
        return "tpeventofrm";
    }
    
    public String update() {
        dao.update(tipoevento);
        return "tpeventolst";
    }
    
    public String delete(TipoEvento t) {
        dao.delete(t);
        return "tpeventolst";
    }
    
    public String salvar() {
        if (tipoevento.getTpe_codigo()> 0)
            dao.update(tipoevento);
        else 
            dao.insert(tipoevento);
        
        return "tpeventolst";
    }
    
    public String listar() {
        return "tpeventolst";
    }
}
