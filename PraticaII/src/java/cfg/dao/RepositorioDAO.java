
package cfg.dao;

import cfg.model.Repositorio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class RepositorioDAO {
    private Session session;

    public RepositorioDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Repositorio b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(Repositorio b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(Repositorio b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public Repositorio findById(int rep_codigo) {
        return (Repositorio) session.load(Repositorio.class, rep_codigo);
    }
    
    public List<Repositorio> findAll() {
        Query q = session.createQuery("from Repositorio");
        return q.list();
    }
    
}
