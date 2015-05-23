/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dao;


import fp.model.TipoEvento;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class TipoEventoDAO {
    
    
     private Session session;

    public TipoEventoDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(TipoEvento tipoEvento) {

        Transaction t = session.beginTransaction();
        session.save(tipoEvento);
        t.commit();
    }

    public void update(TipoEvento tipoEvento) {

        Transaction t = session.beginTransaction();
        session.merge(tipoEvento);
        t.commit();
    }

    public void delete(TipoEvento tipoEvento) {

        Transaction t = session.beginTransaction();
        session.delete(tipoEvento);
        t.commit();
    }

    public TipoEvento findById(int id) {

        return (TipoEvento) session.load(TipoEvento.class, id);
    }

    public List<TipoEvento> finAll() {

        Query query = session.createQuery("from TipoEvento");
        return query.list();

    }
    
}
