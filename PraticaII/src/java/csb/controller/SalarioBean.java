package csb.controller;

import cfg.dao.LogDAO;
import cfg.dao.PessoaDAO;
import cfg.dao.UsuarioDAO;
import cfg.model.Pessoa;
import cfg.model.Usuario;
import csb.dao.CargoDAO;
import csb.dao.MotivoAlteracaoSalarialDAO;
import csb.dao.PlanejamentoCargosDAO;
import csb.dao.SalarioDAO;
import csb.model.Cargo;
import csb.model.MotivoAlteracaoSalarial;
import csb.model.PlanejamentoCargos;
import csb.model.PlanejamentoCarreira;
import csb.model.Salario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Augusto
 */
@ManagedBean
@RequestScoped
public class SalarioBean {

    private final String sTitle = Salario.sTitle;
    private final String pTitle = Salario.pTitle;

    private List<MotivoAlteracaoSalarial> lstMotivoAlteracaoSalarial;
    private MotivoAlteracaoSalarial motivoAlteracaoSalarial = new MotivoAlteracaoSalarial();
    private MotivoAlteracaoSalarialDAO motivoAlteracaoSalarialDAO = new MotivoAlteracaoSalarialDAO();

    private List<Cargo> lstCargo;
    private Cargo cargo = new Cargo();
    private CargoDAO cargoDAO = new CargoDAO();

    private PlanejamentoCargos planocargo;
    private PlanejamentoCargosDAO daoPLN = new PlanejamentoCargosDAO();
    private DataModel planocargos;

    private List<Pessoa> lstPessoa;
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();

    private Salario salario = new Salario();
    private SalarioDAO dao = new SalarioDAO();
    private DataModel salarios;
    private DataModel salariosHistorico;
    private DataModel salariosCargoHistorico;
    private DataModel salariosOff;

    private String usu_login;
    private String usu_pass;

    public SalarioBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public DataModel getPlanocargos(PlanejamentoCarreira p) {
        this.planocargos = new ListDataModel(daoPLN.findByPlanejamento(p.getPla_codigo()));
        return planocargos;
    }

    public void setPlanocargos(DataModel planocargos) {
        this.planocargos = planocargos;
    }

    public PlanejamentoCargos getPlanocargo() {
        return planocargo;
    }

    public void setPlanocargo(PlanejamentoCargos planocargo) {
        this.planocargo = planocargo;
    }

    public Salario getSalario() {
        return salario;
    }

    public DataModel getSalarios() {
        this.salarios = new ListDataModel(dao.findSalariosAtivos());
        return salarios;
    }

    public void setSalarios(DataModel datamodel) {
        this.salarios = datamodel;
    }

    public DataModel getSalariosHistorico(Salario sal) {
        this.salariosHistorico = new ListDataModel(dao.findBySalPessoaId(sal.getPessoa().getPes_codigo()));
        return salariosHistorico;
    }

    public void setSalariosHistorico(DataModel salariosHistorico) {
        this.salariosHistorico = salariosHistorico;
    }

    public DataModel getSalariosCargoHistorico(Salario sal) {
        this.salariosCargoHistorico = new ListDataModel(dao.findSalByCargo(sal.getCargo().getCar_codigo()));
        return salariosCargoHistorico;
    }

    public void setSalariosCargoHistorico(DataModel salariosCargoHistorico) {
        this.salariosCargoHistorico = salariosCargoHistorico;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public DataModel getSalariosOff() {
        List<Pessoa> lsPessoa = pessoaDAO.findCandidatos("2");
        List<Salario> lsSal = new ArrayList<>();
        for (Pessoa lsPessoa1 : lsPessoa) {
            List<Salario> teste = dao.findBySalPessoaIdInativo(lsPessoa1.getPes_codigo());
            lsSal.add(teste.get(0));
        }
        this.salariosOff = new ListDataModel(lsSal);
        return salariosOff;
    }

    public void setSalariosOff(DataModel salariosOff) {
        this.salariosOff = salariosOff;
    }

    public String getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    public String getUsu_pass() {
        return usu_pass;
    }

    public void setUsu_pass(String usu_pass) {
        this.usu_pass = usu_pass;
    }

    public String insert() {
        dao.insert(salario);
        return "salariolst";
    }

    public String edit(Salario i) {
        salario = (Salario) salarios.getRowData();
        return "salariofrm";
    }

    public String editTOFF(Salario i) {
        salario = (Salario) salarios.getRowData();
        return "salariotoff";
    }

    public String update() {
        dao.update(salario);
        return "salariolst";
    }

    public String updateSalario() {
        UsuarioDAO daoUser = new UsuarioDAO();
        Usuario usrResponsavel = daoUser.findUser(this.usu_login, util.Utilidades.encryptSHA(this.usu_pass));
        if (usrResponsavel != null) {
            dao.updateSalario(salario);
            return "salariolst";
        } else {
            throw new Error("As credenciais fornecidas são inválidas, tente novamente!");
        }
    }

    public String history(Salario sal) {
        salario = (Salario) salarios.getRowData();
        this.salariosHistorico = new ListDataModel(dao.findBySalPessoaId(sal.getPessoa().getPes_codigo()));
        this.planocargos = new ListDataModel(daoPLN.findByPlanejamento(sal.getPlanejamentocargo().getPlanejamento().getPla_codigo()));
        return "historiasalario";
    }

    public String historyTeam(Salario sal) {
        salario = (Salario) salarios.getRowData();
        this.salariosCargoHistorico = new ListDataModel(dao.findSalByCargo(sal.getCargo().getCar_codigo()));
        return "historiacargosalario";
    }

    public String turnOffEmployer() {
        UsuarioDAO daoUser = new UsuarioDAO();
        Usuario usrResponsavel = daoUser.findUser(this.usu_login, util.Utilidades.encryptSHA(this.usu_pass));
        if (usrResponsavel != null) {
            Salario sal = dao.findById(salario.getSal_codigo());
            sal.setSal_situacao(false);
            sal.setSal_datafim(salario.getSal_datafim());
            salario = null;
            dao.turnOffEmployer(sal);
            Pessoa deslig = pessoaDAO.findById(sal.getPessoa().getPes_codigo());
            deslig.setPes_tipo(2);
            pessoaDAO.update(deslig);
            return "salariolst";
        } else {
            throw new Error("As credenciais fornecidas são inválidas, tente novamente!");
        }
    }

    public String delete(Salario i) {
        dao.delete(i);
        LogDAO.insert("Salario", "Deletou salário código: " + i.getSal_codigo() + ", código cargo: " + i.getCargo().getCar_codigo()
                + ", motivo alteração salarial código: " + i.getMotivoAlteracaoSalarial().getMas_codigo() + ", código pessoa: " + i.getPessoa().getPes_codigo()
                + ", data início salário: " + i.getSal_datainicio() + ", data fim salário: " + i.getSal_datafim() + ", situação: " + i.isSal_situacao()
                + ", valor bruto: " + i.getSal_valorbruto());
        return "salariolst";
    }

    public String salvar() {
        if (salario.getSal_codigo() > 0) {
            dao.update(salario);
            LogDAO.insert("Salario", "Alterou salário código: " + salario.getSal_codigo() + ", código cargo: " + salario.getCargo().getCar_codigo()
                    + ", motivo alteração salarial código: " + salario.getMotivoAlteracaoSalarial().getMas_codigo() + ", código pessoa: " + salario.getPessoa().getPes_codigo()
                    + ", data início salário: " + salario.getSal_datainicio() + ", data fim salário: " + salario.getSal_datafim() + ", situação: " + salario.isSal_situacao()
                    + ", valor bruto: " + salario.getSal_valorbruto());
        } else {
            dao.insert(salario);
            LogDAO.insert("Salario", "Cadastrou salário código: " + salario.getSal_codigo() + ", código cargo: " + salario.getCargo().getCar_codigo()
                    + ", motivo alteração salarial código: " + salario.getMotivoAlteracaoSalarial().getMas_codigo() + ", código pessoa: " + salario.getPessoa().getPes_codigo()
                    + ", data início salário: " + salario.getSal_datainicio() + ", data fim salário: " + salario.getSal_datafim() + ", situação: " + salario.isSal_situacao()
                    + ", valor bruto: " + salario.getSal_valorbruto());
        }
        return "salariolst";
    }

    public String listar() {
        return "salariolst";
    }

    public List<MotivoAlteracaoSalarial> getLstMotivoAlteracaoSalarial() {
        lstMotivoAlteracaoSalarial = motivoAlteracaoSalarialDAO.findAll();
        return lstMotivoAlteracaoSalarial;
    }

    public void setLstMotivoAlteracaoSalarial(List<MotivoAlteracaoSalarial> lstMotivoAlteracaoSalarial) {
        this.lstMotivoAlteracaoSalarial = lstMotivoAlteracaoSalarial;
    }

    /*RETORNARA APENAS O PROXIMO CARGO DO PLANO DE CARREIRA*/
    public List<Cargo> getLstCargo(Salario s) {
        if (s == null || s.getSal_codigo() == 0) {
            this.lstCargo = cargoDAO.findAllChildrens();
            return this.lstCargo;
        } else {
            this.lstCargo = new ArrayList<Cargo>();
            List<PlanejamentoCargos> lstt = daoPLN.findByPlanejamento(s.getPlanejamentocargo().getPlanejamento().getPla_codigo());
            for (int i = 0; i < lstt.size(); i++) {
                this.lstCargo.add(lstt.get(i).getCargo());
            }
            return this.lstCargo;
        }
    }

    public void setLstCargo(List<Cargo> lstCargo) {
        this.lstCargo = lstCargo;
    }

    public List<Pessoa> getLstPessoa() {
        lstPessoa = pessoaDAO.findAll();
        return lstPessoa;
    }

    public void setLstPessoa(List<Pessoa> lstPessoa) {
        this.lstPessoa = lstPessoa;
    }
}
