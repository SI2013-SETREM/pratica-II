package ad.converter;

import ad.dao.TipoCompetenciaDAO;
import ad.model.TipoCompetencia;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoCompetenciaConverter")
public class TipoCompetenciaConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new TipoCompetenciaDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((TipoCompetencia) object).getTcp_codigo();
    }
}
