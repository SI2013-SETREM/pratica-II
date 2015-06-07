package td.dao;

import td.model.Turma;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TurmaDAO {
    
    private Session session;
    
    public TurmaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Turma c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(Turma c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(Turma c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public Turma findById(String id) {
        return (Turma) session.load(Turma.class, id);
    }

    public List<Turma> findAll() {
        Query q = session.createQuery("from Turma");
        return q.list();
    }
}