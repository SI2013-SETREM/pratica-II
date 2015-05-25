package td.controller;

import td.dao.CursoDAO;
import td.model.Curso;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class CursoBean {

    private final String sTitle = Curso.sTitle;
    private final String pTitle = Curso.pTitle;

    private Curso curso = new Curso();
    private CursoDAO dao = new CursoDAO();
    private DataModel cursos;

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public DataModel getCursos() {
        this.cursos = new ListDataModel(dao.findAll());
        return cursos;
    }

    public void setAvaliacoes(DataModel cursos) {
        this.cursos = cursos;
    }
    
    public String insert() {
        dao.insert(curso);
        return "cursolst";
    }
    
    public String edit(Curso i) {
        curso = (Curso) cursos.getRowData();
        return "cursofrm";
    }

    public String update() {
        dao.update(curso);
        return "cursolst";
    }
    
    public String delete(Curso i) {
        dao.delete(i);
        return "cursolst";
    }
    
    public String salvar() {
        if (true) {
            dao.update(curso);
        } else {
            dao.insert(curso);
        }
        return "cursolst";
    }

    public String listar() {
        return "cursolst";
    }
    
}
