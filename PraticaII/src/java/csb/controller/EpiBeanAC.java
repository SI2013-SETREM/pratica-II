package csb.controller;

import ad.dao.CompetenciaDAO;
import ad.model.Competencia;
import csb.dao.EpiDAO;
import csb.model.Epi;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean(name = "epiMBAC", eager = true)
@ApplicationScoped
public class EpiBeanAC {

    private List<Epi> lsEpi;
    private EpiDAO dao = new EpiDAO();

    public List<Epi> getEpis() {
        lsEpi = dao.findEpc();
        return lsEpi;
    }
}
