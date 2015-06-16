package td.controller;

import cfg.model.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;
import td.dao.PessoasReceberTreinamentoDAO;
import td.model.PessoasReceberTreinamento;
import td.model.Solicitacao;

@ManagedBean
public class PessoasReceberTreinamentoBean {

    private PessoasReceberTreinamento pesSol = new PessoasReceberTreinamento();
    private PessoasReceberTreinamentoDAO dao = new PessoasReceberTreinamentoDAO();
    private DataModel pesSols;
    //private DataModel pessoas;
    //private DataModel solicitacoes;
    private List<PessoasReceberTreinamento> lstPessoasReceberTreinamento;
    
    public PessoasReceberTreinamentoBean() {
    }
   /*
    public DataModel getPessoas() {
        List<PessoasReceberTreinamento> lsPessoasReceberTreinamento = dao.GetListPessoasReceberTreinamento(0, 0);
        List<Pessoa> lsPessoas = new ArrayList<>();
        List<Integer> lsCod = new ArrayList<>();
        for (PessoasReceberTreinamento pa : lsPessoasReceberTreinamento) {
            if (!lsCod.contains(pa.getSolicitacao().getSol_codigo())) {
                lsCod.add(pa.getSolicitacao().getSol_codigo());
                lsPessoas.add(pa.getPessoa());
            }
        }
        pessoas = new ListDataModel(lsPessoas);
        return pessoas;
    }*/
   
    public PessoasReceberTreinamento getPesSol() {
        return pesSol;
    }

    public void setPesSol(PessoasReceberTreinamento pesSol) {
        this.pesSol = pesSol;
    }
    
    public DataModel getPesSols() {
        return pesSols;
    }

    public void setPesSols(DataModel pesSols) {
        this.pesSols = pesSols;
    }
    
    public String insert() {
        dao.insert(pesSol);
        return "solicitacaolst";
    }

    public String edit(PessoasReceberTreinamento i) {
        pesSol = (PessoasReceberTreinamento) pesSols.getRowData();
        return "solicitacaolst";
    }

    public String details(PessoasReceberTreinamento i) {
        pesSol = (PessoasReceberTreinamento) pesSols.getRowData();
        return "solicitacaolst";
    }

    public String update() {
        dao.update(pesSol);
        return "solicitacaolst";
    }

    public String delete(PessoasReceberTreinamento i) {
        dao.delete(i);
        return "solicitacaolst";
    }

    public String salvar() {
        if (pesSol.getSolicitacao().getSol_codigo()> 0)
            dao.update(pesSol);
        else 
            dao.insert(pesSol);
        
        return "solicitacaolst";
    }

    public String listar() {
        return "solicitacaolst";
    }
    
    public List<PessoasReceberTreinamento> GetListPessoasReceberTreinamento(int pes_codigo, int sol_codigo) {
        lstPessoasReceberTreinamento = dao.GetListPessoasReceberTreinamento(pes_codigo, sol_codigo);
        return lstPessoasReceberTreinamento;
    }
}
