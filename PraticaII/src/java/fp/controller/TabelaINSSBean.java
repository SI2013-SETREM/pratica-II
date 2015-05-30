
package fp.controller;

import fp.dao.FaixaINSSDAO;
import fp.dao.TabINSSDAO;
import fp.model.FaixaINSS;
import fp.model.TabINSS;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;




@ManagedBean
@RequestScoped
public class TabelaINSSBean {
    
    private final String sTitle = TabINSS.getsTitle();
    private final String pTitle = TabINSS.getpTitle();
    
    private TabINSS tabelainss = new TabINSS();
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
    
    public TabINSS getTabINSS() {
        return tabelainss;
    }

    public void setTabINSS(TabINSS tabelainss) {
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
    
    public String edit(TabINSS i) {
        tabelainss = (TabINSS) tabelasinss.getRowData();
        return "tabelainssfrm";
    }
    
    public String update() {
        dao.update(tabelainss);
        return "tabelainsslst";
    }
    
    public String delete(TabINSS i) {
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

