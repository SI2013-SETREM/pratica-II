/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.dao;



import ff.model.Falta;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class FaltaDAO {
    
    
     private Session session;

    public FaltaDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Falta advertencia) {

        Transaction t = session.beginTransaction();
        session.save(advertencia);
        t.commit();
    }

    public void update(Falta advertencia) {

        Transaction t = session.beginTransaction();
        session.merge(advertencia);
        t.commit();
    }

    public void delete(Falta falta) {

        Transaction t = session.beginTransaction();
        session.delete(falta);
        t.commit();
    }

    public Falta findById(int id) {

        return (Falta) session.load(Falta.class, id);
    }

    public List<Falta> finAll() {

        Query query = session.createQuery("from Falta");
        return query.list();

    }
     public List<Falta> findFaltas(int id) {

        Query q = session.createQuery("from Falta where pes_codigo = :pes_codigo");
        return q.setParameter("pes_codigo", id).list();

    }
    
}
