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
public class Historico_avaliacao implements Serializable {

    @Id
    @SequenceGenerator(name = "historico_avaliacao_pk_sequence", sequenceName = "historico_avaliacao_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "historico_avaliacao_pk_sequence")
    private int hia_codigo;
    private Date hia_datahora_inicio;
    private Date hia_datahora_fim;
    private double hia_valor;
    private String hia_descricao;
    @ManyToOne
    @JoinColumn(name = "codavaliacao")
    private Avaliacao avaliacao;

    public Historico_avaliacao() {
    }
}
