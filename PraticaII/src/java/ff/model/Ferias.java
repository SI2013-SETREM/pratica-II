package ff.model;

import java.io.Serializable;
import java.util.Date;
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
@SequenceGenerator(name = "genFerias", sequenceName = "genFerias", allocationSize = 1)
public class Ferias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genFerias")
    private int fer_codigo;
    private Date fer_data_inicio;
    private Date fer_data_fim;
    private String fer_observacao;
}