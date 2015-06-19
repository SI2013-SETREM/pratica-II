/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dao;


import fp.model.EventoPadrao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class EventoPadraoDAO {
    
    
     private Session session;

    public EventoPadraoDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(EventoPadrao eventoPadrao) {

        Transaction t = session.beginTransaction();
        session.save(eventoPadrao);
        t.commit();
    }

    public void update(EventoPadrao eventoPadrao) {

        Transaction t = session.beginTransaction();
        session.merge(eventoPadrao);
        t.commit();
    }

    public void delete(EventoPadrao eventoPadrao) {

        Transaction t = session.beginTransaction();
        session.delete(eventoPadrao);
        t.commit();
    }

    public EventoPadrao findById(int id) {

        return (EventoPadrao) session.load(EventoPadrao.class, id);
    }

    public List<EventoPadrao> findAll() {

        Query query = session.createQuery("from EventoPadrao");
        return query.list();

    }
  
    
         public List<EventoPadrao> EventoPessoa(int pes_codigo) {

        Query query = session.createQuery("from EventoPadrao where pes_codigo = :pes_codigo");
        return  query.setParameter("pes_codigo", pes_codigo).list();

    }
    
}
