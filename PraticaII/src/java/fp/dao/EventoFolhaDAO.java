
package fp.dao;


import fp.model.EventoFolha;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class EventoFolhaDAO {
    
    
    private Session session;

    public EventoFolhaDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(EventoFolha eventoFolha) {

        Transaction t = session.beginTransaction();
        session.save(eventoFolha);
        t.commit();
    }

 

    public EventoFolha findById(int id) {

        return (EventoFolha) session.load(EventoFolha.class, id);
    }

    public List<EventoFolha> finAll() {

        Query query = session.createQuery("from EventoFolha");
        return query.list();

    }
    
}
