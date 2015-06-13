package td.controller;

import cfg.model.Pessoa;
import cfg.dao.PessoaDAO;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
@ManagedBean(name="pessoaMBAC", eager = true)
@ApplicationScoped
public class PessoaBeanAC {
     
    private List<Pessoa> listapessoas;
    private PessoaDAO dao = new PessoaDAO();
     
    public List<Pessoa> getPessoas() {
        listapessoas = dao.findPessoasTreinamento();
        return listapessoas;
    } 

}
