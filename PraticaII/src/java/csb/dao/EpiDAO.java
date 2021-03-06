package csb.dao;

import csb.model.Epi;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EpiDAO {

    private Session session;

    public EpiDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Epi e) {
        Transaction t = session.beginTransaction();
        session.save(e);
        t.commit();
    }

    public void update(Epi e) {
        Transaction t = session.beginTransaction();
        session.merge(e);
        t.commit();
    }

    public void delete(Epi e) {
        Transaction t = session.beginTransaction();
        session.delete(e);
        t.commit();
    }

    public Epi findById(int epi_codigo) {
        return (Epi) session.load(Epi.class, epi_codigo);
    }

    public List<Epi> findAll() {
        Query q = session.createQuery("from Epi order by epi_descricao asc");
        return q.list();
    }

    public List<Epi> findEpc() {
        Query q = session.createQuery("from Epi where epi_tipo = 'C' and epi_situacao = true order by epi_descricao asc");
        return q.list();
    }

    public List<Epi> findEpi() {
        Query q = session.createQuery("from Epi where epi_tipo = 'I' and epi_situacao = true order by epi_descricao asc");
        return q.list();
    }
}
