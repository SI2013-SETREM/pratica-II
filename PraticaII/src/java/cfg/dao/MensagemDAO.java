
package cfg.dao;

import cfg.model.Mensagem;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MensagemDAO {
    private Session session;

    public MensagemDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Mensagem b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(Mensagem b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(Mensagem b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public Mensagem findById(int msg_codigo) {
        return (Mensagem) session.load(Mensagem.class, msg_codigo);
    }
    
    public List<Mensagem> findAll() {
        Query q = session.createQuery("from Mensagem");
        return q.list();
    }
    
}
