
package csb.controller;
import csb.controller.*;

import csb.dao.CargoDAO;
import csb.model.Cargo;
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
        if (cargo.getCar_codigo()> 0)
            dao.update(cargo);
        else 
            dao.insert(cargo);
        
        return "cargolst";
    }
    
    public String listar() {
        return "cargolst";
    }
    
    
}
