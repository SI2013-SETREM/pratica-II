package td.controller;

import td.dao.AlunosTreinamentoDAO;
import td.model.AlunosTreinamento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class AlunosTreinamentoBean {

    private final String sTitle = AlunosTreinamento.sTitle;

    private final String pTitle = AlunosTreinamento.pTitle;
    
    private AlunosTreinamento alunos_treinamento = new AlunosTreinamento();
    private AlunosTreinamentoDAO dao = new AlunosTreinamentoDAO();
    private DataModel alunos_treinamentos;
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public AlunosTreinamento getAlunos_treinamento() {
        return alunos_treinamento;
    }

    public void setAlunos_treinamento(AlunosTreinamento alunos_treinamento) {
        this.alunos_treinamento = alunos_treinamento;
    }
    
    public DataModel getAlunos_treinamentos() {
        this.alunos_treinamentos = new ListDataModel(dao.findAll());
        return alunos_treinamentos;
    }

    public void setAvaliacoes(DataModel alunos_treinamentos) {
        this.alunos_treinamentos = alunos_treinamentos;
    }
    
    public String insert() {
        dao.insert(alunos_treinamento);
        return "alunostreinamentolst";
    }
    
    public String edit(AlunosTreinamento i) {
        alunos_treinamento = (AlunosTreinamento) alunos_treinamentos.getRowData();
        return "alunostreinamentofrm";
    }

    public String update() {
        dao.update(alunos_treinamento);
        return "alunostreinamentolst";
    }
    
    public String delete(AlunosTreinamento i) {
        dao.delete(i);
        return "alunostreinamentolst";
    }
    
    public String salvar() {
        if (alunos_treinamento.> 0)
            dao.update(alunos_treinamento);
        else 
            dao.insert(alunos_treinamento);
        
        return "alunostreinamentolst";
    }

    public String listar() {
        return "alunostreinamentolst";
    }
    
}
