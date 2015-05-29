
package cfg.controller;

import cfg.dao.MensagemPessoaDAO;
import cfg.model.MensagemPessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class MensagemPessoaBean {
    
    private final String sTitle = MensagemPessoa.sTitle;
    private final String pTitle = MensagemPessoa.pTitle;
    
    private MensagemPessoa mensangempessoa = new MensagemPessoa();
    private MensagemPessoaDAO dao = new MensagemPessoaDAO();
    private DataModel mensangenspessoa;
    
    public MensagemPessoaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public MensagemPessoa getMensagemPessoa() {
        return mensangempessoa;
    }

    public void seMensagemPessoa(MensagemPessoa mensangempessoa) {
        this.mensangempessoa= mensangempessoa;
    }

    public DataModel getMensagemPessoas() {
        this.mensangenspessoa = new ListDataModel(dao.findAll());
        return mensangenspessoa;
    }

    public void setMensagemPessoas(DataModel idiomas) {
        this.mensangenspessoa= mensangenspessoa;
    }
    
    public String insert() {
        dao.insert(mensangempessoa);
        return "mensagempessoalst";
    }
    
    public String edit(MensagemPessoa i) {
        mensangempessoa= (MensagemPessoa) mensangenspessoa.getRowData();
        return "mensagempessoalst";
    }
    
    public String update() {
        dao.update(mensangempessoa);
        return "mensagempessoalst";
    }
    
    public String delete(MensagemPessoa i) {
        dao.delete(i);
        return "mensagempessoalst";
    }
    
    public String salvar() {
        if (mensangempessoa.getMensagem().getMsgCodigo()> 0)
            dao.update(mensangempessoa);
        else 
            dao.insert(mensangempessoa);
        
        return "mensagempessoalst";
    }
    
    public String listar() {
        return "mensagempessoalst";
    }
    
    
}
