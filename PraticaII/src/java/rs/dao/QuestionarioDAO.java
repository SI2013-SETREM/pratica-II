
package rs.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rs.model.Questionario;
import util.HibernateUtil;

public class QuestionarioDAO {
    private Session session;

    public QuestionarioDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Questionario obj) {
        Transaction t = session.beginTransaction();
        session.save(obj);
        t.commit();
    }
    
    public void update(Questionario obj) {
        Transaction t = session.beginTransaction();
        session.merge(obj);
        t.commit();
    }
    
    public void delete(Questionario obj) {
        Transaction t = session.beginTransaction();
        session.delete(obj);
        t.commit();
    }
    
    public Questionario findById(int qst_codigo) {
        return (Questionario) session.load(Questionario.class, qst_codigo);
    }
    
    public List<Questionario> findAll() {
        Query q = session.createQuery("from Questionario");
        return q.list();
    }
    
}
