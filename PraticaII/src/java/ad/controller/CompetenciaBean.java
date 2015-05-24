package ad.controller;

import ad.dao.CompetenciaDAO;
import ad.dao.TipoCompetenciaDAO;
import ad.model.Competencia;
import ad.model.TipoCompetencia;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class CompetenciaBean {

    private final String sTitle = Competencia.sTitle;
    private final String pTitle = Competencia.pTitle;

    private Competencia competencia = new Competencia();
    private CompetenciaDAO dao = new CompetenciaDAO();
    private DataModel competencias;

    private List<TipoCompetencia> lstipo_competencia;
    private TipoCompetenciaDAO tipo_competenciaDAO = new TipoCompetenciaDAO();
    private TipoCompetencia tipo_competencia = new TipoCompetencia();

    public CompetenciaBean() {
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia i) {
        this.competencia = i;
    }

    public DataModel getCompetencias() {
        this.competencias = new ListDataModel(dao.findAll());
        return competencias;
    }

    public void setCompetencias(DataModel dm) {
        this.competencias = dm;
    }

    public List<TipoCompetencia> getLstipo_competencia() {
        lstipo_competencia = tipo_competenciaDAO.findAll();
        return lstipo_competencia;
    }

    public void setLstipo_competencia(List<TipoCompetencia> lstipo_competencia) {
        this.lstipo_competencia = lstipo_competencia;
    }

    public TipoCompetencia getTipo_competencia() {
        return tipo_competencia;
    }

    public void setTipo_competencia(TipoCompetencia tipo_competencia) {
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

    public String Status() {
        if (competencia.getCmp_status() == 1) {
            return "Ativo";
        } else {
            return "Inativo";
        }
    }
}
