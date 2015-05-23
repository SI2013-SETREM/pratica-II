/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.dao;



import ff.model.Dependente;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class DependenteDAO {
    
    
     private Session session;

    public DependenteDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Dependente dependente) {

        Transaction t = session.beginTransaction();
        session.save(dependente);
        t.commit();
    }

    public void update(Dependente dependente) {

        Transaction t = session.beginTransaction();
        session.merge(dependente);
        t.commit();
    }

    public void delete(Dependente dependente) {

        Transaction t = session.beginTransaction();
        session.delete(dependente);
        t.commit();
    }

    public Dependente findById(int id) {

        return (Dependente) session.load(Dependente.class, id);
    }

    public List<Dependente> finAll() {

        Query query = session.createQuery("from Dependente");
        return query.list();

    }
    
}
