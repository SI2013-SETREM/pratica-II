package ad.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "avd_competencia")
public class Competencia implements Serializable {

    public static String sTitle = "Competência";
    public static String pTitle = "Competências";

    @Id
    @SequenceGenerator(name = "competencia_pk_sequence", sequenceName = "competencia_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "competencia_pk_sequence")
    private int cmp_codigo;
    private String cmp_descricao;
    private int cmp_status;

    @ManyToOne
    @JoinColumn(name = "tcp_codigo", referencedColumnName = "tcp_codigo")
    private TipoCompetencia tipocompetencia;

    public Competencia() {
    }

    public int getCmp_codigo() {
        return cmp_codigo;
    }

    public void setCmp_codigo(int cmp_codigo) {
        this.cmp_codigo = cmp_codigo;
    }

    public String getCmp_descricao() {
        return cmp_descricao;
    }

    public void setCmp_descricao(String cmp_descricao) {
        this.cmp_descricao = cmp_descricao;
    }

    public int getCmp_status() {
        return cmp_status;
    }

    public void setCmp_status(int cmp_status) {
        this.cmp_status = cmp_status;
    }

    public TipoCompetencia getTipocompetencia() {
        return tipocompetencia;
    }

    public void setTipocompetencia(TipoCompetencia tipocompetencia) {
        this.tipocompetencia = tipocompetencia;
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
        hash = 79 * hash + this.cmp_codigo;
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
        final Competencia other = (Competencia) obj;
        if (this.cmp_codigo != other.cmp_codigo) {
            return false;
        }
        return true;
    }

}
