
package rs.model;

import cfg.model.Empresa;
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
 * @author Dinei A. Rockenbach
 */
@Entity
@Table(name = "rec_certificacao")
public class Certificacao implements Serializable {
    
    public static final String sTitle = "Certificação";
    public static final String pTitle = "Certificações";
    
    @Id
    @SequenceGenerator(name="certificacao_pk_sequence", sequenceName="seq_rs_certificacao")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="certificacao_pk_sequence")
    private int cer_codigo;
    
    @ManyToOne
    @JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
    private Empresa empresa;
    
    private String cer_nome;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cer_datainicial;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cer_datafinal;
    
    private String cer_url;
    
    public Certificacao() {
    }

    public int getCerCodigo() {
        return cer_codigo;
    }

    public void setCerCodigo(int cer_codigo) {
        this.cer_codigo = cer_codigo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getCerNome() {
        return cer_nome;
    }

    public void setCerNome(String cer_nome) {
        this.cer_nome = cer_nome;
    }

    public Date getCerDatainicial() {
        return cer_datainicial;
    }

    public void setCerDatainicial(Date cer_datainicial) {
        this.cer_datainicial = cer_datainicial;
    }

    public Date getCerDatafinal() {
        return cer_datafinal;
    }

    public void setCerDatafinal(Date cer_datafinal) {
        this.cer_datafinal = cer_datafinal;
    }

    public String getCerUrl() {
        return cer_url;
    }

    public void setCerUrl(String cer_url) {
        this.cer_url = cer_url;
    }
    
}
