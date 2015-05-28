
package cfg.dao;

import cfg.model.MensagemPessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MensagemPessoaDAO {
    private Session session;

    public MensagemPessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(MensagemPessoa b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(MensagemPessoa b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(MensagemPessoa b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public MensagemPessoa findById(int bai_codigo) {
        return (MensagemPessoa) session.load(MensagemPessoa.class, bai_codigo);
    }
    
    public List<MensagemPessoa> findAll() {
        Query q = session.createQuery("from MensagemPessoa");
        return q.list();
    }
    
}
