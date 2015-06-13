package rs.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import rs.dao.QuestionarioDAO;
import rs.model.Questionario;

@FacesConverter("QuestionarioConverter")
public class QuestionarioConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new QuestionarioDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Questionario) object).getQstCodigo();
    }
}
