
package rs.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.dao.PerguntaDAO;
import rs.dao.PerguntaOpcaoDAO;
import rs.dao.QuestionarioDAO;
import rs.model.Pergunta;
import rs.model.PerguntaOpcao;
import rs.model.Questionario;

@ManagedBean
@SessionScoped
public class QuestionarioBean {
    
    private final String sTitle = Questionario.sTitle;
    private final String pTitle = Questionario.pTitle;
    
    private Questionario questionario = new Questionario();
    private QuestionarioDAO dao = new QuestionarioDAO();
    private PerguntaDAO daoPrg = new PerguntaDAO();
    private PerguntaOpcaoDAO daoPrgOpc = new PerguntaOpcaoDAO();
    private DataModel questionarios;
    
//    private List<Pergunta> arrPerguntas;

    public QuestionarioDAO getDao() {
        return dao;
    }

    public void setDao(QuestionarioDAO dao) {
        this.dao = dao;
    }

//    public List<Pergunta> getArrPerguntas() {
//        return arrPerguntas;
//    }
//
//    public void setArrPerguntas(List<Pergunta> arrPerguntas) {
////        if (arrPerguntas != null) {
////            Collections.sort(arrPerguntas);
////        }
//        this.arrPerguntas = arrPerguntas;
//    }

    public QuestionarioBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public DataModel getQuestionarios() {
        this.questionarios = new ListDataModel(dao.findAll());
        return questionarios;
    }

    public void setQuestionarios(DataModel questionarios) {
        this.questionarios = questionarios;
    }
    
    public String novo() {
        this.questionario = new Questionario();
//        this.arrPerguntas = null;
        return "questionariofrm?faces-redirect=true";
    }
    
    public String edit(Questionario obj) {
//        questionario = (Questionario) questionarios.getRowData();
//        questionario = dao.findById(questionario.getQstCodigo());
        questionario = obj;
//        arrPerguntas = questionario.getPerguntas();
        return "questionariofrm?faces-redirect=true";
    }
    
    public String delete(Questionario obj) {
        dao.delete(obj);
        return "questionariolst?faces-redirect=true";
    }
    
    public String salvar() {
//        questionario.setPerguntas(getArrPerguntas());
        if (questionario.getQstCodigo() > 0) {
            dao.update(questionario);
        } else {
            this.insert();
        }
        return "questionariolst?faces-redirect=true";
    }
    
    // TENTAR ISTO http://stackoverflow.com/a/18518859/3136474
    public void insert() {
        dao.insert(questionario);
        
//        Questionario qst = new Questionario();
//        qst.setQstTitulo(questionario.getQstTitulo());
//        qst.setQstPontuacaototal(questionario.getQstPontuacaototal());
//        qst.setQstPontuacaomax(questionario.getQstPontuacaomax());
//        qst.setQstTipoQuestoes(questionario.getQstTipoQuestoes());
//        dao.insert(qst);
//        
//        List<Pergunta> arrPerguntas = questionario.getPerguntas();
//        if (arrPerguntas != null) {
//            Collections.sort(arrPerguntas);
//            int prgOrdem = 1;
//            for (Pergunta pergunta : arrPerguntas) {
//                if (!"".equals(pergunta.getPrgPergunta())) {
//                    pergunta.setQuestionario(questionario);
//                    pergunta.setPrgOrdem(prgOrdem++);
//                    daoPrg.insert(pergunta);
//                    
//                    if (pergunta.getPerguntaOpcoes() != null) {
//                        int opcCodigo = 1;
//                        for (PerguntaOpcao perguntaOpcao : pergunta.getPerguntaOpcoes()) {
////                            perguntaOpcao.setPergunta(pergunta);
//                            perguntaOpcao.setOpcCodigo(opcCodigo);
//                            daoPrgOpc.insert(perguntaOpcao);
//                        }
//                    }
//                }
//            }
//        }
    }
    
    public String listar() {
        return "questionariolst?faces-redirect=true";
    }
    
    public void addPergunta() {
//        if (arrPerguntas == null) {
//            arrPerguntas = new ArrayList<>();
//        }
//        Pergunta p = new Pergunta();
//        p.setPrgOrdem(arrPerguntas.size()+1);
//        if (questionario.getQstTipoQuestoes() == 1 || questionario.getQstTipoQuestoes() == 2) {
//            p.setPrgTipo(questionario.getQstTipoQuestoes());
//        }
//        this.arrPerguntas.add(p);
        this.questionario.addPergunta();
    }
    
    public void delPergunta(Pergunta p) {
        this.questionario.delPergunta(p);
    }
//    public void delPergunta(int prgCodigo, int prgOrdem) {
//        this.questionario.delPergunta(prgCodigo, prgOrdem);
//    }
    
    public void savePergunta(Pergunta p) {
        List<Pergunta> arrPerguntas = this.questionario.getPerguntas();
        if (arrPerguntas != null) {
            int idx = arrPerguntas.indexOf(p);
            arrPerguntas.set(idx, p);
            this.questionario.setPerguntas(arrPerguntas);
        }
    }
    
    public void moveUpPergunta(Pergunta p) {
        this.questionario.moveUpPergunta(p);
    }
    
    public void moveDownPergunta(Pergunta p) {
        this.questionario.moveDownPergunta(p);
    }
    
    public void addPerguntaOpcao(Pergunta p) {
        p.addPerguntaOpcao();
    }
    
    public void delPerguntaOpcao(PerguntaOpcao po) {
        po.getPergunta();
    }
    
}
