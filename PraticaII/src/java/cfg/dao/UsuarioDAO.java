
package cfg.dao;

import cfg.model.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UsuarioDAO {
    private Session session;

    public UsuarioDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Usuario b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(Usuario b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(Usuario b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public Usuario findByLogin(String usu_login) {
        return (Usuario) session.load(Usuario.class, usu_login);
    }
    
    public List<Usuario> findAll() {
        Query q = session.createQuery("from Usuario");
        return q.list();
    }
    
}
