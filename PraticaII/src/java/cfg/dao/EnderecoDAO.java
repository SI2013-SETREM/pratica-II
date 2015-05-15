
package cfg.dao;

import cfg.model.Endereco;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EnderecoDAO {
    private Session session;

    public EnderecoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Endereco e) {
        Transaction t = session.beginTransaction();
        session.save(e);
        t.commit();
    }
    
    public void update(Endereco e) {
        Transaction t = session.beginTransaction();
        session.merge(e);
        t.commit();
    }
    
    public void delete(Endereco e) {
        Transaction t = session.beginTransaction();
        session.delete(e);
        t.commit();
    }
    
    public Endereco findById(int end_codigo) {
        return (Endereco) session.load(Endereco.class, end_codigo);
    }
    
    public List<Endereco> findAll() {
        Query q = session.createQuery("from Endereco");
        return q.list();
    }
    
}
