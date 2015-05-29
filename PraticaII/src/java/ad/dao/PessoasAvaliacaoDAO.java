package ad.dao;

import ad.model.PessoasAvaliacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PessoasAvaliacaoDAO {

    private Session session;

    public PessoasAvaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(PessoasAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(PessoasAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(PessoasAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public PessoasAvaliacao findById(int idi_codigo) {
        return (PessoasAvaliacao) session.load(PessoasAvaliacao.class, idi_codigo);
    }

    public List<PessoasAvaliacao> findAll() {
        Query q = session.createQuery("from PessoasAvaliacao");
        return q.list();
    }

////------MApear    
    public List<PessoasAvaliacao> GetListPessoasAvaliacao(int ava_id, int pes_codigo, int pes_codigo_avaliador) {
        String sql = "";
        if (ava_id != 0) {
            sql += " and ava_codigo = " + ava_id;
        }
        if (pes_codigo != 0) {
            sql += " and pes_codigo = " + pes_codigo;
        }
        if (pes_codigo_avaliador != 0) {
            sql += " and pes_codigo_avaliador = " + pes_codigo_avaliador;
        }
        Query q = session.createQuery(" from PessoasAvaliacao where 1=1 " + sql);
        return q.list();
    }

}
