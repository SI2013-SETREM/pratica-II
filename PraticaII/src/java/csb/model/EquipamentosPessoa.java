package csb.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "csb_equipamentospessoa")
public class EquipamentosPessoa implements Serializable {

    public static final String sTitle = "Equipamento";
    public static final String pTitle = "Equipamentos";

    @Id
    @SequenceGenerator(name = "eqp_pk_sequence", sequenceName = "seq_csb_equipamentospessoa")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "eqp_pk_sequence")
    private int eqp_codigo;

    @ManyToOne
    @JoinColumn(name = "epi_codigo", referencedColumnName = "epi_codigo")
    private Epi epi;

    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date epe_datainicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date epe_datavencimento;
    private char epe_situacao;
    private double epe_valor;

    public EquipamentosPessoa() {
    }

    public int getEqp_codigo() {
        return eqp_codigo;
    }

    public void setEqp_codigo(int eqp_codigo) {
        this.eqp_codigo = eqp_codigo;
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

    public char getEpe_situacao() {
        return epe_situacao;
    }

    public String getEpe_situacaoString() {
        if (epe_situacao == 'E') {
            return "EM USO";
        } else if (epe_situacao == 'D') {
            return "DESCARTADO";
        } else if (epe_situacao == 'P') {
            return "PLANEJADO";
        } else {
            return "DESCONHECIDO";
        }
    }

    public void setEpe_situacao(char epe_situacao) {
        this.epe_situacao = epe_situacao;
    }

    public double getEpe_valor() {
        return epe_valor;
    }

    public void setEpe_valor(double epe_valor) {
        this.epe_valor = epe_valor;
    }

    public String getDataConverter(Date data) {
        return util.Utilidades.getDataString(data);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.eqp_codigo;
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
        final EquipamentosPessoa other = (EquipamentosPessoa) obj;
        if (this.eqp_codigo != other.eqp_codigo) {
            return false;
        }
        return true;
    }

}
