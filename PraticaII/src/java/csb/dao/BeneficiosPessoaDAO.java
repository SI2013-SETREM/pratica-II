package csb.dao;

import csb.model.BeneficiosPessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class BeneficiosPessoaDAO {
    private Session session;

    public BeneficiosPessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(BeneficiosPessoa p) {
        Transaction t = session.beginTransaction();
        session.save(p);
        t.commit();
    }
    
    public void update(BeneficiosPessoa p) {
        Transaction t = session.beginTransaction();
        session.merge(p);
        t.commit();
    }
    
    public void delete(BeneficiosPessoa p) {
        Transaction t = session.beginTransaction();
        session.delete(p);
        t.commit();
    }
    
    public BeneficiosPessoa findById(int pes_codigo) {
        return (BeneficiosPessoa) session.load(BeneficiosPessoa.class, pes_codigo);
    }
    
    public List<BeneficiosPessoa> findAll() {
        Query q = session.createQuery("from BeneficiosPessoa");
        return q.list();
    }
}
