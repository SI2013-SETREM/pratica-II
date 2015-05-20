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
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {

    public static final String sTitle = "Avaliação";
    public static final String pTitle = "Avaliações";

    @Id
    @SequenceGenerator(name = "avaliacoes_pk_sequence", sequenceName = "avaliacoes_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "avaliacoes_pk_sequence")
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
    private Date ava_data_inicial;
    private int ava_modulo;
    private String ava_observacao;
    private Date ava_data_final;

    public Avaliacao() {
    }
}
