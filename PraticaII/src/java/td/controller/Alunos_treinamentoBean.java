package td.controller;

import td.dao.Alunos_treinamentoDAO;
import td.model.Alunos_treinamento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class Alunos_treinamentoBean {

    private Alunos_treinamento alunos_treinamento = new Alunos_treinamento();
    private Alunos_treinamentoDAO dao = new Alunos_treinamentoDAO();
    private DataModel alunos_treinamentos;

    public Alunos_treinamento getAlunos_treinamento() {
        return alunos_treinamento;
    }

    public void setAlunos_treinamento(Alunos_treinamento alunos_treinamento) {
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
        return "alunos_treinamentolst";
    }
    
    public String edit(Alunos_treinamento i) {
        alunos_treinamento = (Alunos_treinamento) alunos_treinamentos.getRowData();
        return "alunos_treinamentofrm";
    }

    public String update() {
        dao.update(alunos_treinamento);
        return "alunos_treinamentolst";
    }
    
    public String delete(Alunos_treinamento i) {
        dao.delete(i);
        return "alunos_treinamentolst";
    }
    
    public String salvar() {
        if (true) {
            dao.update(alunos_treinamento);
        } else {
            dao.insert(alunos_treinamento);
        }
        return "alunos_treinamentolst";
    }

    public String listar() {
        return "alunos_treinamentolst";
    }
    
}
