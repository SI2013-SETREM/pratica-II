package ff.controller;

import cfg.dao.EmpresaDAO;
import cfg.dao.LogDAO;
import cfg.dao.PessoaDAO;
import cfg.model.Empresa;
import cfg.model.Pessoa;
import csb.dao.BeneficiosPessoaDAO;
import csb.dao.CargosPessoaDAO;
import csb.dao.GraduacoesPessoaDAO;
import csb.dao.SalarioDAO;
import csb.model.BeneficiosPessoa;
import csb.model.CargosPessoa;
import csb.model.Graduacao;
import csb.model.GraduacoesPessoa;
import csb.model.Salario;
import ff.dao.AdvertenciaDAO;
import ff.dao.FaltaDAO;
import ff.dao.FeriasDAO;
import ff.model.Advertencia;

import ff.model.Falta;
import ff.model.Ferias;
import fp.controller.calculoFolha;
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
import javax.faces.model.DataModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

@SessionScoped
@ManagedBean
public class FuncionarioBean {
//INICIALIZADORES
    //========================================================================================

    private Pessoa pessoa = new Pessoa();
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    private DataModel<Pessoa> funcionarios;

    private final BeneficiosPessoaDAO beneficiosPessoaDAO = new BeneficiosPessoaDAO();
    private List<BeneficiosPessoa> beneficios;

    private final FeriasDAO feriasDAO = new FeriasDAO();
    private List<Ferias> lstferias;
    private Ferias ferias = new Ferias();

    private final CargosPessoaDAO cargosDAO = new CargosPessoaDAO();
    private List<CargosPessoa> cargos;
    private CargosPessoa cargosPessoa = new CargosPessoa();

    private final FaltaDAO faltaDAO = new FaltaDAO();
    private Falta falta = new Falta();
    private List<Falta> faltas;

    private final GraduacoesPessoaDAO graduacoesPessoaDAO = new GraduacoesPessoaDAO();
    private List<GraduacoesPessoa> graduacoes;

    private final SalarioDAO salarioDAO = new SalarioDAO();
    private List<Salario> salarios;

    private Advertencia advertencia = new Advertencia();
    private final AdvertenciaDAO advertenciaDAO = new AdvertenciaDAO();
    private List<Advertencia> advertencias;

    private EventoPadrao eventopadrao = new EventoPadrao();
    private EventoPadraoDAO eventopadraoDAO = new EventoPadraoDAO();
    private DataModel eventospadroes;

    private Empresa empresa = new Empresa();
    private EmpresaDAO empresaDAO = new EmpresaDAO();
    private DataModel empresas;

    private Evento evento = new Evento();
    private EventoDAO eventoDao = new EventoDAO();
    private DataModel eventos;

    private List<Evento> Listeventos;

    private String estadoCivil;
    private String tipoPessoa;

    public FuncionarioBean() {
    }

//========================================================================================================================================================
    //EVENTOS PADRÕES
    public String deleteEventoPadrao(EventoPadrao f) {
        eventopadraoDAO.delete(f);
        //    LogDAO.insert("Formula", "Deletou fórmula código: " + f.getFor_codigo() + ", taxa: " + f.getFor_taxa()
        //            + ", horas: " + f.getFor_horas() + ", horas mais: " + f.getFor_horasmais() + ", nome: " + f.getFor_nome());
        return "eventopadlst";
    }

    public String deleteEventoPadraoFolha(EventoPadrao f) {
        eventopadraoDAO.delete(f);
        //    LogDAO.insert("Formula", "Deletou fórmula código: " + f.getFor_codigo() + ", taxa: " + f.getFor_taxa()
        //            + ", horas: " + f.getFor_horas() + ", horas mais: " + f.getFor_horasmais() + ", nome: " + f.getFor_nome());
        return "folhapagfrm";
    }

    public String listarEventosPadroes() {
        return "eventopadlst";
    }

    public void setEventospadroes(DataModel eventospadroes) {
        this.eventospadroes = eventospadroes;
    }

    public String salvarEventospadroes() {
        if (eventopadrao.getEvp_codigo() > 0) {
            eventopadraoDAO.update(eventopadrao);
            //      LogDAO.insert("Formula", "Alterou fórmula código: " + formula.getFor_codigo() + ", taxa: " + formula.getFor_taxa()
            //              + ", horas: " + formula.getFor_horas() + ", horas mais: " + formula.getFor_horasmais() + ", nome: " + formula.getFor_nome());
        } else {
            eventopadraoDAO.insert(eventopadrao);
            //     LogDAO.insert("Formula", "Cadastrou fórmula código: " + formula.getFor_codigo() + ", taxa: " + formula.getFor_taxa()
            //             + ", horas: " + formula.getFor_horas() + ", horas mais: " + formula.getFor_horasmais() + ", nome: " + formula.getFor_nome());
        }

        return "eventopadlst";
    }

    public String deleteEventospadroes(EventoPadrao f) {
        eventopadraoDAO.delete(f);
        //    LogDAO.insert("Formula", "Deletou fórmula código: " + f.getFor_codigo() + ", taxa: " + f.getFor_taxa()
        //            + ", horas: " + f.getFor_horas() + ", horas mais: " + f.getFor_horasmais() + ", nome: " + f.getFor_nome());
        return "eventopadlst";
    }

    public String updateEventosPadroes() {
        eventopadraoDAO.update(eventopadrao);
        return "eventopadlst";
    }

    public String editEventosPadroes(EventoPadrao ep) {
        eventopadrao = (EventoPadrao) eventospadroes.getRowData();
        return "eventopadfrm";
    }

    public String insertEventospadroes() {
        eventopadraoDAO.insert(eventopadrao);
        return "eventopadlst";
    }

    public DataModel<EventoPadrao> getEventosPadroes() {
        this.eventospadroes = new ListDataModel(eventopadraoDAO.EventoPessoa(pessoa.getPes_codigo()));
        return eventospadroes;
    }

    public void setEventosPadroes(DataModel eventospadroes) {
        this.eventospadroes = eventospadroes;
    }

    public EventoPadraoDAO getEventoPadraoDao() {
        return eventopadraoDAO;
    }

    public void setEventoPadroesDao(EventoPadraoDAO eventopadraoDAO) {
        this.eventopadraoDAO = eventopadraoDAO;
    }
    //===============================================================================================================================================================  
    //FICHA FUNCIONAL  

    public String select2() {
        pessoa = funcionarios.getRowData();
        //pessoa = pessoaDAO.findById(pessoa.getPes_codigo());
        //cargosPessoa = cargosDAO.cargo(pessoa.getPes_codigo());

        //cargosPessoa = cargosDAO.GetListCargoPessoa(pessoa.getPes_codigo(),0).get(1);    
        return "folhapagfrm";
    }

    public String select() {
        pessoa = funcionarios.getRowData();
        pessoa = pessoaDAO.findById(pessoa.getPes_codigo());
        if (pessoa != null) {
            salarios = salarioDAO.findBySalPessoaId(pessoa.getPes_codigo());
            beneficios = beneficiosPessoaDAO.findByPessoaId(pessoa.getPes_codigo());
            lstferias = feriasDAO.findById(pessoa.getPes_codigo());
            cargos = cargosDAO.GetListCargoPessoa(pessoa.getPes_codigo(), 0);
            faltas = faltaDAO.findFaltas(pessoa.getPes_codigo());
            graduacoes = graduacoesPessoaDAO.findByGraduacoesId(pessoa.getPes_codigo());
            advertencias = advertenciaDAO.findByAvertId(pessoa.getPes_codigo());

        } else {
            beneficios = new ArrayList<>();
            faltas = new ArrayList<>();
            lstferias = new ArrayList<>();
            cargos = new ArrayList<>();
            graduacoes = new ArrayList<>();
            salarios = new ArrayList<>();
            advertencias = new ArrayList<>();
        }
        return "fichafunfrm";
    }

    public String cancelar() {
        return "fichafunlst";
    }

    public List<GraduacoesPessoa> getGraduacoes() {
        return graduacoes;
    }

    public void setGraduacoes(List<GraduacoesPessoa> graduacoes) {
        this.graduacoes = graduacoes;
    }

    public List<CargosPessoa> getCargos() {
        return cargos;
    }

    public void setCargos(List<CargosPessoa> cargos) {
        this.cargos = cargos;
    }

    public CargosPessoa getCargosPessoa() {
        return cargosPessoa;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

    public List<Salario> getSalarios() {
        return salarios;
    }

    public void setSalarios(List<Salario> salarios) {
        this.salarios = salarios;
    }

    public Falta getFalta() {
        return falta;
    }

    public void setFalta(Falta falta) {
        this.falta = falta;
    }

    public List<Advertencia> getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(List<Advertencia> advertencias) {
        this.advertencias = advertencias;
    }

    public String getEstadoCivil() {
        String estado = "";
        int valor = pessoa.getPes_tipo();

        if (valor == 1) {
            estado = "Solteiro(a)";
        } else if (valor == 2) {
            estado = "Casado(a)";
        } else if (valor == 3) {
            estado = "Separado(a)";
        } else if (valor == 4) {
            estado = "Outros";
        }

        return estado;

    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTipoPessoa(String p) {

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

    public void setCargosPessoa(CargosPessoa cargosPessoa) {
        this.cargosPessoa = cargosPessoa;
    }

    public List<Ferias> getlstFerias() {
        return lstferias;
    }

    public List<BeneficiosPessoa> getBeneficios() {
        return beneficios;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------
    //FERIAS
    public String insertFerias() {
        ferias.setPessoa(pessoaDAO.findById(pessoa.getPes_codigo()));
        feriasDAO.insert(ferias);
        ferias = null;
        return "fichafunlst";
    }

    public String novaFerias() {
        this.ferias = new Ferias();
//        this.arrPerguntas = null;
        return "feriasfrm";
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    //FALTA

    public String insertFalta() {
        falta.setPessoa(pessoaDAO.findById(pessoa.getPes_codigo()));
        faltaDAO.insert(falta);
        falta = new Falta();
        return "fichafunlst";
    }

    public String novaFalta() {
        this.falta = new Falta();
//        this.arrPerguntas = null;
        return "faltafrm";
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------
    //ADVERTENCIA
    public String insertAdvertencia() {
        advertencia.setPessoa(pessoaDAO.findById(pessoa.getPes_codigo()));
        if (advertencia.getPessoa() != null && advertencia.getPessoa().getPes_codigo() != 0 && advertencia.getPessoaAplicador() != null && advertencia.getPessoaAplicador().getPes_codigo() != 0) {
            advertenciaDAO.insert(advertencia);
            LogDAO.insert("Advertencia", "Cadastrou advertência código: " + advertencia.getAdv_codigo()
                    + ", motivo: " + advertencia.getAdv_motivo() + ", descrição: " + advertencia.getAdv_descricao()
                    + ", observação: " + advertencia.getAdv_observacao() + ", data: " + advertencia.getAdv_data());
            return "fichafunlst";
        }
        return "advertenciafrm";
    }

    public List<Pessoa> completePessoa(String query) {
        return pessoaDAO.searchPessoa(query);
    }

    public String novaADV() {
        this.advertencia = new Advertencia();
//        this.arrPerguntas = null;
        return "advertenciafrm";
    }

//=======================================================================================================================================================================    
    //FOLHA DE PAGAMENTO
    public String gerarFolha() {
        return "eventopadlst";
    }

    //=========================================================================================================================================================================
    //PESSOA
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public DataModel<Pessoa> getFuncionarios() {
        this.funcionarios = new ListDataModel<>(pessoaDAO.findAllFuncionarios());
        return funcionarios;
    }

    public void setFuncionarios(DataModel<Pessoa> funcionarios) {
        this.funcionarios = funcionarios;
    }

    //===========================================================================================================================================================================
    //EVENTO
    private EventoPadraoDAO dao = new EventoPadraoDAO();
    private calculoFolha calculoFolha = new calculoFolha();

    private EventoFolha eventoFolha = new EventoFolha();
    private EventoFolhaDAO eventoFolhaDAO = new EventoFolhaDAO();
    private List<EventoFolha> EveFolhas;

    private HistoricoFolha historicoFolha = new HistoricoFolha();
    private HistoricoFolhaDAO historicoFolhaDAO = new HistoricoFolhaDAO();
    private List<HistoricoFolha> HistFolhas;

    private int idEvento;

    public String insert2(Integer eve_codigo, Integer _pes_codigo) {

        EventoPadrao f = new EventoPadrao();

        if (getIdEvento() != 2) {

            f.setPessoa(pessoaDAO.findById(_pes_codigo));
            f.setEve_codigo(eventoDao.findById(eve_codigo));

            dao.insert(f);
            return "eventopadlst";
        } else {

            this.funcionarios = new ListDataModel<>(pessoaDAO.findByPessoaId(_pes_codigo));
            pessoa = funcionarios.getRowData();
            pessoa = pessoaDAO.findById(pessoa.getPes_codigo());

            double valor = 0;
            double ValorAcresc = 0, ValorDesc = 0;
            double salarioBase = salarioBruto();
            List<EventoFolha> listaFolha = new ArrayList<EventoFolha>();
            Listeventos = eventoDao.EventoId(eve_codigo);

            for (Evento e : Listeventos) {
                int serie = e.getSerieevento().getSev_codigo();

                evento = eventoDao.findById(eve_codigo);

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

    public double salarioBruto() {

        double sal = 0;
        salarios = salarioDAO.findBySalPessoaId(pessoa.getPes_codigo());
        for (Salario s : salarios) {
            sal = s.getSal_valorbruto();
        }

        return sal;
    }

    public void salvarItens() {

        eventoFolhaDAO.insert(eventoFolha);
    }

    public void salvarCabecalho() {

        historicoFolhaDAO.update(historicoFolha);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public DataModel<Evento> getEventos() {
        this.eventos = new ListDataModel(eventoDao.findAll());
        return eventos;
    }

    public void setEventos(DataModel eventos) {
        this.eventos = eventos;
    }

    public String insert() {
        eventoDao.insert(evento);
        return "eventoslst";
    }

    public String edit(Evento i) {
        evento = (Evento) eventos.getRowData();
        return "eventosfrm";
    }

    public String update() {
        eventoDao.update(evento);
        return "eventolst";
    }

    public String delete(Evento i) {
        eventoDao.delete(i);
        //      LogDAO.insert("Evento", "Deletou evento código: " + i.getEve_codigo() + ", descrição: " + i.getEve_descricao()+
        //      ", índice: "+i.getEve_indice()+", código benefício: "+i.getBeneficio().getBen_codigo()+", fórmula: "+i.getFormula()+
        //      ", série evento: "+i.getSerieevento()+", código tabela inss: "+i.getTabelainss().getTbs_codigo()+
        //      ", código tabela irrf: "+i.getTabelairrf().getTif_codigo());
        return "eventolst";
    }

    public String salvar() {
        if (evento.getEve_codigo() > 0) {
            eventoDao.update(evento);
            //         LogDAO.insert("Evento", "Alterou evento código: " + evento.getEve_codigo() + ", descrição: " + evento.getEve_descricao()+
            //     ", índice: "+evento.getEve_indice()+", código benefício: "+evento.getBeneficio().getBen_codigo()+", fórmula: "+evento.getFormula()+
            //     ", série evento: "+evento.getSerieevento()+", código tabela inss: "+evento.getTabelainss().getTbs_codigo()+
            //    ", código tabela irrf: "+evento.getTabelairrf().getTif_codigo());
        } else {
            eventoDao.insert(evento);
            //            LogDAO.insert("Evento", "Cadastrou evento código: " + evento.getEve_codigo() + ", descrição: " + evento.getEve_descricao()+
            //    ", índice: "+evento.getEve_indice()+", código benefício: "+evento.getBeneficio().getBen_codigo()+", fórmula: "+evento.getFormula()+
            //   ", série evento: "+evento.getSerieevento()+", código tabela inss: "+evento.getTabelainss().getTbs_codigo()+
            //   ", código tabela irrf: "+evento.getTabelairrf().getTif_codigo());
        }

        return "eventolst";
    }

    public String listar() {
        return "eventolst";
    }
    //============================================================================================================================================================================
    //EMPRESA

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setEmpresas(DataModel empresas) {
        this.empresas = empresas;
    }

    public String insertEmpresa() {
        empresaDAO.insert(empresa);
        return "empresalst";
    }

    public String editEmpresa(Empresa i) {
        empresa = (Empresa) empresas.getRowData();
        return "empresafrm";
    }

    public String updateEmpresa() {
        empresaDAO.update(empresa);
        return "empresalst";
    }

    public String deleteEmpresa(Empresa i) {
        empresaDAO.delete(i);
        return "empresalst";
    }

    public String salvarEmpresa() {
        if (empresa.getEmp_codigo() > 0) {
            empresaDAO.update(empresa);
        } else {
            empresaDAO.insert(empresa);
        }

        return "empresalst";
    }
//===========================================================================================================================================================
    //GUETTER E SETTER

    public String listarEmpresa() {
        return "empresalst";
    }

    public EventoPadrao getEventopadrao() {
        return eventopadrao;
    }

    public void setEventopadrao(EventoPadrao eventopadrao) {
        this.eventopadrao = eventopadrao;
    }

    public EventoPadraoDAO getEventopadraoDAO() {
        return eventopadraoDAO;
    }

    public void setEventopadraoDAO(EventoPadraoDAO eventopadraoDAO) {
        this.eventopadraoDAO = eventopadraoDAO;
    }

    public EmpresaDAO getEmpresaDAO() {
        return empresaDAO;
    }

    public void setEmpresaDAO(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO;
    }

    public EventoDAO getEventoDao() {
        return eventoDao;
    }

    public void setEventoDao(EventoDAO eventoDao) {
        this.eventoDao = eventoDao;
    }

    public List<Evento> getListeventos() {
        return Listeventos;
    }

    public void setListeventos(List<Evento> Listeventos) {
        this.Listeventos = Listeventos;
    }

    public EventoPadraoDAO getDao() {
        return dao;
    }

    public void setDao(EventoPadraoDAO dao) {
        this.dao = dao;
    }

    public calculoFolha getCalculoFolha() {
        return calculoFolha;
    }

    public void setCalculoFolha(calculoFolha calculoFolha) {
        this.calculoFolha = calculoFolha;
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

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Ferias getFerias() {
        return ferias;
    }

    public void setFerias(Ferias ferias) {
        this.ferias = ferias;
    }

    public List<Ferias> getLstferias() {
        return lstferias;
    }

    public void setLstferias(List<Ferias> lstferias) {
        this.lstferias = lstferias;
    }

    public Advertencia getAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(Advertencia advertencia) {
        this.advertencia = advertencia;
    }

}
