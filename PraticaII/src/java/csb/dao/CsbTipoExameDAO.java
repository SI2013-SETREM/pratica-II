package csb.dao;

import csb.model.CsbTipoExame;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CsbTipoExameDAO {

    private Session session;

    public CsbTipoExameDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(CsbTipoExame tp) {
        Transaction t = session.beginTransaction();
        session.save(tp);
        t.commit();
    }

    public void update(CsbTipoExame tp) {
        Transaction t = session.beginTransaction();
        session.merge(tp);
        t.commit();
    }

    public void delete(CsbTipoExame tp) {
        Transaction t = session.beginTransaction();
        session.delete(tp);
        t.commit();
    }

    public CsbTipoExame findById(int eme_codigo) {
        return (CsbTipoExame) session.load(CsbTipoExame.class, eme_codigo);
    }

    public List<CsbTipoExame> findAll() {
        Query q = session.createQuery("from CbsTipoExame");
        return q.list();
    }
}
