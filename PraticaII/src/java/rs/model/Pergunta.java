
package rs.model;

import ad.model.Competencia;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_pergunta")
@IdClass(Pergunta.PerguntaPK.class)
public class Pergunta implements Serializable {
    
    public static final String sTitle = "Pergunta";
    public static final String pTitle = "Perguntas";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo")
    private Questionario questionario;
    
    @Id
    private int prg_codigo;
    
    @ManyToOne
    @JoinColumn(name = "cmp_codigo", referencedColumnName = "cmp_codigo")
    private Competencia competencia;
    
    private String prg_pergunta;
    private int prg_ordem;
    private int prg_tipo;
    private boolean prg_opcaooutros;
    private boolean prg_exibircandidato;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class PerguntaPK implements Serializable {
        protected Questionario questionario;
        protected int prg_codigo;

        public PerguntaPK() {}

        public PerguntaPK(Questionario questionario, int prg_codigo) {
            this.questionario = questionario;
            this.prg_codigo = prg_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 19 * hash + Objects.hashCode(this.questionario);
            hash = 19 * hash + this.prg_codigo;
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
            final PerguntaPK other = (PerguntaPK) obj;
            if (!Objects.equals(this.questionario, other.questionario)) {
                return false;
            }
            if (this.prg_codigo != other.prg_codigo) {
                return false;
            }
            return true;
        }

    }

    public Pergunta() {
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public int getPrgCodigo() {
        return prg_codigo;
    }

    public void setPrgCodigo(int prg_codigo) {
        this.prg_codigo = prg_codigo;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public String getPrgPergunta() {
        return prg_pergunta;
    }

    public void setPrgPergunta(String prg_pergunta) {
        this.prg_pergunta = prg_pergunta;
    }

    public int getPrgOrdem() {
        return prg_ordem;
    }

    public void setPrgOrdem(int prg_ordem) {
        this.prg_ordem = prg_ordem;
    }

    public int getPrgTipo() {
        return prg_tipo;
    }

    public void setPrgTipo(int prg_tipo) {
        this.prg_tipo = prg_tipo;
    }

    public boolean isPrgOpcaooutros() {
        return prg_opcaooutros;
    }

    public void setPrgOpcaooutros(boolean prg_opcaooutros) {
        this.prg_opcaooutros = prg_opcaooutros;
    }

    public boolean isPrgExibircandidato() {
        return prg_exibircandidato;
    }

    public void setPrgExibircandidato(boolean prg_exibircandidato) {
        this.prg_exibircandidato = prg_exibircandidato;
    }
    
    
}
