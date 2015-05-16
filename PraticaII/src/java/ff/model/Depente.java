
package ff.model;

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
@SequenceGenerator(name = "genDependente", sequenceName = "genDependente", allocationSize = 1)
public class Depente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genDependente")
    private int dep_codigo;
    private String dep_observacao;

}
