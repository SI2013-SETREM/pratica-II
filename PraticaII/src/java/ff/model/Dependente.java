package ff.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Max
 */
@Entity
@Table(name = "ffp_dependente")
public class Dependente implements Serializable {

    @Id
    @SequenceGenerator(name = "genDependente", sequenceName = "genDependente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genDependente")
    private int dep_codigo;
    @ManyToOne
    private FichaFuncional ffu_codigo;
    private String dep_observacao;

    public int getDep_codigo() {
        return dep_codigo;
    }

    public void setDep_codigo(int dep_codigo) {
        this.dep_codigo = dep_codigo;
    }

    public String getDep_observacao() {
        return dep_observacao;
    }

    public void setDep_observacao(String dep_observacao) {
        this.dep_observacao = dep_observacao;
    }

    public FichaFuncional getFfu_codigo() {
        return ffu_codigo;
    }

    public void setFfu_codigo(FichaFuncional ffu_codigo) {
        this.ffu_codigo = ffu_codigo;
    }

}
