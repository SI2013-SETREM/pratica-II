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

@Entity
@Table(name = "historico_avaliacao")
public class Historico_Avaliacao implements Serializable {

    public static final String sTitle = "Histórico Avaliação";
    public static final String pTitle = "Histórico de Avaliações";

    @Id
    @SequenceGenerator(name = "historico_avaliacao_pk_sequence", sequenceName = "historico_avaliacao_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "historico_avaliacao_pk_sequence")
    private int hav_codigo;
    private Date hav_datahorainicio_avaliacao;
    private Date hav_datahorafim_avaliacao;
    private int hav_valor;
    private String hav_descricao;
    @ManyToOne
    @JoinColumn(name = "codavaliacao")
    private Avaliacao avaliacao;

    public Historico_Avaliacao() {
    }
}
