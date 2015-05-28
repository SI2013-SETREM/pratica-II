package cfg.dao;

import cfg.model.Log;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LogDAO {

    private Session session;

    public LogDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Log b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }

    public void update(Log b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }

    public void delete(Log b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }

    public Log findById(int log_codigo) {
        return (Log) session.load(Log.class, log_codigo);
    }

    public List<Log> findAll() {
        Query q = session.createQuery("from Log");
        return q.list();
    }

}
