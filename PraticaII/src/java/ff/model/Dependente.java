package ff.model;

import java.io.Serializable;
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
@SequenceGenerator(name = "genDependente", sequenceName = "genDependente", allocationSize = 1)
public class Dependente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genDependente")
    private int dep_codigo;
    @ManyToOne
    private FichaFuncional ficha_funcional;
    private String dep_observacao;

    public int getDep_codigo() {
        return dep_codigo;
    }

    public void setDep_codigo(int dep_codigo) {
        this.dep_codigo = dep_codigo;
    }

    public FichaFuncional getFicha_funcional() {
        return ficha_funcional;
    }

    public void setFicha_funcional(FichaFuncional ficha_funcional) {
        this.ficha_funcional = ficha_funcional;
    }

    public String getDep_observacao() {
        return dep_observacao;
    }

    public void setDep_observacao(String dep_observacao) {
        this.dep_observacao = dep_observacao;
    }

}
