
package fp.dao;


import fp.model.HistoricoFolha;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class HistoricoFolhaDAO {
    
    
    private Session session;

    public HistoricoFolhaDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(HistoricoFolha historicoFolha) {

        Transaction t = session.beginTransaction();
        session.save(historicoFolha);
        t.commit();
    }

 

    public HistoricoFolha findById(int id) {

        return (HistoricoFolha) session.load(HistoricoFolha.class, id);
    }

    public List<HistoricoFolha> finAll() {

        Query query = session.createQuery("from HistoricoFolha");
        return query.list();

    }
    
}
