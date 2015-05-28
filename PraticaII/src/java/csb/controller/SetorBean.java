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
    private DataModel datamodel;

    public SetorBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Setor getCbsEpi() {
        return setor;
    }

    public DataModel getDatamodel() {
        this.datamodel = new ListDataModel(dao.findAll());
        return datamodel;
    }

    public void setDatamodel(DataModel datamodel) {
        this.datamodel = datamodel;
    }

    public void setCbsEpi(Setor setor) {
        this.setor = setor;
    }

    public void setCbsEpiDM(DataModel setorDM) {
        this.datamodel = setorDM;
    }

    public String insert() {
        dao.insert(setor);
        return "setorlst";
    }

    public String edit(Setor i) {
        setor = (Setor) datamodel.getRowData();
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
