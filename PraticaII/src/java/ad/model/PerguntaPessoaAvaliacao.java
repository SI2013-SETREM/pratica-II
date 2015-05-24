package ad.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import rs.model.Pergunta;
//import rs.model.Questionario;

@Entity
@Table(name = "avd_pergunta_pessoa_avaliacao")
@IdClass(PerguntaPessoaAvaliacao.PerguntaPessoaAvaliacaoPK.class)
public class PerguntaPessoaAvaliacao implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa colaboradorAvaliado;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo_avaliador", referencedColumnName = "pes_codigo")
    private Pessoa avaliador;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "ava_codigo", referencedColumnName = "ava_codigo")
    private Avaliacao avaliacao;
    
    @Id
    @ManyToOne
    @JoinColumns( {
        @JoinColumn(name = "prg_codigo", referencedColumnName = "prg_codigo"),
        @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo")
    })
    private Pergunta pergunta;

    private String ppa_resposta;
    private String ppa_pergunta;
    private int ppa_pontuacao;

    public class PerguntaPessoaAvaliacaoPK implements Serializable {

        protected Pessoa avaliador;
        protected Pessoa colaboradorAvaliado;
        protected Avaliacao avaliacao;
        protected Pergunta pergunta;

        public PerguntaPessoaAvaliacaoPK() {
        }

        public PerguntaPessoaAvaliacaoPK(Pessoa avaliador, Pessoa colaboradorAvaliado, Avaliacao avaliacao, Pergunta pergunta) {
            this.avaliador = avaliador;
            this.colaboradorAvaliado = colaboradorAvaliado;
            this.avaliacao = avaliacao;
            this.pergunta = pergunta;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 29 * hash + Objects.hashCode(this.avaliador);
            hash = 29 * hash + Objects.hashCode(this.colaboradorAvaliado);
            hash = 29 * hash + Objects.hashCode(this.avaliacao);
            hash = 29 * hash + Objects.hashCode(this.pergunta);
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
            final PerguntaPessoaAvaliacaoPK other = (PerguntaPessoaAvaliacaoPK) obj;
            if (!Objects.equals(this.avaliador, other.avaliador)) {
                return false;
            }
            if (!Objects.equals(this.colaboradorAvaliado, other.colaboradorAvaliado)) {
                return false;
            }
            if (!Objects.equals(this.avaliacao, other.avaliacao)) {
                return false;
            }
            if (!Objects.equals(this.pergunta, other.pergunta)) {
                return false;
            }
            return true;
        }
    }

    public PerguntaPessoaAvaliacao() {
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
