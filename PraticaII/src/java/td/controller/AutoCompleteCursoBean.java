package td.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import td.model.Curso;

@ManagedBean
public class AutoCompleteCursoBean {
    
    @ManyToMany
    @JoinTable(name = "trd_cursos_pessoa")
    private List<Curso> cursos;

    @ManagedProperty("#{cursoMBAC}")
    private CursoBeanAC serviceCurso;

    public List<Curso> completaNomeCurso(String query) {
        List<Curso> allThemes = serviceCurso.getCursos();
        List<Curso> filteredThemes = new ArrayList<Curso>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Curso skin = allThemes.get(i);
            if(skin.getCur_nome().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void setServiceCurso(CursoBeanAC serviceCurso) {
        this.serviceCurso = serviceCurso;
    }
}
