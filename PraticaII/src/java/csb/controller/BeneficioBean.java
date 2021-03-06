package csb.controller;

import csb.dao.BeneficioDAO;
import csb.model.Beneficio;
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

public class BeneficioBean {

    private final String sTitle = Beneficio.sTitle;
    private final String pTitle = Beneficio.pTitle;

    private Beneficio beneficio = new Beneficio();
    private BeneficioDAO dao = new BeneficioDAO();
    private DataModel beneficios;

    public BeneficioBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Beneficio getBeneficio() {
        return beneficio;
    }

    public DataModel getBeneficios() {
        this.beneficios = new ListDataModel(dao.findAll());
        return beneficios;
    }

    public void setBeneficios(DataModel datamodel) {
        this.beneficios = datamodel;
    }

    public void setSetor(Beneficio beneficio) {
        this.beneficio = beneficio;
    }

    public String insert() {
        dao.insert(beneficio);
        return "beneficiodispfrm";
    }

    public String edit(Beneficio i) {
        beneficio = (Beneficio) beneficios.getRowData();
        return "beneficiodispfrm";
    }

    public String update() {
        dao.update(beneficio);
        return "beneficiodisplst";
    }

    public String delete(Beneficio i) {
        dao.delete(i);
        return "beneficiodisplst";
    }

    public String salvar() {
        if (beneficio.getBen_codigo()> 0) {
            dao.update(beneficio);
        } else {
            dao.insert(beneficio);
        }
        return "beneficiodisplst";
    }

    public String listar() {
        return "beneficiodisplst";
    }
}
