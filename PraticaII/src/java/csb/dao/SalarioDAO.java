package csb.dao;

import csb.model.Salario;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class SalarioDAO
{
    
    private Session session;
    
    public SalarioDAO()
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Salario s)
    {
        Transaction t = session.beginTransaction();
        session.save(s);
        t.commit();
    }
    
    public void update(Salario s)
    {
        Transaction t = session.beginTransaction();
        session.merge(s);
        t.commit();
    }
    
    public void updateSalario(Salario s)
    {
        Transaction t = session.beginTransaction();
        
        Salario salUpdate = findById(s.getSal_codigo());
        
        salUpdate.setSal_datafim(new Date());
        salUpdate.setSal_situacao(false);
        salUpdate.setMotivoAlteracaoSalarial(s.getMotivoAlteracaoSalarial());
        
        Salario salInsert = new Salario();
        salInsert.setPessoa(s.getPessoa());
        salInsert.setCargo(s.getCargo());
        salInsert.setSal_datainicio(new Date());
        salInsert.setSal_situacao(true);
        salInsert.setSal_valorbruto(s.getSal_valorbruto());
        
        session.save(salInsert);
        session.merge(salUpdate);
        t.commit();
    }
    
    public void delete(Salario s)
    {
        Transaction t = session.beginTransaction();
        session.delete(s);
        t.commit();
    }
    
    public Salario findById(int sal_codigo)
    {
        return (Salario) session.load(Salario.class, sal_codigo);
    }
    
    public List<Salario> findAll()
    {
        Query q = session.createQuery("from Salario");
        return q.list();
    }
    
    public List<Salario> findSalariosAtivos()
    {
        Query q = session.createQuery("from Salario where sal_situacao is true and sal_datafim is null");
        return q.list();
    }
}
