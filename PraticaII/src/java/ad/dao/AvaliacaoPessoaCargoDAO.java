package ad.dao;

import ad.model.AvaliacaoPessoaCargo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AvaliacaoPessoaCargoDAO {

    private Session session;

    public AvaliacaoPessoaCargoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(AvaliacaoPessoaCargo i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(AvaliacaoPessoaCargo i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(AvaliacaoPessoaCargo i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public AvaliacaoPessoaCargo findById(int idi_codigo) {
        return (AvaliacaoPessoaCargo) session.load(AvaliacaoPessoaCargo.class, idi_codigo);
    }

    public List<AvaliacaoPessoaCargo> findAll() {
        Query q = session.createQuery("from Avaliacao_pessoa_cargo");
        return q.list();
    }
}
