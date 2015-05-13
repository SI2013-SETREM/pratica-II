package ad.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="avaliacoes")
public class Avaliacao implements Serializable {
    
    public static final String sTitle = "Avaliação";
    public static final String pTitle = "Avaliações";
    
    @Id
    @SequenceGenerator(name="avaliacoes_pk_sequence", sequenceName="avaliacoes_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="avaliacoes_pk_sequence")
    private int ava_codigo;
    private String ava_nome;
    private String ava_observacao;

    public Avaliacao() {
    }

    public int getAva_codigo() {
        return ava_codigo;
    }

    public void setAva_codigo(int ava_codigo) {
        this.ava_codigo = ava_codigo;
    }

    public String getAva_nome() {
        return ava_nome;
    }

    public void setAva_nome(String ava_nome) {
        this.ava_nome = ava_nome;
    }

    public String getAva_observacao() {
        return ava_observacao;
    }

    public void setAva_observacao(String ava_observacao) {
        this.ava_observacao = ava_observacao;
    }


    
}