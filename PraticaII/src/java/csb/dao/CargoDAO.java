package csb.dao;

import csb.model.Cargo;
import csb.model.PlanejamentoCargos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import util.HibernateUtil;

public class CargoDAO {

    private Session session;
    private TreeNode root;
    private TreeNode filho;

    public CargoDAO() {
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(Cargo c) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().save(c);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void update(Cargo c) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().merge(c);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public void delete(Cargo c) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().delete(c);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public Cargo findById(int car_codigo) {
        return (Cargo) getSession().load(Cargo.class, car_codigo);
    }

    public List<Cargo> findAllChildrens() {
        Query q = getSession().createQuery("from Cargo where car_pai is not null order by car_pai asc");
        return q.list();
    }

    public List<Cargo> findAll() {
        Query q = getSession().createQuery("from Cargo order by car_descricao asc");
        return q.list();
    }

    public List<Cargo> findPlanoDoCargo(PlanejamentoCargos pln_codigo) {
        Query q = getSession().createSQLQuery("from Cargo where car_codigo in (select car_codigo from PlanejamentoCargos where pla_codigo = (select pla_codigo from PlanejamentoCargos where pln_codigo = " + pln_codigo + ") order by car_ordem);");
        return q.list();
    }

    public List<Cargo> findAllParents() {
        Query q = getSession().createQuery("from Cargo where car_pai is null order by car_descricao asc");
        return q.list();
    }

    public List<Cargo> findTree(int id) {
        String s = "from Cargo";
        if (id != 0) {
            s += " where car_pai=" + id;
        } else {
            s += " where car_pai=null";
        }
        Query q = getSession().createQuery(s);
        return q.list();
    }

    public TreeNode arvoreCargo() {
        root = new DefaultTreeNode("root", null);
        filho = new DefaultTreeNode("Cargos", root);
        treeCargo(null, 0, filho);
        return root;
    }

    public void treeCargo(List<Cargo> lista, int id, TreeNode node) {
        List<Cargo> tree = this.findTree(id);
        TreeNode f;
        for (Cargo c : tree) {
            f = new DefaultTreeNode(c.getCar_descricao(), node);
            treeCargo(tree, c.getCar_codigo(), f);
        }
    }

    public List<Cargo> searchCargo(String name) {
        String sqlCargo = "";
        if (name != null && name != "") {
            sqlCargo = " and upper (translate(car_descricao, 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))"
                    + " LIKE upper(translate('%" + name + "%', 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))";
        }
        return getSession().createQuery("from Cargo where 1 = 1 " + sqlCargo).list();
    }
}
