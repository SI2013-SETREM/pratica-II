package ad.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "pessoas_avaliacao")
public class Pessoas_avaliacao implements Serializable {

    private static final String sTitle = "Avaliados";
    private static final String sTitleDetails = "Detalhes da Avaliação";
    private static final String pTitle = "Avaliações";

    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pessoa colaboradorAvaliado;

    @ManyToOne
    @JoinColumn(name = "pes_codigo_avaliador")
    private Pessoa avaliador;

    @ManyToOne
    @JoinColumn(name = "ava_codigo")
    private Avaliacao avaliacao;

    private double pea_media;
    private String pea_observacao;
    private Date pea_datahora_resposta;

    public Pessoas_avaliacao() {
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
