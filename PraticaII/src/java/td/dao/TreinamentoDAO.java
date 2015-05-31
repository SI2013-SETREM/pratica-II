package td.dao;

import td.model.Treinamento;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TreinamentoDAO {

    private Session session;

    public TreinamentoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Treinamento c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(Treinamento c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(Treinamento c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public Treinamento findById(int id) {
        return (Treinamento) session.load(Treinamento.class, id);
    }

    public List<Treinamento> findAll() {
        Query q = session.createQuery("from Treinamento");
        return q.list();
    }
}
