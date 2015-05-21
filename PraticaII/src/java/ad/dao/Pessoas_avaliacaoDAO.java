package ad.dao;

import ad.model.Pessoas_avaliacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Pessoas_avaliacaoDAO {

    private Session session;

    public Pessoas_avaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pessoas_avaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Pessoas_avaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Pessoas_avaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Pessoas_avaliacao findById(int idi_codigo) {
        return (Pessoas_avaliacao) session.load(Pessoas_avaliacao.class, idi_codigo);
    }

    public List<Pessoas_avaliacao> findAll() {
        Query q = session.createQuery("from Pessoas_avaliacao");
        return q.list();
    }
}
