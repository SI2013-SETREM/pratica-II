
package cfg.controller;

import cfg.dao.ConversaDAO;
import cfg.model.Conversa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class ConversaBean {
    
    private final String sTitle = Conversa.sTitle;
    private final String pTitle = Conversa.pTitle;
    
    private Conversa conversa = new Conversa();
    private ConversaDAO dao = new ConversaDAO();
    private DataModel conversas;
    
    public ConversaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Conversa getConversa() {
        return conversa;
    }

    public void setConversa(Conversa conversa) {
        this.conversa= conversa;
    }

    public DataModel getConversas() {
        this.conversas = new ListDataModel(dao.findAll());
        return conversas;
    }

    public void setConversas(DataModel idiomas) {
        this.conversas= conversas;
    }
    
    public String insert() {
        dao.insert(conversa);
        return "conversalst";
    }
    
    public String edit(Conversa i) {
        conversa= (Conversa) conversas.getRowData();
        return "conversafrm";
    }
    
    public String update() {
        dao.update(conversa);
        return "conversalst";
    }
    
    public String delete(Conversa i) {
        dao.delete(i);
        return "conversalst";
    }
    
    public String salvar() {
        if (conversa.getCnvCodigo()> 0)
            dao.update(conversa);
        else 
            dao.insert(conversa);
        
        return "conversalst";
    }
    
    public String listar() {
        return "conversalst";
    }
    
    
}
