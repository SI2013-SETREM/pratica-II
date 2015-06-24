package csb.controller;

import cfg.dao.LogDAO;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import csb.dao.BeneficioDAO;
import csb.dao.BeneficiosPessoaDAO;
import csb.model.Beneficio;
import csb.model.BeneficiosPessoa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean
@RequestScoped
public class BeneficiosPessoaBean {
    
    private final String sTitle = BeneficiosPessoa.sTitle;
    private final String pTitle = BeneficiosPessoa.pTitle;
    
    private BeneficiosPessoa bnp = new BeneficiosPessoa();
    private BeneficiosPessoaDAO dao = new BeneficiosPessoaDAO();
    private DataModel beneficios;

    /* PARA FAZER A COMBO DE PESSOAS */
    private List<Pessoa> lstpessoa;
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoadao = new PessoaDAO();

    /* PARA FAZER A COMBO DE TIPO BENEFICIOS */
    private List<Beneficio> lstbeneficio;
    private Beneficio beneficio = new Beneficio();
    private BeneficioDAO beneficiodao = new BeneficioDAO();
    
    public BeneficiosPessoaBean() {
    }
    
    public String getsTitle() {
        return sTitle;
    }
    
    public String getpTitle() {
        return pTitle;
    }
    
    public BeneficiosPessoa getBnp() {
        return bnp;
    }
    
    public void setBnp(BeneficiosPessoa bnp) {
        this.bnp = bnp;
    }
    
    public DataModel getBeneficios() {
        this.beneficios = new ListDataModel(dao.findAll());
        return beneficios;
    }
    
    public void setBeneficios(DataModel beneficios) {
        this.beneficios = beneficios;
    }
    
    public List<Beneficio> getLstbeneficio() {
        lstbeneficio = beneficiodao.findAll();
        return lstbeneficio;
    }
    
    public void setLstbeneficio(List<Beneficio> lstbeneficio) {
        this.lstbeneficio = lstbeneficio;
    }
    
    public List<Pessoa> getLstpessoa() {
        lstpessoa = pessoadao.findAllFuncionarios();
        return lstpessoa;
    }
    
    public void setLstpessoa(List<Pessoa> lstpessoa) {
        this.lstpessoa = lstpessoa;
    }
    
    public String insert() {
        dao.insert(bnp);
        return "beneficiospessoafrm";
    }
    
    public String edit(BeneficiosPessoa e) {
        bnp = (BeneficiosPessoa) beneficios.getRowData();
        return "beneficiospessoafrm";
    }
    
    public String update() {
        dao.update(bnp);
        return "beneficiospessoalst";
    }
    
    public String delete(BeneficiosPessoa e) {
        dao.delete(e);
        return "beneficiospessoalst";
    }
    
    public String salvar() {
        if (bnp.getBen_datafim() == null && bnp.isBen_ativo() == false) {
            bnp.setBen_ativo(true);
        }
        if (bnp.getBnp_codigo() > 0) {
            dao.update(bnp);
        } else {
            dao.insert(bnp);
        }
        
        return "beneficiospessoalst";
    }
    
    public String listar() {
        return "beneficiospessoalst";
    }
}
