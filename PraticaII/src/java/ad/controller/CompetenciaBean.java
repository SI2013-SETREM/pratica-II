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

    private List<TipoCompetencia> lstipoCompetencia;
    private TipoCompetenciaDAO tipoCompetenciaDAO = new TipoCompetenciaDAO();
    private TipoCompetencia tipoCompetencia = new TipoCompetencia();

    public CompetenciaBean() {
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia i) {
        this.competencia = i;
    }

    public DataModel getCompetencias() {
        if (competencias == null) {
            competencias = new ListDataModel(dao.findAll());
        }
        return competencias;
    }

    public void setCompetencias(DataModel dm) {
        this.competencias = dm;
    }

    public List<TipoCompetencia> getLstipoCompetencia() {
        lstipoCompetencia = tipoCompetenciaDAO.findAll();
        return lstipoCompetencia;
    }

    public void setLstipoCompetencia(List<TipoCompetencia> lstipoCompetencia) {
        this.lstipoCompetencia = lstipoCompetencia;
    }

    public TipoCompetencia getTipo_competencia() {
        return tipoCompetencia;
    }

    public void setTipo_competencia(TipoCompetencia tipoCompetencia) {
        this.tipoCompetencia = tipoCompetencia;
    }

    public String newCompetencia() {
        competencia = new Competencia();
        return "competenciafrm";
    }

    public String select() {
        competencia = (Competencia) competencias.getRowData();
        competencia = dao.findById(competencia.getCmp_codigo());
        return "competenciafrm";
    }

    public String insert() {
        dao.insert(competencia);
        return "competencialst";
    }

    public String edit(Competencia i) {
        competencia = (Competencia) competencias.getRowData();
        return "competencialst";
    }

    public String update() {
        dao.update(competencia);
        return "competencialst";
    }

    public String delete(Competencia i) {
        competencia = (Competencia) competencias.getRowData();
        dao.delete(competencia);
        competencia = null;
        return "competencialst";
    }

    public String salvar() {
        competencia.setTipocompetencia(tipoCompetencia);
        if (competencia.getCmp_codigo() > 0) {
            dao.update(competencia);
        } else {
            dao.insert(competencia);
        }
        return "competencialst";
    }

    public String listar() {
        return "competencialst";
    }

    public String Status() {
        if (competencia.getCmp_status() == 1) {
            return "Ativo";
        } else {
            return "Inativo";
        }
    }

    public void setTipoCompetencia(TipoCompetencia tipoCompetencia) {
        this.tipoCompetencia = tipoCompetencia;
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public TipoCompetencia getTipoCompetencia() {
        return tipoCompetencia;
    }

}
