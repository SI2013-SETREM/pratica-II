package ad.converter;

import ad.dao.CompetenciaDAO;
import ad.model.Competencia;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("CompetenciaConverter")
public class CompetenciaConverter implements javax.faces.convert.Converter{
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new CompetenciaDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Competencia) object).getCmp_codigo();
    }
}
