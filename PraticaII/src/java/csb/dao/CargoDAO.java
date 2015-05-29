package csb.dao;

import csb.model.Cargo;
import csb.model.Setor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import util.HibernateUtil;

public class CargoDAO {

    private Session session;

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

    public TreeNode arvoreSetor() {
        TreeNode raiz = new DefaultTreeNode("raiz", null);
        List<Cargo> cargos = this.findAll();
        for (Cargo c : cargos) {
            if (c.getCar_pai() == null) {
                new DefaultTreeNode(c, raiz);
            } else {
//                Cargo p = new Cargo();
//                p.setCar_descricao("raiz: " + c.getCar_descricao() + ":" + String.valueOf(raiz.getChildCount()));
//                new DefaultTreeNode(p, raiz);
                for (TreeNode t : raiz.getChildren()) {
                    if (c.getCar_pai().getCar_codigo() == ((Cargo) t.getData()).getCar_codigo()) {
                        new DefaultTreeNode(c, t);
                        break;
                    }
                }
            }
        }
        return raiz;
    }

    public List<Cargo> searchCargos(String name) {
        String sql = "";
        if (name != "") {
            sql = " and upper (translate(car_descricao, 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))"
                    + " LIKE upper(translate('%" + name + "%', 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))";
        }
        return session.createQuery("from Cargo where 1 = 1 " + sql).list();
    }
}
