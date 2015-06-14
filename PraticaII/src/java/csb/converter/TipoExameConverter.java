package csb.converter;

import csb.dao.TipoExameDAO;
import csb.model.TipoExame;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoExameConverter")
public class TipoExameConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new TipoExameDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((TipoExame) object).getEme_codigo();
    }
}
