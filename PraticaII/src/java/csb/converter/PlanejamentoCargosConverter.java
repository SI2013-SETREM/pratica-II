/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csb.converter;

import csb.dao.PlanejamentoCargosDAO;
import csb.model.PlanejamentoCargos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Juliano Pires
 */
@FacesConverter("planejamentoCargosConverter")
public class PlanejamentoCargosConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new PlanejamentoCargosDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((PlanejamentoCargos) object).getPln_codigo();
    }
}
