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
import rs.model.RecrutamentoPessoa;
import util.HibernateUtil;

/**
 *
 * @author NADINE
 */
public class RecrutamentoPessoasDAO {
      private Session session;

    public RecrutamentoPessoasDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(RecrutamentoPessoa r) {
        Transaction t = session.beginTransaction();
        session.save(r);
        t.commit();
    }

    public void update(RecrutamentoPessoa r) {
        Transaction t = session.beginTransaction();
        session.merge(r);
        t.commit();
    }

    public void delete(RecrutamentoPessoa r) {
        Transaction t = session.beginTransaction();
        session.delete(r);
        t.commit();
    }
    
     public String salvar() {
//        if (RecrutamentoPessoa. > 0)
//            dao.update(questionario);
//        else 
//            dao.insert(questionario);
        
        return "questionariolst?faces-redirect=true";
    }

    public List<RecrutamentoPessoa> findAll() {
        Query q = session.createQuery("from RecrutamentoPessoa");
        return q.list();
    }

    public List<RecrutamentoPessoa> findByRecrutamento(int recCodigo) {
        Query q = session.createQuery("from RecrutamentoPessoa where recrutamentoPessoaPK.recrutamento = " + String.valueOf(recCodigo));
        return q.list();
    }
    
      public RecrutamentoPessoa findById(int rec_codigo, int pes_codigo) {
        return (RecrutamentoPessoa) session.load(RecrutamentoPessoa.class, rec_codigo);
    }

    
   
}
