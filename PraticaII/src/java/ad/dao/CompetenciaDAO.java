package ad.dao;

import ad.model.Competencia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CompetenciaDAO {

    private Session session;

    public CompetenciaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Competencia i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Competencia i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Competencia i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Competencia findById(int idi_codigo) {
        return (Competencia) session.load(Competencia.class, idi_codigo);
    }

    public List<Competencia> findAll() {
        Query q = session.createQuery("from Competencia");
        return q.list();
    }
    
    public List<Competencia> searchCompetencia(String name) {
        String sqlCompetencia = "";
        if (name != null && name != "") {
            sqlCompetencia = " and upper (translate(cmp_descricao, 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))"
                    + " LIKE upper(translate('%" + name + "%', 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))";
        }
        return session.createQuery("from Competencia where 1 = 1 " + sqlCompetencia).list();
    }
}
