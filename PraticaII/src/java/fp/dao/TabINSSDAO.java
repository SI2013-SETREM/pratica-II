/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dao;


import fp.model.TabINSS;
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

    public void insert(TabINSS tabInss) {

        Transaction t = session.beginTransaction();
        session.save(tabInss);
        t.commit();
    }

    public void update(TabINSS tabInss) {

        Transaction t = session.beginTransaction();
        session.merge(tabInss);
        t.commit();
    }

    public void delete(TabINSS tabInss) {

        Transaction t = session.beginTransaction();
        session.delete(tabInss);
        t.commit();
    }

    public TabINSS findById(int id) {

        return (TabINSS) session.load(TabINSS.class, id);
    }

    public List<TabINSS> finAll() {

        Query query = session.createQuery("from TabINSS");
        return query.list();

    }
    
}
