package ff.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import ff.dao.FaltaDAO;
import ff.dao.FeriasDAO;
import ff.model.Falta;
import ff.model.Ferias;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class FeriasBean {

    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private DataModel<Pessoa> pessoas;
    private int idPessoa;

    private final FeriasDAO feriasDAO = new FeriasDAO();
    private Ferias ferias = new Ferias();

    public FeriasBean() {
    }

    public void inicio() {
        this.pessoas = new ListDataModel<>(pessoaDAO.findByPessoaId(getIdPessoa()));
        pessoa = pessoas.getRowData();
        pessoa = pessoaDAO.findById(pessoa.getPes_codigo());
        ferias.setPessoa(pessoa);
        //return "faltafrm";
    }

    public String insert() {
        feriasDAO.insert(ferias);
        return "fichafunlst";
        //return "fichafunfrm";
    }

    public String cancelar() {
        return "fichafunfrm";
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

    public DataModel getPessoas() {
        return pessoas;
    }

    public void setPessoas(DataModel pessoas) {
        this.pessoas = pessoas;
    }

    public Ferias getFerias() {
        return ferias;
    }

    public void setFerias(Ferias ferias) {
        this.ferias = ferias;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

}
