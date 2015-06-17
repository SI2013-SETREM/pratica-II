
package fp.controller;

import fp.dao.FaixaIRRFDAO;
import fp.dao.TabelaIRRFDAO;
import fp.model.FaixaIRRF;
import fp.model.TabelaIRRF;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class TabelaIRRFBean {
    
    private final String sTitle = TabelaIRRF.sTitle;
    private final String pTitle = TabelaIRRF.pTitle;
    
    private TabelaIRRF tabelairrf = new TabelaIRRF();
    private TabelaIRRFDAO dao = new TabelaIRRFDAO();
    private DataModel tabelairrfs;
    
    
    private List<FaixaIRRF> lstfaixairrf;
    private FaixaIRRF faixairrf = new FaixaIRRF();
    private FaixaIRRFDAO faixairrfdao = new FaixaIRRFDAO();
    
    
    public TabelaIRRFBean(){
    }
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public TabelaIRRF getTabelaIRRF() {
        return tabelairrf;
    }

    public void setTabelaIRRF(TabelaIRRF tabelairrf) {
        this.tabelairrf = tabelairrf;
    }

    public DataModel getTabelaIRRFs() {
        this.tabelairrfs = new ListDataModel(dao.findAll());
        return tabelairrfs;
    }

    public void setTabelaIRRFs(DataModel tabelairrfs) {
        this.tabelairrfs = tabelairrfs;
    }
    
    public String insert() {
        dao.insert(tabelairrf);
        return "tabelairrfslst";
    }
    
    public String edit(TabelaIRRF i) {
        tabelairrf = (TabelaIRRF) tabelairrfs.getRowData();
        return "tabelairrffrm";
    }
    
    public String update() {
        dao.update(tabelairrf);
        return "tabelairrflst";
    }
    
    public String delete(TabelaIRRF i) {
        dao.delete(i);
        return "tabelairrflst";
    }
    
    public String salvar() {
        if (tabelairrf.getTif_codigo()> 0)
            dao.update(tabelairrf);
        else 
            dao.insert(tabelairrf);
        
        return "tabelairrflst";
    }
    
    public String listar() {
        return "tabelairrflst";
    }
    
    
}

