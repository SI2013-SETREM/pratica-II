
package fp.dao;


import fp.model.EventoFolha;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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

    public List<EventoFolha> findAll() {

        Query query = session.createQuery("from EventoFolha");
        return query.list();

    }
       public List<EventoFolha> EventoFolhas(int hif_codigo) {
        Criteria crit = session.createCriteria(EventoFolha.class);    
        crit.add(Restrictions.eq("hif_codigo", hif_codigo));
        List results = crit.list();

        return  crit.list();
    }
    
}
