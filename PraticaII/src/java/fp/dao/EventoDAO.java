/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dao;


import fp.model.Evento;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class EventoDAO {
    
    
     private Session session;

    public EventoDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Evento evento) {

        Transaction t = session.beginTransaction();
        session.save(evento);
        t.commit();
    }

    public void update(Evento evento) {

        Transaction t = session.beginTransaction();
        session.merge(evento);
        t.commit();
    }

    public void delete(Evento evento) {

        Transaction t = session.beginTransaction();
        session.delete(evento);
        t.commit();
    }

    public Evento findById(int id) {

        return (Evento) session.load(Evento.class, id);
    }

    public List<Evento> finAll() {

        Query query = session.createQuery("from Evento");
        return query.list();

    }
    
}
