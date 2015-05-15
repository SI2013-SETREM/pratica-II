
package cfg.controller;

import cfg.dao.CidadeDAO;
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
        return "cidadelst";
    }
    
    public String salvar() {
        if (cidade.getCid_cep()!="")
            dao.update(cidade);
        else 
            dao.insert(cidade);
        
        return "cidadelst";
    }
    
    public String listar() {
        return "cidadelst";
    }
    
    
}
