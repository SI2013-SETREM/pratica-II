package cfg.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "idioma")
public class Idioma implements Serializable {

    public static final String sTitle = "Idioma";
    public static final String pTitle = "Idiomas";

    @Id
    @SequenceGenerator(name = "idioma_pk_sequence", sequenceName = "seq_cfg_idioma")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idioma_pk_sequence")
    private int idi_codigo;
    private String idi_descricao;

    public Idioma() {
    }

    public Idioma(int idi_codigo, String idi_descricao) {
        this.idi_codigo = idi_codigo;
        this.idi_descricao = idi_descricao;
    }

    public int getIdiCodigo() {
        return idi_codigo;
    }

    public void setIdiCodigo(int idi_codigo) {
        this.idi_codigo = idi_codigo;
    }

    public String getIdiDescricao() {
        return idi_descricao;
    }

    public void setIdiDescricao(String idi_descricao) {
        this.idi_descricao = idi_descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idi_codigo;
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
        final Idioma other = (Idioma) obj;
        if (this.idi_codigo != other.idi_codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getIdiDescricao();
    }
}
