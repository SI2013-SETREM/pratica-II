
package rs.model;

import cfg.model.Empresa;
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

@Entity
@Table(name="rec_pessoa_formacao")
@IdClass(PessoaFormacao.PessoaFormacaoPK.class)
public class PessoaFormacao implements Serializable {
    
    public static final String sTitle = "Formação";
    public static final String pTitle = "Formações";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
    private Empresa empresa;
    
    @Id
    private int frm_codigo;
    
    private String frm_curso;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date frm_datainicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date frm_datafim;
    
    private String frm_referencia;
    private String frm_anotacao;
    private int frm_tipo;
    private int frm_status;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class PessoaFormacaoPK implements Serializable {
        protected Pessoa pessoa;
        protected Empresa empresa;
        protected int frm_codigo;

        public PessoaFormacaoPK() {}

        public PessoaFormacaoPK(Pessoa pessoa, Empresa empresa, int frm_codigo) {
            this.pessoa = pessoa;
            this.empresa = empresa;
            this.frm_codigo = frm_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 47 * hash + Objects.hashCode(this.pessoa);
            hash = 47 * hash + Objects.hashCode(this.empresa);
            hash = 47 * hash + this.frm_codigo;
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
            final PessoaFormacaoPK other = (PessoaFormacaoPK) obj;
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (!Objects.equals(this.empresa, other.empresa)) {
                return false;
            }
            if (this.frm_codigo != other.frm_codigo) {
                return false;
            }
            return true;
        }

    }

    public PessoaFormacao() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getFrmCodigo() {
        return frm_codigo;
    }

    public void setFrmCodigo(int frm_codigo) {
        this.frm_codigo = frm_codigo;
    }

    public String getFrmCurso() {
        return frm_curso;
    }

    public void setFrmCurso(String frm_curso) {
        this.frm_curso = frm_curso;
    }

    public Date getFrmDatainicio() {
        return frm_datainicio;
    }

    public void setFrmDatainicio(Date frm_datainicio) {
        this.frm_datainicio = frm_datainicio;
    }

    public Date getFrmDatafim() {
        return frm_datafim;
    }

    public void setFrmDatafim(Date frm_datafim) {
        this.frm_datafim = frm_datafim;
    }

    public String getFrmReferencia() {
        return frm_referencia;
    }

    public void setFrmReferencia(String frm_referencia) {
        this.frm_referencia = frm_referencia;
    }

    public String getFrmAnotacao() {
        return frm_anotacao;
    }

    public void setFrmAnotacao(String frm_anotacao) {
        this.frm_anotacao = frm_anotacao;
    }

    public int getFrmTipo() {
        return frm_tipo;
    }

    public void setFrmTipo(int frm_tipo) {
        this.frm_tipo = frm_tipo;
    }

    public int getFrmStatus() {
        return frm_status;
    }

    public void setFrmStatus(int frm_status) {
        this.frm_status = frm_status;
    }
    
    
    
    
}
