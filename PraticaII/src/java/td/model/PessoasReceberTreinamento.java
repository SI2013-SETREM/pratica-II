package td.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trd_pessoas_recebertreinamento")
public class PessoasReceberTreinamento implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;

    @Id
    @ManyToOne
    @JoinColumn(name = "sol_codigo", referencedColumnName = "sol_codigo")
    private Solicitacao solicitacao;

    public PessoasReceberTreinamento() {
    }
    
   /* public static class PessoasReceberTreinamentoPK implements Serializable {

        protected Pessoa pessoa;
        protected Solicitacao solicitacao;

        public PessoasReceberTreinamentoPK(Pessoa pessoa, Solicitacao solicitacao) {
            this.pessoa = pessoa;
            this.solicitacao = solicitacao;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.pessoa);
            hash = 97 * hash + Objects.hashCode(this.solicitacao);
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
            final PessoasReceberTreinamentoPK other = (PessoasReceberTreinamentoPK) obj;
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (!Objects.equals(this.solicitacao, other.solicitacao)) {
                return false;
            }
            return true;
        }

    }*/
   
     public PessoasReceberTreinamento(Pessoa pessoa, Solicitacao solicitacao) {
        this.pessoa = pessoa;
        this.solicitacao = solicitacao;
    }
     
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

}
