
package rs.controller;

import cfg.model.Pessoa;
import rs.dao.CurriculoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.model.PessoaCompetencia;
import rs.model.PessoaExperiencia;
import rs.model.PessoaFormacao;
import rs.model.PessoaIdioma;
import rs.model.PessoaRedeSocial;

@ManagedBean
@SessionScoped
public class CurriculoBean {

    private CurriculoDAO dao = new CurriculoDAO();
    private Pessoa pessoa = new Pessoa();
    private DataModel cvs;
    private PessoaFormacao pessoaFormacao;
    private DataModel formacoes;
    private PessoaExperiencia pessoaExperiencia;
    private DataModel experiencias;
    private PessoaIdioma pessoaIdioma;
    private DataModel idiomas;
    private PessoaCompetencia pessoaCompetencia;
    private DataModel competencias;
    private PessoaRedeSocial pessoaRedeSocial;
    private DataModel redessociais;
    
    public CurriculoBean() {
    }

    ///// Getters e Setters Models /////
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaFormacao getPessoaFormacao() {
        return pessoaFormacao;
    }

    public void setPessoaFormacao(PessoaFormacao pessoaFormacao) {
        this.pessoaFormacao = pessoaFormacao;
    }

    public PessoaExperiencia getPessoaExperiencia() {
        return pessoaExperiencia;
    }

    public void setPessoaExperiencia(PessoaExperiencia pessoaExperiencia) {
        this.pessoaExperiencia = pessoaExperiencia;
    }

    public PessoaIdioma getPessoaIdioma() {
        return pessoaIdioma;
    }

    public void setPessoaIdioma(PessoaIdioma pessoaIdioma) {
        this.pessoaIdioma = pessoaIdioma;
    }

    public PessoaCompetencia getPessoaCompetencia() {
        return pessoaCompetencia;
    }

    public void setPessoaCompetencia(PessoaCompetencia pessoaCompetencia) {
        this.pessoaCompetencia = pessoaCompetencia;
    }

    public PessoaRedeSocial getPessoaRedeSocial() {
        return pessoaRedeSocial;
    }

    public void setPessoaRedeSocial(PessoaRedeSocial pessoaRedeSocial) {
        this.pessoaRedeSocial = pessoaRedeSocial;
    }

    ///// Getters e Setters Lists /////
    public DataModel getCvs() {
        this.cvs = new ListDataModel(dao.findAll());
        return cvs;
    }

    public void setCvs(DataModel cvs) {
        this.cvs = cvs;
    }

    public DataModel getFormacoes() {
        this.formacoes = new ListDataModel(dao.findFormacoes(pessoa.getPes_codigo()));
        return formacoes;
    }

    public void setFormacoes(DataModel formacoes) {
        this.formacoes = formacoes;
    }

    public DataModel getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(DataModel experiencias) {
        this.experiencias = new ListDataModel(dao.findExperiencias(pessoa.getPes_codigo()));
        this.experiencias = experiencias;
    }

    public DataModel getIdiomas() {
        this.idiomas = new ListDataModel(dao.findIdiomas(pessoa.getPes_codigo()));
        return idiomas;
    }

    public void setIdiomas(DataModel idiomas) {
        this.idiomas = idiomas;
    }

    public DataModel getCompetencias() {
        this.competencias = new ListDataModel(dao.findCompetencias(pessoa.getPes_codigo()));
        return competencias;
    }

    public void setCompetencias(DataModel competencias) {
        this.competencias = competencias;
    }

    public DataModel getRedessociais() {
        this.redessociais = new ListDataModel(dao.findRedesSociais(pessoa.getPes_codigo()));
        return redessociais;
    }

    public void setRedessociais(DataModel redessociais) {
        this.redessociais = redessociais;
    }
    
    ///// Métodos da View /////
    public String listar() {
        return "curriculolst";
    }
    
    public String edit() {
        pessoa = (Pessoa) cvs.getRowData();
        return "curriculofrm";
    }
    
    public String salvar() {
        return "curriculolst";
    }
    
    public String salvarCurriculo() {
        storeCurriculo();
        return listar();
    }
    
    public String avancarCurriculo() {
        storeCurriculo();
        return "curriculoFormacaolst";
    }
    
    public void storeCurriculo() {
        dao.update(pessoa);
    }
    
    ///// FORMAÇÃO /////
    public String novaFormacao() {
        this.pessoaFormacao = new PessoaFormacao();
        return "curriculoFormacaofrm";
    }
    
    public String editFormacao() {
        this.pessoaFormacao = (PessoaFormacao) formacoes.getRowData();
        return "curriculoFormacaofrm";
    }
    
    public void deleteFormacao() {
        PessoaFormacao pf = (PessoaFormacao) formacoes.getRowData();
        dao.deleteObj(pf);
    }
    
    public String voltarFormacao() {
        return "curriculofrm";
    }
    
    public String avancarFormacao() {
        return "curriculoExperiencialst";
    }
    
    ///// EXPERIÊNCIA /////
    public String novaExperiencia() {
        this.pessoaExperiencia = new PessoaExperiencia();
        return "curriculoExperienciafrm";
    }
    
    public String editExperiencia() {
        this.pessoaExperiencia = (PessoaExperiencia) experiencias.getRowData();
        return "curriculoExperienciafrm";
    }
    
    public void deleteExperiencia() {
        PessoaExperiencia pf = (PessoaExperiencia) experiencias.getRowData();
        dao.deleteObj(pf);
    }
    
    public String voltarExperiencia() {
        return "curriculoFormacaolst";
    }
    
    public String avancarExperiencia() {
        return "curriculoIdiomalst";
    }
    
    ///// IDIOMA /////
    public String novoIdioma() {
        this.pessoaIdioma = new PessoaIdioma();
        return "curriculoIdiomafrm";
    }
    
    public String editIdioma() {
        this.pessoaIdioma = (PessoaIdioma) idiomas.getRowData();
        return "curriculoIdiomafrm";
    }
    
    public void deleteIdioma() {
        PessoaIdioma pf = (PessoaIdioma) idiomas.getRowData();
        dao.deleteObj(pf);
    }
    
    public String voltarIdioma() {
        return "curriculoExperiencialst";
    }
    
    public String avancarIdioma() {
        return "curriculoCompetencialst";
    }
    
    ///// COMPETENCIA /////
    public String novaCompetencia() {
        this.pessoaCompetencia = new PessoaCompetencia();
        return "curriculoCompetenciafrm";
    }
    
    public String editCompetencia() {
        this.pessoaCompetencia = (PessoaCompetencia) competencias.getRowData();
        return "curriculoCompetenciafrm";
    }
    
    public void deleteCompetencia() {
        PessoaCompetencia pf = (PessoaCompetencia) competencias.getRowData();
        dao.deleteObj(pf);
    }
    
    public String voltarCompetencia() {
        return "curriculoIdiomalst";
    }
    
    public String avancarCompetencia() {
        return "curriculoRedeSociallst";
    }
    
    ///// REDE SOCIAL /////
    public String novaRedeSocial() {
        this.pessoaRedeSocial = new PessoaRedeSocial();
        return "curriculoRedeSocialfrm";
    }
    
    public String editRedeSocial() {
        this.pessoaRedeSocial = (PessoaRedeSocial) redessociais.getRowData();
        return "curriculoRedeSocialfrm";
    }
    
    public void deleteRedeSocial() {
        PessoaRedeSocial obj = (PessoaRedeSocial) redessociais.getRowData();
        dao.deleteObj(obj);
    }
    
    public String voltarRedeSocial() {
        return "curriculoCompetencialst";
    }
    
    public String avancarRedeSocial() {
        return "curriculolst";
    }
    
}