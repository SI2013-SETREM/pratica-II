
package cfg.controller;

import cfg.dao.BairroDAO;
import cfg.model.Bairro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class BairroBean {
    
    private final String sTitle = Bairro.sTitle;
    private final String pTitle = Bairro.pTitle;
    
    private Bairro bairro = new Bairro();
    private BairroDAO dao = new BairroDAO();
    private DataModel bairros;
    
    public BairroBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro= bairro;
    }

    public DataModel getBairros() {
        this.bairros = new ListDataModel(dao.findAll());
        return bairros;
    }

    public void setBairros(DataModel idiomas) {
        this.bairros= bairros;
    }
    
    public String insert() {
        dao.insert(bairro);
        return "bairrolst";
    }
    
    public String edit(Bairro i) {
        bairro= (Bairro) bairros.getRowData();
        return "bairrofrm";
    }
    
    public String update() {
        dao.update(bairro);
        return "bairrolst";
    }
    
    public String delete(Bairro i) {
        dao.delete(i);
        return "bairrolst";
    }
    
    public String salvar() {
        if (bairro.getBai_codigo()> 0)
            dao.update(bairro);
        else 
            dao.insert(bairro);
        
        return "bairrolst";
    }
    
    public String listar() {
        return "bairrolst";
    }
    
    
}
