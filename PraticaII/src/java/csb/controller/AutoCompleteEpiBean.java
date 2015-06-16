package csb.controller;

import csb.model.Epi;
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
public class AutoCompleteEpiBean {
    @ManyToMany
    @JoinTable(name = "csb_episetor")
    private List<Epi> epis;
    
    @ManagedProperty("#{epiMBAC}")
    private EpiBeanAC serviceEpi;

    public List<Epi> completaDescricaoEpi(String query) {
        List<Epi> allThemes = serviceEpi.getEpis();
        List<Epi> filteredThemes = new ArrayList<Epi>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Epi skin = allThemes.get(i);
            if(skin.getEpi_descricao().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
    
    public List<Epi> getEpis() {
        return epis;
    }

    public void setEpis(List<Epi> epis) {
        this.epis = epis;
    }  
    
    public void setServiceEpi(EpiBeanAC serviceEpi) {
        this.serviceEpi = serviceEpi;
    }
}
