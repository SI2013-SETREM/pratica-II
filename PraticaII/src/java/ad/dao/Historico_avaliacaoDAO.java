package ad.dao;

import ad.model.Historico_avaliacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Historico_avaliacaoDAO {

    private Session session;

    public Historico_avaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Historico_avaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Historico_avaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Historico_avaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Historico_avaliacao findById(int idi_codigo) {
        return (Historico_avaliacao) session.load(Historico_avaliacao.class, idi_codigo);
    }

    public List<Historico_avaliacao> findAll() {
        Query q = session.createQuery("from Historico_Avaliacao");
        return q.list();
    }

}
