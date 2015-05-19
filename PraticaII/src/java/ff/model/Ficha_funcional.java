package ff.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Max
 */
@Entity
@SequenceGenerator(name = "genFicha_funcional", sequenceName = "genFicha_funcional", allocationSize = 1)
public class Ficha_funcional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genFicha_funcional")
    private int ffu_codigo;
 
    @Column(nullable = false)
    private int ffp_situacao_ficha;
    @Column(nullable = false)
    private Date ffp_data_adimissao;
    private Date ffp_data_desligamento;

    public int getFfu_codigo() {
        return ffu_codigo;
    }

    public void setFfu_codigo(int ffu_codigo) {
        this.ffu_codigo = ffu_codigo;
    }

    public int getFfp_situacao_ficha() {
        return ffp_situacao_ficha;
    }

    public void setFfp_situacao_ficha(int ffp_situacao_ficha) {
        this.ffp_situacao_ficha = ffp_situacao_ficha;
    }

    public Date getFfp_data_adimissao() {
        return ffp_data_adimissao;
    }

    public void setFfp_data_adimissao(Date ffp_data_adimissao) {
        this.ffp_data_adimissao = ffp_data_adimissao;
    }

    public Date getFfp_data_desligamento() {
        return ffp_data_desligamento;
    }

    public void setFfp_data_desligamento(Date ffp_data_desligamento) {
        this.ffp_data_desligamento = ffp_data_desligamento;
    }
}
