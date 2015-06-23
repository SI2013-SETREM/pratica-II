package csb.dao;

import csb.model.ExamePessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ExamePessoaDAO {
    private Session session;

    public ExamePessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(ExamePessoa e) {
        Transaction t = session.beginTransaction();
        session.save(e);
        t.commit();
    }
    
    public void update(ExamePessoa e) {
        Transaction t = session.beginTransaction();
        session.merge(e);
        t.commit();
    }
    
    public void delete(ExamePessoa e) {
        Transaction t = session.beginTransaction();
        session.delete(e);
        t.commit();
    }
    
    public ExamePessoa findById(int exa_codigo) {
        return (ExamePessoa) session.load(ExamePessoa.class, exa_codigo);
    }
    
    public List<ExamePessoa> findAll() {
        Query q = session.createQuery("from ExamePessoa order by pes_codigo, eps_dataexame asc");
        return q.list();
    }
}
