package csb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cbs_epi")
public class Epi implements Serializable {

    public static final String sTitle = "Equipamento de Proteção";
    public static final String pTitle = "Equipamentos de Proteção";

    @Id
    @SequenceGenerator(name = "cbs_epi_pk_sequence", sequenceName = "cbs_epi_epi_codigo_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cbs_epi_pk_sequence")
    private int epi_codigo;
    private String epi_descricao;
    private char epi_tipo;
    private boolean epi_situacao;

    public Epi() {
    }

    public int getEpi_codigo() {
        return epi_codigo;
    }

    public void setEpi_codigo(int epi_codigo) {
        this.epi_codigo = epi_codigo;
    }

    public String getEpi_descricao() {
        return epi_descricao;
    }

    public void setEpi_descricao(String epi_descricao) {
        this.epi_descricao = epi_descricao;
    }

    public char getEpi_tipo() {
        return epi_tipo;
    }

    public void setEpi_tipo(char epi_tipo) {
        this.epi_tipo = epi_tipo;
    }

    public boolean isEpi_situacao() {
        return epi_situacao;
    }

    public void setEpi_situacao(boolean epi_situacao) {
        this.epi_situacao = epi_situacao;
    }

    
}
