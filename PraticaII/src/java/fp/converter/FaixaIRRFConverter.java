
package fp.converter;


import fp.dao.FaixaIRRFDAO;
import fp.model.FaixaIRRF;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("faixaIRRFConverter")
public class FaixaIRRFConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new FaixaIRRFDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((FaixaIRRF) object).getFrf_codigo();
    }
}