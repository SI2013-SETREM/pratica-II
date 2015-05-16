package csb.dao;

import csb.model.Epi;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EpiDAO {
    private Session session;

    public EpiDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Epi e) {
        Transaction t = session.beginTransaction();
        session.save(e);
        t.commit();
    }
    
    public void update(Epi e) {
        Transaction t = session.beginTransaction();
        session.merge(e);
        t.commit();
    }
    
    public void delete(Epi e) {
        Transaction t = session.beginTransaction();
        session.delete(e);
        t.commit();
    }
    
    public Epi findById(int epi_codigo) {
        return (Epi) session.load(Epi.class, epi_codigo);
    }
    
    public List<Epi> findAll() {
        Query q = session.createQuery("from CsbEpi");
        return q.list();
    }
}
