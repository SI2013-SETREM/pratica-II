
package fp.dao;


import fp.model.TabelaINSS;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class TabelaINSSDAO {
    
    
     private Session session;

    public TabelaINSSDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(TabelaINSS tabelaInss) {

        Transaction t = session.beginTransaction();
        session.save(tabelaInss);
        t.commit();
    }

    public void update(TabelaINSS tabelaInss) {

        Transaction t = session.beginTransaction();
        session.merge(tabelaInss);
        t.commit();
    }

    public void delete(TabelaINSS tabelaInss) {

        Transaction t = session.beginTransaction();
        session.delete(tabelaInss);
        t.commit();
    }

    public TabelaINSS findById(int id) {

        return (TabelaINSS) session.load(TabelaINSS.class, id);
    }

    public List<TabelaINSS> findAll() {

        Query query = session.createQuery("from TabelaINSS");
        return query.list();

    }
    
}
