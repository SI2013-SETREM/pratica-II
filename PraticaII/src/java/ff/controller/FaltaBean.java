package ff.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import ff.dao.FaltaDAO;
import ff.model.Falta;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class FaltaBean {

    private final FaltaDAO faltaDAO = new FaltaDAO();
    private Falta falta = new Falta();
    private List<Falta> faltas;
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private DataModel pessoas;
    private int parametro;

    public FaltaBean() {
    }

    public String inicia() {

        pessoa = pessoaDAO.findByPessoaId(parametro);
        pessoa = pessoaDAO.findById(pessoa.getPes_codigo());
        falta.setPessoa(pessoa);

        return "faltafrm";
    }

    public String insert() {
        faltaDAO.insert(falta);
        return "fichafunfrm";
    }

    public String editar() {
        faltaDAO.update(falta);
        return "fichafunfrm";
    }

    public Falta getFalta() {
        return falta;
    }

    public void setFalta(Falta falta) {
        this.falta = falta;
    }

    public List<Falta> getFaltas() {

        return faltas;
    }


    public void getPessoas() {
        this.pessoa = pessoaDAO.findById(parametro);
       // return pessoas;
    }

    public void setPessoas(DataModel pessoas) {
        this.pessoas = pessoas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getParametro() {
        return parametro;
    }

    public void setParametro(int parametro) {
        this.parametro = parametro;
    }
}
