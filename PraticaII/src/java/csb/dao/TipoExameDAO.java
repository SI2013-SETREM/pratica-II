package csb.dao;

import csb.model.TipoExame;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TipoExameDAO {

    private Session session;

    public TipoExameDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(TipoExame tp) {
        Transaction t = session.beginTransaction();
        session.save(tp);
        t.commit();
    }

    public void update(TipoExame tp) {
        Transaction t = session.beginTransaction();
        session.merge(tp);
        t.commit();
    }

    public void delete(TipoExame tp) {
        Transaction t = session.beginTransaction();
        session.delete(tp);
        t.commit();
    }

    public TipoExame findById(int eme_codigo) {
        return (TipoExame) session.load(TipoExame.class, eme_codigo);
    }

    public List<TipoExame> findAll() {
        Query q = session.createQuery("from TipoExame");
        return q.list();
    }
}
