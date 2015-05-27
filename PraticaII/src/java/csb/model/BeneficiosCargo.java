package csb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_beneficios_cargo")
@IdClass(BeneficiosCargo.BeneficiosCargoPK.class)
public class BeneficiosCargo implements Serializable {

    public static final String sTitle = "Benefício";
    public static final String pTitle = "Benefícios";

    @Id
    @ManyToOne
    @JoinColumn(name = "ben_codigo", referencedColumnName = "ben_codigo")
    private Beneficio beneficio;
    @Id
    @ManyToOne
    @JoinColumn(name = "car_codigo", referencedColumnName = "car_codigo")
    private Cargo cargo;
    private boolean ben_ativo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ben_datainicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ben_datafim;

    public class BeneficiosCargoPK implements Serializable {

        protected Beneficio beneficio;
        protected Cargo cargo;

        public BeneficiosCargoPK() {
        }

        public BeneficiosCargoPK(Beneficio beneficio, Cargo cargo) {
            this.beneficio = beneficio;
            this.cargo = cargo;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 29 * hash + Objects.hashCode(this.beneficio);
            hash = 29 * hash + Objects.hashCode(this.cargo);
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
            final BeneficiosCargoPK other = (BeneficiosCargoPK) obj;
            if (!Objects.equals(this.beneficio, other.beneficio)) {
                return false;
            }
            if (!Objects.equals(this.cargo, other.cargo)) {
                return false;
            }
            return true;
        }
        
    }

    public BeneficiosCargo() {
    }

    public Beneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Beneficio beneficio) {
        this.beneficio = beneficio;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public boolean isBen_ativo() {
        return ben_ativo;
    }

    public void setBen_ativo(boolean ben_ativo) {
        this.ben_ativo = ben_ativo;
    }

    public Date getBen_datainicio() {
        return ben_datainicio;
    }

    public void setBen_datainicio(Date ben_datainicio) {
        this.ben_datainicio = ben_datainicio;
    }

    public Date getBen_datafim() {
        return ben_datafim;
    }

    public void setBen_datafim(Date ben_datafim) {
        this.ben_datafim = ben_datafim;
    }

}
