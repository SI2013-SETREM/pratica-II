package csb.dao;

import csb.model.MotivoAlteracaoSalarial;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MotivoAlteracaoSalarialDAO {

    private Session session;

    public MotivoAlteracaoSalarialDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(MotivoAlteracaoSalarial m) {
        Transaction t = session.beginTransaction();
        session.save(m);
        t.commit();
    }

    public void update(MotivoAlteracaoSalarial m) {
        Transaction t = session.beginTransaction();
        session.merge(m);
        t.commit();
    }

    public void delete(MotivoAlteracaoSalarial m) {
        Transaction t = session.beginTransaction();
        session.delete(m);
        t.commit();
    }

    public MotivoAlteracaoSalarial findById(int mas_codigo) {
        return (MotivoAlteracaoSalarial) session.load(MotivoAlteracaoSalarial.class, mas_codigo);
    }

    public List<MotivoAlteracaoSalarial> findAll() {
        Query q = session.createQuery("from CbsMotivoAlteracaoSalarial");
        return q.list();
    }
}
