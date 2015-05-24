package ad.dao;

import ad.model.TipoCompetencia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TipoCompetenciaDAO {

    private Session session;

    public TipoCompetenciaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(TipoCompetencia i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(TipoCompetencia i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(TipoCompetencia i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public TipoCompetencia findById(int idi_codigo) {
        return (TipoCompetencia) session.load(TipoCompetencia.class, idi_codigo);
    }

    public List<TipoCompetencia> findAll() {
        Query q = session.createQuery("from Tipo_competencia");
        return q.list();
    }
}