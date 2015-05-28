package csb.dao;

import csb.model.EquipamentosPessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EquipamentosPessoaDAO {
    private Session session;

    public EquipamentosPessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(EquipamentosPessoa e) {
        Transaction t = session.beginTransaction();
        session.save(e);
        t.commit();
    }
    
    public void update(EquipamentosPessoa e) {
        Transaction t = session.beginTransaction();
        session.merge(e);
        t.commit();
    }
    
    public void delete(EquipamentosPessoa e) {
        Transaction t = session.beginTransaction();
        session.delete(e);
        t.commit();
    }
    
    public EquipamentosPessoa findById(int pes_codigo) {
        return (EquipamentosPessoa) session.load(EquipamentosPessoa.class, pes_codigo);
    }
    
    public List<EquipamentosPessoa> findAll() {
        Query q = session.createQuery("from EquipamentosPessoa");
        return q.list();
    }
}
