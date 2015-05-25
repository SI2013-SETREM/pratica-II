
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

/**
 *
 * @author Dinei A. Rockenbach
 */
@Entity
@Table(name = "rec_entrevista_questionario_resposta")
@IdClass(EntrevistaQuestionarioResposta.EntrevistaQuestionarioRespostaPK.class)
public class EntrevistaQuestionarioResposta implements Serializable {
    
    public static final String sTitle = "Resposta";
    public static final String pTitle = "Respostas";
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo"),
        @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo"),
        @JoinColumn(name = "ent_codigo", referencedColumnName = "ent_codigo"),
        @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo")
    })
    private EntrevistaQuestionario entrevistaQuestionario;
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo", insertable = false, updatable = false),
        @JoinColumn(name = "prg_codigo", referencedColumnName = "prg_codigo", insertable = false, updatable = false)
    })
    private Pergunta pergunta;
    
    private String rsp_pergunta;
    private String rsp_resposta;
    private int rsp_ordem;
    private int rsp_pontuacao;
    
    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class EntrevistaQuestionarioRespostaPK implements Serializable {
        protected EntrevistaQuestionario entrevistaQuestionario;
        protected Pergunta pergunta;

        public EntrevistaQuestionarioRespostaPK() {
        }

        public EntrevistaQuestionarioRespostaPK(EntrevistaQuestionario entrevistaQuestionario, Pergunta pergunta) {
            this.entrevistaQuestionario = entrevistaQuestionario;
            this.pergunta = pergunta;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.entrevistaQuestionario);
            hash = 17 * hash + Objects.hashCode(this.pergunta);
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
            final EntrevistaQuestionarioRespostaPK other = (EntrevistaQuestionarioRespostaPK) obj;
            if (!Objects.equals(this.entrevistaQuestionario, other.entrevistaQuestionario)) {
                return false;
            }
            if (!Objects.equals(this.pergunta, other.pergunta)) {
                return false;
            }
            return true;
        }
        
    }

    public EntrevistaQuestionarioResposta() {
    }

    public EntrevistaQuestionario getEntrevistaQuestionario() {
        return entrevistaQuestionario;
    }

    public void setEntrevistaQuestionario(EntrevistaQuestionario entrevistaQuestionario) {
        this.entrevistaQuestionario = entrevistaQuestionario;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public String getRspPergunta() {
        return rsp_pergunta;
    }

    public void setRspPergunta(String rsp_pergunta) {
        this.rsp_pergunta = rsp_pergunta;
    }

    public String getRspResposta() {
        return rsp_resposta;
    }

    public void setRspResposta(String rsp_resposta) {
        this.rsp_resposta = rsp_resposta;
    }

    public int getRspOrdem() {
        return rsp_ordem;
    }

    public void setRspOrdem(int rsp_ordem) {
        this.rsp_ordem = rsp_ordem;
    }

    public int getRspPontuacao() {
        return rsp_pontuacao;
    }

    public void setRspPontuacao(int rsp_pontuacao) {
        this.rsp_pontuacao = rsp_pontuacao;
    }
    
    
}
