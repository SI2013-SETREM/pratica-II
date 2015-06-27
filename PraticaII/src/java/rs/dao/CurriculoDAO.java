
package rs.dao;

import cfg.model.Pessoa;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rs.model.PessoaCompetencia;
import rs.model.PessoaExperiencia;
import rs.model.PessoaFormacao;
import rs.model.PessoaIdioma;
import rs.model.PessoaRedeSocial;
import util.HibernateUtil;

public class CurriculoDAO {

    private Session session;

    public CurriculoDAO() {
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }
    
    public void update(Pessoa pessoa) {
        pessoa.setPes_cur_dataatualizado(new Date());
        updateObj(pessoa);
    }

    public void delete(Pessoa pessoa) {
        pessoa.setPes_cur_resumo(null);
        pessoa.setPes_cur_pretensaosalarial(null);
        pessoa.setPes_cur_dataatualizado(null);
        this.update(pessoa);
    }
    
    public void insertObj(Object obj) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().merge(obj);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }
    
    public void updateObj(Object obj) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().merge(obj);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }
    
    public void deleteObj(Object model) {
        try {
            Transaction t = getSession().beginTransaction();
            try {
                getSession().delete(model);
                t.commit();
            } catch (Exception ex) {
                t.rollback();
                throw ex;
            }
        } finally {
            getSession().close();
        }
    }

    public List<Pessoa> findAll() {
        Query q = getSession().createQuery("from Pessoa");
        return q.list();
    }

    public List<PessoaFormacao> findFormacoes(int pes_codigo) {
        Query q = getSession().createQuery("from PessoaFormacao where pessoa = " + String.valueOf(pes_codigo));
        return q.list();
    }

    public List<PessoaExperiencia> findExperiencias(int pes_codigo) {
        Query q = getSession().createQuery("from PessoaExperiencia where pessoa = " + String.valueOf(pes_codigo));
        return q.list();
    }

    public List<PessoaIdioma> findIdiomas(int pes_codigo) {
        Query q = getSession().createQuery("from PessoaIdioma where pessoa = " + String.valueOf(pes_codigo));
        return q.list();
    }

    public List<PessoaCompetencia> findCompetencias(int pes_codigo) {
        Query q = getSession().createQuery("from PessoaCompetencia where pessoa = " + String.valueOf(pes_codigo));
        return q.list();
    }

    public List<PessoaRedeSocial> findRedesSociais(int pes_codigo) {
        Query q = getSession().createQuery("from PessoaRedeSocial where pessoa = " + String.valueOf(pes_codigo));
        return q.list();
    }

}
