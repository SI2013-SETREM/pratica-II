
package cfg.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="idiomas")
public class Idiomas implements Serializable {
    
    public static final String sTitle = "Idioma";
    public static final String pTitle = "Idiomas";
    
    @Id
    @SequenceGenerator(name="idiomas_pk_sequence", sequenceName="idiomas_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="idiomas_pk_sequence")
    private int idi_codigo;
    private String idi_descricao;

    public Idiomas() {
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

}
