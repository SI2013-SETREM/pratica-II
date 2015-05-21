package ad.dao;

import ad.model.Competencias_pessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Competencias_pessoaDAO {

    private Session session;

    public Competencias_pessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Competencias_pessoa i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Competencias_pessoa i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Competencias_pessoa i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Competencias_pessoa findById(int idi_codigo) {
        return (Competencias_pessoa) session.load(Competencias_pessoa.class, idi_codigo);
    }

    public List<Competencias_pessoa> findAll() {
        Query q = session.createQuery("from Competencias_pessoa");
        return q.list();
    }
}
