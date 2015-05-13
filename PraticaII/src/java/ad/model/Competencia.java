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
@Table(name = "competencias")
public class Competencia implements Serializable {

    public static final String sTitle = "Competência";
    public static final String pTitle = "Competências";

    @Id
    @SequenceGenerator(name = "competencias_pk_sequence", sequenceName = "competencias_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "competencias_pk_sequence")
    private int cmp_codigo;
    private String cmp_descricao;
    private char cmp_status;
    @ManyToOne
    @JoinColumn(name = "codtipocompetencia")
    private Tipo_Competencia tipo_competencia;

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

    public char getCmp_status() {
        return cmp_status;
    }

    public void setCmp_status(char cmp_status) {
        this.cmp_status = cmp_status;
    }

    public Tipo_Competencia getTipo_competencia() {
        return tipo_competencia;
    }

    public void setTipo_competencia(Tipo_Competencia tipo_competencia) {
        this.tipo_competencia = tipo_competencia;
    }

}
