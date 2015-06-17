package td.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import td.model.InstrutoresTreinamento;
import util.HibernateUtil;

public class InstrutoresTreinamentoDAO {
    
    private Session session;
    
    public InstrutoresTreinamentoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
     public void insert(InstrutoresTreinamento i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(InstrutoresTreinamento i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(InstrutoresTreinamento i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

     public InstrutoresTreinamento findById(int i) {
        return (InstrutoresTreinamento) session.load(InstrutoresTreinamento.class, i);
    }

    public List<InstrutoresTreinamento> findAll() {
        Query q = session.createQuery("from CompetenciasTreinamento");
        return q.list();
    }
    
    public List<InstrutoresTreinamento> GetListInstrutoresTreinamento(int pes_codigo_instrutor, int tre_codigo) {
        String sql = "";
        if (pes_codigo_instrutor != 0) {
            sql += " and pes_codigo_instrutor = " + pes_codigo_instrutor;
        }
        if (tre_codigo != 0) {
            sql += " and tre_codigo = " + tre_codigo;
        }
        Query q = session.createQuery(" from InstrutoresTreinamento where 1=1 " + sql);
        return q.list();
    }
}
