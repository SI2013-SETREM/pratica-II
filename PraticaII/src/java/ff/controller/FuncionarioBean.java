package ff.controller;

import cfg.dao.EmpresaDAO;
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
import fp.dao.EventoDAO;
import fp.dao.EventoPadraoDAO;
import fp.model.Evento;
import fp.model.EventoPadrao;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

@SessionScoped
@ManagedBean
public class FuncionarioBean {

    //========================================================================================
    private Pessoa pessoa = new Pessoa();
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    private DataModel<Pessoa> funcionarios;

    private final BeneficiosPessoaDAO beneficiosPessoaDAO = new BeneficiosPessoaDAO();
    private List<BeneficiosPessoa> beneficios;

    private final FeriasDAO feriasDAO = new FeriasDAO();
    private List<Ferias> ferias;

  
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
    
    private String estadoCivil;
    private String tipoPessoa;
    
    public FuncionarioBean() {
    }
    
//=======================================================================================================
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
 //===============================================================================================================   
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
            ferias = feriasDAO.findById(pessoa.getPes_codigo());
            cargos = cargosDAO.GetListCargoPessoa(pessoa.getPes_codigo(), 0);
            faltas = faltaDAO.findFaltas(pessoa.getPes_codigo());
            graduacoes = graduacoesPessoaDAO.findByGraduacoesId(pessoa.getPes_codigo());
            advertencias = advertenciaDAO.findByAvertId(pessoa.getPes_codigo());

        } else {
            beneficios = new ArrayList<>();
            faltas = new ArrayList<>();
            ferias = new ArrayList<>();
            cargos = new ArrayList<>();
            graduacoes = new ArrayList<>();
            salarios = new ArrayList<>();
            advertencias = new ArrayList<>();
        }
        return "fichafunfrm";
    }
    
    public String cancelar() {
        return "fichafulst";
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
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTipoPessoa(String p) {
     
                
        return tipoPessoa;
    }

    public void setCargosPessoa(CargosPessoa cargosPessoa) {
        this.cargosPessoa = cargosPessoa;
    }

    public List<Ferias> getFerias() {
        return ferias;
    }

    public List<BeneficiosPessoa> getBeneficios() {
        return beneficios;
    }
    
     public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
//    public String select() {
//        pessoa = funcionarios.getRowData();
//        pessoa = pessoaDAO.findById(pessoa.getPes_codigo());
//        if (pessoa != null) {
//            salarios = salarioDAO.findBySalPessoaId(pessoa.getPes_codigo());
//            beneficios = beneficiosPessoaDAO.findByPessoaId(pessoa.getPes_codigo());
//            ferias = feriasDAO.findById(pessoa.getPes_codigo());
//            cargos = cargosDAO.GetListCargoPessoa(pessoa.getPes_codigo(), 0);
//            faltas = faltaDAO.findFaltas(pessoa.getPes_codigo());
//            graduacoes = graduacoesPessoaDAO.findByGraduacoesId(pessoa.getPes_codigo());
//            advertencias = advertenciaDAO.findByAvertId(pessoa.getPes_codigo());
//
//        } else {
//            beneficios = new ArrayList<>();
//            faltas = new ArrayList<>();
//            ferias = new ArrayList<>();
//            cargos = new ArrayList<>();
//            graduacoes = new ArrayList<>();
//            salarios = new ArrayList<>();
//            advertencias = new ArrayList<>();
//        }
//        return "fichafunfrm";
//    }
 
//===================================================================    
    //FOLHA DE PAGAMENTO
    public String gerarFolha() {
        return "eventopadlst";
    }

 //=======================================================================
    //AMBOS

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
 //======================================================================
    //EVENTO
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
 //========================================================================================
    //EMPRESA
    
//    public Empresa getEmpresa() {
//        this.empresa = empresaDAO.findByIdPessoa(pessoa.getPes_codigo());
//        return empresa;
//    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

//    public DataModel getEmpresas() {
//        this.empresas = new ListDataModel(empresaDAO.EmpresaPessoa(pessoa.getPes_codigo()));
//        return empresas;
//    }

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

    public String listarEmpresa() {
        return "empresalst";
    }
    
    
}
