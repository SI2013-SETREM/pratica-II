
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
@SequenceGenerator(name = "genFicha_funcional", sequenceName = "genFicha_funcional", allocationSize = 1)
public class Ficha_funcional implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genFicha_funcional")
    private int ffu_codigo;
    private int ffp_situacao_ficha;
    private Date ffp_data_adimissao;
    private Date ffp_data_desligamento;
}
