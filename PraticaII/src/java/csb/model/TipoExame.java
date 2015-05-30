package csb.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "csb_tipoexame")
public class TipoExame implements Serializable {

    public static final String sTitle = "Tipo de Exame";
    public static final String pTitle = "Tipos de Exames";

    @Id
    @SequenceGenerator(name = "cbs_tipoexame_pk_sequence", sequenceName = "cbs_tipoexame_eme_codigo_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cbs_tipoexame_pk_sequence")
    private int eme_codigo;
    private String eme_descricao;
    private char eme_tipo;
    private boolean eme_periodico;
    private int eme_validade;
    private boolean eme_obrigatorio;
    private int eme_intervalorepeticao;

    public TipoExame() {
    }

    public int getEme_codigo() {
        return eme_codigo;
    }

    public void setEme_codigo(int eme_codigo) {
        this.eme_codigo = eme_codigo;
    }

    public String getEme_descricao() {
        return eme_descricao;
    }

    public void setEme_descricao(String eme_descricao) {
        this.eme_descricao = eme_descricao;
    }

    public char getEme_tipo() {
        return eme_tipo;
    }

    public void setEme_tipo(char eme_tipo) {
        this.eme_tipo = eme_tipo;
    }

    public boolean isEme_periodico() {
        return eme_periodico;
    }

    public void setEme_periodico(boolean eme_periodico) {
        this.eme_periodico = eme_periodico;
    }

    public int getEme_validade() {
        return eme_validade;
    }

    public void setEme_validade(int eme_validade) {
        this.eme_validade = eme_validade;
    }

    public boolean isEme_obrigatorio() {
        return eme_obrigatorio;
    }

    public void setEme_obrigatorio(boolean eme_obrigatorio) {
        this.eme_obrigatorio = eme_obrigatorio;
    }

    public int getEme_intervalorepeticao() {
        return eme_intervalorepeticao;
    }

    public void setEme_intervalorepeticao(int eme_intervalorepeticao) {
        this.eme_intervalorepeticao = eme_intervalorepeticao;
    }
}
