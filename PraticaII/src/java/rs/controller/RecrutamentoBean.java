/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import rs.dao.RecrutamentoDAO;
import rs.dao.RecrutamentoPessoasDAO;
import rs.model.CandidatoRecrutamento;
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

    private Recrutamento recrutamento;
    private RecrutamentoPessoasDAO recrutamentoPessoaDAO = new RecrutamentoPessoasDAO();
    private RecrutamentoDAO dao = new RecrutamentoDAO();
    private PessoaDAO pesDao = new PessoaDAO();
    private CargoDAO daocargo = new CargoDAO();
    private Pessoa pessoa = new Pessoa();
    private DataModel recrutamentos;
    private List<CandidatoRecrutamento> candidatosRecrutamento;
    private List<Cargo> cargos;
    private TreeNode arvoreCargos;
    private TreeNode selectedNode;

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

    public String insert() {
        dao.insert(recrutamento);
        return "recrutamentolst?faces-redirect=true";
    }

    public String edit(Recrutamento r, String pagina) {
        recrutamento = (Recrutamento) recrutamentos.getRowData();
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
                recruta = recrutamentoPessoaDAO.findById(recruta);
                recrutamentoPessoaDAO.delete(recruta);
            }
        }
//        recrutamento.setRecrutamentoPessoa(rp);
//        dao.update(recrutamento);
        return pg;
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

}
