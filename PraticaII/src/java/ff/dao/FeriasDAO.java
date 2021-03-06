/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.dao;



import ff.model.Ferias;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class FeriasDAO {
    
    
     private Session session;

    public FeriasDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Ferias ferias) {

        Transaction t = session.beginTransaction();
        session.save(ferias);
        t.commit();
    }

    public void update(Ferias ferias) {

        Transaction t = session.beginTransaction();
        session.merge(ferias);
        t.commit();
    }

    public void delete(Ferias ferias) {

        Transaction t = session.beginTransaction();
        session.delete(ferias);
        t.commit();
    }


      public List<Ferias> findById(int ffu_codigo) {
        Query q = session.createQuery("from Ferias where pes_codigo = :pes_codigo");
        return q.setParameter("pes_codigo", ffu_codigo).list();
       
    }
    
    public List<Ferias> finAll() {

        Query query = session.createQuery("from Ferias");
        return query.list();

    }
    
}
