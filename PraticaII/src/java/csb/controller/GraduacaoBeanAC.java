package csb.controller;

import csb.dao.GraduacaoDAO;
import csb.model.Graduacao;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean(name = "graduacaoMBAC", eager = true)
@ApplicationScoped
public class GraduacaoBeanAC {

    private List<Graduacao> lsGraduacoes;
    private GraduacaoDAO dao = new GraduacaoDAO();

    public List<Graduacao> getGraduacoes() {
        lsGraduacoes = dao.findAll();
        return lsGraduacoes;
    }
}
