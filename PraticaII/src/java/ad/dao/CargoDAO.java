package ad.dao;

import csb.model.Cargo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CargoDAO {

    private Session session;

    public CargoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Cargo i) {
        Transaction t = session.beginTransaction();
        session.save(i);
        t.commit();
    }

    public void update(Cargo i) {
        Transaction t = session.beginTransaction();
        session.merge(i);
        t.commit();
    }

    public void delete(Cargo i) {
        Transaction t = session.beginTransaction();
        session.delete(i);
        t.commit();
    }

    public Cargo findById(int idi_codigo) {
        return (Cargo) session.load(Cargo.class, idi_codigo);
    }

    public List<Cargo> findAll(String query) {
        String sql = "";
        if (query != "") {
            sql = " and upper (translate(car_descricao, 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))"
                    + " LIKE upper(translate('%" + query + "%', 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))";
        }
        return session.createQuery("from Cargo where 1 = 1 " + sql).list();
    }

}
