package td.dao;

import td.model.Alunos_treinamento;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Alunos_treinamentoDAO {
    
    private Session session;
    
    public Alunos_treinamentoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Alunos_treinamento c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(Alunos_treinamento c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(Alunos_treinamento c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public Alunos_treinamento findById(String id) {
        return (Alunos_treinamento) session.load(Alunos_treinamento.class, id);
    }

    public List<Alunos_treinamento> findAll() {
        Query q = session.createQuery("from Alunos_treinamento");
        return q.list();
    }
}
