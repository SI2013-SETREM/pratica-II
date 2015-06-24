package csb.controller;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import csb.dao.EpiDAO;
import csb.dao.EquipamentosPessoaDAO;
import csb.model.Epi;
import csb.model.EquipamentosPessoa;
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
public class EquipamentosPessoaBean {

    private final String sTitle = EquipamentosPessoa.sTitle;
    private final String pTitle = EquipamentosPessoa.pTitle;

    private EquipamentosPessoa eqp = new EquipamentosPessoa();
    private final EquipamentosPessoaDAO dao = new EquipamentosPessoaDAO();
    private DataModel equipamentos;

    /* PARA FAZER A COMBO DE PESSOAS */
    private List<Pessoa> lstpessoa;
    private final Pessoa pessoa = new Pessoa();
    private final PessoaDAO pessoadao = new PessoaDAO();

    
    /* PARA FAZER A COMBO DE EQUIPAMENTOS */
    private List<Epi> lstEpi;
    private final Epi epi = new Epi();
    private final EpiDAO epidao = new EpiDAO();
    
    public EquipamentosPessoaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public EquipamentosPessoa getEqp() {
        return eqp;
    }

    public void setEqp(EquipamentosPessoa eqp) {
        this.eqp = eqp;
    }

    public DataModel getEquipamentos() {
        this.equipamentos = new ListDataModel(dao.findAll());
        return equipamentos;
    }

    public void setEquipamentos(DataModel equipamentos) {
        this.equipamentos = equipamentos;
    }

    public List<Pessoa> getLstpessoa() {
        lstpessoa = pessoadao.findAllFuncionarios();
        return lstpessoa;
    }

    public void setLstpessoa(List<Pessoa> lstpessoa) {
        this.lstpessoa = lstpessoa;
    }    
    
    public List<Epi> getLstEpi() {
        lstEpi = epidao.findEpi();
        return lstEpi;
    }

    public void setLstEpi(List<Epi> lstepi) {
        this.lstEpi = lstepi;
    }
    
    public String insert() {
        dao.insert(eqp);
        return "equipamentospessoafrm";
    }

    public String edit(EquipamentosPessoa e) {
        eqp = (EquipamentosPessoa) equipamentos.getRowData();
        return "equipamentospessoafrm";
    }

    public String update() {
        dao.update(eqp);
        return "equipamentospessoalst";
    }

    public String delete(EquipamentosPessoa e) {
        dao.delete(e);
        return "equipamentospessoalst";
    }

    public String salvar() {
        if (eqp.getEqp_codigo() > 0) {
            dao.update(eqp);
        } else {
            dao.insert(eqp);
        }

        return "equipamentospessoalst";
    }

    public String listar() {
        return "equipamentospessoalst";
    }
}