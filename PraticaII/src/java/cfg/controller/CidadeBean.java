
package cfg.controller;

import cfg.dao.CidadeDAO;
import cfg.dao.LogDAO;
import cfg.model.Cidade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class CidadeBean {
    
    private final String sTitle = Cidade.sTitle;
    private final String pTitle = Cidade.pTitle;
    
    private Cidade cidade = new Cidade();
    private CidadeDAO dao = new CidadeDAO();
    private DataModel cidades;
    
    public CidadeBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade= cidade;
    }

    public DataModel getCidades() {
        this.cidades = new ListDataModel(dao.findAll());
        return cidades;
    }

    public void setCidades(DataModel cidades) {
        this.cidades= cidades;
    }
    
    public String insert() {
        dao.insert(cidade);
        return "cidadeslst";
    }
    
    public String edit(Cidade i) {
        cidade= (Cidade) cidades.getRowData();
        return "cidadefrm";
    }
    
    public String update() {
        dao.update(cidade);
        return "cidadelst";
    }
    
    public String delete(Cidade i) {
        dao.delete(i);
        LogDAO.insert("Cidade", "Deletou cidade código: " + i.getCid_codigo() + ", nome: " + i.getCid_nome() + ", uf: " + i.getCid_uf());
        return "cidadelst";
    }

    public String salvar() {
        if (cidade.getCid_codigo() != 0) {
            dao.update(cidade);
            LogDAO.insert("Cidade", "Alterou cidade código: " + cidade.getCid_codigo() + ", nome: " + cidade.getCid_nome() + ", uf: " + cidade.getCid_uf());
        } else {
            dao.insert(cidade);
            LogDAO.insert("Cidade", "Cadastrou cidade código: " + cidade.getCid_codigo() + ", nome: " + cidade.getCid_nome() + ", uf: " + cidade.getCid_uf());
        }
        return "cidadelst";
    }
    
    public String listar() {
        return "cidadelst";
    }
    
    
}
