package ad.dao;

import ad.model.PerguntaPessoaAvaliacao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PerguntaPessoaAvaliacaoDAO {

    private Session session;

    public PerguntaPessoaAvaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(PerguntaPessoaAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(PerguntaPessoaAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(PerguntaPessoaAvaliacao i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public PerguntaPessoaAvaliacao findById(int idi_codigo) {
        return (PerguntaPessoaAvaliacao) session.load(PerguntaPessoaAvaliacao.class, idi_codigo);
    }

    public List<PerguntaPessoaAvaliacao> findAll() {
        Query q = session.createQuery("from Pergunta_pessoa_avaliacao");
        return q.list();
    }

    public List<PerguntaPessoaAvaliacao> ListPerguntasPessoasAvaliacao(int ava_id, int col_id, int per_id) {
        String sql = "";
        if (ava_id != 0) {
            sql += " and ava_codigo = " + ava_id;
        }
        if (col_id != 0) {
            sql += " and pes_codigo = " + col_id;
        }
        if (per_id != 0) {
            sql += " and prg_codigo = " + per_id;
        }
//        if (user_id != 0) {
//            sql += " and pes_codigo_avaliador = " + user_id;
//        }
        Query q = session.createQuery(" from PerguntaPessoaAvaliacao where 1=1 " + sql);
        return q.list();
    }
}
