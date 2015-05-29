package csb.controller;

import csb.dao.MotivoAlteracaoSalarialDAO;
import csb.model.MotivoAlteracaoSalarial;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean
@RequestScoped
public class MotivoAlteracaoSalarialBean {
    
    private final String sTitle = MotivoAlteracaoSalarial.sTitle;
    private final String pTitle = MotivoAlteracaoSalarial.pTitle;

    private MotivoAlteracaoSalarial motivo = new MotivoAlteracaoSalarial();
    private MotivoAlteracaoSalarialDAO dao = new MotivoAlteracaoSalarialDAO();
    private DataModel motivos;

    public MotivoAlteracaoSalarialBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public MotivoAlteracaoSalarial getMotivo() {
        return motivo;
    }

    public DataModel getMotivos() {
        this.motivos = new ListDataModel(dao.findAll());
        return motivos;
    }

    public void setMotivos(DataModel datamodel) {
        this.motivos = datamodel;
    }

    public void setMotivo(MotivoAlteracaoSalarial motivo) {
        this.motivo = motivo;
    }

    public String insert() {
        dao.insert(motivo);
        return "motivoalteracaosalariallst";
    }

    public String edit(MotivoAlteracaoSalarial i) {
        motivo = (MotivoAlteracaoSalarial) motivos.getRowData();
        return "motivoalteracaosalarialfrm";
    }

    public String update() {
        dao.update(motivo);
        return "motivoalteracaosalariallst";
    }

    public String delete(MotivoAlteracaoSalarial i) {
        dao.delete(i);
        return "motivoalteracaosalariallst";
    }

    public String salvar() {
        if (motivo.getMas_codigo()> 0) {
            dao.update(motivo);
        } else {
            dao.insert(motivo);
        }
       return "motivoalteracaosalariallst";
    }

    public String listar() {
        return "motivoalteracaosalariallst";
    }

}
