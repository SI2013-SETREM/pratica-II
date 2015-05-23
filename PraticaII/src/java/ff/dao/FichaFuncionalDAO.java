/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.dao;



import ff.model.FichaFuncional;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class FichaFuncionalDAO {
    
    
     private Session session;

    public FichaFuncionalDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(FichaFuncional fichaFuncional) {

        Transaction t = session.beginTransaction();
        session.save(fichaFuncional);
        t.commit();
    }

    public void update(FichaFuncional fichaFuncional) {

        Transaction t = session.beginTransaction();
        session.merge(fichaFuncional);
        t.commit();
    }


    public FichaFuncional findById(int id) {

        return (FichaFuncional) session.load(FichaFuncional.class, id);
    }

    public List<FichaFuncional> finAll() {

        Query query = session.createQuery("from FichaFuncional");
        return query.list();

    }
    
}
