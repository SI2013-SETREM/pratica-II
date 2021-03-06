
package fp.converter;


import fp.dao.TabelaIRRFDAO;
import fp.model.TabelaIRRF;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("tabelaIRRFConverter")
public class TabelaIRRFConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new TabelaIRRFDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((TabelaIRRF) object).getTif_codigo();
    }
}