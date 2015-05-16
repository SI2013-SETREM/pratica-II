package csb.dao;

import csb.model.CsbEpi;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CsbEpiDAO {
    private Session session;

    public CsbEpiDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(CsbEpi e) {
        Transaction t = session.beginTransaction();
        session.save(e);
        t.commit();
    }
    
    public void update(CsbEpi e) {
        Transaction t = session.beginTransaction();
        session.merge(e);
        t.commit();
    }
    
    public void delete(CsbEpi e) {
        Transaction t = session.beginTransaction();
        session.delete(e);
        t.commit();
    }
    
    public CsbEpi findById(int epi_codigo) {
        return (CsbEpi) session.load(CsbEpi.class, epi_codigo);
    }
    
    public List<CsbEpi> findAll() {
        Query q = session.createQuery("from CsbEpi");
        return q.list();
    }
}
