package csb.dao;

import csb.model.Cargo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CargoDAO {
    private Session session;

    public CargoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Cargo c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }
    
    public void update(Cargo c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }
    
    public void delete(Cargo c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }
    
    public Cargo findById(int car_codigo) {
        return (Cargo) session.load(Cargo.class, car_codigo);
    }
    
    public List<Cargo> findAll() {
        Query q = session.createQuery("from Cargo");
        return q.list();
    }
}
