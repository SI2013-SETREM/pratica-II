
package rs.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
        Session s = this.getSession();
        Transaction t = s.getTransaction();
        if (!t.isActive()) {
            t = s.beginTransaction();
        }
        ArrayList<Pergunta> arrPerguntas = (ArrayList<Pergunta>) obj.getPerguntas();
        Questionario qst = new Questionario();
        qst.setQstTitulo(obj.getQstTitulo());
        qst.setQstPontuacaototal(obj.getQstPontuacaototal());
        qst.setQstPontuacaomax(obj.getQstPontuacaomax());
        qst.setQstTipoQuestoes(arrPerguntas);
        qst.setQstTipo(obj.getQstTipo());
        s.save(qst);
        
        saveLevels(qst, arrPerguntas);
        
        //s.refresh(obj); //Não sei se preciso disso
        
        t.commit();
        s.close();
    }
    
    public void update(Questionario obj) {
        if (obj.getQstCodigo() == 0) {
            insert(obj);
        } else {
            Session s = this.getSession();
            Transaction t = s.getTransaction();
            if (!t.isActive()) {
                t = s.beginTransaction();
            }
            
            ArrayList<Pergunta> arrPerguntas = (ArrayList<Pergunta>) obj.getPerguntas();
            Questionario qst = findById(obj.getQstCodigo());
            qst.setQstTitulo(obj.getQstTitulo());
            qst.setQstPontuacaototal(obj.getQstPontuacaototal());
            qst.setQstPontuacaomax(obj.getQstPontuacaomax());
            qst.setQstTipoQuestoes(arrPerguntas);
            qst.setQstTipo(obj.getQstTipo());
            s.merge(obj);
            
            saveLevels(qst, arrPerguntas);
            
            //s.flush(); //Não sei se preciso disso
            
            t.commit();
            s.close();
        }
    }
    
    public void saveLevels(Questionario qst, ArrayList<Pergunta> arrPerguntas) {
        Session s = this.getSession();
        
        // Remove as peguntas antes de cadastrar de novo
        Query qPergunta = s.createQuery("DELETE FROM Pergunta WHERE Pergunta.questionario.qst_codigo = " + String.valueOf(qst.getQstCodigo()));
        qPergunta.executeUpdate();
        
        for (Pergunta pergunta : arrPerguntas) {
            if (!"".equals(pergunta.getPrgPergunta())) {
                Pergunta prg = new Pergunta();
                prg.setQuestionario(qst);
                if (pergunta.getCompetencia() != null) {
                    prg.setCompetencia(pergunta.getCompetencia());
                }
                prg.setPrgPergunta(pergunta.getPrgPergunta());
                prg.setPrgOrdem(pergunta.getPrgOrdem());
                prg.setPrgTipo(pergunta.getPrgTipo());
                prg.setPrgOpcaooutros(pergunta.isPrgOpcaooutros());
                prg.setPrgExibircandidato(pergunta.isPrgExibircandidato());
                prg.setPrgObrigatoria(pergunta.isPrgObrigatoria());
                s.save(prg);

                // Isso provavelmente vai dar problema, tem que revisar
                Query qPrgOpcao = s.createQuery("DELETE FROM PerguntaOpcao po WHERE po.qst_codigo = :qst AND po.prg_codigo = :prg");
                qPrgOpcao.setParameter("qst", pergunta.getQuestionario().getQstCodigo());
                qPrgOpcao.setParameter("prg", pergunta.getPrgCodigo());
                qPrgOpcao.executeUpdate();

                for (PerguntaOpcao perguntaOpcao : pergunta.getPerguntaOpcoes()) {
                    PerguntaOpcao prgOpc = new PerguntaOpcao();
                    prgOpc.setOpcNome(perguntaOpcao.getOpcNome());
                    prgOpc.setOpcDescricao(perguntaOpcao.getOpcDescricao());
                    prgOpc.setOpcPontuacao(perguntaOpcao.getOpcPontuacao());

                    s.save(prgOpc);
                }
            }
        }
    }
    
    public void delete(Questionario obj) {
        Session s = this.getSession();
        Transaction t = s.beginTransaction();
        s.delete(obj);
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
