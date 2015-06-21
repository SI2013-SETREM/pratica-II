/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.controller;

import cfg.controller.LoginBean;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import csb.dao.CargoDAO;
import csb.model.Cargo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.model.TreeNode;
import rs.dao.RecrutamentoCargoDAO;
import rs.model.RecrutamentoCargo;
import util.Utilidades;

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
    private TreeNode arvoreCargos;
    private TreeNode selectedNode;

    //N:N
    private List<Cargo> cargos;
    private Cargo cargo = new Cargo();
    private CargoDAO daocargo = new CargoDAO();

    //N:N
    private List<Pessoa> pessoas;
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public RecrutamentoCargoBean() {

    }

    @PostConstruct
    public void init() {
        arvoreCargos = daocargo.arvoreCargo();
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

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public CargoDAO getDaocargo() {
        return daocargo;
    }

    public void setDaocargo(CargoDAO daocargo) {
        this.daocargo = daocargo;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
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

    public String interesse(String pg) {
        LoginBean loginBeana = (LoginBean) Utilidades.getSessionObject("loginBean");
        this.pessoa = loginBeana.getUsuario().getPessoa();
        daocargo.update(cargo);
        return pg;
    }

}
