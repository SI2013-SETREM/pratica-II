package csb.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_graduacao")
public class Graduacao implements Serializable {
    public static final String sTitle = "Graduacao";
    public static final String pTitle = "Graduações";
    
    @Id
    @SequenceGenerator(name="graduacao_pk_sequence", sequenceName="seq_csb_graduacao")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="graduacao_pk_sequence")
    private int grd_codigo;
    private String grd_descricao;

    public Graduacao() {
    }

    public int getGrd_codigo() {
        return grd_codigo;
    }

    public void setGrd_codigo(int grd_codigo) {
        this.grd_codigo = grd_codigo;
    }

    public String getGrd_descricao() {
        return grd_descricao;
    }

    public void setGrd_descricao(String grd_descricao) {
        this.grd_descricao = grd_descricao;
    }
}
