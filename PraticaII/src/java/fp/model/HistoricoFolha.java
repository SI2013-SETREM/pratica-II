package fp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Max
 */
@Entity
@SequenceGenerator(name = "genHistoricoFolha", sequenceName = "genHistoricoFolha", allocationSize = 1)
public class HistoricoFolha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genHistoricoFolha")
    private int hif_codigo;
    //@ManyToOne
    //private Pessoa pessoa;
    private double hif_valor_acre;
    private double hif_valor_desc;
    @Column(nullable = false)
    private double hif_salario_base;
    @Column(nullable = false)
    private Date hif_data;
    @Column(nullable = false)
    private double hif_valor_liquido;
    
    

}
