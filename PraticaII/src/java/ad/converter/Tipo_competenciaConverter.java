package ad.converter;

import ad.dao.Tipo_competenciaDAO;
import ad.model.Tipo_competencia;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipo_competenciaConverter")
public class Tipo_competenciaConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new Tipo_competenciaDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Tipo_competencia) object).getTcp_codigo();
    }
}
