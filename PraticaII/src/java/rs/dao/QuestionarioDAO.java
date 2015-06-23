
package rs.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.type.IntegerType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import rs.model.Pergunta;
import rs.model.PerguntaOpcao;
import rs.model.Questionario;
import util.HibernateUtil;
import util.Utilidades;

public class QuestionarioDAO {
    private Session session;

    public QuestionarioDAO() {
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }
    
    public void delete(Questionario qst) {
        Session s = this.getSession();
        Utilidades.setSession(s);
        Transaction t = s.beginTransaction();
//        clearLevels(qst.getQstCodigo());
//        
//        try {
//            String sql = "DELETE FROM rec_questionario WHERE qst_codigo = ?";
//            System.err.println("SQL: " + sql);
//            Utilidades.executeUpdate(sql, new Object[]{qst.getQstCodigo()});
//        } catch (SQLException ex) {
//            System.err.println("ERRO: " + ex.toString());
//            Logger.getLogger(QuestionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        s.delete(qst);
        t.commit();
    }
    
    public void insert(Questionario qst) {
//        System.err.println("QST INSERT");
        
        Session s = this.getSession();
        Transaction t = s.getTransaction();
        if (!t.isActive()) {
            t = s.beginTransaction();
        }
        
        
        Questionario newQst = new Questionario();
        newQst.setQstTitulo(qst.getQstTitulo());
        newQst.setQstPontuacaototal(qst.getQstPontuacaototal());
        newQst.setQstPontuacaomax(qst.getQstPontuacaomax());
        newQst.setQstTipoQuestoes(qst.getQstTipoQuestoes());
        s.save(newQst);
        
        List<Pergunta> arrPerguntas = qst.getPerguntas();
        if (arrPerguntas != null) {
            Collections.sort(arrPerguntas);
            int prgOrdem = 1;
            for (Pergunta pergunta : arrPerguntas) {
                if (!"".equals(pergunta.getPrgPergunta())) {
                    Pergunta p = new Pergunta();
                    p.setPrgCodigo(prgOrdem);
                    p.setPrgPergunta(pergunta.getPrgPergunta());
                    p.setPrgTipo(pergunta.getPrgTipo());
                    p.setPrgOrdem(prgOrdem);
                    p.setPrgExibircandidato(pergunta.isPrgExibircandidato());
                    p.setPrgObrigatoria(pergunta.isPrgObrigatoria());
                    p.setPrgOpcaooutros(pergunta.isPrgOpcaooutros());
                    p.setQuestionario(newQst);
                    s.save(p);
                    prgOrdem++;
                    
                    if (pergunta.getPerguntaOpcoes() != null) {
                        int opcCodigo = 1;
                        for (PerguntaOpcao perguntaOpcao : pergunta.getPerguntaOpcoes()) {
                            PerguntaOpcao po = new PerguntaOpcao();
                            po.setOpcCodigo(opcCodigo);
                            po.setOpcNome(perguntaOpcao.getOpcNome());
                            po.setOpcDescricao(perguntaOpcao.getOpcDescricao());
                            po.setOpcPontuacao(perguntaOpcao.getOpcPontuacao());
                            po.setPergunta(p);
                            s.save(po);
                            
                            opcCodigo++;
//                            if (p.getPerguntaOpcoes() == null) {
//                                p.setPerguntaOpcoes(new ArrayList<PerguntaOpcao>());
//                            }
//                            p.getPerguntaOpcoes().add(po);
                        }
                    }
                    
//                    if (newQst.getPerguntas() == null) {
//                        newQst.setPerguntas(new ArrayList<Pergunta>());
//                    }
//                    newQst.getPerguntas().add(p);
                }
            }
        }
        
//        List<Pergunta> arrPerguntas = obj.getPerguntas();
//        if (arrPerguntas != null) {
//            Collections.sort(arrPerguntas);
//            int prgOrdem = 1;
//            for (Pergunta pergunta : arrPerguntas) {
//                if (!"".equals(pergunta.getPrgPergunta())) {
//
//                    
//                    if (pergunta.getPerguntaOpcoes() != null) {
//                        int opcCodigo = 1;
//                        for (PerguntaOpcao perguntaOpcao : pergunta.getPerguntaOpcoes()) {
//                            
//                            
//                        }
//                    }
//                }
//            }
//        }
        
//        s.save(obj);
        
        t.commit();
        
//        clearLevels(qst.getQstCodigo());
//        saveLevels(qst, arrPerguntas);
        
        //s.refresh(obj); //Não sei se preciso disso
        
        s.close();
    }
    
    public void update(Questionario obj) {
        if (obj.getQstCodigo() == 0) {
            insert(obj);
        } else {
            System.err.println("QST UPDATE");
            
            Session s = this.getSession();
//            Utilidades.setSession(s);
            Transaction t = s.beginTransaction();
            
//            List<Pergunta> arrPerguntas = obj.getPerguntas();
            
            System.err.println("before_clearLevels");
//            clearLevels(obj.getQstCodigo());
            System.err.println("after_clearLevels");
            
            s.merge(obj);
            
//            try {
//                String sql = "UPDATE rec_questionario SET qst_titulo = ?, qst_pontuacaototal = ?, qst_pontuacaomax = ?, qst_tipo_questoes = ? WHERE qst_codigo = ?";
//                System.err.println("SQL: " + sql);
//                Utilidades.executeUpdate(sql, new Object[]{obj.getQstTitulo(), obj.getQstPontuacaototal(), obj.getQstPontuacaomax(), obj.getQstTipoQuestoes(), obj.getQstCodigo()});
//            } catch (SQLException ex) {
//                System.err.println("ERRO: " + ex.toString());
//                Logger.getLogger(QuestionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
            
            System.err.println("after_update");
            t.commit();
            System.err.println("AFTER UPDATE COMMIT");

//            t = s.beginTransaction();
            
//            saveLevels(obj, arrPerguntas);
            
            System.err.println("before_Close");
//            t.commit();
            System.err.println("after_COMMIT");
            s.close();
        }
    }
    
//    public void clearLevels(int qstCodigo) {
////        Session s = this.getSession();
//        
//        // Limpando tudo pq o Hibernate só faz merda
//        // Isso provavelmente vai dar problema, tem que revisar
//        try {
//            String sql = "DELETE FROM rec_pergunta_opcao WHERE qst_codigo = ?";
//            System.err.println("SQL: " + sql);
//            Utilidades.executeUpdate(sql, new Object[]{qstCodigo});
//            
//            sql = "DELETE FROM rec_pergunta WHERE qst_codigo = ?";
//            System.err.println("SQL: " + sql);
//            Utilidades.executeUpdate(sql, new Object[]{qstCodigo});
//        } catch (SQLException ex) {
//            System.err.println("ERRO: " + ex.toString());
//            Logger.getLogger(QuestionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
////        System.err.println("clearLevels_beforeFlush");
////        s.flush(); // Temta dar um update nas perguntas
//    }
    
//    public void saveLevels(Questionario qst, List<Pergunta> arrPerguntas) {
//        Session s = this.getSession();
//        System.err.println("saveLevels");
//        
//        Collections.sort(arrPerguntas);
//        
//        if (arrPerguntas != null) {
//            int prgOrdem = 1;
//            for (Pergunta pergunta : arrPerguntas) {
//                if (!"".equals(pergunta.getPrgPergunta())) {
////                    Pergunta prg = new Pergunta();
////                    prg.setQuestionario(qst);
////                    if (pergunta.getCompetencia() != null) {
////                        prg.setCompetencia(pergunta.getCompetencia());
////                    }
////                    prg.setPrgPergunta(pergunta.getPrgPergunta());
////                    prg.setPrgOrdem(pergunta.getPrgOrdem());
////                    prg.setPrgTipo(pergunta.getPrgTipo());
////                    prg.setPrgOpcaooutros(pergunta.isPrgOpcaooutros());
////                    prg.setPrgExibircandidato(pergunta.isPrgExibircandidato());
////                    prg.setPrgObrigatoria(pergunta.isPrgObrigatoria());
////                    s.save(prg);
//                    
//                    BigInteger bi = (BigInteger) s.createSQLQuery("SELECT NEXTVAL('seq_rs_pergunta')").uniqueResult();
//                    int prgCodigo = bi.intValue();
//
//                    System.err.println("NEXT prgCodigo: " + prgCodigo);
//
//                    String sql = "insert into rec_pergunta (cmp_codigo, prg_exibircandidato, prg_obrigatoria, prg_opcaooutros, prg_ordem, prg_pergunta, prg_tipo, prg_codigo, qst_codigo)  values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//                    System.err.println("SQL: " + sql);
//
//                    try {
//                        Utilidades.executeUpdate(sql, new Object[]{
//                            pergunta.getCompetencia() == null ? null : pergunta.getCompetencia().getCmp_codigo(),
//                            pergunta.isPrgExibircandidato(),
//                            pergunta.isPrgObrigatoria(),
//                            pergunta.isPrgOpcaooutros(),
//                            prgOrdem++,
//                            pergunta.getPrgPergunta(),
//                            pergunta.getPrgTipo(),
//                            prgCodigo,
//                            qst.getQstCodigo()
//                        });
//                    } catch (SQLException ex) {
//                        System.err.println("ERRO: " + ex.toString());
//                        Logger.getLogger(QuestionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    
////                    Query q = s.createSQLQuery(sql);
////                    int pos = 0;
////                    if (pergunta.getCompetencia() != null) {
////                        q.setInteger(pos++, pergunta.getCompetencia().getCmp_codigo());
////                    } else {
////                        q.setParameter(pos++, null, IntegerType.INSTANCE);
////                    }
////                    q.setBoolean(pos++, pergunta.isPrgExibircandidato());
////                    q.setBoolean(pos++, pergunta.isPrgObrigatoria());
////                    q.setBoolean(pos++, pergunta.isPrgOpcaooutros());
////                    q.setInteger(pos++, prgOrdem++);
////                    q.setString(pos++, pergunta.getPrgPergunta());
////                    q.setInteger(pos++, pergunta.getPrgTipo());
////                    q.setInteger(pos++, prgCodigo);
////                    q.setInteger(pos++, qst.getQstCodigo());
////                    q.executeUpdate();
//            
//                    System.err.println("saveLevels_pergunta_saved: " + prgCodigo + "-" + pergunta.getPrgPergunta());
//                    
//                    if (pergunta.getPerguntaOpcoes() != null) {
//                        int opcCodigo = 1;
//                        for (PerguntaOpcao perguntaOpcao : pergunta.getPerguntaOpcoes()) {
//                            
//                            sql = "INSERT INTO rec_pergunta_opcao (qst_codigo, prg_codigo, opc_codigo, opc_nome, opc_descricao, opc_pontuacao) values (?, ?, ?, ?, ?, ?)";
//                            System.err.println("SQL: " + sql);
//                            try {
//                                Utilidades.executeUpdate(sql, new Object[]{
//                                    qst.getQstCodigo(),
//                                    prgCodigo,
//                                    opcCodigo,
//                                    perguntaOpcao.getOpcNome(),
//                                    perguntaOpcao.getOpcDescricao(),
//                                    perguntaOpcao.getOpcPontuacao()
//                                });
//                            } catch (SQLException ex) {
//                                System.err.println("ERRO: " + ex.toString());
//                                Logger.getLogger(QuestionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            
////                            q = s.createSQLQuery(sql);
////                            pos = 0;
////                            q.setInteger(pos++, qst.getQstCodigo());
////                            q.setInteger(pos++, prgCodigo);
////                            q.setInteger(pos++, opcCodigo);
////                            q.setString(pos++, perguntaOpcao.getOpcNome());
////                            q.setString(pos++, perguntaOpcao.getOpcDescricao());
////                            q.setInteger(pos++, perguntaOpcao.getOpcPontuacao());
////                            q.executeUpdate();
//                            
//                        }
//                    }
//                }
//            }
//        }
//        System.err.println("after_SaveLevels");
//    }
    
    public Questionario findById(int qst_codigo) {
        return (Questionario) this.getSession().load(Questionario.class, qst_codigo);
    }
    
    public List<Questionario> findAll() {
        Query q = this.getSession().createQuery("from Questionario");
        return q.list();
    }
    
}
