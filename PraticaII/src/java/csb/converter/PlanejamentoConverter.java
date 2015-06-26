package csb.converter;

import csb.dao.PlanejamentoCarreiraDAO;
import csb.model.PlanejamentoCarreira;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Juliano Pires
 */
@FacesConverter("planejamentoConverter")
public class PlanejamentoConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new PlanejamentoCarreiraDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((PlanejamentoCarreira) object).getPla_codigo();
    }
}
