/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dao;


import fp.model.Formula;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class FormulaDAO {
    
    
     private Session session;

    public FormulaDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Formula formula) {

        Transaction t = session.beginTransaction();
        session.save(formula);
        t.commit();
    }

    public void update(Formula formula) {

        Transaction t = session.beginTransaction();
        session.merge(formula);
        t.commit();
    }

    public void delete(Formula formula) {

        Transaction t = session.beginTransaction();
        session.delete(formula);
        t.commit();
    }

    public Formula findById(int id) {

        return (Formula) session.load(FormulaDAO.class, id);
    }

    public List<Formula> findAll() {

        Query query = session.createQuery("from Formula");
        return query.list();

    }
    
}
