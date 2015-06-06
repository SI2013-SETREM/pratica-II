package ff.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "ffp_ficha_funcional")
public class FichaFuncional implements Serializable {

    @Id
    @SequenceGenerator(name = "genFichaFuncional", sequenceName = "genFichaFuncional", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genFichaFuncional")
    private int ffu_codigo;
 
    @ManyToOne
    @JoinColumn (name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    @Column(nullable = false)
    private int ffp_situacao_ficha;
    @Column(nullable = false)
    private Date ffp_data_admissao;
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

    public Date getFfp_data_desligamento() {
        return ffp_data_desligamento;
    }

    public void setFfp_data_desligamento(Date ffp_data_desligamento) {
        this.ffp_data_desligamento = ffp_data_desligamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getFfp_data_admissao() {
        return ffp_data_admissao;
    }

    public void setFfp_data_admissao(Date ffp_data_admissao) {
        this.ffp_data_admissao = ffp_data_admissao;
    }

  

   


}
