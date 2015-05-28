package csb.dao;

import csb.model.Graduacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class GraduacaoDAO {
    private Session session;

    public GraduacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Graduacao g) {
        Transaction t = session.beginTransaction();
        session.save(g);
        t.commit();
    }
    
    public void update(Graduacao g) {
        Transaction t = session.beginTransaction();
        session.merge(g);
        t.commit();
    }
    
    public void delete(Graduacao g) {
        Transaction t = session.beginTransaction();
        session.delete(g);
        t.commit();
    }
    
    public Graduacao findById(int grd_codigo) {
        return (Graduacao) session.load(Graduacao.class, grd_codigo);
    }
    
    public List<Graduacao> findAll() {
        Query q = session.createQuery("from Graduacao");
        return q.list();
    }
}
