
package rs.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rs.model.PerguntaOpcao;
import util.HibernateUtil;

public class PerguntaOpcaoDAO {
    private Session session;

    public PerguntaOpcaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(PerguntaOpcao obj) {
        Transaction t = session.getTransaction();
        if (!t.isActive()) {
            t = session.beginTransaction();
        }
//        Transaction t = session.beginTransaction();
        session.save(obj);
        t.commit();
    }
    
    public void update(PerguntaOpcao obj) {
        Transaction t = session.beginTransaction();
        session.merge(obj);
        t.commit();
    }
    
    public void delete(PerguntaOpcao obj) {
        Transaction t = session.beginTransaction();
        session.delete(obj);
        t.commit();
    }
    
//    public PerguntaOpcao findById(int prg_codigo) {
//        return (PerguntaOpcao) session.load(PerguntaOpcao.class, prg_codigo);
//    }
    
    public List<PerguntaOpcao> findAll() {
        Query q = session.createQuery("from PerguntaOpcao");
        return q.list();
    }
    
}
