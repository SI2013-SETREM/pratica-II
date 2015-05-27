
package cfg.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "parametro")
public class Parametro implements Serializable {

    public static final String sTitle = "Parâmetro";
    public static final String pTitle = "Parâmetros";

    @Id
    @SequenceGenerator(name = "par_codigo", sequenceName = "par_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "par_codigo")
    private int par_codigo;
    
    private int par_qst_pontuacaomax_padrao;

    public Parametro() {
    }

    public int getPar_codigo() {
        return par_codigo;
    }

    public void setPar_codigo(int par_codigo) {
        this.par_codigo = par_codigo;
    }

    public int getPar_qst_pontuacaomax_padrao() {
        return par_qst_pontuacaomax_padrao;
    }

    public void setPar_qst_pontuacaomax_padrao(int par_qst_pontuacaomax_padrao) {
        this.par_qst_pontuacaomax_padrao = par_qst_pontuacaomax_padrao;
    }
    
}
