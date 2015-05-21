package ad.controller;

import ad.dao.Tipo_competenciaDAO;
import ad.model.Tipo_competencia;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class Tipo_competenciaBean {

    private Tipo_competencia tipo_competencia = new Tipo_competencia();
    private Tipo_competenciaDAO dao = new Tipo_competenciaDAO();
    private DataModel tipo_competencias;

    public Tipo_competenciaBean() {
    }

    public Tipo_competencia getTipo_competencia() {
        return tipo_competencia;
    }

    public void setTipo_competencia(Tipo_competencia i) {
        this.tipo_competencia = i;
    }

    public DataModel getAvaliacoes() {
        this.tipo_competencias = new ListDataModel(dao.findAll());
        return tipo_competencias;
    }

    public void setAvaliacoes(DataModel dm) {
        this.tipo_competencias = dm;
    }

    public String edit(Tipo_competencia i) {
        tipo_competencia = (Tipo_competencia) tipo_competencias.getRowData();
        return "tipo_competenciagrm";
    }

    public String update() {
        dao.update(tipo_competencia);
        return "tipo_competenciagrm";
    }

    public String delete(Tipo_competencia i) {
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
