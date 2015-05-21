package ad.dao;

import ad.model.Tipo_competencia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Tipo_competenciaDAO {

    private Session session;

    public Tipo_competenciaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Tipo_competencia i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Tipo_competencia i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Tipo_competencia i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Tipo_competencia findById(int idi_codigo) {
        return (Tipo_competencia) session.load(Tipo_competencia.class, idi_codigo);
    }

    public List<Tipo_competencia> findAll() {
        Query q = session.createQuery("from Tipo_competencia");
        return q.list();
    }
}