package td.controller;

import td.dao.TreinamentoDAO;
import td.model.Treinamento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class TreinamentoBean {

    private Treinamento treinamento = new Treinamento();
    private TreinamentoDAO dao = new TreinamentoDAO();
    private DataModel treinamentos;

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }

    public DataModel getTreinamentos() {
        this.treinamentos = new ListDataModel(dao.findAll());
        return treinamentos;
    }

    public void setTreinamentos(DataModel treinamentos) {
        this.treinamentos = treinamentos;
    }
    
    public String insert() {
        dao.insert(treinamento);
        return "treinamentolst";
    }
    
    public String edit(Treinamento i) {
        treinamento = (Treinamento) treinamentos.getRowData();
        return "treinamentofrm";
    }

    public String update() {
        dao.update(treinamento);
        return "treinamentolst";
    }
    
    public String delete(Treinamento i) {
        dao.delete(i);
        return "treinamentolst";
    }
    
    public String salvar() {
        if (true) {
            dao.update(treinamento);
        } else {
            dao.insert(treinamento);
        }
        return "treinamentolst";
    }

    public String listar() {
        return "treinamentolst";
    }
}
