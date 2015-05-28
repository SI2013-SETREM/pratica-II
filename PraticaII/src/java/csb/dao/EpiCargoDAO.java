package csb.dao;

import csb.model.EpiCargo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EpiCargoDAO {
    private Session session;

    public EpiCargoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(EpiCargo e) {
        Transaction t = session.beginTransaction();
        session.save(e);
        t.commit();
    }
    
    public void update(EpiCargo e) {
        Transaction t = session.beginTransaction();
        session.merge(e);
        t.commit();
    }
    
    public void delete(EpiCargo e) {
        Transaction t = session.beginTransaction();
        session.delete(e);
        t.commit();
    }
    
    public EpiCargo findById(int car_codigo) {
        return (EpiCargo) session.load(EpiCargo.class, car_codigo);
    }
    
    public List<EpiCargo> findAll() {
        Query q = session.createQuery("from EpiCargo");
        return q.list();
    }
}
