package fp.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import static com.sun.mail.imap.protocol.INTERNALDATE.format;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class EventoPadraoBean {

    public final String sTitle = EventoPadrao.getsTitle();
    public final String pTitle = EventoPadrao.getpTitle();

    private EventoPadrao eventopadrao = new EventoPadrao();
    private EventoPadraoDAO dao = new EventoPadraoDAO();

    private EventoDAO daoEvento = new EventoDAO();
    private int idEvento;
    private DataModel eventospadroes;

    private Pessoa pessoa = new Pessoa();
    private PessoaDAO daoPessoa = new PessoaDAO();
    private DataModel<Pessoa> pessoas;

    private Salario salario = new Salario();
    private SalarioDAO salarioDAO = new SalarioDAO();
    private List<Salario> salarios;

    private EventoFolha eventoFolha = new EventoFolha();
    private EventoFolhaDAO eventoFolhaDAO = new EventoFolhaDAO();
    private List<EventoFolha> EveFolhas;

    private Evento evento = new Evento();
    private EventoDAO eventoDAO = new EventoDAO();
    private List<Evento> eventos;

    private HistoricoFolha historicoFolha = new HistoricoFolha();
    private HistoricoFolhaDAO historicoFolhaDAO = new HistoricoFolhaDAO();
    private List<HistoricoFolha> HistFolhas;

    private calculoFolha calculoFolha = new calculoFolha();

    //private int parametro;
    public EventoPadraoBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public EventoPadrao getEventoPadrao() {

        return eventopadrao;
    }

    public void setFormula(EventoPadrao eventopadrao) {
        this.eventopadrao = eventopadrao;
    }

    public EventoPadraoDAO getDao() {
        return dao;
    }

    public void setDao(EventoPadraoDAO dao) {
        this.dao = dao;
    }

    public DataModel<EventoPadrao> getEventosPadroes() {
        this.eventospadroes = new ListDataModel(dao.findAll());
        return eventospadroes;
    }

    public void setEventosPadroes(DataModel eventospadroes) {
        this.eventospadroes = eventospadroes;
    }

    public String insert() {
        dao.insert(eventopadrao);
        return "eventopadlst";
    }

    public double salarioBruto() {

        double sal = 0;
        salarios = salarioDAO.findBySalPessoaId(pessoa.getPes_codigo());
        for (Salario s : salarios) {
            sal = s.getSal_valorbruto();
        }

        return sal;
    }

    //
    public String insert2(Integer eve_codigo, Integer _pes_codigo) {

       
        EventoPadrao f = new EventoPadrao();

        if (getIdEvento() != 2) {

            f.setPessoa(daoPessoa.findById(_pes_codigo));
            f.setEve_codigo(daoEvento.findById(eve_codigo));

            dao.insert(f);
            return "eventopadlst";
        } else {

            this.pessoas = new ListDataModel<>(daoPessoa.findByPessoaId(_pes_codigo));
            pessoa = pessoas.getRowData();
            pessoa = daoPessoa.findById(pessoa.getPes_codigo());

            double valor = 0;
            double ValorAcresc = 0, ValorDesc = 0;
            double salarioBase = salarioBruto();
            List<EventoFolha> listaFolha = new ArrayList<EventoFolha>();
            eventos = eventoDAO.EventoId(eve_codigo);

            for (Evento e : eventos) {
                int serie = e.getSerieevento().getSev_codigo();

                evento = eventoDAO.findById(eve_codigo);

                if (serie == 1) {
                    valor = calculoFolha.calculaDesconto(evento, salarioBase);
                    ValorDesc += valor;
                } else {
                    valor = calculoFolha.calculaAcrescimo(evento, salarioBase);
                    ValorAcresc += valor;
                }

                //eventos = eventoDAO.EventoId(evento.getEve_codigo());
                eventoFolha.setEve_evento(getEvento());
                eventoFolha.setEvf_descricao(evento.getEve_descricao());
                eventoFolha.setEvf_valor(valor);
                eventoFolha.setEvf_indice("" + evento.getEve_indice());
                eventoFolha.setEvf_imprimir(evento.isEve_imprimir());
                eventoFolha.setEvf_serv_codigo(e.getSerieevento().getSev_codigo());
                eventoFolha.setEvf_tif_codigo(e.getTipoevento().getTpe_codigo());
                eventoFolha.setEvf_ben_codigo(e.getBeneficio().getBen_codigo());
                eventoFolha.setEvf_for_godigo(e.getFormula().getFor_codigo());
                eventoFolha.setEvf_tif_codigo(e.getTabelairrf().getTif_codigo());
                eventoFolha.setEvs_tbs_codigo(e.getTabelainss().getTbs_codigo());

                listaFolha.add(eventoFolha);

            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String dat = dateFormat.format(date);

            HistFolhas = historicoFolhaDAO.historicoAtual(pessoa.getPes_codigo(), dat);
            for (HistoricoFolha h : HistFolhas) {
                double desconto, acrescimo, liquido;
                desconto = h.getHif_valor_desc();
                acrescimo = h.getHif_valor_acre();
                liquido = h.getHif_valor_liquido();

                ValorDesc += desconto;
                ValorAcresc += acrescimo;

                double salarioLiq = ValorAcresc + (salarioBase - ValorDesc);
                historicoFolha.setPessoa(pessoa);
                historicoFolha.setHif_valor_acre(ValorAcresc);
                historicoFolha.setHif_valor_desc(ValorDesc);
                historicoFolha.setHif_salario_base(salarioBase);
                historicoFolha.setHif_data(date);
                historicoFolha.setHif_valor_liquido(salarioLiq);
                
                salvarCabecalho();

                for (EventoFolha ef : listaFolha) {
                    ef.setHistoricoFolha(historicoFolha);
                    
                    salvarItens();
                }

            }

            
        }
        return "folhapagfrm";
    }

    public void salvarItens() {

        eventoFolhaDAO.insert(eventoFolha);
    }

    public void salvarCabecalho() {
        
       historicoFolhaDAO.update(historicoFolha);
    }

    public String edit(EventoPadrao ep) {
        eventopadrao = (EventoPadrao) eventospadroes.getRowData();
        return "eventopadfrm";
    }

    public String update() {
        dao.update(eventopadrao);
        return "eventopadlst";
    }

    public String delete(EventoPadrao f) {
        dao.delete(f);
        //    LogDAO.insert("Formula", "Deletou fórmula código: " + f.getFor_codigo() + ", taxa: " + f.getFor_taxa()
        //            + ", horas: " + f.getFor_horas() + ", horas mais: " + f.getFor_horasmais() + ", nome: " + f.getFor_nome());
        return "eventopadlst";
    }

    public String salvar() {
        if (eventopadrao.getEvp_codigo() > 0) {
            dao.update(eventopadrao);
            //      LogDAO.insert("Formula", "Alterou fórmula código: " + formula.getFor_codigo() + ", taxa: " + formula.getFor_taxa()
            //              + ", horas: " + formula.getFor_horas() + ", horas mais: " + formula.getFor_horasmais() + ", nome: " + formula.getFor_nome());
        } else {
            dao.insert(eventopadrao);
            //     LogDAO.insert("Formula", "Cadastrou fórmula código: " + formula.getFor_codigo() + ", taxa: " + formula.getFor_taxa()
            //             + ", horas: " + formula.getFor_horas() + ", horas mais: " + formula.getFor_horasmais() + ", nome: " + formula.getFor_nome());
        }

        return "eventopadlst";
    }

    public String listar() {
        return "eventopadlst";
    }

//    public int getParametro() {
//        return parametro;
//    }
//
//    public void setParametro(int parametro) {
//        this.parametro = parametro;
//    }
//    public void inicia() {
//        this.eventospadroes = new ListDataModel <> (dao.EventoPessoa(getParametro()));
//        eventopadrao = (EventoPadrao) eventospadroes.getRowData();
//        eventopadrao = (EventoPadrao) dao.EventoPessoa(eventopadrao.getPessoa().getPes_codigo());
//    }
    public EventoPadrao getEventopadrao() {
        return eventopadrao;
    }

    public void setEventopadrao(EventoPadrao eventopadrao) {
        this.eventopadrao = eventopadrao;
    }

    public EventoDAO getDaoEvento() {
        return daoEvento;
    }

    public void setDaoEvento(EventoDAO daoEvento) {
        this.daoEvento = daoEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public DataModel getEventospadroes() {
        return eventospadroes;
    }

    public void setEventospadroes(DataModel eventospadroes) {
        this.eventospadroes = eventospadroes;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaDAO getDaoPessoa() {
        return daoPessoa;
    }

    public void setDaoPessoa(PessoaDAO daoPessoa) {
        this.daoPessoa = daoPessoa;
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

    public List<Salario> getSalarios() {
        return salarios;
    }

    public void setSalarios(List<Salario> salarios) {
        this.salarios = salarios;
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
        return EveFolhas;
    }

    public void setEveFolhas(List<EventoFolha> EveFolhas) {
        this.EveFolhas = EveFolhas;
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

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public calculoFolha getCalculoFolha() {
        return calculoFolha;
    }

    public void setCalculoFolha(calculoFolha calculoFolha) {
        this.calculoFolha = calculoFolha;
    }

    public HistoricoFolha getHistoricoFolha() {
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

    public List<HistoricoFolha> getHistFolhas() {
        return HistFolhas;
    }

    public void setHistFolhas(List<HistoricoFolha> HistFolhas) {
        this.HistFolhas = HistFolhas;
    }

}
