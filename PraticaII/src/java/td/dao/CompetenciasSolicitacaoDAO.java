package td.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import td.model.CompetenciasSolicitacao;
import util.HibernateUtil;

public class CompetenciasSolicitacaoDAO {

    private Session session;
    
    public CompetenciasSolicitacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
     public void insert(CompetenciasSolicitacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(CompetenciasSolicitacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(CompetenciasSolicitacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

     public CompetenciasSolicitacao findById(int i) {
        return (CompetenciasSolicitacao) session.load(CompetenciasSolicitacao.class, i);
    }

    public List<CompetenciasSolicitacao> findAll() {
        Query q = session.createQuery("from CompetenciasSolicitacao");
        return q.list();
    }
    
    public List<CompetenciasSolicitacao> GetListCompetenciasSolicitacao(int cmp_codigo, int sol_codigo) {
        String sql = "";
        if (cmp_codigo != 0) {
            sql += " and cmp_codigo = " + cmp_codigo;
        }
        if (sol_codigo != 0) {
            sql += " and sol_codigo = " + sol_codigo;
        }
        Query q = session.createQuery(" from CompetenciasSolicitacao where 1=1 " + sql);
        return q.list();
    }
}
