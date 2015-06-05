package csb.dao;

import csb.model.Cargo;
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
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Cargo c) {
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
    }

    public void update(Cargo c) {
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
    }

    public void delete(Cargo c) {
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
    }

    public Cargo findById(int car_codigo) {
        return (Cargo) session.load(Cargo.class, car_codigo);
    }

    public List<Cargo> findAll() {
        Query q = session.createQuery("from Cargo ORDER BY car_pai");
        return q.list();
    }

    public List<Cargo> findTree(int id) {
        String s = "from Cargo";
        if (id != 0) {
            s += " where car_pai="+id;
        }else{
            s += " where car_pai=null";
        }
        Query q = session.createQuery(s);
        return q.list();
    }
    
    public TreeNode arvoreCargo(){
        root=new DefaultTreeNode("root",null);
        filho=new DefaultTreeNode("Cargos", root);
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
        return session.createQuery("from Cargo where 1 = 1 " + sqlCargo).list();
    }

}
