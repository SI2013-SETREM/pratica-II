
package rs.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="rec_questionario")
public class Questionario implements Serializable {
    
    public static final String sTitle = "Questionário";
    public static final String pTitle = "Questionários";
    
    @Id
    @SequenceGenerator(name="questionario_pk_sequence", sequenceName="questionario_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="questionario_pk_sequence")
    private int qst_codigo;
    private String qst_titulo;
    private int qst_pontuacaototal;
    private int qst_tipo;
    private int qst_pontuacaomax;

    public Questionario() {
    }

    public int getQst_codigo() {
        return qst_codigo;
    }

    public void setQst_codigo(int qst_codigo) {
        this.qst_codigo = qst_codigo;
    }

    public String getQst_titulo() {
        return qst_titulo;
    }

    public void setQst_titulo(String qst_titulo) {
        this.qst_titulo = qst_titulo;
    }

    public int getQst_pontuacaototal() {
        return qst_pontuacaototal;
    }

    public void setQst_pontuacaototal(int qst_pontuacaototal) {
        this.qst_pontuacaototal = qst_pontuacaototal;
    }

    public int getQst_tipo() {
        return qst_tipo;
    }

    public void setQst_tipo(int qst_tipo) {
        this.qst_tipo = qst_tipo;
    }

    public int getQst_pontuacaomax() {
        return qst_pontuacaomax;
    }

    public void setQst_pontuacaomax(int qst_pontuacaomax) {
        this.qst_pontuacaomax = qst_pontuacaomax;
    }
    
    
}
