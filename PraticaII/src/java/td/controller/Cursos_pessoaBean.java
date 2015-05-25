package td.controller;

import td.dao.Cursos_pessoaDAO;
import td.model.Cursos_pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class Cursos_pessoaBean {

    private final String sTitle = Cursos_pessoa.sTitle;
    private final String pTitle = Cursos_pessoa.pTitle;

    private Cursos_pessoa cursos_pessoa = new Cursos_pessoa();
    private Cursos_pessoaDAO dao = new Cursos_pessoaDAO();
    private DataModel cursos_pessoas;

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Cursos_pessoa getCursos_pessoa() {
        return cursos_pessoa;
    }

    public void setCursos_pessoa(Cursos_pessoa cursos_pessoa) {
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
        return "cursos_pessoalst";
    }
    
    public String edit(Cursos_pessoa i) {
        cursos_pessoa = (Cursos_pessoa) cursos_pessoas.getRowData();
        return "cursos_pessoafrm";
    }

    public String update() {
        dao.update(cursos_pessoa);
        return "cursos_pessoalst";
    }
    
    public String delete(Cursos_pessoa i) {
        dao.delete(i);
        return "cursos_pessoalst";
    }
    
    public String salvar() {
        if (true) {
            dao.update(cursos_pessoa);
        } else {
            dao.insert(cursos_pessoa);
        }
        return "cursos_pessoalst";
    }

    public String listar() {
        return "cursos_pessoalst";
    }
    
}
