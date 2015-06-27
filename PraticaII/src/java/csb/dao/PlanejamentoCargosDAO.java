package csb.dao;

import csb.model.PlanejamentoCargos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Juliano Pires
 */
public class PlanejamentoCargosDAO {

    private final Session session;

    public PlanejamentoCargosDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(PlanejamentoCargos b) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
    }

    public void update(PlanejamentoCargos b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }

    public void delete(PlanejamentoCargos b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }

    public PlanejamentoCargos findById(int pln_codigo) {
        return (PlanejamentoCargos) session.load(PlanejamentoCargos.class, pln_codigo);
    }

    public List<PlanejamentoCargos> findAll() {
        Query q = session.createQuery("from PlanejamentoCargos order by car_ordem asc");
        return q.list();
    }

    public List<PlanejamentoCargos> findByCargo(int car_codigo) {
        Query q = session.createQuery("from PlanejamentoCargos where car_codigo = " + car_codigo + " order by car_ordem asc");
        return q.list();
    }

    public List<PlanejamentoCargos> findByPlanejamento(int pla_codigo) {
        Query q = session.createQuery("from PlanejamentoCargos where pla_codigo = " + pla_codigo + " order by car_ordem asc");
        return q.list();
    }

    public List<PlanejamentoCargos> findByPlanejamentoCargo(int pla_codigo, int car_codigo) {
        Query q = session.createQuery("from PlanejamentoCargos where pla_codigo = " + pla_codigo + " and car_codigo = " + car_codigo);
        return q.list();
    }
    
    public List<PlanejamentoCargos> findByPlanejamentoOrdem(int pla_codigo, int car_ordem) {
        Query q = session.createQuery("from PlanejamentoCargos where pla_codigo = " + pla_codigo + " and car_ordem = " + car_ordem);
        return q.list();
    }    
}
