package td.controller;

import cfg.dao.EmpresaDAO;
import cfg.dao.PessoaDAO;
import cfg.model.Empresa;
import cfg.model.Pessoa;
import java.util.List;
import td.dao.CursosPessoaDAO;
import td.model.CursosPessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import td.dao.CursoDAO;
import td.model.Curso;

@ManagedBean
@RequestScoped
public class CursosPessoaBean {

    private final String sTitle = CursosPessoa.sTitle;
    private final String pTitle = CursosPessoa.pTitle;
    
    private List<Empresa> lstempresa;
    private Empresa empresa = new Empresa();
    private EmpresaDAO empresadao = new EmpresaDAO();

    private List<Curso> lstcurso;
    
    private List<Pessoa> lstpessoa;
    private List<Pessoa> lstpessoacurso;

    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoadao = new PessoaDAO();
    
    private Curso curso = new Curso();
    private CursoDAO cursodao = new CursoDAO();

    private CursosPessoa cursos_pessoa = new CursosPessoa();
    private CursosPessoaDAO dao = new CursosPessoaDAO();
    private DataModel cursos_pessoas;

    public List<Empresa> getLstempresa() {
        lstempresa = empresadao.findAll();
        return lstempresa;
    }

    public void setLstempresa(List<Empresa> lstempresa) {
        this.lstempresa = lstempresa;
    }

    public List<Curso> getLstcurso() {
        lstcurso = cursodao.findAll();
        return lstcurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public List<Pessoa> getLstpessoa() {
        lstpessoa = pessoadao.findAll();
        return lstpessoa;
    }

    public void setLstpessoa(List<Pessoa> lstpessoa) {
        this.lstpessoa = lstpessoa;
    }
    
    public List<Pessoa> getLstpessoacurso() {
        lstpessoacurso = pessoadao.findPesCur();
        return lstpessoacurso;
    }

    public void setLstpessoacurso(List<Pessoa> lstpessoacurso) {
        this.lstpessoacurso = lstpessoacurso;
    }
    
    public void setLstcurso(List<Curso> lstcurso) {
        this.lstcurso = lstcurso;
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public CursosPessoa getCursos_pessoa() {
        return cursos_pessoa;
    }

    public void setCursos_pessoa(CursosPessoa cursos_pessoa) {
        this.cursos_pessoa = cursos_pessoa;
    }

    public DataModel getCursos_pessoas() {
        this.cursos_pessoas = new ListDataModel(dao.findAll());
        return cursos_pessoas;
    }

    public void setCursos_pessoas(DataModel cursos_pessoas) {
        this.cursos_pessoas = cursos_pessoas;
    }

    public String insert() {
        dao.insert(cursos_pessoa);
        return "cursospessoalst";
    }
    
    public String edit(CursosPessoa i) {
        cursos_pessoa = (CursosPessoa) cursos_pessoas.getRowData();
        return "cursospessoafrm";
    }

    public String update() {
        dao.update(cursos_pessoa);
        return "cursospessoalst";
    }
    
    public String delete(CursosPessoa i) {
        dao.delete(i);
        return "cursospessoalst";
    }
    
    public String salvar() {
        if (cursos_pessoa.getCrp_curpes() > 0)
            dao.update(cursos_pessoa);
        else 
            dao.insert(cursos_pessoa);
        
        return "cursospessoalst";
    }

    public String listar() {
        return "cursospessoalst";
    }
    
}
