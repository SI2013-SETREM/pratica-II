package td.controller;

import td.dao.LocalDAO;
import td.model.Local;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class LocalBean {

    private Local local = new Local();
    private LocalDAO dao = new LocalDAO();
    private DataModel locais;

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public DataModel getLocais() {
        this.locais = new ListDataModel(dao.findAll());
        return locais;
    }

    public void setLocais(DataModel locais) {
        this.locais = locais;
    }
    
    public String insert() {
        dao.insert(local);
        return "locallst";
    }
    
    public String edit(Local i) {
        local = (Local) locais.getRowData();
        return "localfrm";
    }

    public String update() {
        dao.update(local);
        return "locallst";
    }
    
    public String delete(Local i) {
        dao.delete(i);
        return "locallst";
    }
    
    public String salvar() {
        if (true) {
            dao.update(local);
        } else {
            dao.insert(local);
        }
        return "locallst";
    }

    public String listar() {
        return "locallst";
    }
}
