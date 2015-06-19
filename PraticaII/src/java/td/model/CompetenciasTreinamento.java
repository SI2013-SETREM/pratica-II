package td.model;

import ad.model.Competencia;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trd_competencias_treinamento")
public class CompetenciasTreinamento implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "cmp_codigo", referencedColumnName = "cmp_codigo")
    private Competencia competencia;

    @Id
    @ManyToOne
    @JoinColumn(name = "tre_codigo", referencedColumnName = "tre_codigo")
    private Treinamento treinamento;
    /*
      public static class CompetenciasTreinamentoPK implements Serializable {

        protected Competencia competencia;
        protected Treinamento treinamento;

        public CompetenciasTreinamentoPK(Competencia competencia, Treinamento treinamento) {
            this.competencia = competencia;
            this.treinamento = treinamento;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.competencia);
            hash = 97 * hash + Objects.hashCode(this.treinamento);
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
            final CompetenciasTreinamentoPK other = (CompetenciasTreinamentoPK) obj;
            if (!Objects.equals(this.competencia, other.competencia)) {
                return false;
            }
            if (!Objects.equals(this.treinamento, other.treinamento)) {
                return false;
            }
            return true;
        }

    }*/
   
       public CompetenciasTreinamento() {
    }
    
    public CompetenciasTreinamento(Competencia competencia, Treinamento treinamento) {
        this.competencia = competencia;
        this.treinamento = treinamento;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }
}
