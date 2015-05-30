
package rs.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.dao.QuestionarioDAO;
import rs.model.Questionario;

@ManagedBean
@RequestScoped
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
    
    public String insert() {
        dao.insert(questionario);
        return "questionariolst";
    }
    
    public String edit(Questionario i) {
        questionario = (Questionario) questionarios.getRowData();
        return "questionariofrm";
    }
    
    public String update() {
        dao.update(questionario);
        return "questionariolst";
    }
    
    public String delete(Questionario i) {
        dao.delete(i);
        return "questionariolst";
    }
    
    public String salvar() {
        if (questionario.getQstCodigo() > 0)
            dao.update(questionario);
        else 
            dao.insert(questionario);
        
        return "questionariolst";
    }
    
    public String listar() {
        return "questionariolst";
    }
    
    public void addPergunta() {
        this.questionario.addPergunta();
    }
    
    
}
