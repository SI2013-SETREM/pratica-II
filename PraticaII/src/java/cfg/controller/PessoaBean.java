
package cfg.controller;

import cfg.dao.LogDAO;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class PessoaBean {
    
    private final String sTitle = Pessoa.sTitle;
    private final String pTitle = Pessoa.pTitle;
    
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO dao = new PessoaDAO();
    private DataModel pessoas;
    
    public PessoaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa= pessoa;
    }

    public DataModel getPessoas() {
        this.pessoas = new ListDataModel(dao.findAll());
        return pessoas;
    }

    public void setPessoas(DataModel idiomas) {
        this.pessoas= pessoas;
    }
    
    public String insert() {
        dao.insert(pessoa);
        return "pessoalst";
    }
    
    public String edit(Pessoa i) {
        pessoa= (Pessoa) pessoas.getRowData();
        return "pessoafrm";
    }
    
    public String update() {
        dao.update(pessoa);
        return "pessoalst";
    }
    
    public String delete(Pessoa i) {
        dao.delete(i);
        LogDAO.insert("Pessoa", "Deletou pessoa código: " + i.getPes_codigo() + ", nome: " + i.getPes_nome()+ ", código repositório: " + i.getRepositorio().getRep_codigo()+
            ", código bairro: "+i.getBairro().getBai_codigo()+", código endereço: "+i.getEndereco().getEnd_codigo()+", código cidade: "+
            i.getCidade().getCid_codigo()+", código cep nasc: "+i.getCidadenasc().getCid_codigo()+", cpf: "+i.getPes_cpf()+
            ", rg: "+i.getPes_rg()+", data nasc: "+i.getPes_datanasc()+", número endereço: "+i.getPes_numeroend()+", complemento endereço: "+i.getPes_complementoend()+
            ", telefone: "+i.getPes_telefone()+", email"+i.getPes_email()+", pai: "+i.getPes_pai()+", mãe: "+i.getPes_mae()+
            ", tipo pessoa: "+i.getPes_tipo()+", estado civil: "+i.getPes_estadocivil()+", observações: "+i.getPes_observacoes()+
            ", necessidade especial: "+i.getPes_necessidadeespecialdsc()+", data cadastro: "+i.getPes_datacadastro());
        return "pessoalst";
    }

    public String salvar() {
        if (pessoa.getPes_codigo() > 0) {
            dao.update(pessoa);
            LogDAO.insert("Pessoa", "Alterou pessoa código: " + pessoa.getPes_codigo() + ", nome: " + pessoa.getPes_nome()+ ", código repositório: " + pessoa.getRepositorio().getRep_codigo()+
            ", código bairro: "+pessoa.getBairro().getBai_codigo()+", código endereço: "+pessoa.getEndereco().getEnd_codigo()+", código cidade: "+
            pessoa.getCidade().getCid_codigo()+", código cep nasc: "+pessoa.getCidadenasc().getCid_codigo()+", cpf: "+pessoa.getPes_cpf()+
            ", rg: "+pessoa.getPes_rg()+", data nasc: "+pessoa.getPes_datanasc()+", número endereço: "+pessoa.getPes_numeroend()+", complemento endereço: "+pessoa.getPes_complementoend()+
            ", telefone: "+pessoa.getPes_telefone()+", email"+pessoa.getPes_email()+", pai: "+pessoa.getPes_pai()+", mãe: "+pessoa.getPes_mae()+
            ", tipo pessoa: "+pessoa.getPes_tipo()+", estado civil: "+pessoa.getPes_estadocivil()+", observações: "+pessoa.getPes_observacoes()+
            ", necessidade especial: "+pessoa.getPes_necessidadeespecialdsc()+", data cadastro: "+pessoa.getPes_datacadastro());
        } else {
            dao.insert(pessoa);
            LogDAO.insert("Pessoa", "Cadastrou pessoa código: " + pessoa.getPes_codigo() + ", nome: " + pessoa.getPes_nome()+ ", código repositório: " + pessoa.getRepositorio().getRep_codigo()+
            ", código bairro: "+pessoa.getBairro().getBai_codigo()+", código endereço: "+pessoa.getEndereco().getEnd_codigo()+", código cidade: "+
            pessoa.getCidade().getCid_codigo()+", código cep nasc: "+pessoa.getCidadenasc().getCid_codigo()+", cpf: "+pessoa.getPes_cpf()+
            ", rg: "+pessoa.getPes_rg()+", data nasc: "+pessoa.getPes_datanasc()+", número endereço: "+pessoa.getPes_numeroend()+", complemento endereço: "+pessoa.getPes_complementoend()+
            ", telefone: "+pessoa.getPes_telefone()+", email"+pessoa.getPes_email()+", pai: "+pessoa.getPes_pai()+", mãe: "+pessoa.getPes_mae()+
            ", tipo pessoa: "+pessoa.getPes_tipo()+", estado civil: "+pessoa.getPes_estadocivil()+", observações: "+pessoa.getPes_observacoes()+
            ", necessidade especial: "+pessoa.getPes_necessidadeespecialdsc()+", data cadastro: "+pessoa.getPes_datacadastro());
        }

        return "pessoalst";
    }
    
    public String listar() {
        return "pessoalst";
    }
}
