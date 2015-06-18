package csb.controller;

import csb.model.Beneficio;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean
public class AutoCompleteBeneficioBean {

    @ManyToMany
    @JoinTable(name = "csb_beneficios_cargo")
    private List<Beneficio> beneficios;

    @ManagedProperty("#{beneficioMBAC}")
    private BeneficioBeanAC serviceBeneficio;

    public List<Beneficio> completaDescricaoBeneficio(String query) {
        List<Beneficio> allThemes = serviceBeneficio.getBeneficios();
        List<Beneficio> filteredThemes = new ArrayList<>();

        for (Beneficio skin : allThemes) {
            if (skin.getBen_descricao().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }

        return filteredThemes;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public void setServiceBeneficio(BeneficioBeanAC serviceBeneficio) {
        this.serviceBeneficio = serviceBeneficio;
    }
}
