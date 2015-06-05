package cfg.controller;

import cfg.dao.RepositorioDAO;
import cfg.model.Repositorio;
import cfg.model.Repositorio;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class RepositorioBean {

    private final String sTitle = Repositorio.sTitle;
    private final String pTitle = Repositorio.pTitle;

    private Repositorio repositorio = new Repositorio();
    private RepositorioDAO dao = new RepositorioDAO();
    private DataModel repositorios;

    public RepositorioBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public DataModel getRepositorios() {
        this.repositorios = new ListDataModel(dao.findAll());
        return repositorios;
    }

    public void setRepositorio(DataModel repositorios) {
        this.repositorios = repositorios;
    }

    public String insert() {
        dao.insert(repositorio);
        return "repositoriolst";
    }

    public String edit(Repositorio i) {
        repositorio = (Repositorio) repositorios.getRowData();
        return "repositoriofrm";
    }

    public String update() {
        dao.update(repositorio);
        return "repositoriolst";
    }

    public String delete(Repositorio i) {
        dao.delete(i);
        return "repositoriolst";
    }

    public String salvar() {
        if (repositorio.getRep_codigo()> 0) {
            dao.update(repositorio);
        } else {
            dao.insert(repositorio);
        }

        return "repositoriolst";
    }

    public String listar() {
        return "repositoriolst";
    }
    
    public void upload() {
        
    }

}
