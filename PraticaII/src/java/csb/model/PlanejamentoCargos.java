package csb.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_planejamentocargos")
public class PlanejamentoCargos implements Serializable {

    public static final String sTitle = "Plano de Carreira";
    public static final String pTitle = "Planos de Carreiras";

    @Id
    @SequenceGenerator(name = "plncargo_pk_sequence", sequenceName = "seq_csb_planejamentocargo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "plncargo_pk_sequence")
    private int pln_codigo;
    @ManyToOne
    @JoinColumn(name = "pla_codigo")
    private PlanejamentoCarreira planejamento;
    @ManyToOne
    @JoinColumn(name = "car_codigo")
    private Cargo cargo;
    private int car_ordem;
    private Integer car_tempominimo;

    public PlanejamentoCargos() {
    }

    public int getPln_codigo() {
        return pln_codigo;
    }

    public void setPln_codigo(int pln_codigo) {
        this.pln_codigo = pln_codigo;
    }

    public PlanejamentoCarreira getPlanejamento() {
        return planejamento;
    }

    public void setPlanejamento(PlanejamentoCarreira planejamento) {
        this.planejamento = planejamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getCar_ordem() {
        return car_ordem;
    }

    public void setCar_ordem(int car_ordem) {
        this.car_ordem = car_ordem;
    }

    public Integer getCar_tempominimo() {
        return car_tempominimo;
    }

    public void setCar_tempominimo(Integer car_tempominimo) {
        this.car_tempominimo = car_tempominimo;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.pln_codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlanejamentoCargos other = (PlanejamentoCargos) obj;
        if (!Objects.equals(this.pln_codigo, other.pln_codigo)) {
            return false;
        }
        return true;
    }
}
