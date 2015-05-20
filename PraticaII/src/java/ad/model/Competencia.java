package ad.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "competencia")
public class Competencia implements Serializable {

    @Id
    @SequenceGenerator(name = "competencias_pk_sequence", sequenceName = "competencias_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "competencias_pk_sequence")
    private int cmp_codigo;
    private String cmp_descricao;
    private int cmp_status;
    @ManyToOne
    @JoinColumn(name = "codtipocompetencia")
    private TipoCompetencia tipocompetencia;

    public Competencia() {
    }
}
