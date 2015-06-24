package csb.dao;

import csb.model.Beneficio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class BeneficioDAO {
    private Session session;

    public BeneficioDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Beneficio b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }
    
    public void update(Beneficio b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }
    
    public void delete(Beneficio b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }
    
    public Beneficio findById(int ben_codigo) {
        return (Beneficio) session.load(Beneficio.class, ben_codigo);
    }
    
    public List<Beneficio> findAll() {
        Query q = session.createQuery("from Beneficio order by ben_descricao asc");
        return q.list();
    }
}
