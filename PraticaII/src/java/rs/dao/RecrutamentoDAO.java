/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dao;

import java.util.ArrayList;
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
    public List<Recrutamento> rc = new ArrayList<>();

    public RecrutamentoDAO() {
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public List<Recrutamento> getRc() {
        Query q = getSession().createQuery("from Recrutamento where rec_status=2");
        this.rc = q.list();
        return rc;
    }

    public void setRc(List<Recrutamento> rc) {
        this.rc = rc;
    }

    public void insert(Recrutamento r) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                r.setRecStatus(2);
                getSession().save(r);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void update(Recrutamento r) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                if (r.getRecStatus() == 0) {
                    r.setRecStatus(2);
                }
                getSession().update(r);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void delete(Recrutamento r) {
        Transaction t = getSession().beginTransaction();
        getSession().delete(r);
        t.commit();
    }

    public List<Recrutamento> findAll() {
        Query q = getSession().createQuery("from Recrutamento");
        return q.list();
    }
}
