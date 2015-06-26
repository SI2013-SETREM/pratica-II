
package rs.model;

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

@Entity
@Table(name="rec_pessoa_certificacao")
public class PessoaCertificacao implements Serializable {
    
    public static final String sTitle = "Certificação";
    public static final String pTitle = "Certificações";
    
    @Id
    @SequenceGenerator(name = "pescertificacao_pk_sequence", sequenceName = "seq_rs_pessoa_certificacao")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pescertificacao_pk_sequence")
    private int pcr_codigo;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "cer_codigo", referencedColumnName = "cer_codigo")
    private Certificacao certificacao;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcr_datainicial;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcr_datafinal;

    public PessoaCertificacao() {
    }

    public int getPcrCodigo() {
        return pcr_codigo;
    }

    public void setPcrCodigo(int pcr_codigo) {
        this.pcr_codigo = pcr_codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Certificacao getCertificacao() {
        return certificacao;
    }

    public void setCertificacao(Certificacao certificacao) {
        this.certificacao = certificacao;
    }

    public Date getPcrDatainicial() {
        return pcr_datainicial;
    }

    public void setPcrDatainicial(Date pcr_datainicial) {
        this.pcr_datainicial = pcr_datainicial;
    }

    public Date getPcrDatafinal() {
        return pcr_datafinal;
    }

    public void setPcrDatafinal(Date pcr_datafinal) {
        this.pcr_datafinal = pcr_datafinal;
    }

    
}
