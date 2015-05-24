package ad.dao;

import ad.model.PessoasAvaliacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PessoasAvaliacaoDAO {

    private Session session;

    public PessoasAvaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(PessoasAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(PessoasAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(PessoasAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public PessoasAvaliacao findById(int idi_codigo) {
        return (PessoasAvaliacao) session.load(PessoasAvaliacao.class, idi_codigo);
    }

    public List<PessoasAvaliacao> findAll() {
        Query q = session.createQuery("from Pessoas_avaliacao");
        return q.list();
    }
}
