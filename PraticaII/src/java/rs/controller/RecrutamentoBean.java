/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.dao.RecrutamentoDAO;
import rs.dao.RecrutamentoPessoasDAO;
import rs.model.CandidatoRecrutamento;
import rs.model.Recrutamento;
import rs.model.RecrutamentoPessoa;

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
    private DataModel recrutamentos;
    private List<CandidatoRecrutamento> candidatosRecrutamento;

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
                    break;
                }
            }

            candidatosRecrutamento.add(cdtRec);
        }

        return new ListDataModel(candidatosRecrutamento);
//        this.pessoas = new ListDataModel(pesDao.findCandidatos(pes_tipo));
    }

    public void setCandidatosRecrutamento(DataModel candidatosRecrutamento) {
        this.candidatosRecrutamento = (List<CandidatoRecrutamento>) candidatosRecrutamento;
    }

    public RecrutamentoBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
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
        return "recrutamentolst";
    }

    public String edit(Recrutamento r, String pagina) {
        recrutamento = (Recrutamento) recrutamentos.getRowData();
        return pagina;
    }

    public String update() {
        dao.update(recrutamento);
        return "recrutamentolst";
    }

    public String altera_status(int status, Recrutamento r) {
        this.setRecrutamento(r);
        recrutamento.setRecStatus(status);
        dao.update(recrutamento);
        return "recrutamentolst";
    }

    public String delete(Recrutamento r) {
        dao.delete(r);
        return "recrutamentolst";
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
        return "recrutamentolst";
    }

    public String novo(String pg) {
        this.recrutamento = new Recrutamento();
        recrutamento.setRecInicio(new Date());
        return pg;
    }

    public String salvarCandidatos(String pg) {
        List<RecrutamentoPessoa> rp = new ArrayList<>();
        for (CandidatoRecrutamento cr : candidatosRecrutamento) {
            if (cr.isSelecionado()) {
                
                RecrutamentoPessoa recruta = new RecrutamentoPessoa();
                recruta.setPessoa(cr.getPessoa());
                recruta.setRecPesStatus(1);
                recruta.setRecrutamento(recrutamento);
                rp.add(recruta);
            }
        }
        recrutamento.setRecrutamentoPessoa(rp);
        dao.update(recrutamento);
        return pg;
    }

}
