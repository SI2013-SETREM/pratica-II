package csb.dao;

import csb.model.BeneficiosCargo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class BeneficiosCargoDAO {
    private Session session;

    public BeneficiosCargoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(BeneficiosCargo c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }
    
    public void update(BeneficiosCargo c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }
    
    public void delete(BeneficiosCargo c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }
    
    public BeneficiosCargo findById(int car_codigo) {
        return (BeneficiosCargo) session.load(BeneficiosCargo.class, car_codigo);
    }
    
    public List<BeneficiosCargo> findAll() {
        Query q = session.createQuery("from BeneficiosCargo");
        return q.list();
    }
}
