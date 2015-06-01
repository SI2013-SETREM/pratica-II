/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.controller;

import csb.dao.CargoDAO;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.model.TreeNode;
import rs.dao.RecrutamentoCargoDAO;
import rs.model.RecrutamentoCargo;

/**
 *
 * @author NADINE
 */
@ManagedBean
@RequestScoped
public class RecrutamentoCargoBean {

    private final String sTitle = RecrutamentoCargo.sTitle;
    private final String pTitle = RecrutamentoCargo.pTitle;

    private RecrutamentoCargo recrutamentoCargo = new RecrutamentoCargo();
    private RecrutamentoCargoDAO dao = new RecrutamentoCargoDAO();
    private DataModel recrutamentoCargos;
    private CargoDAO daocargo = new CargoDAO();
    private TreeNode arvoreCargos;

    public RecrutamentoCargoBean() {

    }

    @PostConstruct
    public void init() {
        arvoreCargos = daocargo.arvoreCargo(null, 0, null);
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public RecrutamentoCargo getRecrutamentoCargo() {
        return recrutamentoCargo;
    }

    public void setRecrutamentoCargo(RecrutamentoCargo recrutamentoCargo) {
        this.recrutamentoCargo = recrutamentoCargo;
    }

    public RecrutamentoCargoDAO getDao() {
        return dao;
    }

    public void setDao(RecrutamentoCargoDAO dao) {
        this.dao = dao;
    }

    public DataModel getRecrutamentoCargos() {
        this.recrutamentoCargos = new ListDataModel(dao.findAll());
        return recrutamentoCargos;
    }

    public void setRecrutamentoCargos(DataModel recrutamentoCargos) {
        this.recrutamentoCargos = recrutamentoCargos;
    }

    public TreeNode getArvoreCargos() {
        return arvoreCargos;
    }

    public String insert() {
        dao.insert(recrutamentoCargo);
        return "recrutamentocargolst";
    }

    public String edit(RecrutamentoCargo i) {
        recrutamentoCargo = (RecrutamentoCargo) recrutamentoCargos.getRowData();
        return "recrutamentocargofrm";
    }

    public String update() {
        dao.update(recrutamentoCargo);
        return "recrutamentocargolst";
    }

    public String delete(RecrutamentoCargo r) {
        dao.delete(r);
        return "recrutamentocargolst";
    }

    public String salvar() {
        if (recrutamentoCargo.getRecCarCodigo() > 0) {
            dao.update(recrutamentoCargo);
        } else {
            dao.insert(recrutamentoCargo);
        }

        return "recrutamentocargolst";
    }

    public String listar() {
        return "recrutamentocargolst";
    }

}
