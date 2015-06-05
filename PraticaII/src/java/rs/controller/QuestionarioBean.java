
package rs.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.dao.QuestionarioDAO;
import rs.model.Pergunta;
import rs.model.PerguntaOpcao;
import rs.model.Questionario;

@ManagedBean
@SessionScoped
public class QuestionarioBean {
    
    private final String sTitle = Questionario.sTitle;
    private final String pTitle = Questionario.pTitle;
    
    private Questionario questionario = new Questionario();
    private QuestionarioDAO dao = new QuestionarioDAO();
    private DataModel questionarios;
    
    public QuestionarioBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public DataModel getQuestionarios() {
        this.questionarios = new ListDataModel(dao.findAll());
        return questionarios;
    }

    public void setQuestionarios(DataModel questionarios) {
        this.questionarios = questionarios;
    }
    
    public String novo() {
        this.questionario = new Questionario();
        return "questionariofrm?faces-redirect=true";
    }
    
    public String insert() {
        dao.insert(questionario);
        return "questionariolst?faces-redirect=true";
    }
    
    public String edit(Questionario obj) {
//        questionario = (Questionario) questionarios.getRowData();
//        questionario = dao.findById(questionario.getQstCodigo());
        questionario = obj;
        return "questionariofrm?faces-redirect=true";
    }
    
    public String update() {
        dao.update(questionario);
        return "questionariolst?faces-redirect=true";
    }
    
    public String delete(Questionario obj) {
        dao.delete(obj);
        return "questionariolst?faces-redirect=true";
    }
    
    public String salvar() {
        if (questionario.getQstCodigo() > 0)
            dao.update(questionario);
        else 
            dao.insert(questionario);
        
        return "questionariolst?faces-redirect=true";
    }
    
    public String listar() {
        return "questionariolst?faces-redirect=true";
    }
    
    public void addPergunta() {
        this.questionario.addPergunta();
    }
    
    public void delPergunta(Pergunta p) {
        this.questionario.delPergunta(p);
    }
    
    public String getVersao() {
        return FacesContext.class.getPackage().getImplementationVersion();
    }
    
    public void savePergunta(Pergunta p) {
        List<Pergunta> arrPerguntas = this.questionario.getPerguntas();
        int idx = arrPerguntas.indexOf(p);
        arrPerguntas.set(idx, p);
        this.questionario.setPerguntas(arrPerguntas);
    }
    
    public void moveUpPergunta(Pergunta p) {
        this.questionario.moveUpPergunta(p);
    }
    
    public void moveDownPergunta(Pergunta p) {
        this.questionario.moveDownPergunta(p);
    }
    
    public void addPerguntaOpcao(Pergunta p) {
        p.addPerguntaOpcao();
    }
    
    public void delPerguntaOpcao(PerguntaOpcao po) {
        po.getPergunta();
    }
    
}
