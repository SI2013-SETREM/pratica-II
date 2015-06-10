package ff.controller;

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
import javax.faces.model.ListDataModel;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class FichaFuncionalBean {

    private List<Pessoa> pessoas;    

    private final BeneficiosPessoaDAO beneficiosPessoaDAO = new BeneficiosPessoaDAO();
    private List<BeneficiosPessoa> beneficios;
   
    private final FeriasDAO feriasDAO = new FeriasDAO();
    private List<Ferias> ferias;

    private final CargosPessoaDAO cargosDAO = new CargosPessoaDAO();
    private List<CargosPessoa> cargos;
    
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

    public String visualizar() {
        return "fichafunfrm";
    }

    public String manutecao() {
        return "fichafunfrm";
    }
    
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<CargosPessoa> getCargos() {
        return cargos;
    }

    public CargosPessoaDAO getCargosDAO() {
        return cargosDAO;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public BeneficiosPessoaDAO getBeneficiosPessoaDAO() {
        return beneficiosPessoaDAO;
    }

    public FeriasDAO getFeriasDAO() {
        return feriasDAO;
    }

    public void setBeneficios(List<BeneficiosPessoa> beneficios) {
        this.beneficios = beneficios;
    }

    public void setFerias(List<Ferias> ferias) {
        this.ferias = ferias;
    }

    public void setCargos(List<CargosPessoa> cargos) {
        this.cargos = cargos;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }  

}
