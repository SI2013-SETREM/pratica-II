
package ad.dao;

import ad.model.Avaliacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AvaliacaoDAO {
    private Session session;

    public AvaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Avaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }
    
    public void update(Avaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }
    
    public void delete(Avaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }
    
    public Avaliacao findById(int idi_codigo) {
        return (Avaliacao) session.load(Avaliacao.class, idi_codigo);
    }
    
    public List<Avaliacao> findAll() {
        Query q = session.createQuery("from Avaliacao");
        return q.list();
    }
    
}