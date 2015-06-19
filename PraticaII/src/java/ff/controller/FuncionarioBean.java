package ff.controller;

import cfg.dao.PessoaDAO;
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
import fp.dao.EventoPadraoDAO;
import fp.model.EventoPadrao;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;

import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

@ManagedBean
public class FuncionarioBean {

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
    
    private String estadoCivil;
    private String tipoPessoa;

    public FuncionarioBean() {
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

    
    
    
    
    
    
    
    
   
      public String deleteEventoPadrao(EventoPadrao f) {
        eventopadraoDAO.delete(f);
    //    LogDAO.insert("Formula", "Deletou fórmula código: " + f.getFor_codigo() + ", taxa: " + f.getFor_taxa()
        //            + ", horas: " + f.getFor_horas() + ", horas mais: " + f.getFor_horasmais() + ", nome: " + f.getFor_nome());
        return "eventopadlst";
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

    public String insert2EventosPadroes(EventoPadrao f) {
       eventopadraoDAO.insert(f);
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
    
    
    
    
    
    
    
    
    public String select2() {
        pessoa = funcionarios.getRowData();
        //pessoa = pessoaDAO.findById(pessoa.getPes_codigo());
        //cargosPessoa = cargosDAO.cargo(pessoa.getPes_codigo());
        
        //cargosPessoa = cargosDAO.GetListCargoPessoa(pessoa.getPes_codigo(),0).get(1);
        
 
        
        return "folhapagfrm";
    }
    
    public String gerarFolha() {
        return "eventopadlst";
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

    public void setCargosPessoa(CargosPessoa cargosPessoa) {
        this.cargosPessoa = cargosPessoa;
    }

    public List<Ferias> getFerias() {
        return ferias;
    }

    public List<BeneficiosPessoa> getBeneficios() {
        return beneficios;
    }

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

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

}
