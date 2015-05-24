package ad.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avd_pessoas_avaliacao")
@IdClass(PessoasAvaliacao.PessoasAvaliacaoPK.class)
public class PessoasAvaliacao implements Serializable {

    private static final String sTitle = "Avaliados";
    private static final String sTitleDetails = "Detalhes da Avaliação";
    private static final String pTitle = "Avaliações";
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

    private double pea_media;
    private String pea_observacao;
    private Date pea_datahora_resposta;

    public class PessoasAvaliacaoPK implements Serializable {

        protected Pessoa colaboradorAvaliado;
        protected Pessoa avaliador;
        protected Avaliacao avaliacao;

        public PessoasAvaliacaoPK() {
        }

        public PessoasAvaliacaoPK(Pessoa colaboradorAvaliado, Pessoa avaliador, Avaliacao avaliacao) {
            this.colaboradorAvaliado = colaboradorAvaliado;
            this.avaliador = avaliador;
            this.avaliacao = avaliacao;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.colaboradorAvaliado);
            hash = 97 * hash + Objects.hashCode(this.avaliador);
            hash = 97 * hash + Objects.hashCode(this.avaliacao);
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
            final PessoasAvaliacaoPK other = (PessoasAvaliacaoPK) obj;
            if (!Objects.equals(this.colaboradorAvaliado, other.colaboradorAvaliado)) {
                return false;
            }
            if (!Objects.equals(this.avaliador, other.avaliador)) {
                return false;
            }
            if (!Objects.equals(this.avaliacao, other.avaliacao)) {
                return false;
            }
            return true;
        }

    }

    public PessoasAvaliacao() {
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

    public double getPea_media() {
        return pea_media;
    }

    public void setPea_media(double pea_media) {
        this.pea_media = pea_media;
    }

    public String getPea_observacao() {
        return pea_observacao;
    }

    public void setPea_observacao(String pea_observacao) {
        this.pea_observacao = pea_observacao;
    }

    public Date getPea_datahora_resposta() {
        return pea_datahora_resposta;
    }

    public void setPea_datahora_resposta(Date pea_datahora_resposta) {
        this.pea_datahora_resposta = pea_datahora_resposta;
    }

    public static String getsTitle() {
        return sTitle;
    }

    public static String getsTitleDetails() {
        return sTitleDetails;
    }

    public static String getpTitle() {
        return pTitle;
    }

}
