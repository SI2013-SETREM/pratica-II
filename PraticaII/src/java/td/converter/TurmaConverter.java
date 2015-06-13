package td.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import td.dao.TurmaDAO;
import td.model.Turma;

@FacesConverter("turmaConverter")
public class TurmaConverter implements javax.faces.convert.Converter {
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new TurmaDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Turma) object).getTur_codigo();
    }
}
