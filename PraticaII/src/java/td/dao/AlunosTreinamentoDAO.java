package td.dao;

import td.model.AlunosTreinamento;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AlunosTreinamentoDAO {
    
    private Session session;
    
    public AlunosTreinamentoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(AlunosTreinamento c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(AlunosTreinamento c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(AlunosTreinamento c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public AlunosTreinamento findById(String id) {
        return (AlunosTreinamento) session.load(AlunosTreinamento.class, id);
    }

    public List<AlunosTreinamento> findAll() {
        Query q = session.createQuery("from Alunos_treinamento");
        return q.list();
    }
}
