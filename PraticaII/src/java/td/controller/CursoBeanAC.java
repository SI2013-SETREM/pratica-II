package td.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import td.dao.CursoDAO;
import td.model.Curso;
 
@ManagedBean(name="cursoMBAC", eager = true)
@ApplicationScoped
public class CursoBeanAC {

    private List<Curso> listapessoas;
    private CursoDAO dao = new CursoDAO();
     
    public List<Curso> getCursos() {
        listapessoas = dao.findAll();
        return listapessoas;
    } 
    
}
