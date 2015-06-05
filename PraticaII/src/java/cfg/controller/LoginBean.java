
package cfg.controller;

import cfg.dao.UsuarioDAO;
import cfg.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {
    
    private Usuario usuario;
    private String user;
    private UsuarioDAO dao = new UsuarioDAO();
    
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

}
