package cfg.converter;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import rs.dao.RecrutamentoDAO;
import rs.dao.RecrutamentoPessoasDAO;
import rs.model.Recrutamento;
import rs.model.RecrutamentoPessoa;
import rs.model.RecrutamentoPessoaPK;

@FacesConverter("recrutamentoPessoaConverter")
public class RecrutamentoPessoaConverter implements javax.faces.convert.Converter {
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        String[] parametros = string.split("-");
        Pessoa p = new PessoaDAO().findById(Integer.parseInt(parametros[0]));
        Recrutamento r = new RecrutamentoDAO().findById(Integer.parseInt(parametros[1]));
        RecrutamentoPessoaPK rp = new RecrutamentoPessoaPK();
        rp.setPessoa(p);
        rp.setRecrutamento(r);
        return new RecrutamentoPessoasDAO().findByPKId(rp);
    }
    
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((RecrutamentoPessoa) object).getPessoa().getPes_codigo() + "-" + ((RecrutamentoPessoa) object).getRecrutamento().getRecCodigo();
    }
}