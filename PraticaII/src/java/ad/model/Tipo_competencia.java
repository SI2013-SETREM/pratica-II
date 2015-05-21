package ad.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Table(name = "tipo_competencias")
public class Tipo_competencia implements Serializable {

    @Id
    @SequenceGenerator(name = "tipo_competencias_pk_sequence", sequenceName = "tipo_competencias_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tipo_competencias_pk_sequence")
    private int tcp_codigo;
    private String tcp_descricao;

    public Tipo_competencia() {

    }
}
