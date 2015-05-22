package td.dao;

import td.model.Cursos_pessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Cursos_pessoaDAO {
    
    private Session session;
    
    public Cursos_pessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Cursos_pessoa c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(Cursos_pessoa c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(Cursos_pessoa c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public Cursos_pessoa findById(String id) {
        return (Cursos_pessoa) session.load(Cursos_pessoa.class, id);
    }

    public List<Cursos_pessoa> findAll() {
        Query q = session.createQuery("from Cursos_pessoa");
        return q.list();
    }
}
