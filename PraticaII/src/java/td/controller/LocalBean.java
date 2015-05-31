package td.controller;

import cfg.dao.CidadeDAO;
import cfg.dao.EmpresaDAO;
import cfg.model.Cidade;
import cfg.model.Empresa;
import java.util.List;
import td.dao.LocalDAO;
import td.model.Local;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class LocalBean {

    private final String sTitle = Local.sTitle;
    private final String pTitle = Local.pTitle;
    
    private List<Cidade> lstcidade;
    private Cidade cidade = new Cidade();
    private CidadeDAO cidadedao = new CidadeDAO();
    
    private List<Empresa> lstempresa;
    private Empresa empresa = new Empresa();
    private EmpresaDAO empresadao = new EmpresaDAO();
    
    private Local local = new Local();
    private LocalDAO dao = new LocalDAO();
    private DataModel locais;
   
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public DataModel getLocais() {
        this.locais = new ListDataModel(dao.findAll());
        return locais;
    }

    public void setLocais(DataModel locais) {
        this.locais = locais;
    }
    
    public String insert() {
        dao.insert(local);
        return "locallst";
    }
    
    public String edit(Local i) {
        local = (Local) locais.getRowData();
        return "localfrm";
    }

    public String update() {
        dao.update(local);
        return "locallst";
    }
    
    public String delete(Local i) {
        dao.delete(i);
        return "locallst";
    }
    
    public String salvar() {
         if (local.getLoc_codigo()> 0)
            dao.update(local);
        else 
            dao.insert(local);
        
        return "locallst";
    }

    public String listar() {
        return "locallst";
    }
    
    public List<Cidade> getLstcidade() {
        lstcidade = cidadedao.findAll();
        return lstcidade;
    }

    public void setLstcidade(List<Cidade> lstcidade) {
        this.lstcidade = lstcidade;
    }

    public List<Empresa> getLstempresa() {
        lstempresa = empresadao.findAll();
        return lstempresa;
    }

    public void setLstempresa(List<Empresa> lstempresa) {
        this.lstempresa = lstempresa;
    }
}
