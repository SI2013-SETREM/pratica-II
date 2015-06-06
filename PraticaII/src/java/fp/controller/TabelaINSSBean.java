
package fp.controller;

import fp.dao.FaixaINSSDAO;
import fp.dao.TabINSSDAO;
import fp.model.FaixaINSS;
import fp.model.TabelaINSS;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;




@ManagedBean
@RequestScoped
public class TabelaINSSBean {
    
    private final String sTitle = TabelaINSS.getsTitle();
    private final String pTitle = TabelaINSS.getpTitle();
    
    private TabelaINSS tabelainss = new TabelaINSS();
    private TabINSSDAO dao = new TabINSSDAO();
    private DataModel tabelasinss;
    
    
    private List<FaixaINSS> lstfaixainss;
    private FaixaINSS faixainss = new FaixaINSS();
    private FaixaINSSDAO faixainssdao = new FaixaINSSDAO();
    
    
    public TabelaINSSBean(){
    }
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public TabelaINSS getTabINSS() {
        return tabelainss;
    }

    public void setTabINSS(TabelaINSS tabelainss) {
        this.tabelainss = tabelainss;
    }

    public DataModel getTabsINSS() {
        this.tabelasinss = new ListDataModel(dao.findAll());
        return tabelasinss;
    }

    public void setTabsINSS(DataModel tabelasinss) {
        this.tabelasinss = tabelasinss;
    }
    
    public String insert() {
        dao.insert(tabelainss);
        return "tabelainsslst";
    }
    
    public String edit(TabelaINSS i) {
        tabelainss = (TabelaINSS) tabelasinss.getRowData();
        return "tabelainssfrm";
    }
    
    public String update() {
        dao.update(tabelainss);
        return "tabelainsslst";
    }
    
    public String delete(TabelaINSS i) {
        dao.delete(i);
        return "tabelainsslst";
    }
    
    public String salvar() {
        if (tabelainss.getTbs_codigo()> 0)
            dao.update(tabelainss);
        else 
            dao.insert(tabelainss);
        
        return "tabelainsslst";
    }
    
    public String listar() {
        return "tabelainsslst";
    }
    
    public List<FaixaINSS> getLstFaixaINSS() {
        lstfaixainss = faixainssdao.findAll();
        return lstfaixainss;
    }
    
}

