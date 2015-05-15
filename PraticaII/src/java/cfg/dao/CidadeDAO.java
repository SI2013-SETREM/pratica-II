/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg.dao;

import cfg.model.Cidade;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CidadeDAO {

    private Session session;

    public CidadeDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Cidade c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(Cidade c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(Cidade c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public Cidade findById(String cid_cep) {
        return (Cidade) session.load(Cidade.class, cid_cep);
    }

    public List<Cidade> findAll() {
        Query q = session.createQuery("from Cidade");
        return q.list();
    }
}
