package cfg.dao;

import cfg.controller.LoginBean;
import cfg.model.Log;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.Utilidades;

@ManagedBean
@SessionScoped
public class LogDAO {

    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private Session session;

    public LogDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public static void insert(String tabela, String operacao) {
        LoginBean loginBeana = (LoginBean) Utilidades.getSessionObject("loginBean");
        String usu_login = loginBeana.getUsuario().getUsuLogin();
        try {
            int i = Utilidades.executeUpdate("insert into log values((select coalesce(max(log_codigo), null, 0)+1 from log), ?, ?, ?, current_timestamp);", new Object[]{usu_login, tabela, operacao});
        } catch (Exception ex) {
            System.err.println("Deu brete " + ex);
        }
    }

    public void update(Log b) {
        Transaction t = session.beginTransaction();
        session.merge(b);
        t.commit();
    }

    public void delete(Log b) {
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
    }

    public Log findById(int log_codigo) {
        return (Log) session.load(Log.class, log_codigo);
    }

    public List<Log> findAll() {
        Query q = session.createQuery("from Log");
        return q.list();
    }
}
