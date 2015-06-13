package csb.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@IdClass(ExamePessoa.ExamePessoaPK.class)
public class ExamePessoa implements Serializable {

    public static final String sTitle = "Exame";
    public static final String pTitle = "Exames";

    @Id
    @SequenceGenerator(name = "exa_codigo", sequenceName = "exa_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "exa_codigo")
    private int exa_codigo;

    public int getExa_codigo() {
        return exa_codigo;
    }

    public void setExa_codigo(int exa_codigo) {
        this.exa_codigo = exa_codigo;
    }
    
    @Id
    @ManyToOne
    @JoinColumn(name = "eme_codigo", referencedColumnName = "eme_codigo")
    private TipoExame tipoExame;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eps_dataexame;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date eps_datavalidade;
    private boolean eps_situacao;
    private String eps_observacao;

    
    public class ExamePessoaPK implements Serializable {
        protected TipoExame tipoExame;
        protected Pessoa pessoa;

        public ExamePessoaPK() {}

        public ExamePessoaPK(TipoExame tipoexame, Pessoa pessoa) {
            this.tipoExame = tipoexame;
            this.pessoa = pessoa;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.tipoExame);
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
            if (!Objects.equals(this.tipoExame, other.tipoExame)) {
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

    public TipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
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
}
