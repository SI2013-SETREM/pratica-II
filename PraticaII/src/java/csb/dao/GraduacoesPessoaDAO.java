package csb.dao;

import csb.model.GraduacoesPessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class GraduacoesPessoaDAO {
    private Session session;

    public GraduacoesPessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(GraduacoesPessoa g) {
        Transaction t = session.beginTransaction();
        session.save(g);
        t.commit();
    }
    
    public void update(GraduacoesPessoa g) {
        Transaction t = session.beginTransaction();
        session.merge(g);
        t.commit();
    }
    
    public void delete(GraduacoesPessoa g) {
        Transaction t = session.beginTransaction();
        session.delete(g);
        t.commit();
    }
    
    public GraduacoesPessoa findById(int pes_codigo) {
        return (GraduacoesPessoa) session.load(GraduacoesPessoa.class, pes_codigo);
    }
    
    public List<GraduacoesPessoa> findAll() {
        Query q = session.createQuery("from GraduacoesPessoa");
        return q.list();
    }
}
