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
import rs.model.RecrutamentoCargo;
import util.HibernateUtil;

/**
 *
 * @author NADINE
 */
public class RecrutamentoCargoDAO {

    private Session session;
    public List<RecrutamentoCargo> rc;

    public List<RecrutamentoCargo> getRc() {
        Query q = session.createQuery("from RecrutamentoCargo rc INNER JOIN rc.recrutamento AS r WHERE r.rec_status=2");
        rc = q.list();
        return rc;
    }

    public void setRc(List<RecrutamentoCargo> rc) {
        this.rc = rc;
    }

    public RecrutamentoCargoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(RecrutamentoCargo r) {
        Transaction t = session.beginTransaction();
        session.save(r);
        t.commit();
    }

    public void update(RecrutamentoCargo r) {
        Transaction t = session.beginTransaction();
        session.update(r);
        t.commit();
    }

    public void delete(RecrutamentoCargo r) {
        Transaction t = session.beginTransaction();
        session.delete(r);
        t.commit();
    }

    public RecrutamentoCargo findById(int rec_car_codigo, int car_codigo, int rec_codigo) {
        return (RecrutamentoCargo) session.load(RecrutamentoCargo.class, rec_car_codigo);
    }

    public List<RecrutamentoCargo> findAll() {
        Query q = session.createQuery("from RecrutamentoCargo");
        return q.list();
    }

}
