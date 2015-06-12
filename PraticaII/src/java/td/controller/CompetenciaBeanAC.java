package td.controller;

import ad.dao.CompetenciaDAO;
import ad.model.Competencia;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="competenciaMBAC", eager = true)
@ApplicationScoped
public class CompetenciaBeanAC {

   private List<Competencia> listacompetencias;
   private CompetenciaDAO dao = new CompetenciaDAO();
    
   public List<Competencia> getCompetencias(){
       listacompetencias = dao.findAll();
       return listacompetencias;
   }
}
