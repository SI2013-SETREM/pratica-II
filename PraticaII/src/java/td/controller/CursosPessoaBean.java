package td.controller;

import td.dao.CursosPessoaDAO;
import td.model.CursosPessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class CursosPessoaBean {

    private final String sTitle = CursosPessoa.sTitle;
    private final String pTitle = CursosPessoa.pTitle;

    private CursosPessoa cursos_pessoa = new CursosPessoa();
    private CursosPessoaDAO dao = new CursosPessoaDAO();
    private DataModel cursos_pessoas;

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
        if (cursos_pessoa.getEmpresa().getEmp_codigo()> 0)
            dao.update(cursos_pessoa);
        else 
            dao.insert(cursos_pessoa);
        
        return "idiomalst";
    }

    public String listar() {
        return "cursospessoalst";
    }
    
}
