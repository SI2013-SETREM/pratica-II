package ad.dao;

import ad.model.Avaliacao_pessoa_cargo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Avaliacao_pessoa_cargoDAO {

    private Session session;

    public Avaliacao_pessoa_cargoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Avaliacao_pessoa_cargo i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Avaliacao_pessoa_cargo i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Avaliacao_pessoa_cargo i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Avaliacao_pessoa_cargo findById(int idi_codigo) {
        return (Avaliacao_pessoa_cargo) session.load(Avaliacao_pessoa_cargo.class, idi_codigo);
    }

    public List<Avaliacao_pessoa_cargo> findAll() {
        Query q = session.createQuery("from Avaliacao_pessoa_cargo");
        return q.list();
    }
}
