package fp.converter;

import fp.dao.TipoEventoDAO;
import fp.model.TipoEvento;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoEventoConverter")
public class TipoEventoConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new TipoEventoDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((TipoEvento) object).getTpe_codigo();
    }
}
