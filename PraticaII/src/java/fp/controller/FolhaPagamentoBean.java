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
import fp.dao.FaixaINSSDAO;
import fp.dao.HistoricoFolhaDAO;
import fp.dao.TabelaINSSDAO;
import fp.model.Evento;
import fp.model.EventoFolha;
import fp.model.EventoPadrao;
import fp.model.FaixaINSS;
import fp.model.HistoricoFolha;
import fp.model.TabelaINSS;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
//=============================================================================================================================================
    //INICIALIZADORES

    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private DataModel<Pessoa> pessoas;
    private DataModel<Pessoa> funcionarios;
    private int idPessoa;

    private final EventoPadraoDAO eventoPadraoDAO = new EventoPadraoDAO();
    private EventoPadrao eventoPadrao = new EventoPadrao();
    private List<EventoPadrao> eventosPadroes;
    private DataModel eventospadroesdm;

    private Salario salario = new Salario();
    private SalarioDAO salarioDAO = new SalarioDAO();
    private List<Salario> salarios;

    private Evento evento = new Evento();
    private EventoDAO eventoDAO = new EventoDAO();
    private DataModel<Evento> eventos;
    private List<Evento> Listeventos;

    private HistoricoFolha historicoFolha = new HistoricoFolha();
    private HistoricoFolhaDAO historicoFolhaDAO = new HistoricoFolhaDAO();
    private List<HistoricoFolha> HistFolhas;
    private DataModel<HistoricoFolha> histFolhas;

    private EventoFolha eventoFolha = new EventoFolha();
    private EventoFolhaDAO eventoFolhaDAO = new EventoFolhaDAO();
    private List<EventoFolha> EveFolhas;
    private DataModel<EventoFolha> DataModelEveFolhas;

    private calculoFolha calculoFolha = new calculoFolha();

    private String tipoPessoa;

    private int idEvento;

    public FolhaPagamentoBean() {
    }

    //=======================================================================================================================================================
    //PESSOA / FUNCIONARIO
    public DataModel<Pessoa> getFuncionarios() {
        //if (this.funcionarios == null) {
        this.funcionarios = new ListDataModel<>(pessoaDAO.findAllFuncionarios());
        //}
        return funcionarios;
    }

    public String selectFuncionario() {
        pessoa = funcionarios.getRowData();
        return "folhapagfrm";
    }
//=======================================================================================================================================================
    //EVENTOS PADROES

    public String gerenciarEventosPadroes() {
        return "eventopadlst";
    }

    public DataModel<EventoPadrao> getEventosPadroes() {
        this.eventospadroesdm = new ListDataModel(eventoPadraoDAO.EventoPessoa(pessoa.getPes_codigo()));
        return eventospadroesdm;
    }

    public String deleteEventoPadrao(EventoPadrao f) {
        eventoPadraoDAO.delete(f);
        //    LogDAO.insert("Formula", "Deletou fórmula código: " + f.getFor_codigo() + ", taxa: " + f.getFor_taxa()
        //            + ", horas: " + f.getFor_horas() + ", horas mais: " + f.getFor_horasmais() + ", nome: " + f.getFor_nome());
        return "eventopadlst";
    }

    public String deleteEventoPadraoFolha(EventoPadrao f) {
        eventoPadraoDAO.delete(f);
        //    LogDAO.insert("Formula", "Deletou fórmula código: " + f.getFor_codigo() + ", taxa: " + f.getFor_taxa()
        //            + ", horas: " + f.getFor_horas() + ", horas mais: " + f.getFor_horasmais() + ", nome: " + f.getFor_nome());
        return "folhapagfrm";
    }

    public String insertEventoPadrao(Integer eve_codigo) {

        EventoPadrao f = new EventoPadrao();
        f.setPessoa(pessoaDAO.findById(pessoa.getPes_codigo()));
        f.setEve_codigo(eventoDAO.findById(eve_codigo));

        eventoPadraoDAO.insert(f);
        return "eventopadlst";
    }

    public int getIdEvento() {
        return idEvento;
    }

//=======================================================================================================================================================
    //HISTORICO FOLHA
    public DataModel<HistoricoFolha> getHistFolhas() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dat = dateFormat.format(date);
        this.histFolhas = new ListDataModel(historicoFolhaDAO.historicoAtual(pessoa.getPes_codigo(), dat));
        return histFolhas;
    }

    public void setHistFolhas(DataModel<HistoricoFolha> histFolhas) {
        this.histFolhas = histFolhas;
    }

    //=======================================================================================================================================================
    //EVENTOS FOLHA
    public String addEventoFolha(Integer eve_codigo) {

        double valor = 0;
        double ValorAcresc = 0, ValorDesc = 0;
        double salarioBase = salarioBruto();

        evento = eventoDAO.findById(eve_codigo);

        int serie = evento.getSerieevento().getSev_codigo();

        if (serie == 2) {
            valor = calculoFolha.calculaDesconto(evento, salarioBase);
            ValorDesc += valor;
        } else {
            valor = calculoFolha.calculaAcrescimo(evento, salarioBase);
            ValorAcresc += valor;
        }

        eventoFolha.setEve_evento(getEvento());
        eventoFolha.setEvf_descricao(evento.getEve_descricao());
        eventoFolha.setEvf_valor(valor);
        eventoFolha.setEvf_indice("" + evento.getEve_indice());
        eventoFolha.setEvf_imprimir(evento.isEve_imprimir());
        eventoFolha.setEvf_serv_codigo(evento.getSerieevento().getSev_codigo());
        eventoFolha.setEvf_tif_codigo(evento.getTipoevento().getTpe_codigo());

        if (evento.getBeneficio() != null) {
            eventoFolha.setEvf_ben_codigo(evento.getBeneficio().getBen_codigo());
        } else {
            eventoFolha.setEvf_ben_codigo(0);
        }
        if (evento.getFormula() != null) {
            eventoFolha.setEvf_for_godigo(evento.getFormula().getFor_codigo());
        } else {
            eventoFolha.setEvf_for_godigo(0);
        }
        if (evento.getTabelairrf() != null) {
            eventoFolha.setEvf_tif_codigo(evento.getTabelairrf().getTif_codigo());
        } else {
            eventoFolha.setEvf_tif_codigo(0);
        }
        if (evento.getTabelainss() != null) {
            eventoFolha.setEvs_tbs_codigo(evento.getTabelainss().getTbs_codigo());
        } else {
            eventoFolha.setEvs_tbs_codigo(0);
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dat = dateFormat.format(date);

        HistFolhas = historicoFolhaDAO.historicoAtual(pessoa.getPes_codigo(), dat);

        if (HistFolhas.isEmpty()) {

            double salarioLiq = ValorAcresc + (salarioBase - ValorDesc);
            historicoFolha.setPessoa(pessoa);
            historicoFolha.setHif_valor_acre(ValorAcresc);
            historicoFolha.setHif_valor_desc(ValorDesc);
            historicoFolha.setHif_salario_base(salarioBase);
            historicoFolha.setHif_data(date);
            historicoFolha.setHif_valor_liquido(salarioLiq);

            salvarCabecalho();

            eventoFolha.setHistoricoFolha(historicoFolha);

            salvarItens();

        } else {

            for (HistoricoFolha h : HistFolhas) {

                double desconto, acrescimo, liquido;
                desconto = h.getHif_valor_desc();
                acrescimo = h.getHif_valor_acre();
                liquido = h.getHif_valor_liquido();

                ValorDesc += desconto;
                ValorAcresc += acrescimo;

                double salarioLiq = ValorAcresc - ValorDesc;
                historicoFolha.setPessoa(pessoa);
                historicoFolha.setHif_valor_acre(ValorAcresc);
                historicoFolha.setHif_valor_desc(ValorDesc);
                historicoFolha.setHif_salario_base(salarioBase);
                historicoFolha.setHif_data(date);
                historicoFolha.setHif_valor_liquido(salarioLiq);

                salvarCabecalho();
                eventoFolha.setHistoricoFolha(historicoFolha);
                salvarItens();
            }

        }

        return "folhapagfrm";
    }

    public void salvarItens() {

        eventoFolhaDAO.insert(eventoFolha);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public DataModel<EventoFolha> getDataModelEveFolhas() {
        this.DataModelEveFolhas = new ListDataModel(eventoFolhaDAO.EventoFolhas(historicoFolha.getHif_codigo()));
        return DataModelEveFolhas;
    }

    public void setDataModelEveFolhas(DataModel<EventoFolha> DataModelEveFolhas) {
        this.DataModelEveFolhas = DataModelEveFolhas;
    }

    public String adicionarMaisEventos() {
        return "eventofolhafrm";
    }

    public String adicionarNaFolhaEP() {

        double ValorAcresc = 0, ValorDesc = 0;
        double salarioBase = salarioBruto();
        List<EventoFolha> listaFolha = new ArrayList<EventoFolha>();
        List<EventoPadrao> eventosPadroes = new ArrayList<EventoPadrao>();
        eventosPadroes = eventoPadraoDAO.EventoPessoa(pessoa.getPes_codigo());

        for (EventoPadrao e : eventosPadroes) {
            int serie = e.getEve_codigo().getSerieevento().getSev_codigo();
            double valor = 0;

            evento = eventoDAO.findById(e.getEve_codigo().getEve_codigo());

            if (serie == 2) {
                valor = calculoFolha.calculaDesconto(evento, salarioBase);
                ValorDesc += valor;
            } else {
                valor = calculoFolha.calculaAcrescimo(evento, salarioBase);
                ValorAcresc += valor;
            }

            eventoFolha = new EventoFolha();

            eventoFolha.setEve_evento(getEvento());
            eventoFolha.setEvf_descricao(evento.getEve_descricao());
            eventoFolha.setEvf_valor(valor);
            eventoFolha.setEvf_indice("" + evento.getEve_indice());
            eventoFolha.setEvf_imprimir(evento.isEve_imprimir());
            eventoFolha.setEvf_serv_codigo(e.getEve_codigo().getSerieevento().getSev_codigo());
            eventoFolha.setEvf_tif_codigo(e.getEve_codigo().getTipoevento().getTpe_codigo());

            if (e.getEve_codigo().getBeneficio() != null) {
                eventoFolha.setEvf_ben_codigo(e.getEve_codigo().getBeneficio().getBen_codigo());
            } else {
                eventoFolha.setEvf_ben_codigo(0);
            }
            if (e.getEve_codigo().getFormula() != null) {
                eventoFolha.setEvf_for_godigo(e.getEve_codigo().getFormula().getFor_codigo());
            } else {
                eventoFolha.setEvf_for_godigo(0);
            }
            if (e.getEve_codigo().getTabelairrf() != null) {
                eventoFolha.setEvf_tif_codigo(e.getEve_codigo().getTabelairrf().getTif_codigo());
            } else {
                eventoFolha.setEvf_tif_codigo(0);
            }
            if (e.getEve_codigo().getTabelainss() != null) {
                eventoFolha.setEvs_tbs_codigo(e.getEve_codigo().getTabelainss().getTbs_codigo());
            } else {
                eventoFolha.setEvs_tbs_codigo(0);
            }

            listaFolha.add(eventoFolha);

        }
        Date data = new Date();
        double salarioLiq = ValorAcresc - ValorDesc;
        historicoFolha.setPessoa(pessoa);
        historicoFolha.setHif_valor_acre(ValorAcresc);
        historicoFolha.setHif_valor_desc(ValorDesc);
        historicoFolha.setHif_salario_base(salarioBase);
        historicoFolha.setHif_data(data);
        historicoFolha.setHif_valor_liquido(salarioLiq);
        salvarCabecalho();
        for (EventoFolha f : listaFolha) {
            f.setHistoricoFolha(historicoFolha);

            salvarItens(f);
        }

        return "folhapagfrm";
    }

    public void salvarItens(EventoFolha f) {

        eventoFolhaDAO.insert(f);
    }

    public void salvarCabecalho() {

        historicoFolhaDAO.insert(historicoFolha);
    }

    public double salarioBruto() {

        double sal = 0;
        Salario salar = new Salario();
        salar = (Salario) salarioDAO.findSalPessoaFolha(pessoa.getPes_codigo());
        if (salar != null) {
            sal = salar.getSal_valorbruto();
        }

        return sal;
    }

    //===========================================================================================================================================
    //GUETTERS E SETTERS
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

    public void setEventosPadroes(List<EventoPadrao> eventosPadroes) {
        this.eventosPadroes = eventosPadroes;
    }

//    public Evento getEvento() {
//        return evento;
//    }
//    public void setEvento(Evento evento) {
//        this.evento = evento;
//    }
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
        this.eventos = new ListDataModel(eventoDAO.findAll());
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

    public String getTipoPessoa() {
        String tipo = "";
        int valor = pessoa.getPes_tipo();

        if (valor == 1) {
            tipo = "Funcionário";
        } else if (valor == 2) {
            tipo = "Ex-Funcionário";
        } else if (valor == 3) {
            tipo = "Pessoa Externa (Candidatos)";
        } else if (valor == 4) {
            tipo = "Instrutores";
        }

        return tipo;
    }

}
