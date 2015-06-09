package td.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import td.dao.TreinamentoDAO;
import td.dao.TurmaDAO;
import td.model.AlunosTurma;
import td.model.Treinamento;
import td.model.Turma;

@ManagedBean
@RequestScoped
public class TurmaBean {

    private final String sTitle = Turma.sTitle;

    private final String pTitle = Turma.pTitle;
    
    private List<Treinamento> lsttreinamento;
    private Treinamento treinamento = new Treinamento();
    private TreinamentoDAO treinamentodao = new TreinamentoDAO();
    
    private Turma turma = new Turma();
    private TurmaDAO dao = new TurmaDAO();
    private DataModel turmas;
    
    public List<Treinamento> getLsttreinamento() {
        lsttreinamento = treinamentodao.findAll();
        return lsttreinamento;
    }

    public void setLsttreinamento(List<Treinamento> lsttreinamento) {
        this.lsttreinamento = lsttreinamento;
    }
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public DataModel getTurmas() {
        this.turmas = new ListDataModel(dao.findAll());
        return turmas;
    }

    public void setTurmas(DataModel turmas) {
        this.turmas = turmas;
    }
    
    public String insert() {
        dao.insert(turma);
        return "turmalst";
    }
    
    public String edit(AlunosTurma i) {
        turma = (Turma) turmas.getRowData();
        return "turmalst";
    }

    public String update() {
        dao.update(turma);
        return "turmalst";
    }
    
    public String delete(Turma i) {
        dao.delete(i);
        return "turmalst";
    }
    
    public String salvar() {
        if (turma.getTur_codigo()> 0)
            dao.update(turma);
        else 
            dao.insert(turma);
        
        return "turmalst";
    }

    public String listar() {
        return "turmalst";
    }
    
}
