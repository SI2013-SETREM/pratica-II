package td.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;
import td.dao.CompetenciasSolicitacaoDAO;
import td.model.CompetenciasSolicitacao;
import td.model.Solicitacao;

@ManagedBean
public class CompetenciasSolicitacaoBean {

    private CompetenciasSolicitacao compSol = new CompetenciasSolicitacao();
    private CompetenciasSolicitacaoDAO dao = new CompetenciasSolicitacaoDAO();
    private DataModel compSols;
  //  private DataModel solicitacoes;
    private List<CompetenciasSolicitacao> lstCompetenciasSolicitacao;
/*
    public DataModel getSolicitacoes() {
        List<CompetenciasSolicitacao> lsCompetenciasSolicitacao = dao.GetListCompetenciasSolicitacao(0, 0);
        List<Solicitacao> lsSolicitacao = new ArrayList<>();
        List<Integer> lsCod = new ArrayList<>();
        for (CompetenciasSolicitacao pa : lsCompetenciasSolicitacao) {
            if (!lsCod.contains(pa.getSolicitacao().getSol_codigo())) {
                lsCod.add(pa.getSolicitacao().getSol_codigo());
                lsSolicitacao.add(pa.getSolicitacao());
            }
        }
        solicitacoes = new ListDataModel(lsSolicitacao);
        return solicitacoes;
    }*/
    
    
    public CompetenciasSolicitacaoBean() {
    }
    
    public CompetenciasSolicitacao getCompSol() {
        return compSol;
    }

    public void setCompSol(CompetenciasSolicitacao compSol) {
        this.compSol = compSol;
    }

    public DataModel getCompSols() {
        return compSols;
    }

    public void setCompSols(DataModel compSols) {
        this.compSols = compSols;
    }
    
    public String insert() {
        dao.insert(compSol);
        return "solicitacaolst";
    }

    public String edit(CompetenciasSolicitacao i) {
        compSol = (CompetenciasSolicitacao) compSols.getRowData();
        return "solicitacaolst";
    }

    public String details(CompetenciasSolicitacao i) {
        compSol = (CompetenciasSolicitacao) compSols.getRowData();
        return "solicitacaolst";
    }

    public String update() {
        dao.update(compSol);
        return "solicitacaolst";
    }

    public String delete(CompetenciasSolicitacao i) {
        dao.delete(i);
        return "solicitacaolst";
    }

    public String salvar() {
        if (compSol.getSolicitacao().getSol_codigo()> 0)
            dao.update(compSol);
        else 
            dao.insert(compSol);
        
        return "solicitacaolst";
    }

    public String listar() {
        return "solicitacaolst";
    }
    
    public List<CompetenciasSolicitacao> GetListCompetenciasSolicitacao(int cmp_codigo, int sol_codigo) {
        lstCompetenciasSolicitacao = dao.GetListCompetenciasSolicitacao(cmp_codigo, sol_codigo);
        return lstCompetenciasSolicitacao;
    }
}
