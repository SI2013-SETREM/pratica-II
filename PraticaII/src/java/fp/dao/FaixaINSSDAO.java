/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dao;


import fp.model.FaixaINSS;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class FaixaINSSDAO {
    
    
     private Session session;

    public FaixaINSSDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(FaixaINSS faixaINSS) {

        Transaction t = session.beginTransaction();
        session.save(faixaINSS);
        t.commit();
    }

    public void update(FaixaINSS faixaINSS) {

        Transaction t = session.beginTransaction();
        session.merge(faixaINSS);
        t.commit();
    }

    public void delete(FaixaINSS faixaINSS) {

        Transaction t = session.beginTransaction();
        session.delete(faixaINSS);
        t.commit();
    }

    public FaixaINSS findById(int id) {

        return (FaixaINSS) session.load(FaixaINSSDAO.class, id);
    }

    public List<FaixaINSS> findAll() {

        Query query = session.createQuery("from FaixaINSS");
        return query.list();

    }
    
}
