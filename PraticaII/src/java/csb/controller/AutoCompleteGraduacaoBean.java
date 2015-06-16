package csb.controller;

import csb.model.Graduacao;
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
public class AutoCompleteGraduacaoBean {
    @ManyToMany
    @JoinTable(name = "csb_graduacoes_cargo")
    private List<Graduacao> graduacoes;
    
    @ManagedProperty("#{graduacaoMBAC}")
    private GraduacaoBeanAC serviceGraduacao;
    
    public List<Graduacao> completaDescricaoGraduacao(String query) {
        List<Graduacao> allThemes = serviceGraduacao.getGraduacoes();
        List<Graduacao> filteredThemes = new ArrayList<Graduacao>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Graduacao skin = allThemes.get(i);
            if(skin.getGrd_descricao().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
    
    public List<Graduacao> getGraduacoes() {
        return graduacoes;
    }

    public void setGraduacoes(List<Graduacao> graduacoes) {
        this.graduacoes = graduacoes;
    }  
    
    public void setServiceGraduacao(GraduacaoBeanAC serviceGraduacao) {
        this.serviceGraduacao = serviceGraduacao;
    }
}