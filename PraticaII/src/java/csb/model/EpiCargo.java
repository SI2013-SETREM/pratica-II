package csb.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_epicargo")
@IdClass(EpiCargo.EpiCargoPK.class)
public class EpiCargo implements Serializable {
    public static final String sTitle = "Epi";
    public static final String pTitle = "Epis";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "epi_codigo", referencedColumnName = "epi_codigo")
    private Epi epi_codigo;
    @Id
    @ManyToOne
    @JoinColumn(name = "car_codigo", referencedColumnName = "car_codigo")
    private Cargo car_codigo;
    private boolean ecr_obrigatorio;
    
    public class EpiCargoPK implements Serializable {
        protected Cargo cargo;
        protected Epi epi;

        public EpiCargoPK() {}

        public EpiCargoPK(Cargo cargo, Epi epi) {
            this.cargo = cargo;
            this.epi = epi;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.cargo);
            hash = 17 * hash + Objects.hashCode(this.epi);
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
            final EpiCargoPK other = (EpiCargoPK) obj;
            if (!Objects.equals(this.cargo, other.cargo)) {
                return false;
            }
            if (!Objects.equals(this.epi, other.epi)) {
                return false;
            }
            return true;
        }
        
    }

    public EpiCargo() {
    }

    public Epi getEpi_codigo() {
        return epi_codigo;
    }

    public void setEpi_codigo(Epi epi_codigo) {
        this.epi_codigo = epi_codigo;
    }

    public Cargo getCar_codigo() {
        return car_codigo;
    }

    public void setCar_codigo(Cargo car_codigo) {
        this.car_codigo = car_codigo;
    }

    public boolean isEcr_obrigatorio() {
        return ecr_obrigatorio;
    }

    public void setEcr_obrigatorio(boolean ecr_obrigatorio) {
        this.ecr_obrigatorio = ecr_obrigatorio;
    }
}
