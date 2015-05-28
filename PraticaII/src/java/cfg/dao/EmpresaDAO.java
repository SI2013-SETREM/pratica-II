
package cfg.dao;

import cfg.model.Empresa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EmpresaDAO {
    private Session session;

    public EmpresaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Empresa b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(Empresa b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(Empresa b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public Empresa findById(int bai_codigo) {
        return (Empresa) session.load(Empresa.class, bai_codigo);
    }
    
    public List<Empresa> findAll() {
        Query q = session.createQuery("from Empresa");
        return q.list();
    }
    
}
