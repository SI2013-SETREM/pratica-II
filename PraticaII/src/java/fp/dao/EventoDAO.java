package fp.dao;

import fp.model.Evento;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class EventoDAO {

    private Session session;

    public EventoDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Evento evento) {

        Transaction t = session.beginTransaction();
        session.save(evento);
        t.commit();
    }

    public void update(Evento evento) {

        Transaction t = session.beginTransaction();
        session.merge(evento);
        t.commit();
    }

    public void delete(Evento evento) {

        Transaction t = session.beginTransaction();
        session.delete(evento);
        t.commit();
    }

    public Evento findById(int id) {

        return (Evento) session.load(Evento.class, id);
    }

    public List<Evento> findAll() {

        Query query = session.createQuery("from Evento");
        return query.list();

    }


    public List<Evento> EventoId(int eve_codigo) {
        Criteria crit = session.createCriteria(Evento.class);
        crit.add(Restrictions.eq("eve_codigo", eve_codigo));
        List results = crit.list();

        return  crit.list();
    }

}
