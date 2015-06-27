package rs.converter;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import java.util.List;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import rs.controller.RecrutamentoBean;
import rs.dao.RecrutamentoDAO;
import rs.dao.RecrutamentoPessoasDAO;
import rs.model.Recrutamento;
import rs.model.RecrutamentoPessoa;
import rs.model.RecrutamentoPessoaPK;
import util.Utilidades;

@FacesConverter("recrutamentoPessoaConverter")
public class RecrutamentoPessoaConverter implements javax.faces.convert.Converter {
    
    // NÃO ESTÁ SENDO UTILIZADO. IGNORAR.
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        System.err.println("CONVERTER PARM: " + string);
        RecrutamentoBean recrutamentoBean = (RecrutamentoBean) Utilidades.getSessionObject("recrutamentoBean");
        System.err.println("CONVERTER RECRUTAMENTO: " + recrutamentoBean);
        int PesCodigo = Integer.parseInt(string);
//        String[] parametros = string.split(Pattern.quote("0123210"));
//        System.err.println("CONVERTER PARAMETROS: " + parametros[0] + "-" + parametros[1]);
//        int PesCodigo = Integer.parseInt(parametros[0]);
//        int RecCodigo = Integer.parseInt(parametros[1]);
//        Pessoa p = new PessoaDAO().findById(PesCodigo);
//        Recrutamento r = new RecrutamentoDAO().findById(RecCodigo);
//        System.err.println("CONVERTER CLASSES: " + p + "-" + r);
        
//        RecrutamentoPessoaPK rp = new RecrutamentoPessoaPK();
//        rp.setPessoa(p);
//        rp.setRecrutamento(r);
        List<RecrutamentoPessoa> list = new RecrutamentoPessoasDAO().findAll();
        for (RecrutamentoPessoa recpes : list) {
//            if (recpes.getPessoa().getPes_codigo() == PesCodigo && recpes.getRecrutamento().getRecCodigo() == RecCodigo) {
            if (recpes.getPessoa().getPes_codigo() == PesCodigo && recpes.getRecrutamento().getRecCodigo() == recrutamentoBean.getRecrutamento().getRecCodigo()) {
                System.err.println("CONVERTER CLASSES RETORNA RECPES= " + recpes);
                return recpes;
            }
        }
        System.err.println("CONVERTER CLASSES RETORNA NULO");
        return null;
//        return new RecrutamentoPessoasDAO().findByPKId(rp);
    }
    
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
//        return "" + ((RecrutamentoPessoa) object).getPessoa().getPes_codigo() + "0123210" + ((RecrutamentoPessoa) object).getRecrutamento().getRecCodigo();
        return "" + ((RecrutamentoPessoa) object).getPessoa().getPes_codigo();
    }
}
