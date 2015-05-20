package ad.dao;

import ad.model.HistoricoAvaliacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class HistoricoAvaliacaoDAO {

    private Session session;

    public HistoricoAvaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(HistoricoAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(HistoricoAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(HistoricoAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public HistoricoAvaliacao findById(int idi_codigo) {
        return (HistoricoAvaliacao) session.load(HistoricoAvaliacao.class, idi_codigo);
    }

    public List<HistoricoAvaliacao> findAll() {
        Query q = session.createQuery("from Historico_Avaliacao");
        return q.list();
    }

}
