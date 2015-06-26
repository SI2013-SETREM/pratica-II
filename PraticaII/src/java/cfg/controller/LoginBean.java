
package cfg.controller;

import cfg.dao.RepositorioDAO;
import cfg.dao.UsuarioDAO;
import cfg.dao.LogDAO;
import cfg.model.Repositorio;
import cfg.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class LoginBean {

    private Usuario usuario;
    private String user;
    private UsuarioDAO dao = new UsuarioDAO();
    private RepositorioDAO daoRepositorio = new RepositorioDAO();
    
    private Part file;
    
    public LoginBean() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public void setUsuarioByLogin(String usu_login) {
        this.usuario = dao.findByLogin(usu_login);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario= usuario;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void save() {
        if (file != null && !"".equals(file.getSubmittedFileName())) {
            Repositorio repositorio = new Repositorio(file);
            repositorio.setRep_nome("Foto " + this.usuario.getPessoa().getPes_nome());
            
            String original = "";
            if (this.usuario.getPessoa() != null && this.usuario.getPessoa().getRepositorio() != null) {
                original = this.usuario.getPessoa().getRepositorio().getRep_nomearquivo() + "." + this.usuario.getPessoa().getRepositorio().getRep_extensao();
            }
            String novo = repositorio.getRep_nomearquivo() + "." + repositorio.getRep_extensao();

            daoRepositorio.insert(repositorio);
            this.usuario.getPessoa().setRepositorio(repositorio);
            dao.update(usuario);
            
            LogDAO.insert("Usuário", "Foto do usuário alterada de " + original + " para " + novo);
        }
    }
    
    public String getProfileImageUrl() {
        if (usuario.getPessoa() != null && usuario.getPessoa().getRepositorio() != null) {
            return this.getImageUrl(usuario.getPessoa().getRepositorio().getRep_codigo());
        }
        return "";
    }
    
    public String getImageUrl(int rep_codigo) {
        return "/PraticaII/DirectServlet?method=image&id=" + rep_codigo;
    }
    
}
