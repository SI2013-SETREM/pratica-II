package ad.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import rs.model.Pergunta;
import rs.model.Questionario;

@Table(name = "pergunta_pessoa_avaliacao")
public class Pergunta_pessoa_avaliacao implements Serializable {

    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pessoa colaboradorAvaliado;
    @ManyToOne
    @JoinColumn(name = "pes_codigo_avaliador")
    private Pessoa avaliador;
    @ManyToOne
    @JoinColumn(name = "ava_codigo")
    private Avaliacao avaliacao;

    @ManyToOne
    @JoinColumn(name = "qst_codigo")
    private Questionario questionario;

    @ManyToOne
    @JoinColumn(name = "prg_codigo")
    private Pergunta pergunta;

    private String ppa_resposta;
    private String ppa_pergunta;
    private int ppa_pontuacao;

    public Pergunta_pessoa_avaliacao() {
    }

    public Pessoa getColaboradorAvaliado() {
        return colaboradorAvaliado;
    }

    public void setColaboradorAvaliado(Pessoa colaboradorAvaliado) {
        this.colaboradorAvaliado = colaboradorAvaliado;
    }

    public Pessoa getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Pessoa avaliador) {
        this.avaliador = avaliador;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public String getPpa_resposta() {
        return ppa_resposta;
    }

    public void setPpa_resposta(String ppa_resposta) {
        this.ppa_resposta = ppa_resposta;
    }

    public String getPpa_pergunta() {
        return ppa_pergunta;
    }

    public void setPpa_pergunta(String ppa_pergunta) {
        this.ppa_pergunta = ppa_pergunta;
    }

    public int getPpa_pontuacao() {
        return ppa_pontuacao;
    }

    public void setPpa_pontuacao(int ppa_pontuacao) {
        this.ppa_pontuacao = ppa_pontuacao;
    }

}
