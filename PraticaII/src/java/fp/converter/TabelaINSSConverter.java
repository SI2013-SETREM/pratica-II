
package fp.converter;



import fp.dao.TabelaINSSDAO;



import fp.model.TabelaINSS;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("tabelaINSSConverter")
public class TabelaINSSConverter implements javax.faces.convert.Converter{
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new TabelaINSSDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((TabelaINSS) object).getTbs_codigo();
    }
}
