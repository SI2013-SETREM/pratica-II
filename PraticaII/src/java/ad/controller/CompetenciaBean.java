package ad.controller;

import ad.dao.CompetenciaDAO;
import ad.dao.TipoCompetenciaDAO;
import ad.model.Competencia;
import ad.model.TipoCompetencia;
import cfg.dao.LogDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
public class CompetenciaBean {

    private final String sTitle = Competencia.sTitle;
    private final String pTitle = Competencia.pTitle;
    private List<TipoCompetencia> lstipocompetencia;
    private TipoCompetenciaDAO tipocompetenciadao = new TipoCompetenciaDAO();
    private Competencia competencia;
    private CompetenciaDAO dao = new CompetenciaDAO();
    private DataModel competencias;

    public CompetenciaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Competencia getCompetencia() {
        if (competencia == null) {
            competencia = new Competencia();
            competencia.setCmp_status(1);
        }
        return competencia;
    }

    public DataModel getCompetencias() {
        this.competencias = new ListDataModel(dao.findAll());
        return competencias;
    }

    public void setCompetencias(DataModel i) {
        this.competencias = i;
    }

    public String insert() {
        dao.insert(competencia);
        return "competencialst";
    }

    public String edit(Competencia i) {
        competencia = (Competencia) competencias.getRowData();
        return "competenciafrm";
    }

    public String update() {
        dao.update(competencia);
        return "competencialst";
    }

    public String delete(Competencia i) {
        dao.delete(i);
        LogDAO.insert("Competencia", "Deletou Competência codigo: " + i.getCmp_codigo() + ",nome: " + i.getCmp_descricao() + ", status: " + i.getStatus());
        return "competencialst";
    }

    public String salvar() {
        if (competencia.getCmp_codigo() > 0) {
            dao.update(competencia);
            LogDAO.insert("Competencia", "Alteou Competência codigo: " + competencia.getCmp_codigo() + ",nome: " + competencia.getCmp_descricao() + ", status: " + competencia.getStatus());
        } else {
            dao.insert(competencia);
            LogDAO.insert("Competencia", "Cadastrou Competência nome: " + competencia.getCmp_descricao() + ", status: " + competencia.getStatus());
        }
        return "competencialst";
    }

    public String listar() {
        return "competencialst";
    }

    public List<TipoCompetencia> getLstipocompetencia() {
        lstipocompetencia = tipocompetenciadao.findAll();
        return lstipocompetencia;
    }

    public void setLstipocompetencia(List<TipoCompetencia> i) {
        this.lstipocompetencia = i;
    }
}
