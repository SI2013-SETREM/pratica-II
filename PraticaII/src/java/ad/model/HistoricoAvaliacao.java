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
public class HistoricoAvaliacao implements Serializable {

    @Id
    @SequenceGenerator(name = "historico_avaliacao_pk_sequence", sequenceName = "historico_avaliacao_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "historico_avaliacao_pk_sequence")
    private int hav_codigo;
    private Date hav_datahora_inicio;
    private Date hav_datahora_fim;
    private double hav_valor;
    private String hav_descricao;
    @ManyToOne
    @JoinColumn(name = "codavaliacao")
    private Avaliacao avaliacao;

    public HistoricoAvaliacao() {
    }
}
