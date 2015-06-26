package cfg.dao;

import cfg.model.Repositorio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class RepositorioDAO {

    private Session session;

    public RepositorioDAO() {
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }
    
    public void insert(Repositorio rep) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().save(rep);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void update(Repositorio rep) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().merge(rep);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void delete(Repositorio rep) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().delete(rep);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public Repositorio findById(int rep_codigo) {
        return (Repositorio) getSession().load(Repositorio.class, rep_codigo);
    }

    public List<Repositorio> findAll() {
        Query q = getSession().createQuery("from Repositorio");
        return q.list();
    }

}
