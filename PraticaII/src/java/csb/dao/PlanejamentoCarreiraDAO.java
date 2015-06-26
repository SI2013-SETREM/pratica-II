package csb.dao;

import csb.model.PlanejamentoCarreira;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Juliano Pires
 */
public class PlanejamentoCarreiraDAO {

    private Session session;

    public PlanejamentoCarreiraDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(PlanejamentoCarreira b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(PlanejamentoCarreira b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(PlanejamentoCarreira b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public PlanejamentoCarreira findById(int pla_codigo) {
        return (PlanejamentoCarreira) session.load(PlanejamentoCarreira.class, pla_codigo);
    }
    
    public List<PlanejamentoCarreira> findAll() {
        Query q = session.createQuery("from PlanejamentoCarreira order by pla_descricao asc");
        return q.list();
    }
}
