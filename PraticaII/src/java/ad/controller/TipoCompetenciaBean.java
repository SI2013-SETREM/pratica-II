package ad.controller;

import ad.dao.TipoCompetenciaDAO;
import ad.model.TipoCompetencia;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class TipoCompetenciaBean {

    private final String sTitle = TipoCompetencia.sTitle;
    private final String pTitle = TipoCompetencia.pTitle;

    private TipoCompetencia tipoCompetencia = new TipoCompetencia();
    private TipoCompetenciaDAO dao = new TipoCompetenciaDAO();
    private DataModel tipoCompetencias;

    public TipoCompetenciaBean() {
    }

    public TipoCompetencia getTipoCompetencia() {
        return tipoCompetencia;
    }

    public void setTipoCompetencia(TipoCompetencia i) {
        this.tipoCompetencia = i;
    }

    public DataModel getTipoCompetencias() {
        if (tipoCompetencias == null) {
            tipoCompetencias = new ListDataModel(dao.findAll());
        }
        return tipoCompetencias;
    }

    public void setTipoCompetencias(DataModel dm) {
        this.tipoCompetencias = dm;
    }

    public String edit(TipoCompetencia i) {
        tipoCompetencia = (TipoCompetencia) tipoCompetencias.getRowData();
        return "tipocompetenciagrm";
    }

    public String select() {
        tipoCompetencia = (TipoCompetencia) tipoCompetencias.getRowData();
        tipoCompetencia = dao.findById(tipoCompetencia.getTcp_codigo());
        return "tipocompetenciagrm";
    }

    public String update() {
        dao.update(tipoCompetencia);
        return "tipocompetenciagrm";
    }

    public String delete() {
        tipoCompetencia = (TipoCompetencia) tipoCompetencias.getRowData();
        dao.delete(tipoCompetencia);
        tipoCompetencia = null;
        tipoCompetencias = new ListDataModel(dao.findAll());
        return "tipocompetenciagrm";
    }

    public String insert() {
        if (tipoCompetencia.getTcp_codigo() > 0) {
            dao.update(tipoCompetencia);
        } else {
            dao.insert(tipoCompetencia);
        }
        return "tipocompetenciagrm";
    }

    public String list() {
        return "tipocompetenciagrm";
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

}
