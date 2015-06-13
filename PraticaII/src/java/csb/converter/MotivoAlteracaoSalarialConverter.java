package csb.converter;

import csb.dao.MotivoAlteracaoSalarialDAO;
import csb.model.MotivoAlteracaoSalarial;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Augusto
 */
@FacesConverter("motivoAlteracaoSalarioConverter")
public class MotivoAlteracaoSalarialConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string)
    {
        int id = Integer.parseInt(string);
        return new MotivoAlteracaoSalarialDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object)
    {

        return "" + (((MotivoAlteracaoSalarial) object) == null ? "" : ((MotivoAlteracaoSalarial) object).getMas_codigo());
    }
}
