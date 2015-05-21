package ad.controller;

import ad.dao.CompetenciaDAO;
import ad.dao.Tipo_competenciaDAO;
import ad.model.Competencia;
import ad.model.Tipo_competencia;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class CompetenciaBean {

    private Competencia competencia = new Competencia();
    private CompetenciaDAO dao = new CompetenciaDAO();
    private DataModel competencias;

    private List<Tipo_competencia> lstipo_competencia;
    private Tipo_competenciaDAO tipo_competenciaDAO = new Tipo_competenciaDAO();
    private Tipo_competencia tipo_competencia = new Tipo_competencia();

    public CompetenciaBean() {
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia i) {
        this.competencia = i;
    }

    public DataModel getAvaliacoes() {
        this.competencias = new ListDataModel(dao.findAll());
        return competencias;
    }

    public void setAvaliacoes(DataModel dm) {
        this.competencias = dm;
    }

    public List<Tipo_competencia> getLstipo_competencia() {
        lstipo_competencia = tipo_competenciaDAO.findAll();
        return lstipo_competencia;
    }

    public void setLstipo_competencia(List<Tipo_competencia> lstipo_competencia) {
        this.lstipo_competencia = lstipo_competencia;
    }

    public Tipo_competencia getTipo_competencia() {
        return tipo_competencia;
    }

    public void setTipo_competencia(Tipo_competencia tipo_competencia) {
        this.tipo_competencia = tipo_competencia;
    }

    public String insert() {
        dao.insert(competencia);
        return "competenciagrm";
    }

    public String edit(Competencia i) {
        competencia = (Competencia) competencias.getRowData();
        return "competenciagrm";
    }

    public String update() {
        dao.update(competencia);
        return "competenciagrm";
    }

    public String delete(Competencia i) {
        dao.delete(i);
        return "competenciagrm";
    }

    public String salvar() {
        competencia.setTipocompetencia(tipo_competencia);
        if (competencia.getCmp_codigo() > 0) {
            dao.update(competencia);
        } else {
            dao.insert(competencia);
        }
        return "competenciagrm";
    }

    public String listar() {
        return "competenciagrm";
    }
}
