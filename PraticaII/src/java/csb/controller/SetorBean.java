package csb.controller;

import csb.dao.SetorDAO;
import csb.model.Setor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean
@RequestScoped
public class SetorBean {
    
    private final String sTitle = Setor.sTitle;
    private final String pTitle = Setor.pTitle;

    private Setor setor = new Setor();
    private SetorDAO dao = new SetorDAO();
    private DataModel setores;

    public SetorBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Setor getSetor() {
        return setor;
    }

    public DataModel getSetores() {
        this.setores = new ListDataModel(dao.findAll());
        return setores;
    }

    public void setSetores(DataModel datamodel) {
        this.setores = datamodel;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String insert() {
        dao.insert(setor);
        return "setorlst";
    }

    public String edit(Setor i) {
        setor = (Setor) setores.getRowData();
        return "setorfrm";
    }

    public String update() {
        dao.update(setor);
        return "setorlst";
    }

    public String delete(Setor i) {
        dao.delete(i);
        return "setorlst";
    }

    public String salvar() {
        if (setor.getSet_codigo()> 0) {
            dao.update(setor);
        } else {
            dao.insert(setor);
        }
        return "setorlst";
    }

    public String listar() {
        return "setorlst";
    }

}
