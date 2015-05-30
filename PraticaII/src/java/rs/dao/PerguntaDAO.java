
package rs.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rs.model.Pergunta;
import util.HibernateUtil;

public class PerguntaDAO {
    private Session session;

    public PerguntaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Pergunta obj) {
        Transaction t = session.beginTransaction();
        session.save(obj);
        t.commit();
    }
    
    public void update(Pergunta obj) {
        Transaction t = session.beginTransaction();
        session.merge(obj);
        t.commit();
    }
    
    public void delete(Pergunta obj) {
        Transaction t = session.beginTransaction();
        session.delete(obj);
        t.commit();
    }
    
    public Pergunta findById(int prg_codigo) {
        return (Pergunta) session.load(Pergunta.class, prg_codigo);
    }
    
    public List<Pergunta> findAll() {
        Query q = session.createQuery("from Pergunta");
        return q.list();
    }
    
}
