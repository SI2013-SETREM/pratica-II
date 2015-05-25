
package rs.model;

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

@Entity
@Table(name="rec_pessoa_certificacao")
@IdClass(PessoaCertificacao.PessoaCertificacaoPK.class)
public class PessoaCertificacao implements Serializable {
    
    public static final String sTitle = "Certificação";
    public static final String pTitle = "Certificações";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "cer_codigo", referencedColumnName = "cer_codigo")
    private Certificacao certificacao;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcr_datainicial;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pcr_datafinal;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class PessoaCertificacaoPK implements Serializable {
        protected Pessoa pessoa;
        protected Certificacao certificacao;

        public PessoaCertificacaoPK() {}

        public PessoaCertificacaoPK(Pessoa pessoa, Certificacao certificacao) {
            this.pessoa = pessoa;
            this.certificacao = certificacao;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 61 * hash + Objects.hashCode(this.pessoa);
            hash = 61 * hash + Objects.hashCode(this.certificacao);
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
            final PessoaCertificacaoPK other = (PessoaCertificacaoPK) obj;
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (!Objects.equals(this.certificacao, other.certificacao)) {
                return false;
            }
            return true;
        }
        
    }

    public PessoaCertificacao() {
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
