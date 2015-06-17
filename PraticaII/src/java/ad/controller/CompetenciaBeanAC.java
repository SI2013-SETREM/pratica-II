package ad.controller;

import ad.dao.CompetenciaDAO;
import ad.model.Competencia;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean(name = "competenciaMBAC", eager = true)
@ApplicationScoped
public class CompetenciaBeanAC {

    private List<Competencia> lsCompetencias;
    private CompetenciaDAO dao = new CompetenciaDAO();

    public List<Competencia> getCompetencias() {
        lsCompetencias = dao.findAllActive();
        return lsCompetencias;
    }
}
