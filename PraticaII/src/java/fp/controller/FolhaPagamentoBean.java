package fp.controller;

import ff.controller.*;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import csb.dao.SalarioDAO;
import csb.model.Salario;
import ff.dao.FaltaDAO;
import ff.model.Falta;
import fp.dao.EventoDAO;
import fp.dao.EventoPadraoDAO;
import fp.model.Evento;
import fp.model.EventoPadrao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class FolhaPagamentoBean {

    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private DataModel<Pessoa> pessoas;

    private final EventoPadraoDAO eventoPadraoDAO = new EventoPadraoDAO();
    private EventoPadrao eventoPadrao = new EventoPadrao();
    private DataModel<EventoPadrao> eventosPadroes;

    private Salario salario = new Salario();
    private SalarioDAO salarioDAO = new SalarioDAO();

    private Evento evento = new Evento();
    private EventoDAO eventoDAO = new EventoDAO();

    public void salvaEventPadrao(int pesCodigo) {

        this.pessoas = new ListDataModel<>(pessoaDAO.findByPessoaId(pesCodigo));
        pessoa = pessoas.getRowData();
        pessoa = pessoaDAO.findById(pessoa.getPes_codigo());

        eventosPadroes = (DataModel<EventoPadrao>) eventoPadraoDAO.EventoPessoa(pessoa.getPes_codigo());

        for (int i = 0; i < eventosPadroes.getRowCount(); i++) {
            
            int serie = eventoPadrao.getEve_codigo().getSerieevento().getSev_codigo();
            double valor = 0;

            if (serie == 1) {
                valor = calculaDesconto(this.eventoPadrao);
            } else {
                valor = calculaAcrescimo(this.eventoPadrao);
            }
        }

    }

    public FolhaPagamentoBean() {
    }

    public EventoPadrao getEventoPadrao() {
        return eventoPadrao;
    }

    public void setEventoPadrao(EventoPadrao eventoPadrao) {
        this.eventoPadrao = eventoPadrao;
    }

    public DataModel<EventoPadrao> getEventosPadroes() {
        this.eventosPadroes = new ListDataModel<>(eventoPadraoDAO.EventoPessoa(pessoa.getPes_codigo()));
        return eventosPadroes;
    }

    public void setEventosPadroes(DataModel<EventoPadrao> eventosPadroes) {
        this.eventosPadroes = eventosPadroes;
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

    public DataModel<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(DataModel<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public double salarioBruto() {

        double sal = 0;
        salario = (Salario) salarioDAO.findBySalPessoaId(pessoa.getPes_codigo());
        sal = salario.getSal_valorbruto();
        return sal;
    }

    public double calculaDesconto(Object objD) {

        double desconto = 0;

        return desconto;
    }

    public double calculaAcrescimo(Object objA) {

        double acrescimo = 0;

        return acrescimo;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public SalarioDAO getSalarioDAO() {
        return salarioDAO;
    }

    public void setSalarioDAO(SalarioDAO salarioDAO) {
        this.salarioDAO = salarioDAO;
    }

}
