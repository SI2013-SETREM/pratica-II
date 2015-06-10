package td.controller;
import cfg.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
 
@ManagedBean
public class autoCompleteBean {
     
    @ManyToMany
    @JoinTable(name = "trd_pessoas_recebertreinamento")
    private List<Pessoa> funcionarios;
  //private List<Pessoa> lstpessoas;

    @ManagedProperty("#{aaa}")
    private PessoaBeanAC service;
  
     
    public List<Pessoa> completaNome(String query) {
        List<Pessoa> allThemes = service.getPessoas();
        List<Pessoa> filteredThemes = new ArrayList<Pessoa>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Pessoa skin = allThemes.get(i);
            if(skin.getPes_nome().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
 
    public List<Pessoa> getFuncionarios() {
        return funcionarios;
    }
 
    public void setFuncionarios(List<Pessoa> funcionarios) {
        this.funcionarios = funcionarios;
    }
     
     
    public void setService(PessoaBeanAC service) {
        this.service = service;
    }
}
