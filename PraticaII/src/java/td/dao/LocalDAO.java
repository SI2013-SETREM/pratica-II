package td.dao;

import td.model.Local;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LocalDAO {
 
    private Session session;
    
    public LocalDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Local c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(Local c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(Local c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public Local findById(String id) {
        return (Local) session.load(Local.class, id);
    }

    public List<Local> findAll() {
        Query q = session.createQuery("from Local");
        return q.list();
    }
}
