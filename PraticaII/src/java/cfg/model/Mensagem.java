
package cfg.model;

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
 * @author Dinei A. Rockenbach
 */
@Entity
@Table(name = "mensagem")
@IdClass(Mensagem.MensagemPK.class)
public class Mensagem implements Serializable {
       public static final String sTitle = "Mensagem";
    public static final String pTitle = "Mensagens";
    @Id
    @ManyToOne
    @JoinColumn(name = "cnv_codigo", referencedColumnName = "cnv_codigo")
    private Conversa conversa;
    
    @Id
    private int msg_codigo;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    private String msg_texto;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date msg_datahora;
    
    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class MensagemPK implements Serializable {
        protected Conversa conversa;
        protected int msg_codigo;

        public MensagemPK() {
        }

        public MensagemPK(Conversa conversa, int msg_codigo) {
            this.conversa = conversa;
            this.msg_codigo = msg_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 17 * hash + Objects.hashCode(this.conversa);
            hash = 17 * hash + this.msg_codigo;
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
            final MensagemPK other = (MensagemPK) obj;
            if (!Objects.equals(this.conversa, other.conversa)) {
                return false;
            }
            if (this.msg_codigo != other.msg_codigo) {
                return false;
            }
            return true;
        }
        
    }

    public Mensagem() {
    }

    public Conversa getConversa() {
        return conversa;
    }

    public void setConversa(Conversa conversa) {
        this.conversa = conversa;
    }

    public int getMsgCodigo() {
        return msg_codigo;
    }

    public void setMsgCodigo(int msg_codigo) {
        this.msg_codigo = msg_codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getMsgTexto() {
        return msg_texto;
    }

    public void setMsgTexto(String msg_texto) {
        this.msg_texto = msg_texto;
    }

    public Date getMsgDatahora() {
        return msg_datahora;
    }

    public void setMsgDatahora(Date msg_datahora) {
        this.msg_datahora = msg_datahora;
    }
    
    
    
}
