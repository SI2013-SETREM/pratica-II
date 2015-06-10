package ff.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
 * @author Max
 */
@Entity
@Table(name = "ffp_falta")
public class Falta implements Serializable {

    @Id
    @SequenceGenerator(name = "genFalta", sequenceName = "genFalta", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genFalta")
    private int flt_codigo;
    
    @ManyToOne
    @JoinColumn (name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @ManyToOne
    private Advertencia adv_codigo;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flt_data;
    
    @Column(nullable = false)
    private double flt_qtd_horas;
    
    private String observacao;
    
    @Column(nullable = false)
    private String flt_justificativa;

    public int getFlt_codigo() {
        return flt_codigo;
    }

    public void setFlt_codigo(int flt_codigo) {
        this.flt_codigo = flt_codigo;
    }

    public Date getFlt_data() {
        return flt_data;
    }

    public void setFlt_data(Date flt_data) {
        this.flt_data = flt_data;
    }

    public double getFlt_qtd_horas() {
        return flt_qtd_horas;
    }

    public void setFlt_qtd_horas(double flt_qtd_horas) {
        this.flt_qtd_horas = flt_qtd_horas;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getFlt_justificativa() {
        return flt_justificativa;
    }

    public void setFlt_justificativa(String flt_justificativa) {
        this.flt_justificativa = flt_justificativa;
    }

    public Advertencia getAdv_codigo() {
        return adv_codigo;
    }

    public void setAdv_codigo(Advertencia adv_codigo) {
        this.adv_codigo = adv_codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
