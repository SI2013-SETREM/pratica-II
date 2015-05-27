package csb.dao;

import csb.model.Setor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Juliano Pires
 */
public class SetorDAO {

    private Session session;

    public SetorDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Setor e) {
        Transaction t = session.beginTransaction();
        session.save(e);
        t.commit();
    }

    public void update(Setor e) {
        Transaction t = session.beginTransaction();
        session.merge(e);
        t.commit();
    }

    public void delete(Setor e) {
        Transaction t = session.beginTransaction();
        session.delete(e);
        t.commit();
    }

    public Setor findById(int set_codigo) {
        return (Setor) session.load(Setor.class, set_codigo);
    }

    public List<Setor> findAll() {
        Query q = session.createQuery("from Setor");
        return q.list();
    }
}
