package csb.controller;

import csb.dao.EpiDAO;
import csb.model.Epi;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class EpiBean {

    private final String sTitle = Epi.sTitle;
    private final String pTitle = Epi.pTitle;

    private Epi cbsepi = new Epi();
    private EpiDAO dao = new EpiDAO();
    private DataModel datamodel;

    public EpiBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Epi getCbsEpi() {
        return cbsepi;
    }

    public DataModel getDatamodel() {
        this.datamodel = new ListDataModel(dao.findAll());
        return datamodel;
    }

    public void setDatamodel(DataModel datamodel) {
        this.datamodel = datamodel;
    }

    public void setCbsEpi(Epi cbsepi) {
        this.cbsepi = cbsepi;
    }

    public void setCbsEpiDM(DataModel cbsepidm) {
        this.datamodel = cbsepidm;
    }

    public String insert() {
        dao.insert(cbsepi);
        return "cbsepilst";
    }

    public String edit(Epi i) {
        cbsepi = (Epi) datamodel.getRowData();
        return "csbepifrm";
    }

    public String update() {
        dao.update(cbsepi);
        return "cbsepilst";
    }

    public String delete(Epi i) {
        dao.delete(i);
        return "cbsepilst";
    }

    public String salvar() {
        if (cbsepi.getEpi_codigo()> 0) {
            dao.update(cbsepi);
        } else {
            dao.insert(cbsepi);
        }

        return "csbepilst";
    }

    public String listar() {
        return "csbepilst";
    }

}
