
package cfg.dao;
import cfg.model.Bairro;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class BairroDAO {
    private Session session;

    public BairroDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Bairro b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(Bairro b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(Bairro b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public Bairro findById(int bai_codigo) {
        return (Bairro) session.load(Bairro.class, bai_codigo);
    }
    
    public List<Bairro> findAll() {
        Query q = session.createQuery("from Bairro");
        return q.list();
    }
    
}
