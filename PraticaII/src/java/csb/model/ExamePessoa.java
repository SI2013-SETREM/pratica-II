package csb.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_examepessoa")
@IdClass(ExamePessoa.ExamePessoaPK.class)
public class ExamePessoa implements Serializable {

    public static final String sTitle = "Exame";
    public static final String pTitle = "Exames";

    @Id
    @ManyToOne
    @JoinColumn(name = "eme_codigo", referencedColumnName = "eme_codigo")
    private TipoExame eme_codigo;
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pes_codigo; 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eps_dataexame;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eps_datavalidade;
    private boolean eps_situacao;
    private String eps_observacao;

    
    public class ExamePessoaPK implements Serializable {
        protected TipoExame tipoexame;
        protected Pessoa pessoa;

        public ExamePessoaPK() {}

        public ExamePessoaPK(TipoExame tipoexame, Pessoa pessoa) {
            this.tipoexame = tipoexame;
            this.pessoa = pessoa;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.tipoexame);
            hash = 17 * hash + Objects.hashCode(this.pessoa);
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
            final ExamePessoaPK other = (ExamePessoaPK) obj;
            if (!Objects.equals(this.tipoexame, other.tipoexame)) {
                return false;
            }
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            return true;
        }
        
    }
    
    public ExamePessoa() {
    }

    public TipoExame getEme_codigo() {
        return eme_codigo;
    }

    public void setEme_codigo(TipoExame eme_codigo) {
        this.eme_codigo = eme_codigo;
    }

    public Pessoa getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(Pessoa pes_codigo) {
        this.pes_codigo = pes_codigo;
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
}
