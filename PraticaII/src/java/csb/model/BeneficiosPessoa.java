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
@Table(name = "csb_beneficios_pessoa")
@IdClass(BeneficiosPessoa.BeneficiosPessoaPK.class)
public class BeneficiosPessoa implements Serializable {

    public static final String sTitle = "Benefício";
    public static final String pTitle = "Benefícios";

    @Id
    @ManyToOne
    @JoinColumn(name = "ben_codigo", referencedColumnName = "ben_codigo")
    private Beneficio beneficio;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    private boolean ben_ativo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ben_datainicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ben_datafim;
    private double ben_valor;

    public static class BeneficiosPessoaPK implements Serializable {

        protected Beneficio beneficio;
        protected Pessoa pessoa;

        public BeneficiosPessoaPK() {
        }

        public BeneficiosPessoaPK(Beneficio beneficio, Pessoa pessoa) {
            this.beneficio = beneficio;
            this.pessoa = pessoa;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.beneficio);
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
            final BeneficiosPessoaPK other = (BeneficiosPessoaPK) obj;
            if (!Objects.equals(this.beneficio, other.beneficio)) {
                return false;
            }
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            return true;
        }

    }

    public BeneficiosPessoa() {
    }

    public Beneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Beneficio beneficio) {
        this.beneficio = beneficio;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public double getBen_valor() {
        return ben_valor;
    }

    public void setBen_valor(double ben_valor) {
        this.ben_valor = ben_valor;
    }
}
