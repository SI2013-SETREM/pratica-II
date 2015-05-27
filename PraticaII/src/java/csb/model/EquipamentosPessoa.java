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
@Table(name = "csb_equipamentospessoa")
@IdClass(EquipamentosPessoa.EquipamentosPessoaPK.class)
public class EquipamentosPessoa implements Serializable {
    
    public static final String sTitle = "Equipamento";
    public static final String pTitle = "Equipamentos";

    @Id
    @ManyToOne
    @JoinColumn(name = "epi_codigo", referencedColumnName = "epi_codigo")
    private Epi epi;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "car_codigo", referencedColumnName = "car_codigo")
    private Cargo cargo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date epe_datainicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date epe_datavencimento;
    private boolean epe_situacao;
    private double epe_valor;
    
    public class EquipamentosPessoaPK implements Serializable {
        protected Cargo cargo;
        protected Pessoa pessoa;
        protected Epi epi;

        public EquipamentosPessoaPK() {}

        public EquipamentosPessoaPK(Cargo cargo, Pessoa pessoa, Epi epi) {
            this.cargo = cargo;
            this.pessoa = pessoa;
            this.epi = epi;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 11 * hash + Objects.hashCode(this.cargo);
            hash = 11 * hash + Objects.hashCode(this.pessoa);
            hash = 11 * hash + Objects.hashCode(this.epi);
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
            final EquipamentosPessoaPK other = (EquipamentosPessoaPK) obj;
            if (!Objects.equals(this.cargo, other.cargo)) {
                return false;
            }
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (!Objects.equals(this.epi, other.epi)) {
                return false;
            }
            return true;
        }

    }

    public EquipamentosPessoa() {
    }

    public Epi getEpi() {
        return epi;
    }

    public void setEpi(Epi epi) {
        this.epi = epi;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Date getEpe_datainicio() {
        return epe_datainicio;
    }

    public void setEpe_datainicio(Date epe_datainicio) {
        this.epe_datainicio = epe_datainicio;
    }

    public Date getEpe_datavencimento() {
        return epe_datavencimento;
    }

    public void setEpe_datavencimento(Date epe_datavencimento) {
        this.epe_datavencimento = epe_datavencimento;
    }

    public boolean isEpe_situacao() {
        return epe_situacao;
    }

    public void setEpe_situacao(boolean epe_situacao) {
        this.epe_situacao = epe_situacao;
    }

    public double getEpe_valor() {
        return epe_valor;
    }

    public void setEpe_valor(double epe_valor) {
        this.epe_valor = epe_valor;
    }
    
    
}
