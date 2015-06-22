package ff.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import ff.dao.AdvertenciaDAO;
import ff.dao.FaltaDAO;
import ff.model.Advertencia;
import ff.model.Falta;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

@ManagedBean

public class AdvertenciaBean {
    
    private AdvertenciaDAO advertenciaDAO = new AdvertenciaDAO();
    private Advertencia advertencia = new Advertencia();
    private List<Pessoa> pesAplicador;
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private DataModel<Pessoa> pessoas;
    private int idPessoa;
    
    public AdvertenciaBean() {
    }
    
    public String inicia() {

        this.pessoas = new ListDataModel<>(pessoaDAO.findByPessoaId(getIdPessoa()));
        pessoa = pessoas.getRowData();
        pessoa = pessoaDAO.findById(pessoa.getPes_codigo());
        advertencia.setPessoa(pessoa);
        
        return "faltafrm";
    }
    
    public String insert() {
        advertenciaDAO.insert(advertencia);
        return "fichafunfrm";
    }
    public String listar() {
        return "fichafunfrm";
    }
    public List<Pessoa> completePessoa(String query) {
        return pessoaDAO.searchPessoa(query);
    }

    public AdvertenciaDAO getAdvertenciaDAO() {
        return advertenciaDAO;
    }

    public void setAdvertenciaDAO(AdvertenciaDAO advertenciaDAO) {
        this.advertenciaDAO = advertenciaDAO;
    }

    public Advertencia getAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(Advertencia advertencia) {
        this.advertencia = advertencia;
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

    public DataModel<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(DataModel<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public List<Pessoa> getPesAplicador() {
        return pesAplicador;
    }

    public void setPesAplicador(List<Pessoa> pesAplicador) {
        this.pesAplicador = pesAplicador;
    }
    
  
    
}
