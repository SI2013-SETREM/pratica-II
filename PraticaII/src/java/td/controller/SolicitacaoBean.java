package td.controller;

import ad.dao.CompetenciaDAO;
import ad.model.Competencia;
import cfg.dao.LogDAO;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import td.dao.SolicitacaoDAO;
import td.model.Solicitacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import td.dao.CompetenciasSolicitacaoDAO;
import td.model.CompetenciasSolicitacao;
import td.dao.PessoasReceberTreinamentoDAO;
import td.model.PessoasReceberTreinamento;

@ManagedBean
@RequestScoped
public class SolicitacaoBean {

    private final String sTitle = Solicitacao.sTitle;
    private final String pTitle = Solicitacao.pTitle;
    private String Title = "Dados da " + sTitle;

    private List<Pessoa> lstpessoa;
    private List<Pessoa> lstUmapessoa;
    private List<Competencia> lstcompetencia;

    // private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoadao = new PessoaDAO();
    private CompetenciaDAO compdao = new CompetenciaDAO();
    private CompetenciasSolicitacaoDAO compSolDao = new CompetenciasSolicitacaoDAO();
    private PessoasReceberTreinamentoDAO pesTreDao = new PessoasReceberTreinamentoDAO();

    private Solicitacao solicitacao = new Solicitacao();
    private SolicitacaoDAO dao = new SolicitacaoDAO();
    private DataModel solicitacoes;

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return Title;
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
        LogDAO.insert("Solicitacao", "Deletou solicitação código: " + i.getSol_codigo()
                + ", data: " + i.getSol_data() + ", prioridade: " + i.getSol_prioridade());
        return "solicitacaolst";
    }

    public String salvar() {
        if (solicitacao.getSol_codigo() > 0) {
            // dao.update(solicitacao);
            if (ValidaDados()) {
                dao.update(solicitacao);
                LogDAO.insert("Solicitacao", "Alterou solicitação código: " + solicitacao.getSol_codigo()
                        + ", data: " + solicitacao.getSol_data() + ", prioridade: " + solicitacao.getSol_prioridade());
                if (SalvaListas()) {
                    return "solicitacaolst";
                } else {
                    return "solicitacaolst";
                }
            }
        } else {
            if (ValidaDados()) {
                dao.insert(solicitacao);
                LogDAO.insert("Solicitacao", "Cadastrou solicitação código: " + solicitacao.getSol_codigo()
                        + ", data: " + solicitacao.getSol_data() + ", prioridade: " + solicitacao.getSol_prioridade());
                if (SalvaListas()) {
                    return "solicitacaolst";
                } else {
                    return "solicitacaolst";
                }
            } else {
                return "solicitacaofrm";
            }
        }
        return "solicitacaolst";
    }

    public String listar() {
        return "solicitacaolst";
    }

    public List<Pessoa> getLstUmapessoa() {
        lstUmapessoa = pessoadao.findAll();
        return lstUmapessoa;
    }

    public void setLstUmapessoa(List<Pessoa> lstUmapessoa) {
        this.lstUmapessoa = lstUmapessoa;
    }

    public List<Pessoa> getLstpessoa() {
        int i = solicitacao.getSol_codigo();
        if (i > 0) {
            pessoadao.id = i;
            lstpessoa = pessoadao.findPesSol();
        }
        return lstpessoa;
    }

    public void setLstpessoa(List<Pessoa> lstpessoa) {
        this.lstpessoa = lstpessoa;
    }

    public List<Competencia> getLstcompetencia() {
        int i = solicitacao.getSol_codigo();
        if (i > 0) {
            compdao.idSol = i;
            lstcompetencia = compdao.findCompSol();
        }
        return lstcompetencia;
    }

    public void setLstcompetencia(List<Competencia> lstcompetencia) {
        this.lstcompetencia = lstcompetencia;
    }

    public List<Pessoa> completePessoa(String query) {
        return pessoadao.searchPessoa(query);
    }

    public List<Competencia> completeCompetencia(String query) {
        return compdao.searchCompetencia(query);
    }

    private boolean ValidaDados() {//Verifica as Listas se não estão vazias
        if (lstpessoa == null) {
            lstpessoa = new ArrayList<>();
        }
        if (lstcompetencia == null) {
            lstcompetencia = new ArrayList<>();
        }
        return true;
    }

    private boolean SalvaListas() {
        int i = solicitacao.getSol_codigo();
        if (i == 0) {
            try {
                SalvarPesCompNovo(filtraCompetencia(lstcompetencia), filtraPessoas(lstpessoa));
                return true;
            } catch (Exception e) {
                Title = e.toString();
            }
        } else {
            try {
                SalvarPesCompExistente(filtraCompetencia(lstcompetencia), filtraPessoas(lstpessoa));
                return true;
            } catch (Exception e) {
                Title = e.toString();
            }
        }
        return true;
    }

    private List<Competencia> filtraCompetencia(List<Competencia> lstCompetencia) {
        List<Integer> lsCod = new ArrayList<>();
        List<Competencia> lsItens = new ArrayList<>();
        if (!lstCompetencia.isEmpty()) {
            for (Competencia c : lstCompetencia) {
                if (c != null && !lsCod.contains(c.getCmp_codigo())) {
                    lsCod.add(c.getCmp_codigo());
                    lsItens.add(c);
                }
            }
        }
        return lsItens;
    }

    private List<Pessoa> filtraPessoas(List<Pessoa> lsPessoas) {//Filtra Lista de pessoas, para não repetir uma pessoa ao salvar
        List<Integer> lsCod = new ArrayList<>();
        List<Pessoa> lsItens = new ArrayList<>();
        if (!lsPessoas.isEmpty()) {
            for (Pessoa p : lsPessoas) {
                if (p != null && !lsCod.contains(p.getPes_codigo())) {
                    lsCod.add(p.getPes_codigo());
                    lsItens.add(p);
                }
            }
        }
        return lsItens;
    }

    private void SalvarPesCompNovo(List<Competencia> lsCompetencia, List<Pessoa> lsPessoa) {//Salva a lista de cargos e pessoas que fazem parte da avlaiação, basta passar a lista de Cargos e Pessoas e o Tipo (Colaborador= 1 ou Avaliador = 2)
        if (!lsPessoa.isEmpty()) {
            for (Pessoa p : lsPessoa) {
                PessoasReceberTreinamento pes = new PessoasReceberTreinamento();
                pes.setPessoa(p);
                pes.setSolicitacao(solicitacao);
                pesTreDao.insert(pes);
            }
        }
        if (!lsCompetencia.isEmpty()) {
            for (Competencia c : lsCompetencia) {
                CompetenciasSolicitacao comp = new CompetenciasSolicitacao();
                comp.setCompetencia(c);
                comp.setSolicitacao(solicitacao);
                compSolDao.insert(comp);
            }
        }
    }

    private void SalvarPesCompExistente(List<Competencia> lsCompetencia, List<Pessoa> lsPessoa) {//Salva a lista de cargos e pessoas que fazem parte da avlaiação, basta passar a lista de Cargos e Pessoas e o Tipo (Colaborador= 1 ou Avaliador = 2)
        int i = solicitacao.getSol_codigo();
        compSolDao.idSol = i;
        pesTreDao.idSol = i;
        compSolDao.deletaCompSol();
        pesTreDao.deletaPesSol();
        if (!lsPessoa.isEmpty()) {
            for (Pessoa p : lsPessoa) {
                PessoasReceberTreinamento pes = new PessoasReceberTreinamento();
                pes.setPessoa(p);
                pes.setSolicitacao(solicitacao);
                pesTreDao.insert(pes);
            }
        }
        if (!lsCompetencia.isEmpty()) {
            for (Competencia c : lsCompetencia) {
                CompetenciasSolicitacao comp = new CompetenciasSolicitacao();
                comp.setCompetencia(c);
                comp.setSolicitacao(solicitacao);
                compSolDao.insert(comp);
            }
        }
    }
}
