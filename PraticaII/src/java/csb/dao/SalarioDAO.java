package csb.dao;

import csb.model.Salario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class SalarioDAO {
    private Session session;

    public SalarioDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Salario s) {
        Transaction t = session.beginTransaction();
        session.save(s);
        t.commit();
    }
    
    public void update(Salario s) {
        Transaction t = session.beginTransaction();
        session.merge(s);
        t.commit();
    }
    
    public void delete(Salario s) {
        Transaction t = session.beginTransaction();
        session.delete(s);
        t.commit();
    }
    
    public Salario findById(int sal_codigo) {
        return (Salario) session.load(Salario.class, sal_codigo);
    }
    
    public List<Salario> findAll() {
        Query q = session.createQuery("from Salario");
        return q.list();
    }
}
