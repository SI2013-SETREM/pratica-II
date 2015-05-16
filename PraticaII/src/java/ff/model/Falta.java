package ff.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.crypto.Data;

/**
 *
 * @author Max
 */
@Entity
@SequenceGenerator(name = "genFalta", sequenceName = "genFalta", allocationSize = 1)
public class Falta implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genFerias")
    private int flt_codigo;
    private Data flt_data;
    private double flt_qtd_horas;
    private String observacao;
    private String flt_justificativa;
}
