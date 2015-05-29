
package cfg.controller;

import cfg.dao.MensagemDAO;
import cfg.model.Bairro;
import cfg.model.Mensagem;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class MensagemBean {
    
    private final String sTitle = Mensagem.sTitle;
    private final String pTitle = Mensagem.pTitle;
    
    private Mensagem mensagem = new Mensagem();
    private MensagemDAO dao = new MensagemDAO();
    private DataModel bairros;
    
    public MensagemBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem= mensagem;
    }

    public DataModel getMensagens() {
        this.bairros = new ListDataModel(dao.findAll());
        return bairros;
    }

    public void setMensagens(DataModel idiomas) {
        this.bairros= bairros;
    }
    
    public String insert() {
        dao.insert(mensagem);
        return "mensagemfrm";
    }
    
    public String edit(Mensagem i) {
        mensagem= (Mensagem) bairros.getRowData();
        return "mensagemfrm";
    }
    
    public String update() {
        dao.update(mensagem);
        return "mensagemfrm";
    }
    
    public String delete(Mensagem i) {
        dao.delete(i);
        return "mensagemfrm";
    }
    
    public String salvar() {
        if (mensagem.getMsgCodigo()> 0)
            dao.update(mensagem);
        else 
            dao.insert(mensagem);
        
        return "mensagemfrm";
    }
    
    public String listar() {
        return "mensagemfrm";
    }
    
    
}
