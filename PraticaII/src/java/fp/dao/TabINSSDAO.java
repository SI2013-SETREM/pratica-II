/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dao;


import fp.model.TabelaINSS;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class TabINSSDAO {
    
    
     private Session session;

    public TabINSSDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(TabelaINSS tabInss) {

        Transaction t = session.beginTransaction();
        session.save(tabInss);
        t.commit();
    }

    public void update(TabelaINSS tabInss) {

        Transaction t = session.beginTransaction();
        session.merge(tabInss);
        t.commit();
    }

    public void delete(TabelaINSS tabInss) {

        Transaction t = session.beginTransaction();
        session.delete(tabInss);
        t.commit();
    }

    public TabelaINSS findById(int id) {

        return (TabelaINSS) session.load(TabelaINSS.class, id);
    }

    public List<TabelaINSS> findAll() {

        Query query = session.createQuery("from TabINSS");
        return query.list();

    }
    
}
