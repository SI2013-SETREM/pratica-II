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
        Query q = session.createQuery("from PerguntaPessoaAvaliacao");
        return q.list();
    }

    public List<AvaliacaoPessoaCargo> getListAvaliacaoPessoaCargo(int ava_codigo, int pes_codigo, int car_codigo) {
        String sql = "";
        if (ava_codigo != 0) {
            sql += " and ava_codigo = " + ava_codigo;
        }
        if (pes_codigo != 0) {
            sql += " and pes_codigo = " + pes_codigo;
        }
        if (car_codigo != 0) {
            sql += " and car_codigo = " + car_codigo;
        }

        Query q = session.createQuery("from PerguntaPessoaAvaliacao where 1=1 " + sql);
        return q.list();
    }

}
