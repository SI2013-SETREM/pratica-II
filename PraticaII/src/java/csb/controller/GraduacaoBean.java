package csb.controller;

import csb.dao.GraduacaoDAO;
import csb.dao.SetorDAO;
import csb.model.Graduacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Luan meller
 */
@ManagedBean
@RequestScoped
public class GraduacaoBean {
    
    private final String sTitle = Graduacao.sTitle;
    private final String pTitle = Graduacao.pTitle;

    private Graduacao graduacao = new Graduacao();
    private GraduacaoDAO dao = new GraduacaoDAO();
    private DataModel datamodel;

    public GraduacaoBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public DataModel getDatamodel() {
        this.datamodel = new ListDataModel(dao.findAll());
        return datamodel;
    }

    public void setDatamodel(DataModel datamodel) {
        this.datamodel = datamodel;
    }

    public void setCbsGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public void setCbsGraduacaoDM(DataModel graduacaoDM) {
        this.datamodel = graduacaoDM;
    }

    public String insert() {
        dao.insert(graduacao);
        return "graduacaolst";
    }

    public String edit(Graduacao i) {
        graduacao = (Graduacao) datamodel.getRowData();
        return "graduacaofrm";
    }

    public String update() {
        dao.update(graduacao);
        return "graduacaolst";
    }

    public String delete(Graduacao i) {
        dao.delete(i);
        return "graduacaolst";
    }

    public String salvar() {
        if (graduacao.getGrd_codigo()> 0) {
            dao.update(graduacao);
        } else {
            dao.insert(graduacao);
        }

        return "graduacaolst";
    }

    public String listar() {
        return "graduacaolst";
    }

}
