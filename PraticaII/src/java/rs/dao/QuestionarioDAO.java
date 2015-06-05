
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
        
        for (Pergunta pergunta : arrPerguntas) {
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
            
            for (PerguntaOpcao perguntaOpcao : pergunta.getPerguntaOpcoes()) {
                PerguntaOpcao prgOpc = new PerguntaOpcao();
                prgOpc.setOpcNome(perguntaOpcao.getOpcNome());
                prgOpc.setOpcDescricao(perguntaOpcao.getOpcDescricao());
                prgOpc.setOpcPontuacao(perguntaOpcao.getOpcPontuacao());
                
                s.save(prgOpc);
            }
        }
        
        //s.refresh(obj); //Não sei se preciso disso
        
        t.commit();
        s.close();
    }
    
    public void update(Questionario obj) {
        Session s = this.getSession();
        Transaction t = s.getTransaction();
        if (!t.isActive()) {
            t = s.beginTransaction();
        }
//        for (int i = 0; i < obj.getPerguntas().size(); i++) {
//            Pergunta p = obj.getPerguntas().get(i);
//            if (p.getPrgCodigo() > 0) {
//                s.merge(p);
//            } else {
//                s.save(p);
//            }
//        }
        s.merge(obj);
        s.flush();
        t.commit();
        s.close();
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
