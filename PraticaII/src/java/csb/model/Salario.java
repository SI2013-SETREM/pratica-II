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
    private Cargo car_codigo;
    
    @ManyToOne
    @JoinColumn(name = "mas_codigo", referencedColumnName = "mas_codigo")
    private MotivoAlteracaoSalarial mas_codigo;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pes_codigo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sal_datainicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sal_datafim;
    private boolean sal_situacao;
    private double sal_valorbruto;

    public Salario() {
    }

    public int getSal_codigo() {
        return sal_codigo;
    }

    public void setSal_codigo(int sal_codigo) {
        this.sal_codigo = sal_codigo;
    }

    public Cargo getCar_codigo() {
        return car_codigo;
    }

    public void setCar_codigo(Cargo car_codigo) {
        this.car_codigo = car_codigo;
    }

    public MotivoAlteracaoSalarial getMas_codigo() {
        return mas_codigo;
    }

    public void setMas_codigo(MotivoAlteracaoSalarial mas_codigo) {
        this.mas_codigo = mas_codigo;
    }

    public Pessoa getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(Pessoa pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public Date getSal_datainicio() {
        return sal_datainicio;
    }

    public void setSal_datainicio(Date sal_datainicio) {
        this.sal_datainicio = sal_datainicio;
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
