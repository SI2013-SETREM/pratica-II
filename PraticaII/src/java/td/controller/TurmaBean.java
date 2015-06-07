package td.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import td.dao.TurmaDAO;
import td.model.AlunosTurma;
import td.model.Treinamento;
import td.model.Turma;

@ManagedBean
@RequestScoped
public class TurmaBean {

    private final String sTitle = AlunosTurma.sTitle;

    private final String pTitle = AlunosTurma.pTitle;
    
    private List<Treinamento> lsttreinamento;
    
    private Turma turma = new Turma();
    private TurmaDAO dao = new TurmaDAO();
    private DataModel turmas;
    
    public List<Treinamento> getLsttreinamento() {
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
    
    public DataModel getAlunos_treinamentos() {
        this.turmas = new ListDataModel(dao.findAll());
        return turmas;
    }

    public void setAvaliacoes(DataModel alunos_treinamentos) {
        this.turmas = alunos_treinamentos;
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
