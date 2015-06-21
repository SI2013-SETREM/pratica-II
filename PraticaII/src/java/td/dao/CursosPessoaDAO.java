package td.dao;

import td.model.CursosPessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CursosPessoaDAO {
    
    private Session session;
    
    public CursosPessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(CursosPessoa c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(CursosPessoa c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(CursosPessoa c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public CursosPessoa findById(String id) {
        return (CursosPessoa) session.load(CursosPessoa.class, id);
    }

    public List<CursosPessoa> findAll() {
        Query q = session.createQuery("from CursosPessoa");
        return q.list();
    }
}
