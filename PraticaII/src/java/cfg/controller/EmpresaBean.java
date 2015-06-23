package cfg.controller;

import cfg.dao.EmpresaDAO;
import cfg.dao.LogDAO;
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

    public void setEmpresas(DataModel empresas) {
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
        LogDAO.insert("Empresa", "Deletou empresa código: " + i.getEmp_codigo() + ", descrição: " + i.getEmp_descricao()
                    + ", nome: " + i.getEmp_nome() + ", numero endereço: " + i.getEmp_numeroendereco()
                    + ", web site: " + i.getEmp_website() + ", código bairro: " + i.getBairro().getBai_codigo()
                    + ", código cidade: " + i.getCidade() + ", empresa sistema: " + i.getEmp_empresa_sistema()
                    + ", empresa sede: " + i.getEmp_sede() + ", tamanho empresa: " + i.getEmp_tamanho() + ", tipo empresa: "
                    + i.getEmp_tipo() + ", código endereço: " + i.getEndereco().getEnd_codigo() + ", código repositório: " + i.getRepositorio().getRep_codigo());
        return "empresalst";
    }

    public String salvar() {
        if (empresa.getEmp_codigo() > 0) {
            dao.update(empresa);
            LogDAO.insert("Empresa", "Alterou empresa código: " + empresa.getEmp_codigo() + ", descrição: " + empresa.getEmp_descricao()
                    + ", nome: " + empresa.getEmp_nome() + ", numero endereço: " + empresa.getEmp_numeroendereco()
                    + ", web site: " + empresa.getEmp_website() + ", código bairro: " + empresa.getBairro().getBai_codigo()
                    + ", código cidade: " + empresa.getCidade() + ", empresa sistema: " + empresa.getEmp_empresa_sistema()
                    + ", empresa sede: " + empresa.getEmp_sede() + ", tamanho empresa: " + empresa.getEmp_tamanho() + ", tipo empresa: "
                    + empresa.getEmp_tipo() + ", código endereço: " + empresa.getEndereco().getEnd_codigo() + ", código repositório: " + empresa.getRepositorio().getRep_codigo());
        } else {
            dao.insert(empresa);
            LogDAO.insert("Empresa", "Cadastrou empresa código: " + empresa.getEmp_codigo() + ", descrição: " + empresa.getEmp_descricao()
                    + ", nome: " + empresa.getEmp_nome() + ", numero endereço: " + empresa.getEmp_numeroendereco()
                    + ", web site: " + empresa.getEmp_website() + ", código bairro: " + empresa.getBairro().getBai_codigo()
                    + ", código cidade: " + empresa.getCidade() + ", empresa sistema: " + empresa.getEmp_empresa_sistema()
                    + ", empresa sede: " + empresa.getEmp_sede() + ", tamanho empresa: " + empresa.getEmp_tamanho() + ", tipo empresa: "
                    + empresa.getEmp_tipo() + ", código endereço: " + empresa.getEndereco().getEnd_codigo() + ", código repositório: " + empresa.getRepositorio().getRep_codigo());
        }

        return "empresalst";
    }

    public String listar() {
        return "empresalst";
    }

}
