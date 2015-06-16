package csb.converter;

import csb.dao.GraduacaoDAO;
import csb.model.Graduacao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Juliano Pires
 */

@FacesConverter("graduacaoConverter")
public class GraduacaoConverter implements javax.faces.convert.Converter  {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new GraduacaoDAO().findById(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Graduacao) object).getGrd_codigo();
    }
}
