package td.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import td.model.CompetenciasTreinamento;
import util.HibernateUtil;

public class CompetenciasTreinamentoDAO {
    
        private Session session;
    
    public CompetenciasTreinamentoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
     public void insert(CompetenciasTreinamento i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(CompetenciasTreinamento i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(CompetenciasTreinamento i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

     public CompetenciasTreinamento findById(int i) {
        return (CompetenciasTreinamento) session.load(CompetenciasTreinamento.class, i);
    }

    public List<CompetenciasTreinamento> findAll() {
        Query q = session.createQuery("from CompetenciasTreinamento");
        return q.list();
    }
    
    public List<CompetenciasTreinamento> GetListCompetenciasTreinamento(int cmp_codigo, int tre_codigo) {
        String sql = "";
        if (cmp_codigo != 0) {
            sql += " and cmp_codigo = " + cmp_codigo;
        }
        if (tre_codigo != 0) {
            sql += " and tre_codigo = " + tre_codigo;
        }
        Query q = session.createQuery(" from CompetenciasTreinamento where 1=1 " + sql);
        return q.list();
    }
}
