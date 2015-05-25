
package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_recrutamento_pessoa")
@IdClass(RecrutamentoPessoa.RecrutamentoPessoaPK.class)
public class RecrutamentoPessoa implements Serializable {
    
    public static final String sTitle = "Pessoa do Recrutamento";
    public static final String pTitle = "Pessoas do Recrutamento";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo")
    private Recrutamento recrutamento;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    private int rec_pes_status;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class RecrutamentoPessoaPK implements Serializable {
        protected Recrutamento recrutamento;
        protected Pessoa pessoa;

        public RecrutamentoPessoaPK() {}

        public RecrutamentoPessoaPK(Recrutamento recrutamento, Pessoa pessoa) {
            this.recrutamento = recrutamento;
            this.pessoa = pessoa;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.recrutamento);
            hash = 17 * hash + Objects.hashCode(this.pessoa);
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
            final RecrutamentoPessoaPK other = (RecrutamentoPessoaPK) obj;
            if (!Objects.equals(this.recrutamento, other.recrutamento)) {
                return false;
            }
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            return true;
        }
        
    }

    public RecrutamentoPessoa() {
    }

    public Recrutamento getRecrutamento() {
        return recrutamento;
    }

    public void setRecrutamento(Recrutamento recrutamento) {
        this.recrutamento = recrutamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getRecPesStatus() {
        return rec_pes_status;
    }

    public void setRecPesStatus(int rec_pes_status) {
        this.rec_pes_status = rec_pes_status;
    }

    
    
}
