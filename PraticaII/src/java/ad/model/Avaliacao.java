package ad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import rs.model.Questionario;
import td.model.Treinamento;

@Entity
//@Table(name = "avaliacao")
public class Avaliacao implements Serializable {

    @Id
    @SequenceGenerator(name = "avaliacao_pk_sequence", sequenceName = "avaliacao_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "avaliacao_pk_sequence")
    private int ava_codigo;
    @ManyToOne
    @JoinColumn(name = "codtreinamento")
    private Treinamento treinamento;
//
//    @ManyToOne
//    @JoinColumn(name = "recrutamento")
//    private Recrutamento recrutamento;
//
    @ManyToOne
    @JoinColumn(name = "codquestionario")
    private Questionario questionario;

    private int ava_status;
    private String ava_nome;
    private Date ava_datahora_inicial;
    private int ava_modulo;
    private String ava_observacao;
    private Date ava_datahora_final;

    public Avaliacao() { 
    }

    public int getAva_codigo() {
        return ava_codigo;
    }

    public void setAva_codigo(int ava_codigo) {
        this.ava_codigo = ava_codigo;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public int getAva_status() {
        return ava_status;
    }

    public void setAva_status(int ava_status) {
        this.ava_status = ava_status;
    }

    public String getAva_nome() {
        return ava_nome;
    }

    public void setAva_nome(String ava_nome) {
        this.ava_nome = ava_nome;
    }

    public Date getAva_datahora_inicial() {
        return ava_datahora_inicial;
    }

    public void setAva_datahora_inicial(Date ava_datahora_inicial) {
        this.ava_datahora_inicial = ava_datahora_inicial;
    }

    public int getAva_modulo() {
        return ava_modulo;
    }

    public void setAva_modulo(int ava_modulo) {
        this.ava_modulo = ava_modulo;
    }

    public String getAva_observacao() {
        return ava_observacao;
    }

    public void setAva_observacao(String ava_observacao) {
        this.ava_observacao = ava_observacao;
    }

    public Date getAva_datahora_final() {
        return ava_datahora_final;
    }

    public void setAva_datahora_final(Date ava_datahora_final) {
        this.ava_datahora_final = ava_datahora_final;
    }
    
}
