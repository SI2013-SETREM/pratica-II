package ff.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import csb.dao.BeneficiosPessoaDAO;
import csb.dao.CargosPessoaDAO;
import csb.model.BeneficiosPessoa;
import csb.model.CargosPessoa;
import ff.dao.FaltaDAO;
import ff.dao.FeriasDAO;

import ff.model.Falta;
import ff.model.Ferias;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;

import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

@ManagedBean
public class FichaFuncionalBean {

  

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

    private final FaltaDAO faltaDAO = new FaltaDAO();
    private List<Falta> faltas;

    public List<Ferias> getFerias() {
        return ferias;
    }

    public List<BeneficiosPessoa> getBeneficios() {
        return beneficios;
    }

    public FichaFuncionalBean() {
    }

    public String select() {
        pessoa = funcionarios.getRowData();
        pessoa = pessoaDAO.findById(pessoa.getPes_codigo());
        if (pessoa != null) {
            beneficios = beneficiosPessoaDAO.findByPessoaId(pessoa.getPes_codigo());
            ///ferias = feriasDAO.findById(fichaFuncional.getFfu_codigo());
            cargos = cargosDAO.GetListCargoPessoa(pessoa.getPes_codigo(),0);
//            faltas = faltaDAO.findFaltas(fichaFuncional.getFfu_codigo());
        } else {
            beneficios = new ArrayList<>();
            
            cargos = new ArrayList<>();
            
            
        }
        return "fichafunfrm";
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

}
