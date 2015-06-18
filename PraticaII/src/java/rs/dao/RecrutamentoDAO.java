/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rs.model.Recrutamento;
import util.HibernateUtil;

/**
 *
 * @author NADINE
 */
public class RecrutamentoDAO {

    private Session session;

    public RecrutamentoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Recrutamento r) {
        Transaction t = session.beginTransaction();
        r.setRecStatus(2);
        session.save(r);
        t.commit();
    }

    public void update(Recrutamento r) {
        Transaction t = session.beginTransaction();
        session.update(r);
        t.commit();
    }

    public void delete(Recrutamento r) {
        Transaction t = session.beginTransaction();
        session.delete(r);
        t.commit();
    }

      public List<Recrutamento> findAll() {
        Query q = session.createQuery("from Recrutamento");
        return q.list();
    }
}
