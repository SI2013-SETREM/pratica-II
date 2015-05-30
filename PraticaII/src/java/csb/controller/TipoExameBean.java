package csb.controller;

import csb.dao.TipoExameDAO;
import csb.model.TipoExame;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean
@RequestScoped
public class TipoExameBean {

    private final String sTitle = TipoExame.sTitle;
    private final String pTitle = TipoExame.pTitle;

    private TipoExame tipoexame = new TipoExame();
    private TipoExameDAO dao = new TipoExameDAO();
    private DataModel tipoexames;

    public TipoExameBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public TipoExame getTipoexame() {
        return tipoexame;
    }

    public DataModel getTipoexames() {
        this.tipoexames = new ListDataModel(dao.findAll());
        return tipoexames;
    }

    public void setTipoexames(DataModel datamodel) {
        this.tipoexames = datamodel;
    }

    public void setTipoexame(TipoExame tipoexame) {
        this.tipoexame = tipoexame;
    }

    public String insert() {
        dao.insert(tipoexame);
        return "tipoexamelst";
    }

    public String edit(TipoExame i) {
        tipoexame = (TipoExame) tipoexames.getRowData();
        return "tipoexamefrm";
    }

    public String update() {
        dao.update(tipoexame);
        return "tipoexamelst";
    }

    public String delete(TipoExame i) {
        dao.delete(i);
        return "tipoexamelst";
    }

    public String salvar() {
        if (tipoexame.getEme_codigo() > 0) {
            dao.update(tipoexame);
        } else {
            dao.insert(tipoexame);
        }
        return "tipoexamelst";
    }

    public String listar() {
        return "tipoexamelst";
    }
}
