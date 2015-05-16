package ad.dao;

import ad.model.Historico_Avaliacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Historico_AvaliacaoDAO {

    private Session session;

    public Historico_AvaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Historico_Avaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Historico_Avaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Historico_Avaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Historico_Avaliacao findById(int idi_codigo) {
        return (Historico_Avaliacao) session.load(Historico_Avaliacao.class, idi_codigo);
    }

    public List<Historico_Avaliacao> findAll() {
        Query q = session.createQuery("from Historico_Avaliacao");
        return q.list();
    }

}
