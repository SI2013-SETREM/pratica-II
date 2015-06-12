package td.controller;

import ad.model.Competencia;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@ManagedBean
public class AutoCompleteCompetenciaBean {

    @ManyToMany
    @JoinTable(name = "trd_competencias_solicitacao")
    private List<Competencia> competencias;
    
    @ManyToMany
    @JoinTable(name = "trd_competencias_treinamento")
    private List<Competencia> competenciastre;

    @ManagedProperty("#{competenciaMBAC}")
    private CompetenciaBeanAC serviceCompetencia;

    public List<Competencia> completaNomeCompetencia(String query) {
        List<Competencia> allThemes = serviceCompetencia.getCompetencias();
        List<Competencia> filteredThemes = new ArrayList<Competencia>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Competencia skin = allThemes.get(i);
            if(skin.getCmp_descricao().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
    
    public List<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<Competencia> competencias) {
        this.competencias = competencias;
    }  
    
    public List<Competencia> getCompetenciastre() {
        return competenciastre;
    }

    public void setCompetenciastre(List<Competencia> competenciastre) {
        this.competenciastre = competenciastre;
    }
    
    public void setServiceCompetencia(CompetenciaBeanAC serviceCompetencia) {
        this.serviceCompetencia = serviceCompetencia;
    }
}
