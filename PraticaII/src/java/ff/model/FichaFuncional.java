package ff.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Max
 */
@Entity
@Table(name = "ffp_ficha_funcional")
public class FichaFuncional implements Serializable {

    @Id
    @SequenceGenerator(name = "genFichaFuncional", sequenceName = "genFichaFuncional", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genFichaFuncional")
    private int ffu_codigo;
 
    @ManyToOne
    private Pessoa pes_codigo;
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

    public Pessoa getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(Pessoa pes_codigo) {
        this.pes_codigo = pes_codigo;
    }


}
