package csb.dao;

import csb.model.Setor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import util.HibernateUtil;

/**
 *
 * @author Juliano Pires
 */
public class SetorDAO {

    private Session session;

    public SetorDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Setor e) {
        Transaction t = session.beginTransaction();
        session.save(e);
        t.commit();
    }

    public void update(Setor e) {
        Transaction t = session.beginTransaction();
        session.merge(e);
        t.commit();
    }

    public void delete(Setor e) {
        Transaction t = session.beginTransaction();
        session.delete(e);
        t.commit();
    }

    public Setor findById(int set_codigo) {
        return (Setor) session.load(Setor.class, set_codigo);
    }

    public List<Setor> findAll() {
        Query q = session.createQuery("from Setor");
        return q.list();
    }

    public TreeNode arvoreSetor() {
        TreeNode bla = new DefaultTreeNode("aa", null);
        TreeNode um = new DefaultTreeNode("1", bla);
        new DefaultTreeNode("1.1", um);
        TreeNode dois = new DefaultTreeNode("2", bla);
        new DefaultTreeNode("2.1", dois);
        TreeNode dois_dois = new DefaultTreeNode("2.2", dois);
        new DefaultTreeNode("2.2.10", dois_dois);
        return bla;
    }
}
