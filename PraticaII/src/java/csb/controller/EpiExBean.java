package csb.controller;

import cfg.dao.LogDAO;
import csb.dao.EpiDAO;
import csb.model.Epi;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class EpiExBean {

    private final String sTitle = Epi.sTitle;
    private final String pTitle = Epi.pTitle;

    private Epi epi = new Epi();
    private EpiDAO dao = new EpiDAO();
    private DataModel epis;

    public EpiExBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Epi getEpi() {
        return epi;
    }

    public void setEpi(Epi epi) {
        this.epi = epi;
    }

    public DataModel getEpis() {
        this.epis = new ListDataModel(dao.findEpi());
        return epis;
    }

    public void setEpis(DataModel epis) {
        this.epis = epis;
    }

    public String insert() {
        dao.insert(epi);
        return "epilst";
    }

    public String edit(Epi e) {
        epi = (Epi) epis.getRowData();
        return "epifrm";
    }

    public String update() {
        dao.update(epi);
        return "epilst";
    }

    public String delete(Epi e) {
        dao.delete(e);
        LogDAO.insert("EPI", "Deletou epi código: " + e.getEpi_codigo() + ", descrição: " + e.getEpi_descricao() + ", tipo: " + e.getEpi_tipo());
        return "epilst";
    }

    public String salvar() {
        if (epi.getEpi_codigo() > 0) {
            dao.update(epi);
            LogDAO.insert("EPI", "Alterou epi código: " + epi.getEpi_codigo() + ", descrição: " + epi.getEpi_descricao() + ", tipo: " + epi.getEpi_tipo());
        } else {
            LogDAO.insert("EPI", "Cadastrou epi código: " + epi.getEpi_codigo() + ", descrição: " + epi.getEpi_descricao() + ", tipo: " + epi.getEpi_tipo());
            dao.insert(epi);
        }

        return "epilst";
    }

    public String listar() {
        return "epilst";
    }
}
