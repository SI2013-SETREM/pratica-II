package ad.dao;

import ad.model.Avaliacao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AvaliacaoDAO {

    private Session session;

    public AvaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(Avaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Avaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Avaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Avaliacao findById(int idi_codigo) {
        session = HibernateUtil.getSessionFactory().openSession();
        return (Avaliacao) session.load(Avaliacao.class, idi_codigo);
    }

    public List<Avaliacao> findAll() {
        return session.createQuery("from Avaliacao where ava_status < 5").list();
        //return session.createSQLQuery("select * from avd_avaliacao").list();
    }

}
