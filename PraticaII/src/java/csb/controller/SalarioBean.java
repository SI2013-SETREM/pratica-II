package csb.controller;

import cfg.dao.LogDAO;
import cfg.dao.PessoaDAO;
import cfg.dao.UsuarioDAO;
import cfg.model.Pessoa;
import cfg.model.Usuario;
import csb.dao.CargoDAO;
import csb.dao.MotivoAlteracaoSalarialDAO;
import csb.dao.SalarioDAO;
import csb.model.Cargo;
import csb.model.MotivoAlteracaoSalarial;
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

    private List<Pessoa> lstPessoa;
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();

    private Salario salario = new Salario();
    private SalarioDAO dao = new SalarioDAO();
    private DataModel salarios;
    private DataModel salariosHistorico;
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
    
    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public DataModel getSalariosOff() {
        List<Salario> lsSalBank = dao.findSalariosInativos();
        List<Salario> lsSal = new ArrayList<Salario>();
        for (Salario sal : lsSalBank) {
            boolean contem = false;
            if (lsSal.size() > 0) {
                for (Salario se : lsSal) {
                    if (sal.getPessoa().getPes_codigo() == se.getPessoa().getPes_codigo()) {
                        contem = true;
                    }
                }
            }
            if (!contem) {
                lsSal.add(sal);
            }
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
            throw new Error("Error");
        }
    }

    public String history(Salario sal) {
        salario = (Salario) salarios.getRowData();
        this.salariosHistorico = new ListDataModel(dao.findBySalPessoaId(sal.getPessoa().getPes_codigo()));
        return "historiasalario";
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
            return "salariolst";
        } else {
            throw new Error("Error");
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

    public List<Cargo> getLstCargo() {
        lstCargo = cargoDAO.findAllChildrens();
        return lstCargo;
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
