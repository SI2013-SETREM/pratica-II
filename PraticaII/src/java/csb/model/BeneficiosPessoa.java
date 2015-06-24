package csb.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_beneficios_pessoa")
public class BeneficiosPessoa implements Serializable {

    public static final String sTitle = "Benefício";
    public static final String pTitle = "Benefícios";

    @Id
    @SequenceGenerator(name = "bnp_codigo", sequenceName = "bnp_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bnp_codigo")
    private int bnp_codigo;

    @ManyToOne
    @JoinColumn(name = "ben_codigo", referencedColumnName = "ben_codigo")
    private Beneficio beneficio;

    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;

    private boolean ben_ativo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ben_datainicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ben_datafim;
    private double ben_valor;

    public BeneficiosPessoa() {
    }

    public int getBnp_codigo() {
        return bnp_codigo;
    }

    public void setBnp_codigo(int bnp_codigo) {
        this.bnp_codigo = bnp_codigo;
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

    public String getDataConverter(Date data) {
        return util.Utilidades.getDataString(data);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.bnp_codigo;
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
        final BeneficiosPessoa other = (BeneficiosPessoa) obj;
        if (this.bnp_codigo != other.bnp_codigo) {
            return false;
        }
        return true;
    }
}
