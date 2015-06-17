package ad.controller;

import ad.model.Competencia;
import ad.controller.CompetenciaBeanAC;
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
public class AutoCompleteCompetenciaBean {

    @ManyToMany
    @JoinTable(name = "csb_competencias_cargo")   
    private List<Competencia> competencias;
    
    @ManagedProperty("#{competenciaMBAC}")
    private CompetenciaBeanAC serviceCompetencia;
    
    public List<Competencia> completaDescricaoCompetencia(String query) {
        List<Competencia> allThemes = serviceCompetencia.getCompetencias();
        List<Competencia> filteredThemes = new ArrayList<>();
         
        for (Competencia skin : allThemes) {
            if(skin.getCmp_descricao().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
    
    public List<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<Competencia> graduacoes) {
        this.competencias = graduacoes;
    }  
    
    public void setServiceCompetencia(CompetenciaBeanAC serviceCompetencia) {
        this.serviceCompetencia = serviceCompetencia;
    }
}
