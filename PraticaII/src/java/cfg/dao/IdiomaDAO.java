
package cfg.dao;

import cfg.model.Idioma;
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
    
    public void insert(Idioma i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }
    
    public void update(Idioma i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }
    
    public void delete(Idioma i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }
    
    public Idioma findById(int idi_codigo) {
        return (Idioma) session.load(Idioma.class, idi_codigo);
    }
    
    public List<Idioma> findAll() {
        Query q = session.createQuery("from Idioma");
        return q.list();
    }
    
}
