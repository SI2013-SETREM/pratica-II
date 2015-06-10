
package fp.dao;



import fp.model.FaixaIRRF;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import util.HibernateUtil;

public class FaixaIRRFDAO {
    
    
     private Session session;

    public FaixaIRRFDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(FaixaIRRF faixaIRRF) {

        Transaction t = session.beginTransaction();
        session.save(faixaIRRF);
        t.commit();
    }

    public void update(FaixaIRRF faixaIRRF) {

        Transaction t = session.beginTransaction();
        session.merge(faixaIRRF);
        t.commit();
    }

    public void delete(FaixaIRRF faixaIRRF) {

        Transaction t = session.beginTransaction();
        session.delete(faixaIRRF);
        t.commit();
    }

    public FaixaIRRF findById(int id) {

        return (FaixaIRRF) session.load(FaixaIRRFDAO.class, id);
    }

    public List<FaixaIRRF> findAll() {

        Query query = session.createQuery("from FaixaIRRF");
        return query.list();

    }
    
}
