package ad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "historico_avaliacao")
public class Historico_Avaliacao implements Serializable {

    public static final String sTitle = "Histórico Avaliação";
    public static final String pTitle = "Histórico de Avaliações";

    @Id
    @SequenceGenerator(name = "historico_avaliacao_pk_sequence", sequenceName = "historico_avaliacao_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "historico_avaliacao_pk_sequence")
    private int hav_codigo;
    private Date hav_datainicio;
    private Date hav_datafim;
    private int hav_valor;
    private String hav_descricao;

    public Historico_Avaliacao() {
    }

    public int getHav_codigo() {
        return hav_codigo;
    }

    public void setHav_codigo(int hav_codigo) {
        this.hav_codigo = hav_codigo;
    }

    public Date getHav_datainicio() {
        return hav_datainicio;
    }

    public void setHav_datainicio(Date hav_datainicio) {
        this.hav_datainicio = hav_datainicio;
    }

    public Date getHav_datafim() {
        return hav_datafim;
    }

    public void setHav_datafim(Date hav_datafim) {
        this.hav_datafim = hav_datafim;
    }

    public int getHav_valor() {
        return hav_valor;
    }

    public void setHav_valor(int hav_valor) {
        this.hav_valor = hav_valor;
    }

    public String getHav_descricao() {
        return hav_descricao;
    }

    public void setHav_descricao(String hav_descricao) {
        this.hav_descricao = hav_descricao;
    }


}
