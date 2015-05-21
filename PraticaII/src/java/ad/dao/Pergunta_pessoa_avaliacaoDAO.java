package ad.dao;

import ad.model.Pergunta_pessoa_avaliacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Pergunta_pessoa_avaliacaoDAO {

    private Session session;

    public Pergunta_pessoa_avaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Pergunta_pessoa_avaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Pergunta_pessoa_avaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Pergunta_pessoa_avaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Pergunta_pessoa_avaliacao findById(int idi_codigo) {
        return (Pergunta_pessoa_avaliacao) session.load(Pergunta_pessoa_avaliacao.class, idi_codigo);
    }

    public List<Pergunta_pessoa_avaliacao> findAll() {
        Query q = session.createQuery("from Pergunta_pessoa_avaliacao");
        return q.list();
    }
}
