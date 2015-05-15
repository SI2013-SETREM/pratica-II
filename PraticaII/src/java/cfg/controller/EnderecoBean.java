
package cfg.controller;

import cfg.dao.EnderecoDAO;
import cfg.model.Endereco;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class EnderecoBean {
    
    private final String sTitle = Endereco.sTitle;
    private final String pTitle = Endereco.pTitle;
    
    private Endereco endereco = new Endereco();
    private EnderecoDAO dao = new EnderecoDAO();
    private DataModel enderecos;
    
    public EnderecoBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco= endereco;
    }

    public DataModel getEnderecos() {
        this.enderecos= new ListDataModel(dao.findAll());
        return enderecos;
    }

    public void setEndereco(DataModel enderecos) {
        this.enderecos= enderecos;
    }
    
    public String insert() {
        dao.insert(endereco);
        return "enderecolst";
    }
    
    public String edit(Endereco i) {
        endereco= (Endereco) enderecos.getRowData();
        return "enderecofrm";
    }
    
    public String update() {
        dao.update(endereco);
        return "enderecolst";
    }
    
    public String delete(Endereco i) {
        dao.delete(i);
        return "enderecolst";
    }
    
    public String salvar() {
        if (endereco.getEnd_codigo()> 0)
            dao.update(endereco);
        else 
            dao.insert(endereco);
        
        return "enderecolst";
    }
    
    public String listar() {
        return "enderecolst";
    }
    
}
