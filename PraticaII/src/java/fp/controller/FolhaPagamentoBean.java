package fp.controller;

import ff.controller.*;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import csb.dao.SalarioDAO;
import csb.model.Salario;
import ff.dao.FaltaDAO;
import ff.model.Falta;
import fp.dao.EventoDAO;
import fp.dao.EventoFolhaDAO;
import fp.dao.EventoPadraoDAO;
import fp.dao.HistoricoFolhaDAO;
import fp.model.Evento;
import fp.model.EventoFolha;
import fp.model.EventoPadrao;
import fp.model.HistoricoFolha;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class FolhaPagamentoBean {

    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private DataModel<Pessoa> pessoas;
    private int idPessoa;

    private final EventoPadraoDAO eventoPadraoDAO = new EventoPadraoDAO();
    private EventoPadrao eventoPadrao = new EventoPadrao();
    private List<EventoPadrao> eventosPadroes;

    private Salario salario = new Salario();
    private SalarioDAO salarioDAO = new SalarioDAO();
    private List<Salario> salarios;

    private Evento evento = new Evento();
    private EventoDAO eventoDAO = new EventoDAO();
    private DataModel<Evento> eventos;

    private HistoricoFolha historicoFolha = new HistoricoFolha();
    private HistoricoFolhaDAO historicoFolhaDAO = new HistoricoFolhaDAO();
    private List<HistoricoFolha> HistFolhas;

    private EventoFolha eventoFolha = new EventoFolha();
    private EventoFolhaDAO eventoFolhaDAO = new EventoFolhaDAO();
    private List<EventoFolha> EveFolhas;
    
    

    public FolhaPagamentoBean() {
    }

    public String salvaEventPadrao(int pes_codigo) {

        this.pessoas = new ListDataModel<>(pessoaDAO.findByPessoaId(pes_codigo));
        pessoa = pessoas.getRowData();
        pessoa = pessoaDAO.findById(pessoa.getPes_codigo());

        double ValorAcresc = 0, ValorDesc = 0;
        double salarioBase = salarioBruto();
        List<EventoFolha> listaFolha = new ArrayList<EventoFolha>();
        eventosPadroes = eventoPadraoDAO.EventoPessoa(pessoa.getPes_codigo());

        for (EventoPadrao e : eventosPadroes) {
            int serie = e.getEve_codigo().getSerieevento().getSev_codigo();
            double valor = 0;

            int codEv = 0;
            codEv = e.getEve_codigo().getEve_codigo();
            this.eventos = new ListDataModel<>(eventoDAO.EventoId(codEv));
            evento = eventos.getRowData();
            evento = eventoDAO.findById(evento.getEve_codigo());

            if (serie == 1) {
                valor = calculaDesconto(evento);
                ValorDesc += valor;
            } else {
                valor = calculaAcrescimo(evento);
                ValorAcresc += valor;
            }

            //eventos = eventoDAO.EventoId(evento.getEve_codigo());
            eventoFolha.setEve_evento(getEvento());
            eventoFolha.setEvf_descricao(evento.getEve_descricao());
            eventoFolha.setEvf_valor(valor);
            eventoFolha.setEvf_indice("" + evento.getEve_indice());
            eventoFolha.setEvf_imprimir(evento.isEve_imprimir());
            eventoFolha.setEvf_serv_codigo(e.getEve_codigo().getSerieevento().getSev_codigo());
            eventoFolha.setEvf_tif_codigo(e.getEve_codigo().getTipoevento().getTpe_codigo());
            eventoFolha.setEvf_ben_codigo(e.getEve_codigo().getBeneficio().getBen_codigo());
            eventoFolha.setEvf_for_godigo(e.getEve_codigo().getFormula().getFor_codigo());
            eventoFolha.setEvf_tif_codigo(e.getEve_codigo().getTabelairrf().getTif_codigo());
            eventoFolha.setEvs_tbs_codigo(e.getEve_codigo().getTabelainss().getTbs_codigo());

            listaFolha.add(eventoFolha);

        }
        Date data = new Date();
        double salarioLiq = ValorAcresc +(salarioBase -ValorDesc);
        historicoFolha.setPessoa(pessoa);
        historicoFolha.setHif_valor_acre(ValorAcresc);
        historicoFolha.setHif_valor_desc(ValorDesc);
        historicoFolha.setHif_salario_base(salarioBase);
        historicoFolha.setHif_data(data);
        historicoFolha.setHif_valor_liquido(salarioLiq);
        salvarCabecalho();
        for (EventoFolha f : listaFolha) {
            f.setHistoricoFolha(getHistoricoFolha());
            salvarItens();
        }
        return "folhapagfrm";
    }

    public void salvarItens() {

        eventoFolhaDAO.insert(eventoFolha);
    }

    public void salvarCabecalho() {

        historicoFolhaDAO.insert(historicoFolha);
    }

    public EventoPadrao getEventoPadrao() {
        return eventoPadrao;
    }

    public void setEventoPadrao(EventoPadrao eventoPadrao) {
        this.eventoPadrao = eventoPadrao;
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
        salarios = salarioDAO.findBySalPessoaId(pessoa.getPes_codigo());
        for (Salario s : salarios) {
            sal = s.getSal_valorbruto();
        }

        return sal;
    }

    public double calculaDesconto(Evento objD) {

        double sal = salarioBruto();
        double desconto = 0;
        int tipoEv = objD.getTipoevento().getTpe_codigo();

        if (objD.isEve_tributar_fgts()) {

            desconto = sal * objD.getEve_indice();

        }
        if (objD.isEve_tributar_inss()) {

            if (tipoEv == 1) { // verificar os tipos 

            }
        }
        if (objD.isEve_tributar_irrf()) {

        }
        if (objD.isEve_calcular_media_agregada13()) {

        }

        return desconto;
    }

    public double calculaAcrescimo(Evento objA) {

        double acrescimo = 0;
        double sal = salarioBruto();
        int tipoEv = objA.getTipoevento().getTpe_codigo();

        if (objA.getEve_indice() != 0) {
            if (tipoEv == 1) {
                acrescimo = acrescimo * objA.getEve_indice();
            } else if (tipoEv == 2) {

            }
        }

        if (objA.isEve_tributar_inss()) {

        }

        if (objA.isEve_tributar_irrf()) {

        }
        if (objA.isEve_calcular_media_agregada13()) {

        }
        if (objA.getBeneficio().getBen_codigo() > 0) {
            acrescimo += objA.getBeneficio().getBen_valor();

        }
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

    public List<EventoPadrao> getEventosPadroes() {
        return eventosPadroes;
    }

    public void setEventosPadroes(List<EventoPadrao> eventosPadroes) {
        this.eventosPadroes = eventosPadroes;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public EventoDAO getEventoDAO() {
        return eventoDAO;
    }

    public void setEventoDAO(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    public HistoricoFolha getHistoricoFolha() {
        return historicoFolha;
    }

    public void setHistoricoFolha(HistoricoFolha historicoFolha) {
        this.historicoFolha = historicoFolha;
    }

    public List<HistoricoFolha> getHistFolhas() {
        return HistFolhas;
    }

    public void setHistFolhas(List<HistoricoFolha> HistFolhas) {
        this.HistFolhas = HistFolhas;
    }

    public List<Salario> getSalarios() {
        return salarios;
    }

    public void setSalarios(List<Salario> salarios) {
        this.salarios = salarios;
    }

    public HistoricoFolhaDAO getHistoricoFolhaDAO() {
        return historicoFolhaDAO;
    }

    public void setHistoricoFolhaDAO(HistoricoFolhaDAO historicoFolhaDAO) {
        this.historicoFolhaDAO = historicoFolhaDAO;
    }

    public EventoFolha getEventoFolha() {
        return eventoFolha;
    }

    public void setEventoFolha(EventoFolha eventoFolha) {
        this.eventoFolha = eventoFolha;
    }

    public EventoFolhaDAO getEventoFolhaDAO() {
        return eventoFolhaDAO;
    }

    public void setEventoFolhaDAO(EventoFolhaDAO eventoFolhaDAO) {
        this.eventoFolhaDAO = eventoFolhaDAO;
    }

    public List<EventoFolha> getEveFolhas() {
        //this.EveFolhas = (List<EventoFolha>) new ListDataModel<>(eventoFolhaDAO.EventoFolhas(historicoFolha.getHif_codigo()));
        return EveFolhas;
    }

    public void setEveFolhas(List<EventoFolha> EveFolhas) {
        this.EveFolhas = EveFolhas;
    }

    public DataModel<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(DataModel<Evento> eventos) {
        this.eventos = eventos;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

}
