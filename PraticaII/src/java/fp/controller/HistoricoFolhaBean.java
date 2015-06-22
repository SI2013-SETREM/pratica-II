package fp.controller;


import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import csb.dao.SalarioDAO;
import csb.model.Salario;

import fp.dao.EventoDAO;
import fp.dao.EventoFolhaDAO;
import fp.dao.EventoPadraoDAO;
import fp.dao.HistoricoFolhaDAO;
import fp.model.Evento;
import fp.model.EventoFolha;
import fp.model.EventoPadrao;
import fp.model.HistoricoFolha;


import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


@ManagedBean
public class HistoricoFolhaBean {

    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    

    private HistoricoFolha historicoFolha = new HistoricoFolha();
    private HistoricoFolhaDAO historicoFolhaDAO = new HistoricoFolhaDAO();
    private DataModel<HistoricoFolha> HistFolhas;

   

    public HistoricoFolhaBean() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public HistoricoFolha getHistoricoFolha() {
        this.HistFolhas = new ListDataModel<>(historicoFolhaDAO.historicos(pessoa.getPes_codigo(),historicoFolha.getHif_codigo()));
        return historicoFolha;
    }

    public void setHistoricoFolha(HistoricoFolha historicoFolha) {
        this.historicoFolha = historicoFolha;
    }

    public HistoricoFolhaDAO getHistoricoFolhaDAO() {
        return historicoFolhaDAO;
    }

    public void setHistoricoFolhaDAO(HistoricoFolhaDAO historicoFolhaDAO) {
        this.historicoFolhaDAO = historicoFolhaDAO;
    }

    public DataModel<HistoricoFolha> getHistFolhas() {
        return HistFolhas;
    }

    public void setHistFolhas(DataModel<HistoricoFolha> HistFolhas) {
        this.HistFolhas = HistFolhas;
    }

   
}
