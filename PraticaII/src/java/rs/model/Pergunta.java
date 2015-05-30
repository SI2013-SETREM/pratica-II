
package rs.model;

import ad.model.Competencia;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_pergunta")
@IdClass(PerguntaPK.class)
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
