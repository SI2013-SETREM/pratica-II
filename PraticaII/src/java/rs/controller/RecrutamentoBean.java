package rs.controller;

import cfg.controller.LoginBean;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import csb.dao.CargoDAO;
import csb.model.Cargo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.model.TreeNode;
import rs.dao.EntrevistaDAO;
import rs.dao.RecrutamentoDAO;
import rs.dao.RecrutamentoPessoasDAO;
import rs.model.CandidatoRecrutamento;
import rs.model.CandidatosEntrevistas;
import rs.model.Entrevista;
import rs.model.Recrutamento;
import rs.model.RecrutamentoPessoa;
import rs.model.RecrutamentoPessoaPK;
import util.Utilidades;

/**
 *
 * @author NADINE
 */
@ManagedBean
@SessionScoped
public class RecrutamentoBean {

    private final String sTitle = Recrutamento.sTitle;
    private final String pTitle = Recrutamento.pTitle;
    private final String sTitleEntrevista = Entrevista.sTitle;
    private final String pTitleEntrevistas = Entrevista.pTitle;

    private Recrutamento recrutamento;
    private RecrutamentoPessoasDAO recrutamentoPessoaDAO = new RecrutamentoPessoasDAO();
    private RecrutamentoDAO dao = new RecrutamentoDAO();
    private List<RecrutamentoPessoa> recrutamentoPessoas;
    private List<Pessoa> pessoas;
    private Pessoa pessoaRecrutamento;
    private RecrutamentoPessoa recrutementoPessoa;

    private PessoaDAO pesDao = new PessoaDAO();
    private Pessoa pessoa = new Pessoa();

    private DataModel recrutamentos;
    private List<CandidatoRecrutamento> candidatosRecrutamento;

    private CargoDAO daocargo = new CargoDAO();
    private TreeNode arvoreCargos;
    private TreeNode selectedNode;
    private List<Cargo> cargos;

    private Entrevista entrevista = new Entrevista();
    private EntrevistaDAO daoEntrevista = new EntrevistaDAO();
    private DataModel entrevistas;
    private List<CandidatosEntrevistas> candidatosEntrevistas;

    public RecrutamentoBean() {
    }

    @PostConstruct
    public void init() {
        arvoreCargos = daocargo.arvoreCargo();
    }

    public TreeNode getArvoreCargos() {
        return arvoreCargos;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public List<Cargo> getCargos() {
        this.cargos = daocargo.findAll();
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public Recrutamento getRecrutamento() {
        if (recrutamento == null) {
            recrutamento = new Recrutamento();
            recrutamento.setRecInicio(new Date());
        }
        return recrutamento;
    }

    public void setRecrutamento(Recrutamento recrutamento) {
        this.recrutamento = recrutamento;
    }

    public RecrutamentoDAO getDao() {
        return dao;
    }

    public void setDao(RecrutamentoDAO dao) {
        this.dao = dao;
    }

    public DataModel getRecrutamentos() {
        this.recrutamentos = new ListDataModel(dao.findAll());
        return recrutamentos;
    }

    public void setRecrutamentos(DataModel recrutamentos) {
        this.recrutamentos = recrutamentos;
    }

    public Entrevista getEntrevista() {
        if (entrevista == null) {
            entrevista = new Entrevista();
            entrevista.setEntDatahora(new Date());
        }
        return entrevista;
    }

    public void setEntrevista(Entrevista entrevista) {
        this.entrevista = entrevista;
    }

    public void setEntrevistas(DataModel entrevistas) {
        this.entrevistas = entrevistas;
    }

    public String insert() {
        dao.insert(recrutamento);
        return "recrutamentolst?faces-redirect=true";
    }

    public String edit() {
        recrutamento = (Recrutamento) recrutamentos.getRowData();
        String pagina = "recrutamentolst?faces-redirect=true";
        if (recrutamento.getRecStatus() == 2) {
            pagina = "recrutamentoCandidatos?faces-redirect=true";
        } else if (recrutamento.getRecStatus() == 3) {
            pagina = "recrutamentoEntrevistalst?faces-redirect=true";
        } else if (recrutamento.getRecStatus() == 4) {
            pagina = "recrutamentoSelecaolst?faces-redirect=true";
        }
        return pagina;
    }

    public String update() {
        dao.update(recrutamento);
        return "recrutamentolst?faces-redirect=true";
    }

    public String altera_status(int status, Recrutamento r) {
        this.setRecrutamento(r);
        recrutamento.setRecStatus(status);
        dao.update(recrutamento);
        return "recrutamentolst?faces-redirect=true";
    }

    public String delete(Recrutamento r) {
        dao.delete(r);
        return "recrutamentolst?faces-redirect=true";
    }

    public String salvar(String pagina) {
        if (recrutamento.getRecCodigo() > 0) {
            dao.update(recrutamento);
        } else {
            dao.insert(recrutamento);
        }
        return pagina;
    }

    public String listar() {
        return "recrutamentolst?faces-redirect=true";
    }

    public String novo(String pg) {
        this.recrutamento = new Recrutamento();
        recrutamento.setRecInicio(new Date());
        return pg;
    }

    public String novaEntrevista(String pg) {
        this.entrevista = new Entrevista();
        this.pessoaRecrutamento = new Pessoa();
        entrevista.setEntDatahora(new Date());
        return pg;
    }

    public String salvarCandidatos(String pg) {
//        List<RecrutamentoPessoa> rp = new ArrayList<>();
        for (CandidatoRecrutamento cr : candidatosRecrutamento) {
            RecrutamentoPessoa recruta = new RecrutamentoPessoa();
            recruta.setPessoa(cr.getPessoa());
            recruta.setRecrutamento(recrutamento);
            if (cr.isSelecionado()) {
                if (cr.getStatus() == 0) {
                    recruta.setRecPesStatus(1);
                    recrutamentoPessoaDAO.insert(recruta);
                }
//                if (recruta.getRecrutamentoPessoaPK() == null) {
//                    recruta.setRecrutamentoPessoaPK(new RecrutamentoPessoaPK());
//                }
//                recruta.getRecrutamentoPessoaPK().setPessoa(cr.getPessoa().getPes_codigo());
//                recruta.setRecPesStatus(cr.getStatus());
//                recruta.getRecrutamentoPessoaPK().setRecrutamento(recrutamento.getRecCodigo());
//                rp.add(recruta);
            } else if (cr.getStatus() != 0) {
                RecrutamentoPessoaPK rp = new RecrutamentoPessoaPK();
                rp.setPessoa(recruta.getPessoa());
                rp.setRecrutamento(recruta.getRecrutamento());
                recruta = recrutamentoPessoaDAO.findByPKId(rp);
                recrutamentoPessoaDAO.delete(recruta);
            }
        }
//        recrutamento.setRecrutamentoPessoa(rp);
//        dao.update(recrutamento);
        return pg;
    }

    public void setCandidatosRecrutamento(DataModel candidatosRecrutamento) {
        this.candidatosRecrutamento = (List<CandidatoRecrutamento>) candidatosRecrutamento;
    }

    public String interesse(Cargo cargo, String pg) {
        LoginBean login = (LoginBean) Utilidades.getSessionObject("loginBean");
        this.pessoa = login.getUsuario().getPessoa();
        if (cargo.getPessoas() == null) {
            cargo.setPessoas(new ArrayList<Pessoa>());
        }
        cargo.getPessoas().add(pessoa);
//        List<Pessoa> p = new ArrayList();
//        p.add(pessoa);
//        cargo.setPessoas(p);
        daocargo.update(cargo);
        return pg;
    }

    public String insertEntrevista() {
        daoEntrevista.insert(entrevista);
        return "recrutamentoEntrevistafrm?faces-redirect=true";
    }

    public String editEntrevista() {
        this.entrevista = (Entrevista) entrevistas.getRowData();
        this.pessoaRecrutamento = entrevista.getRecrutamentoPessoa().getPessoa();
        return "recrutamentoEntrevistafrm?faces-redirect=true";
    }

    public void deleteEntrevista() {
        this.daoEntrevista.delete((Entrevista) entrevistas.getRowData());
    }

    public String updateEntrevista() {
        daoEntrevista.update(entrevista);
        return "recrutamentoEntrevistafrm?faces-redirect=true";
    }

    public String deleteEntrevista(Entrevista i) {
        daoEntrevista.delete(i);
        return "recrutamentoEntrevistafrm?faces-redirect=true";
    }

    public String salvarEntrevista(String pg) {
        if (pessoaRecrutamento != null) {
            RecrutamentoPessoa recPes = new RecrutamentoPessoa();
            recPes.setRecrutamento(recrutamento);
            recPes.setPessoa(pessoaRecrutamento);
            entrevista.setRecrutamentoPessoa(recPes);
        }
        if (entrevista.getEntCodigo() > 0) {
            daoEntrevista.update(entrevista);
        } else {
            daoEntrevista.insert(entrevista);
        }
        recrutamento.setRecStatus(3);
        recrutamentoPessoaDAO.update(recrutementoPessoa);
        dao.update(recrutamento);
        return pg;
    }

    public String listarEntrevista() {
        return "recrutamentoEntrevistalst?faces-redirect=true";
    }

    public DataModel getCandidatosRecrutamento() {
        String pes_tipo = "1,2,3";
        if (recrutamento.getRecTipo() == 1) {
            pes_tipo = "1";
        } else if (recrutamento.getRecTipo() == 2) {
            pes_tipo = "2,3";
        }
        List<Pessoa> pessoas = pesDao.findCandidatos(pes_tipo);
        List<RecrutamentoPessoa> recPessoasBanco = recrutamentoPessoaDAO.findByRecrutamento(recrutamento.getRecCodigo());
        List<CandidatoRecrutamento> candidatosRecrutamento = new ArrayList<>();
        for (Pessoa pes : pessoas) {
            CandidatoRecrutamento cdtRec = new CandidatoRecrutamento();
            cdtRec.setPessoa(pes);
            cdtRec.setSelecionado(false);
            for (RecrutamentoPessoa rp : recPessoasBanco) {
                if (rp.getPessoa().getPes_codigo() == pes.getPes_codigo()) {
                    cdtRec.setSelecionado(true);
                    cdtRec.setStatus(rp.getRecPesStatus());
                    break;
                }
            }
            candidatosRecrutamento.add(cdtRec);
        }
        this.candidatosRecrutamento = candidatosRecrutamento;
        return new ListDataModel(candidatosRecrutamento);
    }

    public DataModel getEntrevistas() {
        List<Entrevista> entrevistados = daoEntrevista.findEntrevistasRecrutamento(recrutamento);
        entrevistas = new ListDataModel(entrevistados);
        return entrevistas;
    }

    public List<Pessoa> getPessoas() {
        this.recrutamentoPessoas = recrutamentoPessoaDAO.findByRecrutamento(recrutamento.getRecCodigo());
        pessoas = new ArrayList<>();
        for (RecrutamentoPessoa recpes : recrutamentoPessoas) {
            pessoas.add(recpes.getPessoa());
        }
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoaRecrutamento() {
        return pessoaRecrutamento;
    }

    public void setPessoaRecrutamento(Pessoa pessoaRecrutamento) {
        this.pessoaRecrutamento = pessoaRecrutamento;
    }

    public List<RecrutamentoPessoa> getRecrutamentoPessoas() {
        this.recrutamentoPessoas = recrutamentoPessoaDAO.findByRecrutamento(recrutamento.getRecCodigo());
        return recrutamentoPessoas;
    }

    public void setRecrutamentoPessoas(List<RecrutamentoPessoa> recrutamentoPessoas) {
        this.recrutamentoPessoas = recrutamentoPessoas;
    }

    public RecrutamentoPessoa getRecrutementoPessoa() {
        return recrutementoPessoa;
    }

    public void setRecrutementoPessoa(RecrutamentoPessoa recrutementoPessoa) {
        this.recrutementoPessoa = recrutementoPessoa;
    }

    public String voltar(String pg) {
        return pg;
    }

}
