package ff.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Max
 */
@Entity
@Table(name = "ffp_ferias")
public class Ferias implements Serializable {

    @Id
    @SequenceGenerator(name = "genFerias", sequenceName = "genFerias", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genFerias")
    private int fer_codigo;
    @ManyToOne   
    @JoinColumn (name = "ffu_codigo", referencedColumnName = "ffu_codigo")
    private FichaFuncional fichaFuncional;
    private Date fer_data_inicio;
    private Date fer_data_fim;
    private String fer_observacao;

    public int getFer_codigo() {
        return fer_codigo;
    }

    public void setFer_codigo(int fer_codigo) {
        this.fer_codigo = fer_codigo;
    }

    public Date getFer_data_inicio() {
        return fer_data_inicio;
    }

    public void setFer_data_inicio(Date fer_data_inicio) {
        this.fer_data_inicio = fer_data_inicio;
    }

    public Date getFer_data_fim() {
        return fer_data_fim;
    }

    public void setFer_data_fim(Date fer_data_fim) {
        this.fer_data_fim = fer_data_fim;
    }

    public String getFer_observacao() {
        return fer_observacao;
    }

    public void setFer_observacao(String fer_observacao) {
        this.fer_observacao = fer_observacao;
    }

    public FichaFuncional getFichaFuncional() {
        return fichaFuncional;
    }

    public void setFichaFuncional(FichaFuncional fichaFuncional) {
        this.fichaFuncional = fichaFuncional;
    }

 
}