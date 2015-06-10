package td.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import java.util.List;
import td.dao.SolicitacaoDAO;
import td.model.Solicitacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class SolicitacaoBean {

    private final String sTitle = Solicitacao.sTitle;
    private final String pTitle = Solicitacao.pTitle;
    
    private List<Pessoa> lstpessoa;
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoadao = new PessoaDAO();

    private Solicitacao solicitacao = new Solicitacao();
    private SolicitacaoDAO dao = new SolicitacaoDAO();
    private DataModel solicitacoes;
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public DataModel getSolicitacoes() {
        this.solicitacoes = new ListDataModel(dao.findAll());
        return solicitacoes;
    }

    public void setSolicitacoes(DataModel solicitacoes) {
        this.solicitacoes = solicitacoes;
    }
    
    public String insert() {
        dao.insert(solicitacao);
        return "solicitacaolst";
    }
    
    public String edit(Solicitacao i) {
        solicitacao = (Solicitacao) solicitacoes.getRowData();
        return "solicitacaofrm";
    }

    public String update() {
        dao.update(solicitacao);
        return "solicitacaolst";
    }
    
    public String delete(Solicitacao i) {
        dao.delete(i);
        return "solicitacaolst";
    }
    
    public String salvar() {
        if (solicitacao.getSol_codigo()> 0)
            dao.update(solicitacao);
        else 
            dao.insert(solicitacao);
        
        return "solicitacaolst";
    }

    public String listar() {
        return "solicitacaolst";
    }
    
    public List<Pessoa> getLstpessoa() {
        lstpessoa = pessoadao.findAll();
        return lstpessoa;
    }

    public void setLstpessoa(List<Pessoa> lstpessoa) {
        this.lstpessoa = lstpessoa;
    }
}
