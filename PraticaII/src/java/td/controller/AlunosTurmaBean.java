package td.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import java.util.ArrayList;
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
    
    private String Title = "Dados da " + sTitle;

    private List<Turma> lstturma;
    private TurmaDAO turmadao = new TurmaDAO();
    
    private List<Pessoa> lstpessoa;
    
    public int id;
    
    private PessoaDAO pessoadao = new PessoaDAO();
    
    private AlunosTurma alunos_turma = new AlunosTurma();
    private AlunosTurmaDAO dao = new AlunosTurmaDAO();
    private DataModel alunos_turmas;
    private DataModel alunos_turmasD;

    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return Title;
    }

    public List<Turma> getLstturma() {
       // int i = alunos_turma.getPst_oid();
       // if(i > 0){
          //  turmadao.id = i;
            lstturma = turmadao.findAll();
      //  }
        return lstturma;
    }

    public void setLstturma(List<Turma> lstturma) {
        this.lstturma = lstturma;
    }

    public List<Pessoa> getLstpessoa() {
        lstpessoa = pessoadao.findAll();
        return lstpessoa;
    }

    public void setLstpessoa(List<Pessoa> lstpessoa) {
        this.lstpessoa = lstpessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public DataModel getAlunos_turmasD() {
        this.alunos_turmasD = new ListDataModel(dao.findPesTur(getId()));
        return alunos_turmasD;
    }

    public void setAlunos_turmasD(DataModel alunos_turmasD) {
        this.alunos_turmasD = alunos_turmasD;
    }

    public String visualiza(int i) {
        setId(i);
        return "alunosturmalstd";
    }
    
    public String listar() {
        return "alunosturmalst";
    }
    
     public String insert() {
        dao.insert(alunos_turma);
        return "alunosturmalst";
    }
    
    public String edit(AlunosTurma i) {
        alunos_turma = (AlunosTurma) alunos_turmas.getRowData();
        return "alunosturmafrm";
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
        dao.update(alunos_turma);
        return "alunosturmalst";
    }
    
}