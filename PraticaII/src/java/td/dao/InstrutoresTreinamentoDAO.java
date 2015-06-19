package td.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import td.model.InstrutoresTreinamento;
import util.HibernateUtil;

public class InstrutoresTreinamentoDAO {
    
    private Session session;
    public int idTre;
    
    public InstrutoresTreinamentoDAO(){
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
        Query q = session.createQuery("from InstrutoresTreinamento");
        return q.list();
    }
    
    public List<InstrutoresTreinamento> GetListInstrutoresTreinamento(int pes_codigo, int sol_codigo) {
        String sql = "";
        if (pes_codigo != 0) {
            sql += " and pes_codigo = " + pes_codigo;
        }
        if (sol_codigo != 0) {
            sql += " and sol_codigo = " + sol_codigo;
        }
        Query q = session.createQuery(" from InstrutoresTreinamento where 1=1 " + sql);
        return q.list();
    }
    
    public void deletaPesTre(){
        
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "delete from InstrutoresTreinamento where tre_codigo = :uid";
            Query query = session.createQuery(hql);
            //System.out.println(idSol);
            query.setInteger("uid", idTre);
            query.executeUpdate();
            transaction.commit();
        } catch (Throwable t) {
            transaction.rollback();
        throw t;
        }
    }
}
