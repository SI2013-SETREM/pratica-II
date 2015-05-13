package ad.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_competencias")
public class Tipo_Competencia implements Serializable {

    public static final String sTitle = "Tipo de Competência";
    public static final String pTitle = "Tipo de Competências";

    @Id
    @SequenceGenerator(name = "tipo_competencias_pk_sequence", sequenceName = "tipo_competencias_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tipo_competencias_pk_sequence")
    private int tcp_codigo;
    private String tcp_descricao;

    public Tipo_Competencia() {

    }

    public int getTcp_codigo() {
        return tcp_codigo;
    }

    public void setTcp_codigo(int tcp_codigo) {
        this.tcp_codigo = tcp_codigo;
    }

    public String getTcp_descricao() {
        return tcp_descricao;
    }

    public void setTcp_descricao(String tcp_descricao) {
        this.tcp_descricao = tcp_descricao;
    }
    
}
