
package rs.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="rec_questionario")
public class Questionario implements Serializable {
    
    public static final String sTitle = "Questionário";
    public static final String pTitle = "Questionários";
    
    @Id
    @SequenceGenerator(name="questionario_pk_sequence", sequenceName="seq_rs_questionario")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="questionario_pk_sequence")
    private int qst_codigo;
    private String qst_titulo;
    private int qst_pontuacaototal;
    private int qst_tipo;
    private int qst_pontuacaomax;

    @OneToMany
    @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo")
    private List<Pergunta> perguntas;
    
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

    public int getQstTipo() {
        return qst_tipo;
    }
    
    public String getQstTipoDsc() {
        String r = "";
        switch(qst_tipo) {
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

    public void setQstTipo(int qst_tipo) {
        this.qst_tipo = qst_tipo;
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

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
    
}
