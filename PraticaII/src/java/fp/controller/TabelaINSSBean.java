
package fp.controller;

import fp.dao.FaixaINSSDAO;
import fp.dao.TabelaINSSDAO;
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
    
    private final String sTitle = TabelaINSS.sTitle;
    private final String pTitle = TabelaINSS.pTitle;
    
    private TabelaINSS tabelainss = new TabelaINSS();
    private TabelaINSSDAO dao = new TabelaINSSDAO();
    private DataModel tabelainsss;
    
    public TabelaINSSBean(){
    }
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public TabelaINSS getTabelaINSS() {
        return tabelainss;
    }

    public void setTabelaINSS(TabelaINSS tabelainss) {
        this.tabelainss = tabelainss;
    }

    public DataModel getTabelasINSS() {
        this.tabelainsss = new ListDataModel(dao.findAll());
        return tabelainsss;
    }

    public void setTabelasINSS(DataModel tabelainsss) {
        this.tabelainsss = tabelainsss;
    }
    
    public String insert() {
        dao.insert(tabelainss);
        return "tabelainssslst";
    }
    
    public String edit(TabelaINSS i) {
        tabelainss = (TabelaINSS) tabelainsss.getRowData();
        return "tabelainsssfrm";
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
   
    
}

