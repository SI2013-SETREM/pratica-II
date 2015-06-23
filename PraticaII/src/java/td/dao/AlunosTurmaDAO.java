package td.dao;

import td.model.AlunosTurma;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AlunosTurmaDAO {

    private Session session;

    public AlunosTurmaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(AlunosTurma c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(AlunosTurma c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(AlunosTurma c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public AlunosTurma findById(String id) {
        return (AlunosTurma) session.load(AlunosTurma.class, id);
    }

    public List<AlunosTurma> findAll() {
        Query q = session.createQuery("from Alunos_turma");
        return q.list();
    }

    ///Adicionei esse metodo pois utilizo ele para pegar os alunos da turma
    public List<AlunosTurma> GetAlunosTurma(int tur_codigo, int pes_codigo) {
        String sql = "";
        if (tur_codigo != 0) {
            sql += " AND tur_codigo = " + tur_codigo;
        }
        if (pes_codigo != 0) {
            sql += " AND pes_codigo = " + pes_codigo;
        }

        Query q = session.createQuery("from Alunos_turma " + sql);
        return q.list();
    }

}
