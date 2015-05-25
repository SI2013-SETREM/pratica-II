
package rs.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_entrevista_questionario")
@IdClass(EntrevistaQuestionario.EntrevistaPessoaPK.class)
public class EntrevistaQuestionario implements Serializable {
    
    public static final String sTitle = "Entrevista";
    public static final String pTitle = "Entrevista";
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo"),
        @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo"),
        @JoinColumn(name = "ent_codigo", referencedColumnName = "ent_codigo")
    })
    private Entrevista entrevista;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo")
    private Questionario questionario;
    
    private String ent_qst_titulo;
    private int ent_qst_status;
    private boolean ent_qst_respondida;
    private int ent_qst_temporesposta;
    private int ent_qst_pontuacaototal;
    private int ent_qst_pontuacaomax;
    private int ent_qst_tipo;
    
    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class EntrevistaPessoaPK implements Serializable {
        protected Entrevista entrevista;
        protected Questionario questionario;

        public EntrevistaPessoaPK() {}

        public EntrevistaPessoaPK(Entrevista entrevista, Questionario questionario) {
            this.entrevista = entrevista;
            this.questionario = questionario;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 89 * hash + Objects.hashCode(this.entrevista);
            hash = 89 * hash + Objects.hashCode(this.questionario);
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
            final EntrevistaPessoaPK other = (EntrevistaPessoaPK) obj;
            if (!Objects.equals(this.entrevista, other.entrevista)) {
                return false;
            }
            if (!Objects.equals(this.questionario, other.questionario)) {
                return false;
            }
            return true;
        }

    }

    public EntrevistaQuestionario() {
    }

    public Entrevista getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(Entrevista entrevista) {
        this.entrevista = entrevista;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public String getEntQstTitulo() {
        return ent_qst_titulo;
    }

    public void setEntQstTitulo(String ent_qst_titulo) {
        this.ent_qst_titulo = ent_qst_titulo;
    }

    public int getEntQstStatus() {
        return ent_qst_status;
    }

    public void setEntQstStatus(int ent_qst_status) {
        this.ent_qst_status = ent_qst_status;
    }

    public boolean isEntQstRespondida() {
        return ent_qst_respondida;
    }

    public void setEntQstRespondida(boolean ent_qst_respondida) {
        this.ent_qst_respondida = ent_qst_respondida;
    }

    public int getEntQstTemporesposta() {
        return ent_qst_temporesposta;
    }

    public void setEntQstTemporesposta(int ent_qst_temporesposta) {
        this.ent_qst_temporesposta = ent_qst_temporesposta;
    }

    public int getEntQstPontuacaototal() {
        return ent_qst_pontuacaototal;
    }

    public void setEntQstPontuacaototal(int ent_qst_pontuacaototal) {
        this.ent_qst_pontuacaototal = ent_qst_pontuacaototal;
    }

    public int getEntQstPontuacaomax() {
        return ent_qst_pontuacaomax;
    }

    public void setEntQstPontuacaomax(int ent_qst_pontuacaomax) {
        this.ent_qst_pontuacaomax = ent_qst_pontuacaomax;
    }

    public int getEntQstTipo() {
        return ent_qst_tipo;
    }

    public void setEntQstTipo(int ent_qst_tipo) {
        this.ent_qst_tipo = ent_qst_tipo;
    }

    
    
}
