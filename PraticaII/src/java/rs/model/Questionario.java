package rs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

@Entity
@Table(name = "rec_questionario")
//@SQLInsert(sql = "INSERT INTO rec_questionario(qst_titulo,qst_pontuacaototal,qst_pontuacaomax,qst_tipo_questoes,qst_tipo,qst_codigo) VALUES (?,?,?,?,?,?)", check = ResultCheckStyle.NONE)
//@SQLUpdate(sql = "UPDATE rec_questionario SET qst_titulo=?,qst_pontuacaototal=?,qst_pontuacaomax=?,qst_tipo_questoes=?,qst_tipo=? WHERE qst_codigo=?", check = ResultCheckStyle.NONE)
public class Questionario implements Serializable {

    public static final String sTitle = "Questionário";
    public static final String pTitle = "Questionários";

    @Id
    @SequenceGenerator(name = "questionario_pk_sequence", sequenceName = "seq_rs_questionario")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "questionario_pk_sequence")
    private int qst_codigo;

    private String qst_titulo;

    /**
     * Pontuação máxima que poderá ser atingida pelo candidato. Para as questões
     * dissertativas soma o valor de qst_pontuacaomax.
     */
    private int qst_pontuacaototal;

    /**
     * Pontuação máxima para cada questão. Por padrão,
     * parametro.par_qst_pontuacaomax_padrao
     */
    private int qst_pontuacaomax;

    /**
     * 1 = Questões descritivas 2 = Questões objetivas 3 = Misto
     */
    private int qst_tipo_questoes = 1;

    /**
     * 1 = Normal 2 = Avaliação 180º 3 = Avaliação 360º
     */
    private int qst_tipo;

    @OneToMany
    @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo")
    @OrderBy(value = "prg_ordem")
    private List<Pergunta> perguntas = new ArrayList<>();

    public Questionario() {
    }

    public int getQstCodigo() {
        return qst_codigo;
    }

    public void setQstCodigo(int qst_codigo) {
        this.qst_codigo = qst_codigo;
    }

    public String getQstTitulo() {
        return qst_titulo;
    }

    public void setQstTitulo(String qst_titulo) {
        this.qst_titulo = qst_titulo;
    }

    public int getQstPontuacaototal() {
        return qst_pontuacaototal;
    }

    public void setQstPontuacaototal(int qst_pontuacaototal) {
        this.qst_pontuacaototal = qst_pontuacaototal;
    }

    public int getQstPontuacaomax() {
        if (qst_codigo == 0) {
            qst_pontuacaomax = 20;
        }
        return qst_pontuacaomax;
    }

    public void setQstPontuacaomax(int qst_pontuacaomax) {
        this.qst_pontuacaomax = qst_pontuacaomax;
    }

    public int getQstTipoQuestoes() {
        return qst_tipo_questoes;
    }

    public void setQstTipoQuestoes(int qst_tipo_questoes) {
        this.qst_tipo_questoes = qst_tipo_questoes;
    }

    public void setQstTipoQuestoes(ArrayList<Pergunta> perguntas) {
        int qst_tipo_questoes = 0;
        for (Pergunta pergunta : perguntas) {
            switch (pergunta.getPrgTipo()) {
                case 1: //Descritiva
                    if (qst_tipo_questoes == 2) { //Objetivas
                        qst_tipo_questoes = 3; //Misto
                    } else {
                        qst_tipo_questoes = 1; //Descritivas
                    }
                    break;
                case 2: //Objetiva
                    if (qst_tipo_questoes == 1) { //Descritivas
                        qst_tipo_questoes = 3; //Misto
                    } else {
                        qst_tipo_questoes = 2; //Objetivas
                    }
                    break;
            }
            if (qst_tipo_questoes == 3) { //Misto
                break;
            }
        }
        this.qst_tipo_questoes = qst_tipo_questoes;
    }

    public int getQstTipo() {
        return qst_tipo;
    }

    public String getQstTipoDsc(int qst_tipo) {
        String r = "";
        switch (qst_tipo) {
            case 1:
                r = "Normal";
                break;
            case 2:
                r = "Avaliação 180º";
                break;
            case 3:
                r = "Avaliação 360º";
                break;
        }
        return r;
    }

    public String getQstTipoDsc() {
        return this.getQstTipoDsc(this.qst_tipo);
    }

    public void setQstTipo(int qst_tipo) {
        this.qst_tipo = qst_tipo;
    }

    public List<Pergunta> getPerguntas() {
//        if (perguntas.size() > 1) {
//            Collections.sort(perguntas);
//        }
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        if (perguntas.size() > 1) {
            Collections.sort(perguntas);
        }
        this.perguntas = perguntas;
    }

    public void addPergunta() {
        List<Pergunta> arrPerguntas = this.getPerguntas();
        if (arrPerguntas == null) {
            this.perguntas = new ArrayList<>();
            arrPerguntas = this.perguntas;
        }
        Pergunta p = new Pergunta();
        p.setPrgOrdem(arrPerguntas.size() + 1);
        if (this.qst_tipo_questoes == 1 || this.qst_tipo_questoes == 2) {
            p.setPrgTipo(qst_tipo_questoes);
        }
        arrPerguntas.add(p);
        this.perguntas = arrPerguntas;
    }

    public void delPergunta(Pergunta p) {
        int prgOrdem = p.getPrgOrdem();
        this.perguntas.remove(p);
        List<Pergunta> arrPerguntas = this.getPerguntas();
        for (int i = 0; i < arrPerguntas.size(); i++) {
            Pergunta pergunta = arrPerguntas.get(i);
            if (pergunta.getPrgOrdem() > prgOrdem) {
                pergunta.setPrgOrdem(pergunta.getPrgOrdem() - 1);
            }
        }
    }

    public void moveUpPergunta(Pergunta p) {
        int prgOrdem = p.getPrgOrdem();
        List<Pergunta> arrPerguntas = this.getPerguntas();
        for (int i = 0; i < arrPerguntas.size(); i++) {
            Pergunta pergunta = arrPerguntas.get(i);
            if (pergunta.getPrgOrdem() == prgOrdem) {
                pergunta.setPrgOrdem(prgOrdem - 1);
            } else if (pergunta.getPrgOrdem() == (prgOrdem - 1)) {
                pergunta.setPrgOrdem(prgOrdem);
            }
        }
//        Collections.sort(perguntas);
    }

    public void moveDownPergunta(Pergunta p) {
        int prgOrdem = p.getPrgOrdem();
        List<Pergunta> arrPerguntas = this.getPerguntas();
        for (int i = 0; i < arrPerguntas.size(); i++) {
            Pergunta pergunta = arrPerguntas.get(i);
            if (pergunta.getPrgOrdem() == prgOrdem) {
                pergunta.setPrgOrdem(prgOrdem + 1);
            } else if (pergunta.getPrgOrdem() == (prgOrdem + 1)) {
                pergunta.setPrgOrdem(prgOrdem);
            }
        }
//        Collections.sort(perguntas);
    }

    public void addPerguntaOpcao(Pergunta p) {
//        Pergunta pergunta = this.perguntas.get(this.perguntas.indexOf(p));
//        pergunta.addPerguntaOpcao();
        this.perguntas.get(this.perguntas.indexOf(p)).addPerguntaOpcao();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.qst_codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questionario other = (Questionario) obj;
        if (this.qst_codigo != other.qst_codigo) {
            return false;
        }
        return true;
    }

}
