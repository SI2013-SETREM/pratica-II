
package conf.controller;

import conf.dao.IdiomaDAO;
import conf.model.Idiomas;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class IdiomasBean {
    
    private final String sTitle = Idiomas.sTitle;
    private final String pTitle = Idiomas.pTitle;
    
    private Idiomas idioma = new Idiomas();
    private IdiomaDAO dao = new IdiomaDAO();
    private DataModel idiomas;
    
    public IdiomasBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Idiomas getIdioma() {
        return idioma;
    }

    public void setIdioma(Idiomas idioma) {
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
        return "idiomaslst";
    }
    
    public String edit(Idiomas i) {
        idioma = (Idiomas) idiomas.getRowData();
        return "idiomasfrm";
    }
    
    public String update() {
        dao.update(idioma);
        return "idiomaslst";
    }
    
    public String delete(Idiomas i) {
        dao.delete(i);
        return "idiomaslst";
    }
    
    public String salvar() {
        if (idioma.getIdiCodigo()> 0)
            dao.update(idioma);
        else 
            dao.insert(idioma);
        
        return "idiomaslst";
    }
    
    public String listar() {
        return "idiomaslst";
    }
    
    
}
