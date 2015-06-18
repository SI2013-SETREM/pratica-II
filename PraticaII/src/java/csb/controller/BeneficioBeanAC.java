package csb.controller;

import csb.dao.BeneficioDAO;
import csb.model.Beneficio;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean(name = "beneficioMBAC", eager = true)
@ApplicationScoped
public class BeneficioBeanAC {
    private List<Beneficio> lsBeneficios;
    private BeneficioDAO dao = new BeneficioDAO();

    public List<Beneficio> getBeneficios() {
        lsBeneficios = dao.findAll();
        return lsBeneficios;
    }
}
