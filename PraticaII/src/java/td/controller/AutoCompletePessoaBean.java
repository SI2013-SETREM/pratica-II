package td.controller;
import ad.model.Competencia;
import cfg.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
 
@ManagedBean
public class AutoCompletePessoaBean {
     
    @ManyToMany
    @JoinTable(name = "trd_pessoas_recebertreinamento")
    private List<Pessoa> funcionarios;
  //private List<Pessoa> lstpessoas;

    @ManyToMany
    @JoinTable(name = "trd_instrutores_treinamento")
    private List<Pessoa> instrutores;
    
    @ManyToMany
    @JoinTable(name = "trd_alunos_turma")
    private List<Pessoa> alunos;
    
    @ManagedProperty("#{pessoaMBAC}")
    private PessoaBeanAC servicePessoa;
     
    public List<Pessoa> completaNomePessoa(String query) {
        List<Pessoa> allThemes = servicePessoa.getPessoas();
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
    
    public List<Pessoa> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(List<Pessoa> instrutores) {
        this.instrutores = instrutores;
    }
    
    public List<Pessoa> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Pessoa> alunos) {
        this.alunos = alunos;
    }
    
    public void setServicePessoa(PessoaBeanAC servicePessoa) {
        this.servicePessoa = servicePessoa;
    }
}
