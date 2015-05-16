package csb.dao;

import csb.model.CsbMotivoAlteracaoSalarial;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CsbMotivoAlteracaoSalarialDAO {

    private Session session;

    public CsbMotivoAlteracaoSalarialDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(CsbMotivoAlteracaoSalarial m) {
        Transaction t = session.beginTransaction();
        session.save(m);
        t.commit();
    }

    public void update(CsbMotivoAlteracaoSalarial m) {
        Transaction t = session.beginTransaction();
        session.merge(m);
        t.commit();
    }

    public void delete(CsbMotivoAlteracaoSalarial m) {
        Transaction t = session.beginTransaction();
        session.delete(m);
        t.commit();
    }

    public CsbMotivoAlteracaoSalarial findById(int mas_codigo) {
        return (CsbMotivoAlteracaoSalarial) session.load(CsbMotivoAlteracaoSalarial.class, mas_codigo);
    }

    public List<CsbMotivoAlteracaoSalarial> findAll() {
        Query q = session.createQuery("from CbsMotivoAlteracaoSalarial");
        return q.list();
    }
}
