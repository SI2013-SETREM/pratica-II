package fp.dao;

import fp.model.HistoricoFolha;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Max
 */
public class HistoricoFolhaDAO {

    private Session session;

    public HistoricoFolhaDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(HistoricoFolha historicoFolha) {

        Transaction t = session.beginTransaction();
        session.save(historicoFolha);
        t.commit();
    }

    public void update(HistoricoFolha historicoFolha) {

        Transaction t = session.beginTransaction();
        session.merge(historicoFolha);
        t.commit();
    }

    public HistoricoFolha findById(int id) {

        return (HistoricoFolha) session.load(HistoricoFolha.class, id);
    }

    public List<HistoricoFolha> finAll() {

        Query query = session.createQuery("from HistoricoFolha");
        return query.list();

    }

    public List<HistoricoFolha> historicos(int pes_codigo, int hif_codigo) {
        Criteria crit = session.createCriteria(HistoricoFolha.class);
        crit.add(Restrictions.eq("pes_codigo", pes_codigo));
        crit.add(Restrictions.eq("hif_codigo", hif_codigo));
        List results = crit.list();

        return crit.list();
    }

    public List<HistoricoFolha> historicoAtual(int pes_codigo, String data) {

        Query query = session.createQuery("from HistoricoFolha where pes_codigo = " + pes_codigo + " and hif_data = '" + data + "' ");
        return query.list();
    }
    
    public List<HistoricoFolha> historicoTodos(int pes_codigo) {
        Query query = session.createQuery("from HistoricoFolha where pes_codigo =" +pes_codigo);
        return query.list();
    }

}
