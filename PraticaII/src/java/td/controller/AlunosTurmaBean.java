package td.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import td.dao.AlunosTurmaDAO;
import td.dao.TurmaDAO;
import td.model.AlunosTurma;
import td.model.Turma;

@ManagedBean
@RequestScoped
public class AlunosTurmaBean {
    
    private final String sTitle = AlunosTurma.sTitle;

    private final String pTitle = AlunosTurma.pTitle;

    private List<Turma> lstturma;
    private TurmaDAO turmadao = new TurmaDAO();

    private AlunosTurma alunos_turma = new AlunosTurma();
    private AlunosTurmaDAO dao = new AlunosTurmaDAO();
    private DataModel alunos_turmas;
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public AlunosTurma getAlunos_turma() {
        return alunos_turma;
    }

    public void setAlunos_turma(AlunosTurma alunos_turma) {
        this.alunos_turma = alunos_turma;
    }

    public DataModel getAlunos_turmas() {
        this.alunos_turmas = new ListDataModel(dao.findAll());
        return alunos_turmas;
    }

    public void setAlunos_turmas(DataModel alunos_turmas) {
        this.alunos_turmas = alunos_turmas;
    }
    
    public TurmaDAO getTurmadao() {
        return turmadao;
    }

    public void setTurmadao(TurmaDAO turmadao) {
        this.turmadao = turmadao;
    }
    
 
    public List<Turma> getLstturma() {
        lstturma = turmadao.findAll();
        return lstturma;
    }

    public void setLstturma(List<Turma> lstturma) {
        this.lstturma = lstturma;
    }
    public String insert() {
        dao.insert(alunos_turma);
        return "alunosturmalst";
    }
    
    public String edit(AlunosTurma i) {
        alunos_turma = (AlunosTurma) alunos_turmas.getRowData();
        return "alunosturmalst";
    }

    public String update() {
        dao.update(alunos_turma);
        return "alunosturmalst";
    }
    
    public String delete(AlunosTurma i) {
        dao.delete(i);
        return "alunosturmalst";
    }
    
    public String salvar() {
        if (alunos_turma.getTurma().getTur_codigo()> 0)
            dao.update(alunos_turma);
        else 
            dao.insert(alunos_turma);
        
        return "alunosturmalst";
    }

    public String listar() {
        return "alunosturmalst";
    }
}