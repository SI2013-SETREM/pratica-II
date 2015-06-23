package csb.model;

import cfg.model.Pessoa;
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
import javax.persistence.Temporal;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_examepessoa")
public class ExamePessoa implements Serializable {

    public static final String sTitle = "Exame";
    public static final String pTitle = "Exames";

    @Id
    @SequenceGenerator(name = "exa_codigo", sequenceName = "exa_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "exa_codigo")
    private int exa_codigo;

    @ManyToOne
    @JoinColumn(name = "eme_codigo")
    private TipoExame tipoexame;

    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pessoa pessoa;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eps_dataexame;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eps_datavalidade;
    private boolean eps_situacao;
    private String eps_observacao;

    public ExamePessoa() {
    }

    public int getExa_codigo() {
        return exa_codigo;
    }

    public void setExa_codigo(int exa_codigo) {
        this.exa_codigo = exa_codigo;
    }

    public TipoExame getTipoexame() {
        return tipoexame;
    }

    public void setTipoexame(TipoExame tipoexame) {
        this.tipoexame = tipoexame;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getEps_dataexame() {
        return eps_dataexame;
    }

    public void setEps_dataexame(Date eps_dataexame) {
        this.eps_dataexame = eps_dataexame;
    }

    public Date getEps_datavalidade() {
        return eps_datavalidade;
    }

    public void setEps_datavalidade(Date eps_datavalidade) {
        this.eps_datavalidade = eps_datavalidade;
    }

    public boolean isEps_situacao() {
        return eps_situacao;
    }

    public void setEps_situacao(boolean eps_situacao) {
        this.eps_situacao = eps_situacao;
    }

    public String getEps_observacao() {
        return eps_observacao;
    }

    public void setEps_observacao(String eps_observacao) {
        this.eps_observacao = eps_observacao;
    }

    public String getExa_dataToString(Date data) {
        return util.Utilidades.getDataString(data);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.exa_codigo;
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
        final ExamePessoa other = (ExamePessoa) obj;
        if (this.exa_codigo != other.exa_codigo) {
            return false;
        }
        return true;
    }
}
