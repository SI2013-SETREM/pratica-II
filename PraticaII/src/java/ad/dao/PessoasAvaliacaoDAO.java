package ad.dao;

import ad.model.PessoasAvaliacao;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PessoasAvaliacaoDAO {

    private Session session;

    public PessoasAvaliacaoDAO() {
    }
    
    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(PessoasAvaliacao i) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().save(i);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void update(PessoasAvaliacao i) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().merge(i);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void delete(PessoasAvaliacao i) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().delete(i);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public PessoasAvaliacao findById(int idi_codigo) {
        return (PessoasAvaliacao) getSession().load(PessoasAvaliacao.class, idi_codigo);
    }

    public List<PessoasAvaliacao> findAll() {
        Query q = getSession().createQuery("from PessoasAvaliacao");
        return q.list();
    }

////------MApear    
    public List<PessoasAvaliacao> GetListPessoasAvaliacao(int ava_codigo, int pes_codigo, int pes_codigo_avaliador, boolean mediaNull, boolean BFilterDate) {
        String sql = "";
        if (ava_codigo != 0) {
            sql += " and ava_codigo = " + ava_codigo;
        }
        if (pes_codigo != 0) {
            sql += " and pes_codigo = " + pes_codigo;
        }
        if (pes_codigo_avaliador != 0) {
            sql += " and pes_codigo_avaliador = " + pes_codigo_avaliador;
        }
        if (mediaNull) {
            //sql += " and pea_media is null";
            sql += " and pea_media = 0";
        }
        if (BFilterDate) {
            sql += " and (ava_dataInicial >= " + new Date() + " and ava_dataFinal <= " + new Date() + ")";
        }
        Query q = getSession().createQuery(" from PessoasAvaliacao where 1=1 " + sql);
        return q.list();
    }
}
