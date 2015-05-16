package fp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Max
 */
@Entity
@SequenceGenerator(name = "genSerie_evento", sequenceName = "genSerie_evento", allocationSize = 1)
public class Serie_evento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genSerie_evento")
    private int sev_codigo;
    private String sev_descricao;
    private String sev_nome;
}
