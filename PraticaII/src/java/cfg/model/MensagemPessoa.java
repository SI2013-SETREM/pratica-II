
package cfg.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Dinei A. Rockenbach
 */
@Entity
@Table(name = "mensagem_pessoa")
@IdClass(MensagemPessoa.MensagemPessoaPK.class)
public class MensagemPessoa implements Serializable {
    public static final String sTitle = "Mensagem Pessoa";
    public static final String pTitle = "Mensagens Pessoa";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "cnv_codigo", referencedColumnName = "cnv_codigo"),
        @JoinColumn(name = "msg_codigo", referencedColumnName = "msg_codigo")
    })
    private Mensagem mensagem;
    
    private boolean msg_lida;
    
    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class MensagemPessoaPK implements Serializable {
        protected Pessoa pessoa;
        protected Mensagem mensagem;

        public MensagemPessoaPK() {
        }

        public MensagemPessoaPK(Pessoa pessoa, Mensagem mensagem) {
            this.pessoa = pessoa;
            this.mensagem = mensagem;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 29 * hash + Objects.hashCode(this.pessoa);
            hash = 29 * hash + Objects.hashCode(this.mensagem);
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
            final MensagemPessoaPK other = (MensagemPessoaPK) obj;
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (!Objects.equals(this.mensagem, other.mensagem)) {
                return false;
            }
            return true;
        }

    }

    public MensagemPessoa() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isMsgLida() {
        return msg_lida;
    }

    public void setMsgLida(boolean msg_lida) {
        this.msg_lida = msg_lida;
    }
    
}
