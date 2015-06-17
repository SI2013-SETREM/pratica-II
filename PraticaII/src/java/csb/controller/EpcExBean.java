
package csb.controller;

import csb.dao.EpiDAO;
import csb.model.Epi;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class EpcExBean {
    
    private final String sTitle = Epi.sTitle;
    private final String pTitle = Epi.pTitle;
    
    private Epi epc = new Epi();
    private EpiDAO dao = new EpiDAO();
    private DataModel epcs;
    
    public EpcExBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Epi getEpc() {
        return epc;
    }

    public void setEpc(Epi epc) {
        this.epc = epc;
    }

    public DataModel getEpcs() {
        this.epcs = new ListDataModel(dao.findEpc());
        return epcs;
    }

    public void setEpcs(DataModel epcs) {
        this.epcs = epcs;
    }
    
    public String insert() {
        dao.insert(epc);
        return "epilst";
    }
    
    public String edit(Epi e) {
        epc = (Epi) epcs.getRowData();
        return "epifrm";
    }
    
    public String update() {
        dao.update(epc);
        return "epilst";
    }
    
    public String delete(Epi e) {
        dao.delete(e);
        return "epilst";
    }
    
    public String salvar() {
        if (epc.getEpi_codigo()> 0)
            dao.update(epc);
        else 
            dao.insert(epc);
        
        return "epilst";
    }
    
    public String listar() {
        return "epilst";
    }
}
