/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.converter;

import fp.dao.TabINSSDAO;
import fp.model.TabelaINSS;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author Edivan
 */
@FacesConverter("tabelaINSSConverter")
public class TabelaINSSConverter implements javax.faces.convert.Converter{
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new TabINSSDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((TabelaINSS) object).getTbs_codigo();
    }
}
