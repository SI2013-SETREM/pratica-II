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

    private Empresa endereco = new Empresa();
    private EmpresaDAO dao = new EmpresaDAO();
    private DataModel enderecos;

    public EmpresaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Empresa getEmpresa() {
        return endereco;
    }

    public void setEmpresa(Empresa endereco) {
        this.endereco = endereco;
    }

    public DataModel getEmpresas() {
        this.enderecos = new ListDataModel(dao.findAll());
        return enderecos;
    }

    public void setEmpresas(DataModel idiomas) {
        this.enderecos = enderecos;
    }

    public String insert() {
        dao.insert(endereco);
        return "enderecolst";
    }

    public String edit(Empresa i) {
        endereco = (Empresa) enderecos.getRowData();
        return "enderecofrm";
    }

    public String update() {
        dao.update(endereco);
        return "enderecolst";
    }

    public String delete(Empresa i) {
        dao.delete(i);
        return "enderecolst";
    }

    public String salvar() {
        if (endereco.getEmp_codigo() > 0) {
            dao.update(endereco);
        } else {
            dao.insert(endereco);
        }

        return "enderecolst";
    }

    public String listar() {
        return "enderecolst";
    }

}
