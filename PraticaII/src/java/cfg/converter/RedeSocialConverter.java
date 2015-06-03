package cfg.converter;

import cfg.dao.RedeSocialDAO;
import cfg.model.RedeSocial;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("redesocialConverter")
public class RedeSocialConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new RedeSocialDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((RedeSocial) object).getRsc_codigo();
    }
}
