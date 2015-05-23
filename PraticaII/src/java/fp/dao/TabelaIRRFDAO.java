/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dao;



import fp.model.TabelaIRRF;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class TabelaIRRFDAO {
    
    
     private Session session;

    public TabelaIRRFDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(TabelaIRRF tabelaIrrf) {

        Transaction t = session.beginTransaction();
        session.save(tabelaIrrf);
        t.commit();
    }

    public void update(TabelaIRRF tabelaIrrf) {

        Transaction t = session.beginTransaction();
        session.merge(tabelaIrrf);
        t.commit();
    }

    public void delete(TabelaIRRF tabelaIrrf) {

        Transaction t = session.beginTransaction();
        session.delete(tabelaIrrf);
        t.commit();
    }

    public TabelaIRRF findById(int id) {

        return (TabelaIRRF) session.load(TabelaIRRF.class, id);
    }

    public List<TabelaIRRF> finAll() {

        Query query = session.createQuery("from TabelaIRRF");
        return query.list();

    }
    
}
