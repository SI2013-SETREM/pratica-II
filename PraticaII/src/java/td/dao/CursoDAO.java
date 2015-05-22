package td.dao;

import td.model.Curso;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CursoDAO {
 
    private Session session;
    
    public CursoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Curso c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(Curso c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(Curso c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public Curso findById(String id) {
        return (Curso) session.load(Curso.class, id);
    }

    public List<Curso> findAll() {
        Query q = session.createQuery("from Curso");
        return q.list();
    }
}
