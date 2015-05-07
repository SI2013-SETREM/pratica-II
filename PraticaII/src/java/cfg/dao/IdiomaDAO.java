
package cfg.dao;

import cfg.model.Idiomas;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class IdiomaDAO {
    private Session session;

    public IdiomaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Idiomas i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }
    
    public void update(Idiomas i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }
    
    public void delete(Idiomas i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }
    
    public Idiomas findById(int idi_codigo) {
        return (Idiomas) session.load(Idiomas.class, idi_codigo);
    }
    
    public List<Idiomas> findAll() {
        Query q = session.createQuery("from Idiomas");
        return q.list();
    }
    
}
