
package rs.model;

import ad.model.Competencia;
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
@Table(name="rec_pessoa_competencia")
@IdClass(PessoaCompetencia.PessoaCompetenciaPK.class)
public class PessoaCompetencia implements Serializable {
    
    public static final String sTitle = "Competência";
    public static final String pTitle = "Competências";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "cmp_codigo", referencedColumnName = "cmp_codigo")
    private Competencia competencia;
    
    private int pes_cmp_nivel;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class PessoaCompetenciaPK implements Serializable {
        protected Pessoa pessoa;
        protected Competencia competencia;

        public PessoaCompetenciaPK() {}

        public PessoaCompetenciaPK(Pessoa pessoa, Competencia competencia) {
            this.pessoa = pessoa;
            this.competencia = competencia;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 61 * hash + Objects.hashCode(this.pessoa);
            hash = 61 * hash + Objects.hashCode(this.competencia);
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
            final PessoaCompetenciaPK other = (PessoaCompetenciaPK) obj;
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (!Objects.equals(this.competencia, other.competencia)) {
                return false;
            }
            return true;
        }

    }

    public PessoaCompetencia() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public int getPesCmpNivel() {
        return pes_cmp_nivel;
    }

    public void setPesCmpNivel(int pes_cmp_nivel) {
        this.pes_cmp_nivel = pes_cmp_nivel;
    }

    
    
    
}
