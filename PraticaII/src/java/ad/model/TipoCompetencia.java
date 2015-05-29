package ad.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "avd_tipo_competencia")
public class TipoCompetencia implements Serializable {

    public static final String sTitle = "Tipo de Competência";
    public static final String pTitle = "Tipos de Competências";

    @Id
    @SequenceGenerator(name = "tipo_competencia_pk_sequence", sequenceName = "tipo_competencia_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tipo_competencia_pk_sequence")
    private int tcp_codigo;
    private String tcp_descricao;

    public TipoCompetencia() {
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

    public static String getsTitle() {
        return sTitle;
    }

    public static String getpTitle() {
        return pTitle;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.tcp_codigo;
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
        final TipoCompetencia other = (TipoCompetencia) obj;
        if (this.tcp_codigo != other.tcp_codigo) {
            return false;
        }
        return true;
    }
}
