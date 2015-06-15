package csb.controller;

import csb.controller.*;

import csb.dao.CargoDAO;
import csb.dao.SetorDAO;
import csb.model.Cargo;
import csb.model.Setor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class CargosBean {

    private final String sTitle = Cargo.sTitle;
    private final String pTitle = Cargo.pTitle;

    private Cargo cargo = new Cargo();
    private CargoDAO dao = new CargoDAO();
    private DataModel cargos;
    

    /* PARA FAZER A COMBO DE CARGOS */
    private DataModel lsCargosParents;
    private List<Cargo> lsCargo;
    
    /* PARA FAZER A COMBO DE SETORES */
    private List<Setor> lstsetor;
    private Setor setor = new Setor();
    private SetorDAO setordao = new SetorDAO();

    public CargosBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public DataModel getCargos() {
        this.cargos = new ListDataModel(dao.findAll());
        return cargos;
    }

    public void setCargos(DataModel cargos) {
        this.cargos = cargos;
    }

    public DataModel getLsCargosParents() {
       this.lsCargosParents = new ListDataModel(dao.findAllParents());
       return this.lsCargosParents;
    }

    public void setLsCargosParents(DataModel lsCargosParents) {
        this.lsCargosParents = lsCargosParents;
    }
    
    public String insert() {
        dao.insert(cargo);
        return "cargolst";
    }

    public String edit(Cargo c) {
        cargo = (Cargo) cargos.getRowData();
        return "cargofrm";
    }

    public String update() {
        dao.update(cargo);
        return "cargolst";
    }

    public String delete(Cargo c) {
        dao.delete(c);
        return "cargolst";
    }

    public String salvar() {
        if (cargo.getCar_codigo() > 0) {
            dao.update(cargo);
        } else {
            dao.insert(cargo);
        }

        return "cargolst";
    }

    public String listar() {
        return "cargolst";
    }

    public List<Setor> getLstsetor() {
        lstsetor = setordao.findAll();
        return lstsetor;
    }

    public void setLstsetor(List<Setor> lstsetor) {
        this.lstsetor = lstsetor;
    }
    
    public List<Cargo> getLscargo() {
        lsCargo = dao.findAllParents();
        return lsCargo;
    }

    public void setLscargo(List<Cargo> lscargo) {
        this.lsCargo = lscargo;
    }
}
