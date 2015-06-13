package cfg.controller;

import cfg.dao.ParametroDAO;
import cfg.model.Parametro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class ParametroBean {

    private final String sTitle = Parametro.sTitle;
    private final String pTitle = Parametro.pTitle;

    private Parametro parametro = new Parametro();
    private ParametroDAO dao = new ParametroDAO();
    private DataModel parametros;

    public ParametroBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Parametro getParametro() {
        return parametro;
    }

    public void setParametro(Parametro parametro) {
        this.parametro = parametro;
    }

    public DataModel getParametros() {
        this.parametros = new ListDataModel(dao.findAll());
        return parametros;
    }

    public void setParametros(DataModel parametros) {
        this.parametros = parametros;
    }

    public String insert() {
        dao.insert(parametro);
        return "parametrolst";
    }

    public String edit(Parametro i) {
        parametro = (Parametro) parametros.getRowData();
        return "parametrofrm";
    }

    public String update() {
        dao.update(parametro);
        return "parametrolst";
    }

    public String delete(Parametro i) {
        dao.delete(i);
        return "parametrolst";
    }

    public String salvar() {
        if (parametro.getPar_codigo() > 0) {
            dao.update(parametro);
        } else {
            dao.insert(parametro);
        }

        return "parametrolst";
    }

    public String listar() {
        return "parametrolst";
    }

    public String home() {
        return "parametrolst";
    }
}
