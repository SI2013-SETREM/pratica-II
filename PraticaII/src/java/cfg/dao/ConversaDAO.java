
package cfg.dao;

import cfg.model.Conversa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ConversaDAO {
    private Session session;

    public ConversaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Conversa b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(Conversa b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(Conversa b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public Conversa findById(int cnv_codigo) {
        return (Conversa) session.load(Conversa.class, cnv_codigo);
    }
    
    public List<Conversa> findAll() {
        Query q = session.createQuery("from Conversa");
        return q.list();
    }
    
}
