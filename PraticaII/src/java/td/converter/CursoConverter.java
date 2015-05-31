package td.converter;

import td.dao.CursoDAO;
import td.model.Curso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("cursoConverter")
public class CursoConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new CursoDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Curso) object).getCur_codigo();
    }  
}
