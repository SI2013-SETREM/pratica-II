
package td.model;

import ad.model.Competencia;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trd_competencias_solicitacao")
public class CompetenciasSolicitacao implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "cmp_codigo", referencedColumnName = "cmp_codigo")
    private Competencia competencia;

    @Id
    @ManyToOne
    @JoinColumn(name = "sol_codigo", referencedColumnName = "sol_codigo")
    private Solicitacao solicitacao;


    
   public static class CompetenciasSolicitacaoPK implements Serializable {

        protected Competencia competencia;
        protected Solicitacao solicitacao;

        public CompetenciasSolicitacaoPK(Competencia competencia, Solicitacao solicitacao) {
            this.competencia = competencia;
            this.solicitacao = solicitacao;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.competencia);
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
            final CompetenciasSolicitacaoPK other = (CompetenciasSolicitacaoPK) obj;
            if (!Objects.equals(this.competencia, other.competencia)) {
                return false;
            }
            if (!Objects.equals(this.solicitacao, other.solicitacao)) {
                return false;
            }
            return true;
        }

    }
   
       public CompetenciasSolicitacao() {
    }
       
     public CompetenciasSolicitacao(Competencia competencia, Solicitacao solicitacao) {
        this.competencia = competencia;
        this.solicitacao = solicitacao;
    }
     
    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }
    
}
