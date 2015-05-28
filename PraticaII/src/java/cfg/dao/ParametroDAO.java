
package cfg.dao;

import cfg.model.Parametro;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ParametroDAO {
    private Session session;

    public ParametroDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Parametro b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(Parametro b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(Parametro b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public Parametro findById(int prm_codigo) {
        return (Parametro) session.load(Parametro.class, prm_codigo);
    }
    
    public List<Parametro> findAll() {
        Query q = session.createQuery("from Parametro");
        return q.list();
    }
    
}
