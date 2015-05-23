
package cfg.controller;

import cfg.dao.IdiomaDAO;
import cfg.model.Idioma;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class IdiomaBean {
    
    private final String sTitle = Idioma.sTitle;
    private final String pTitle = Idioma.pTitle;
    
    private Idioma idioma = new Idioma();
    private IdiomaDAO dao = new IdiomaDAO();
    private DataModel idiomas;
    
    public IdiomaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public DataModel getIdiomas() {
        this.idiomas = new ListDataModel(dao.findAll());
        return idiomas;
    }

    public void setIdiomas(DataModel idiomas) {
        this.idiomas = idiomas;
    }
    
    public String insert() {
        dao.insert(idioma);
        return "idiomalst";
    }
    
    public String edit(Idioma i) {
        idioma = (Idioma) idiomas.getRowData();
        return "idiomafrm";
    }
    
    public String update() {
        dao.update(idioma);
        return "idiomalst";
    }
    
    public String delete(Idioma i) {
        dao.delete(i);
        return "idiomalst";
    }
    
    public String salvar() {
        if (idioma.getIdiCodigo()> 0)
            dao.update(idioma);
        else 
            dao.insert(idioma);
        
        return "idiomalst";
    }
    
    public String listar() {
        return "idiomalst";
    }
    
    
}
