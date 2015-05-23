/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.dao;



import ff.model.Advertencia;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class AdvertenciaDAO {
    
    
     private Session session;

    public AdvertenciaDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Advertencia advertencia) {

        Transaction t = session.beginTransaction();
        session.save(advertencia);
        t.commit();
    }

    public void update(Advertencia advertencia) {

        Transaction t = session.beginTransaction();
        session.merge(advertencia);
        t.commit();
    }

    public void delete(Advertencia advertencia) {

        Transaction t = session.beginTransaction();
        session.delete(advertencia);
        t.commit();
    }

    public Advertencia findById(int id) {

        return (Advertencia) session.load(Advertencia.class, id);
    }

    public List<Advertencia> finAll() {

        Query query = session.createQuery("from Advertencia");
        return query.list();

    }
    
}
