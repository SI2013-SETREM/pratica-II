package td.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import td.model.PessoasReceberTreinamento;
import util.HibernateUtil;

public class PessoasReceberTreinamentoDAO {
    
    private Session session;
    
    public PessoasReceberTreinamentoDAO(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(PessoasReceberTreinamento i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(PessoasReceberTreinamento i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(PessoasReceberTreinamento i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

     public PessoasReceberTreinamento findById(int i) {
        return (PessoasReceberTreinamento) session.load(PessoasReceberTreinamento.class, i);
    }

    public List<PessoasReceberTreinamento> findAll() {
        Query q = session.createQuery("from PessoasReceberTreinamento");
        return q.list();
    }
    
    public List<PessoasReceberTreinamento> GetListPessoasReceberTreinamento(int pes_codigo, int sol_codigo) {
        String sql = "";
        if (pes_codigo != 0) {
            sql += " and pes_codigo = " + pes_codigo;
        }
        if (sol_codigo != 0) {
            sql += " and sol_codigo = " + sol_codigo;
        }
        Query q = session.createQuery(" from CompetenciasSolicitacao where 1=1 " + sql);
        return q.list();
    }
}
