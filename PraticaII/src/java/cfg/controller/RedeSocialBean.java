package cfg.controller;

import cfg.dao.LogDAO;
import cfg.dao.RedeSocialDAO;
import cfg.dao.RepositorioDAO;
import cfg.model.RedeSocial;
import cfg.model.Repositorio;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.List;

@ManagedBean
@RequestScoped
public class RedeSocialBean {

    private final String sTitle = RedeSocial.sTitle;
    private final String pTitle = RedeSocial.pTitle;

    private RedeSocial redesocial = new RedeSocial();
    private RedeSocialDAO dao = new RedeSocialDAO();
    private DataModel redessociais;
    private RepositorioDAO repositorioDAO = new RepositorioDAO();

    private List<Repositorio> repositorios;

    public List<Repositorio> getRepositorios() {
        repositorios = repositorioDAO.findAll();
        return repositorios;
    }

    public void setRepositorios(List<Repositorio> repositorios) {
        this.repositorios = repositorios;
    }

    public RedeSocialBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public RedeSocial getRedeSocial() {
        return redesocial;
    }

    public void setRedeSocial(RedeSocial redesocial) {
        this.redesocial = redesocial;
    }

    public DataModel getRedesSociais() {
        this.redessociais = new ListDataModel(dao.findAll());
        return redessociais;
    }

    public void setRedesSociais(DataModel redessociais) {
        this.redessociais = redessociais;
    }

    public String insert() {
        dao.insert(redesocial);
        return "redeSociallst";
    }

    public String edit(RedeSocial i) {
        redesocial = (RedeSocial) redessociais.getRowData();
        return "redeSociallst";
    }

    public String update() {
        dao.update(redesocial);
        return "redeSociallst";
    }

    public String delete(RedeSocial i) {
        dao.delete(i);
        LogDAO.insert("RedeSocial", "Deletou rede social código: " + i.getRsc_codigo()+ ", nome: " + i.getRsc_nome()+
                    ", url: "+i.getRsc_url()+", url perfil: "+i.getRsc_urlperfil()+", repositório: "+i.getRepositorio().getRep_codigo());
        return "redeSociallst";
    }

    public String salvar() {
        if (redesocial.getRsc_codigo() > 0) {
            dao.update(redesocial);
            LogDAO.insert("RedeSocial", "Alterou rede social código: " + redesocial.getRsc_codigo()+ ", nome: " + redesocial.getRsc_nome()+
                    ", url: "+redesocial.getRsc_url()+", url perfil: "+redesocial.getRsc_urlperfil()+", repositório: "+redesocial.getRepositorio().getRep_codigo());
        } else {
            dao.insert(redesocial);
            LogDAO.insert("RedeSocial", "Cadastrou rede social código: " + redesocial.getRsc_codigo()+ ", nome: " + redesocial.getRsc_nome()+
                    ", url: "+redesocial.getRsc_url()+", url perfil: "+redesocial.getRsc_urlperfil()+", repositório: "+redesocial.getRepositorio().getRep_codigo());
        }

        return "redeSociallst";
    }

    public String listar() {
        return "redeSociallst";
    }

}
