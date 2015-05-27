/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dao;



import fp.model.SerieEvento;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class SerieEventoDAO {
    
    
     private Session session;

    public SerieEventoDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(SerieEvento serieEvento) {

        Transaction t = session.beginTransaction();
        session.save(serieEvento);
        t.commit();
    }

    public void update(SerieEvento serieEvento) {

        Transaction t = session.beginTransaction();
        session.merge(serieEvento);
        t.commit();
    }

    public void delete(SerieEvento serieEvento) {

        Transaction t = session.beginTransaction();
        session.delete(serieEvento);
        t.commit();
    }

    public SerieEvento findById(int id) {

        return (SerieEvento) session.load(SerieEvento.class, id);
    }

    public List<SerieEvento> findAll() {

        Query query = session.createQuery("from SerieEvento");
        return query.list();

    }
    
}
