package td.dao;

import td.model.Solicitacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class SolicitacaoDAO {
    
    private Session session;
    
    public SolicitacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Solicitacao c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(Solicitacao c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(Solicitacao c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public Solicitacao findById(String id) {
        return (Solicitacao) session.load(Solicitacao.class, id);
    }

    public List<Solicitacao> findAll() {
        Query q = session.createQuery("from Solicitacao");
        return q.list();
    }
}
