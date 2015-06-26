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
import rs.model.Entrevista;
import rs.model.Recrutamento;
import util.HibernateUtil;

/**
 *
 * @author NADINE
 */
public class EntrevistaDAO {

    private Session session;

    public EntrevistaDAO() {
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(Entrevista e) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().save(e);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void update(Entrevista e) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().update(e);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void delete(Entrevista e) {
        Transaction t = getSession().beginTransaction();
        getSession().delete(e);
        t.commit();
    }

    public List<Entrevista> findAll() {
        Query q = getSession().createQuery("from Entrevista");
        return q.list();
    }
    
     public List<Entrevista> findEntrevistasRecrutamento(Recrutamento r) {
        Query q = getSession().createQuery("from Entrevista where rec_codigo="+r.getRecCodigo());
        return q.list();
    }
}
