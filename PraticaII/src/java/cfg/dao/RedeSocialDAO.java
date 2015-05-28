
package cfg.dao;

import cfg.model.RedeSocial;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class RedeSocialDAO {
    private Session session;

    public RedeSocialDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(RedeSocial b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(RedeSocial b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(RedeSocial b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public RedeSocial findById(int rsc_codigo) {
        return (RedeSocial) session.load(RedeSocial.class, rsc_codigo);
    }
    
    public List<RedeSocial> findAll() {
        Query q = session.createQuery("from RedeSocial");
        return q.list();
    }
    
}
