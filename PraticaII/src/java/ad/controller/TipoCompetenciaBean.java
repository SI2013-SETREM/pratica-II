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

    private TipoCompetencia tipo_competencia = new TipoCompetencia();
    private TipoCompetenciaDAO dao = new TipoCompetenciaDAO();
    private DataModel tipo_competencias;

    public TipoCompetenciaBean() {
    }

    public TipoCompetencia getTipo_competencia() {
        return tipo_competencia;
    }

    public void setTipo_competencia(TipoCompetencia i) {
        this.tipo_competencia = i;
    }

    public DataModel getAvaliacoes() {
        this.tipo_competencias = new ListDataModel(dao.findAll());
        return tipo_competencias;
    }

    public void setAvaliacoes(DataModel dm) {
        this.tipo_competencias = dm;
    }

    public String edit(TipoCompetencia i) {
        tipo_competencia = (TipoCompetencia) tipo_competencias.getRowData();
        return "tipo_competenciagrm";
    }

    public String update() {
        dao.update(tipo_competencia);
        return "tipo_competenciagrm";
    }

    public String delete(TipoCompetencia i) {
        dao.delete(i);
        return "tipo_competenciagrm";
    }

    public String insert() {
        if (tipo_competencia.getTcp_codigo() > 0) {
            dao.update(tipo_competencia);
        } else {
            dao.insert(tipo_competencia);
        }
        return "tipo_competenciagrm";
    }

    public String list() {
        return "tipo_competenciagrm";
    }
}
