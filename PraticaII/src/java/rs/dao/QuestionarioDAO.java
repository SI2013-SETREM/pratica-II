
package rs.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    
    public void insert(Questionario obj) {
        System.err.println("QST INSERT");
        
        Session s = this.getSession();
        Transaction t = s.getTransaction();
        if (!t.isActive()) {
            t = s.beginTransaction();
        }
        List<Pergunta> arrPerguntas = obj.getPerguntas();
        Questionario qst = new Questionario();
        qst.setQstTitulo(obj.getQstTitulo());
        qst.setQstPontuacaototal(obj.getQstPontuacaototal());
        qst.setQstPontuacaomax(obj.getQstPontuacaomax());
        qst.setQstTipoQuestoes(arrPerguntas);
        s.save(qst);
        
        clearLevels(qst.getQstCodigo());
        saveLevels(qst, arrPerguntas);
        
        //s.refresh(obj); //Não sei se preciso disso
        
        t.commit();
        s.close();
    }
    
    public void update(Questionario obj) {
        if (obj.getQstCodigo() == 0) {
            insert(obj);
        } else {
            System.err.println("QST UPDATE");
            
            Session s = this.getSession();
            Transaction t = s.beginTransaction();
            
            List<Pergunta> arrPerguntas = obj.getPerguntas();
//            Questionario qst = findById(obj.getQstCodigo());
//            Questionario qst = new Questionario();
//            qst.setQstCodigo(obj.getQstCodigo());
//            qst.setQstTitulo(obj.getQstTitulo());
//            qst.setQstPontuacaototal(obj.getQstPontuacaototal());
//            qst.setQstPontuacaomax(obj.getQstPontuacaomax());
//            qst.setQstTipoQuestoes(arrPerguntas);
//            qst.setPerguntas(new ArrayList<Pergunta>());
            
            System.err.println("before_clearLevels");
            clearLevels(obj.getQstCodigo());
            System.err.println("after_clearLevels");
            
            // CONTINUAR FAZENDO AQUI ESTA MERDA QUE NÃO FUNCIONA CARALHO
            s.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    connection.createStatement();
                }
            });
            
            Query q = s.createSQLQuery("UPDATE rec_questionario SET qst_titulo = ?, qst_pontuacaototal = ?, qst_pontuacaomax = ?, qst_tipo_questoes = ? WHERE qst_codigo = ?");
            int pos = 0;
            q.setString(pos++, obj.getQstTitulo());
            q.setInteger(pos++, obj.getQstPontuacaototal());
            q.setInteger(pos++, obj.getQstPontuacaomax());
            q.setInteger(pos++, obj.getQstTipoQuestoes());
            q.setInteger(pos++, obj.getQstCodigo());
            q.executeUpdate();
            
            System.err.println("after_update");
            t.commit();
            System.err.println("AFTER UPDATE COMMIT");

            t = s.beginTransaction();
            
            saveLevels(obj, arrPerguntas);
            
            System.err.println("before_Close");
            t.commit();
            System.err.println("after_COMMIT");
            s.close();
        }
    }
    
    public void clearLevels(int qstCodigo) {
        Session s = this.getSession();
        
        // Limpando tudo pq o Hibernate só faz merda
        // Isso provavelmente vai dar problema, tem que revisar
        Query qPrgOpcao = s.createSQLQuery("DELETE FROM rec_pergunta_opcao WHERE qst_codigo = " + String.valueOf(qstCodigo));
        qPrgOpcao.executeUpdate();
        
        // Remove tudo antes de cadastrar de novo
        Query qPergunta = s.createSQLQuery("DELETE FROM rec_pergunta WHERE qst_codigo = " + String.valueOf(qstCodigo));
        qPergunta.executeUpdate();
        
//        System.err.println("clearLevels_beforeFlush");
//        s.flush(); // Temta dar um update nas perguntas
    }
    
    public void saveLevels(Questionario qst, List<Pergunta> arrPerguntas) {
        Session s = this.getSession();
        System.err.println("saveLevels");
        
        Collections.sort(arrPerguntas);
        
        if (arrPerguntas != null) {
            int prgOrdem = 1;
            for (Pergunta pergunta : arrPerguntas) {
                if (!"".equals(pergunta.getPrgPergunta())) {
//                    Pergunta prg = new Pergunta();
//                    prg.setQuestionario(qst);
//                    if (pergunta.getCompetencia() != null) {
//                        prg.setCompetencia(pergunta.getCompetencia());
//                    }
//                    prg.setPrgPergunta(pergunta.getPrgPergunta());
//                    prg.setPrgOrdem(pergunta.getPrgOrdem());
//                    prg.setPrgTipo(pergunta.getPrgTipo());
//                    prg.setPrgOpcaooutros(pergunta.isPrgOpcaooutros());
//                    prg.setPrgExibircandidato(pergunta.isPrgExibircandidato());
//                    prg.setPrgObrigatoria(pergunta.isPrgObrigatoria());
//                    s.save(prg);
                
                    BigInteger bi = (BigInteger) s.createSQLQuery("SELECT NEXTVAL('seq_rs_pergunta')").uniqueResult();
                    int prgCodigo = bi.intValue();

                    System.err.println("NEXT prgCodigo: " + prgCodigo);

                    Query q = s.createSQLQuery("insert into rec_pergunta (cmp_codigo, prg_exibircandidato, prg_obrigatoria, prg_opcaooutros, prg_ordem, prg_pergunta, prg_tipo, prg_codigo, qst_codigo)  values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    int pos = 0;
                    if (pergunta.getCompetencia() != null) {
                        q.setInteger(pos++, pergunta.getCompetencia().getCmp_codigo());
                    } else {
                        q.setParameter(pos++, null, IntegerType.INSTANCE);
                    }
                    q.setBoolean(pos++, pergunta.isPrgExibircandidato());
                    q.setBoolean(pos++, pergunta.isPrgObrigatoria());
                    q.setBoolean(pos++, pergunta.isPrgOpcaooutros());
                    q.setInteger(pos++, prgOrdem++);
                    q.setString(pos++, pergunta.getPrgPergunta());
                    q.setInteger(pos++, pergunta.getPrgTipo());
                    q.setInteger(pos++, prgCodigo);
                    q.setInteger(pos++, qst.getQstCodigo());

                    q.executeUpdate();
            
                    System.err.println("saveLevels_pergunta_saved: " + prgCodigo + "-" + pergunta.getPrgPergunta());
                    
                    if (pergunta.getPerguntaOpcoes() != null) {
                        int opcCodigo = 1;
                        for (PerguntaOpcao perguntaOpcao : pergunta.getPerguntaOpcoes()) {
                            
                            q = s.createSQLQuery("INSERT INTO rec_pergunta_opcao (qst_codigo, prg_codigo, opc_codigo, opc_nome, opc_descricao, opc_pontuacao)  values (?, ?, ?, ?, ?, ?)");
                            pos = 0;
                            q.setInteger(pos++, qst.getQstCodigo());
                            q.setInteger(pos++, prgCodigo);
                            q.setInteger(pos++, opcCodigo);
                            q.setString(pos++, perguntaOpcao.getOpcNome());
                            q.setString(pos++, perguntaOpcao.getOpcDescricao());
                            q.setInteger(pos++, perguntaOpcao.getOpcPontuacao());

                            q.executeUpdate();
                            
                        }
                    }
                }
            }
        }
        System.err.println("after_SaveLevels");
    }
    
    public void delete(Questionario qst) {
        Session s = this.getSession();
        Transaction t = s.beginTransaction();
        
        clearLevels(qst.getQstCodigo());
        
        s.delete(qst);
        t.commit();
    }
    
    public Questionario findById(int qst_codigo) {
        return (Questionario) this.getSession().load(Questionario.class, qst_codigo);
    }
    
    public List<Questionario> findAll() {
        Query q = this.getSession().createQuery("from Questionario");
        return q.list();
    }
    
}
