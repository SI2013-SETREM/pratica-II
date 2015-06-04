
package fp.controller;

import fp.dao.FaixaIRRFDAO;
import fp.dao.TabelaIRRFDAO;
import fp.model.FaixaIRRF;
import fp.model.SerieEvento;
import fp.model.TabelaIRRF;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class FaixaIRRFBean {
    
    private final String sTitle = FaixaIRRF.sTitle;
    private final String pTitle = FaixaIRRF.pTitle;
    
    private FaixaIRRF faixairrf = new FaixaIRRF();
    private FaixaIRRFDAO dao = new FaixaIRRFDAO();
    private DataModel faixairrfs;
    
    
    private List<TabelaIRRF> lsttabelairrf;
    private TabelaIRRF tabelairrf = new TabelaIRRF();
    private TabelaIRRFDAO tabelairrfdao = new TabelaIRRFDAO();
        
    public FaixaIRRFBean(){
    }
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public FaixaIRRF getFaixaIRRF() {
        return faixairrf;
    }

    public void setFaixaIRRF(FaixaIRRF faixairrf) {
        this.faixairrf = faixairrf;
    }

    public DataModel getFaixaIRRFs() {
        this.faixairrfs = new ListDataModel(dao.findAll());
        return faixairrfs;
    }

    public void setFaixaIRRFs(DataModel faixairrfs) {
        this.faixairrfs = faixairrfs;
    }
    
    public String insert() {
        dao.insert(faixairrf);
        return "tabelairrflst";
    }
    
    public String edit(FaixaIRRF i) {
        faixairrf = (FaixaIRRF) faixairrfs.getRowData();
        return "faixairrfsfrm";
    }
    
    public String update() {
        dao.update(faixairrf);
        return "tabelairrflst";
    }
    
    public String delete(FaixaIRRF i) {
        dao.delete(i);
        return "tabelairrflst";
    }
    
   public String salvar() {
        if (faixairrf.getFrf_codigo()> 0)
            dao.update(faixairrf);
        else 
            dao.insert(faixairrf);
        
        return "tabelairrflst";
    }
    
    public String listar() {
        return "tabelairrflst";
    }
    
    
     public List<TabelaIRRF> getLstTabelaIRRF() {
        lsttabelairrf = tabelairrfdao.findAll();
        return lsttabelairrf;
    }

    public void setLstTabelaIRRF(List<TabelaIRRF> i) {
        this.lsttabelairrf = i;
    }
    
    
}

