package csb.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import csb.dao.CargoDAO;
import csb.dao.MotivoAlteracaoSalarialDAO;
import csb.dao.SalarioDAO;
import csb.model.Cargo;
import csb.model.MotivoAlteracaoSalarial;
import csb.model.Salario;
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
public class SalarioBean
{

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

    public SalarioBean()
    {
    }

    public String getsTitle()
    {
        return sTitle;
    }

    public String getpTitle()
    {
        return pTitle;
    }

    public Salario getSalario()
    {
        return salario;
    }

    public DataModel getSalarios()
    {
        this.salarios = new ListDataModel(dao.findSalariosAtivos());
        return salarios;
    }

    public void setSalarios(DataModel datamodel)
    {
        this.salarios = datamodel;
    }

    public void setSalario(Salario salario)
    {
        this.salario = salario;
    }

    public String insert()
    {
        dao.insert(salario);
        return "salariolst";
    }

    public String edit(Salario i)
    {
        salario = (Salario) salarios.getRowData();
        return "salariofrm";
    }

    public String update()
    {
        dao.update(salario);
        return "salariolst";
    }

    public String updateSalario()
    {
        dao.updateSalario(salario);
        return "salariolst";
    }

    public String delete(Salario i)
    {
        dao.delete(i);
        return "salariolst";
    }

    public String salvar()
    {
        if (salario.getSal_codigo() > 0)
        {
            dao.update(salario);
        }
        else
        {
            dao.insert(salario);
        }
        return "salariolst";
    }

    public String listar()
    {
        return "salariolst";
    }

    public List<MotivoAlteracaoSalarial> getLstMotivoAlteracaoSalarial()
    {
        lstMotivoAlteracaoSalarial = motivoAlteracaoSalarialDAO.findAll();
        return lstMotivoAlteracaoSalarial;
    }

    public void setLstMotivoAlteracaoSalarial(List<MotivoAlteracaoSalarial> lstMotivoAlteracaoSalarial)
    {
        this.lstMotivoAlteracaoSalarial = lstMotivoAlteracaoSalarial;
    }

    public List<Cargo> getLstCargo()
    {
        lstCargo = cargoDAO.findAll();
        return lstCargo;
    }

    public void setLstCargo(List<Cargo> lstCargo)
    {
        this.lstCargo = lstCargo;
    }

    public List<Pessoa> getLstPessoa()
    {
        lstPessoa = pessoaDAO.findAll();
        return lstPessoa;
    }

    public void setLstPessoa(List<Pessoa> lstPessoa)
    {
        this.lstPessoa = lstPessoa;
    }
}
