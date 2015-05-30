
package rs.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.dao.PerguntaDAO;
import rs.model.Pergunta;

@ManagedBean
@RequestScoped
public class PerguntaBean {
    
    private final String sTitle = Pergunta.sTitle;
    private final String pTitle = Pergunta.pTitle;
    
    private Pergunta pergunta = new Pergunta();
    private PerguntaDAO dao = new PerguntaDAO();
    private DataModel perguntas;
    
    public PerguntaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public DataModel getPerguntas() {
        this.perguntas = new ListDataModel(dao.findAll());
        return perguntas;
    }

    public void setPerguntas(DataModel perguntas) {
        this.perguntas = perguntas;
    }
    
    public String insert() {
        dao.insert(pergunta);
        return "perguntalst";
    }
    
    public String edit(Pergunta i) {
        pergunta = (Pergunta) perguntas.getRowData();
        return "perguntafrm";
    }
    
    public String update() {
        dao.update(pergunta);
        return "perguntalst";
    }
    
    public String delete(Pergunta i) {
        dao.delete(i);
        return "perguntalst";
    }
    
    public String salvar() {
        if (pergunta.getPrgCodigo() > 0)
            dao.update(pergunta);
        else 
            dao.insert(pergunta);
        
        return "perguntalst";
    }
    
    public String listar() {
        return "perguntalst";
    }
    
    
}
