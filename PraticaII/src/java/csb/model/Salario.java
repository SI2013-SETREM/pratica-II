package csb.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_salario")
public class Salario implements Serializable {

    public static final String sTitle = "Salário";
    public static final String pTitle = "Salários";
    
    @Id
    @SequenceGenerator(name="salario_pk_sequence", sequenceName="seq_csb_salario")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="salario_pk_sequence")
    private int sal_codigo;
    
    @ManyToOne
    @JoinColumn(name = "car_codigo", referencedColumnName = "car_codigo")
    private Cargo cargo;
    
    @ManyToOne
    @JoinColumn(name = "mas_codigo", referencedColumnName = "mas_codigo")
    private MotivoAlteracaoSalarial motivoAlteracaoSalarial;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sal_datainicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sal_datafim;
    private boolean sal_situacao;
    private double sal_valorbruto;
    @Transient
    private double sal_valorbrutoNovo;

    public double getSal_valorbrutoNovo()
    {
        return sal_valorbrutoNovo;
    }

    public void setSal_valorbrutoNovo(double sal_valorbrutoNovo)
    {
        this.sal_valorbrutoNovo = sal_valorbrutoNovo;
    }

    public Salario() {
    }
    

    public int getSal_codigo() {
        return sal_codigo;
    }

    public void setSal_codigo(int sal_codigo) {
        this.sal_codigo = sal_codigo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public MotivoAlteracaoSalarial getMotivoAlteracaoSalarial() {
        return motivoAlteracaoSalarial;
    }

    public void setMotivoAlteracaoSalarial(MotivoAlteracaoSalarial motivoAlteracaoSalarial) {
        this.motivoAlteracaoSalarial = motivoAlteracaoSalarial;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getSal_datainicio() {
        return sal_datainicio;
    }

    public void setSal_datainicio(Date sal_datainicio) {
        this.sal_datainicio = sal_datainicio;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.motivoAlteracaoSalarial);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Salario other = (Salario) obj;
        if (!Objects.equals(this.motivoAlteracaoSalarial, other.motivoAlteracaoSalarial))
        {
            return false;
        }
        return true;
    }

    public Date getSal_datafim() {
        return sal_datafim;
    }

    public void setSal_datafim(Date sal_datafim) {
        this.sal_datafim = sal_datafim;
    }

    public boolean isSal_situacao() {
        return sal_situacao;
    }

    public void setSal_situacao(boolean sal_situacao) {
        this.sal_situacao = sal_situacao;
    }

    public double getSal_valorbruto() {
        return sal_valorbruto;
    }

    public void setSal_valorbruto(double sal_valorbruto) {
        this.sal_valorbruto = sal_valorbruto;
    }
}
