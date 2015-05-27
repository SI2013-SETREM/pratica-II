package csb.model;

import cfg.model.Pessoa;
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
@Table(name = "csb_cargos_pessoa")
@IdClass(CargosPessoa.CargosPessoaPK.class)
public class CargosPessoa implements Serializable {
    public static final String sTitle = "Cargo";
    public static final String pTitle = "Cargos";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "car_codigo", referencedColumnName = "car_codigo")
    private Cargo car_codigo;
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pes_codigo; 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date car_data_inicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date car_data_fim;
    private boolean car_status;
    
    public class CargosPessoaPK implements Serializable {
        protected Cargo cargo;
        protected Pessoa pessoa;

        public CargosPessoaPK() {}

        public CargosPessoaPK(Cargo cargo, Pessoa pessoa) {
            this.cargo = cargo;
            this.pessoa = pessoa;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.cargo);
            hash = 17 * hash + Objects.hashCode(this.pessoa);
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
            final CargosPessoaPK other = (CargosPessoaPK) obj;
            if (!Objects.equals(this.cargo, other.cargo)) {
                return false;
            }
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            return true;
        }
        
    }

    public CargosPessoa() {
    }

    public Cargo getCar_codigo() {
        return car_codigo;
    }

    public void setCar_codigo(Cargo car_codigo) {
        this.car_codigo = car_codigo;
    }

    public Pessoa getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(Pessoa pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public Date getCar_data_inicio() {
        return car_data_inicio;
    }

    public void setCar_data_inicio(Date car_data_inicio) {
        this.car_data_inicio = car_data_inicio;
    }

    public Date getCar_data_fim() {
        return car_data_fim;
    }

    public void setCar_data_fim(Date car_data_fim) {
        this.car_data_fim = car_data_fim;
    }

    public boolean isCar_status() {
        return car_status;
    }

    public void setCar_status(boolean car_status) {
        this.car_status = car_status;
    }
    
    
}
