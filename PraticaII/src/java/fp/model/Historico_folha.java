package fp.model;

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
@SequenceGenerator(name = "genHistorico_folha", sequenceName = "genHistorico_folha", allocationSize = 1)
public class Historico_folha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genHistorico_folha")
    private int hif_codigo;
    private double hif_valor_acre;
    private double  hif_valor_desc;
    private double hif_salario_base;
    private Date hif_data;
    private double hif_valor_liquido;

}
