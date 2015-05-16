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
@SequenceGenerator(name = "genAdvertencia", sequenceName = "genAdvertencia", allocationSize = 1)
public class Advertencia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genAdvertencia")
    private int adv_codigo;
    private String adv_descricao;
    private Date adv_data;
    private String adv_observacao;
    private String adv_motivo;
    private String adv_advertencia;
}
