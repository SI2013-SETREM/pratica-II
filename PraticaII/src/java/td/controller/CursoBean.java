package td.controller;

import cfg.dao.LogDAO;
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
        LogDAO.insert("Curso", "Deletou curso código: " + i.getCur_codigo()+
                    ", nome: " + i.getCur_nome());
        return "cursolst";
    }

    public String salvar() {
        if (curso.getCur_codigo() > 0) {
            dao.update(curso);
            LogDAO.insert("Curso", "Cadastrou curso código: " + curso.getCur_codigo()+
                    ", nome: " + curso.getCur_nome());
        } else {
            dao.insert(curso);
            LogDAO.insert("Curso", "Alterou curso código: " + curso.getCur_codigo()+
                    ", nome: " + curso.getCur_nome());
        }

        return "cursolst";
    }

    public String listar() {
        return "cursolst";
    }

}
