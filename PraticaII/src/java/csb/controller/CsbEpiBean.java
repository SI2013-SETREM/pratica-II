package csb.controller;

import csb.dao.CsbEpiDAO;
import csb.model.CsbEpi;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class CsbEpiBean {

    private final String sTitle = CsbEpi.sTitle;
    private final String pTitle = CsbEpi.pTitle;

    private CsbEpi cbsepi = new CsbEpi();
    private CsbEpiDAO dao = new CsbEpiDAO();
    private DataModel datamodel;

    public CsbEpiBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public CsbEpi getCbsEpi() {
        return cbsepi;
    }

    public DataModel getDatamodel() {
        this.datamodel = new ListDataModel(dao.findAll());
        return datamodel;
    }

    public void setDatamodel(DataModel datamodel) {
        this.datamodel = datamodel;
    }

    public void setCbsEpi(CsbEpi cbsepi) {
        this.cbsepi = cbsepi;
    }

    public void setCbsEpiDM(DataModel cbsepidm) {
        this.datamodel = cbsepidm;
    }

    public String insert() {
        dao.insert(cbsepi);
        return "cbsepilst";
    }

    public String edit(CsbEpi i) {
        cbsepi = (CsbEpi) datamodel.getRowData();
        return "csbepifrm";
    }

    public String update() {
        dao.update(cbsepi);
        return "cbsepilst";
    }

    public String delete(CsbEpi i) {
        dao.delete(i);
        return "cbsepilst";
    }

    public String salvar() {
        if (cbsepi.getEpiCodigo() > 0) {
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
