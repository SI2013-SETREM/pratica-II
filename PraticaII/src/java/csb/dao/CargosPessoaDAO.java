package csb.dao;

import csb.model.CargosPessoa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CargosPessoaDAO {
    private Session session;

    public CargosPessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(CargosPessoa c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }
    
    public void update(CargosPessoa c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }
    
    public void delete(CargosPessoa c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }
    
    public CargosPessoa findById(int pes_codigo) {
        return (CargosPessoa) session.load(CargosPessoa.class, pes_codigo);
    }
    
    public List<CargosPessoa> findAll() {
        Query q = session.createQuery("from CargosPessoa");
        return q.list();
    }
}
