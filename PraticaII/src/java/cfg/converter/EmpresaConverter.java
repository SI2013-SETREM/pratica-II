package cfg.converter;

import cfg.dao.EmpresaDAO;
import cfg.model.Empresa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("empresaConverter")
public class EmpresaConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new EmpresaDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Empresa) object).getEmp_codigo();
    } 
}
