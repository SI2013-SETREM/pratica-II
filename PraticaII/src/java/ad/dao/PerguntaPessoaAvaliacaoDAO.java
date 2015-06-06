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
    
    
}
