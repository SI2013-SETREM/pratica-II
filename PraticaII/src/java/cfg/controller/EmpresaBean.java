package cfg.controller;

import cfg.dao.EmpresaDAO;
import cfg.model.Empresa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class EmpresaBean {

    private final String sTitle = Empresa.sTitle;
    private final String pTitle = Empresa.pTitle;

    private Empresa empresa = new Empresa();
    private EmpresaDAO dao = new EmpresaDAO();
    private DataModel empresas;

    public EmpresaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public DataModel getEmpresas() {
        this.empresas = new ListDataModel(dao.findAll());
        return empresas;
    }

    public void setEmpresas(DataModel idiomas) {
        this.empresas = empresas;
    }

    public String insert() {
        dao.insert(empresa);
        return "empresalst";
    }

    public String edit(Empresa i) {
        empresa = (Empresa) empresas.getRowData();
        return "empresafrm";
    }

    public String update() {
        dao.update(empresa);
        return "empresalst";
    }

    public String delete(Empresa i) {
        dao.delete(i);
        return "empresalst";
    }

    public String salvar() {
        if (empresa.getEmp_codigo() > 0) {
            dao.update(empresa);
        } else {
            dao.insert(empresa);
        }

        return "empresalst";
    }

    public String listar() {
        return "empresalst";
    }

}
