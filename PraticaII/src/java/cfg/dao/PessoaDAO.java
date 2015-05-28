
package cfg.dao;

import cfg.model.Pessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PessoaDAO {
    private Session session;

    public PessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Pessoa b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(Pessoa b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(Pessoa b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public Pessoa findById(int pes_codigo) {
        return (Pessoa) session.load(Pessoa.class, pes_codigo);
    }
    
    public List<Pessoa> findAll() {
        Query q = session.createQuery("from Pessoa");
        return q.list();
    }
    
}
