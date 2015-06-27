
package rs.model;

import cfg.model.Empresa;
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

@Entity
@Table(name="rec_pessoa_experiencia")
public class PessoaExperiencia implements Serializable {
    
    public static final String sTitle = "Experiência";
    public static final String pTitle = "Experiências";
    
    @Id
    @SequenceGenerator(name = "pesexperiencia_pk_sequence", sequenceName = "seq_rs_pessoa_experiencia")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pesexperiencia_pk_sequence")
    private int exp_codigo;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
    private Empresa empresa;
    
    private String exp_cargo;
    private String exp_descricao;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date exp_datainicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date exp_datafim;
    
    private String exp_local;
    private String exp_referencia;
    private String exp_anotacao;
    private boolean exp_voluntario;

    public PessoaExperiencia() {
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

    public int getExpCodigo() {
        return exp_codigo;
    }

    public void setExpCodigo(int exp_codigo) {
        this.exp_codigo = exp_codigo;
    }

    public String getExpCargo() {
        return exp_cargo;
    }

    public void setExpCargo(String exp_cargo) {
        this.exp_cargo = exp_cargo;
    }

    public String getExpDescricao() {
        return exp_descricao;
    }

    public void setExpDescricao(String exp_descricao) {
        this.exp_descricao = exp_descricao;
    }

    public Date getExpDatainicio() {
        return exp_datainicio;
    }

    public void setExpDatainicio(Date exp_datainicio) {
        this.exp_datainicio = exp_datainicio;
    }

    public Date getExpDatafim() {
        return exp_datafim;
    }

    public void setExpDatafim(Date exp_datafim) {
        this.exp_datafim = exp_datafim;
    }

    public String getExpLocal() {
        return exp_local;
    }

    public void setExpLocal(String exp_local) {
        this.exp_local = exp_local;
    }

    public String getExpReferencia() {
        return exp_referencia;
    }

    public void setExpReferencia(String exp_referencia) {
        this.exp_referencia = exp_referencia;
    }

    public String getExpAnotacao() {
        return exp_anotacao;
    }

    public void setExpAnotacao(String exp_anotacao) {
        this.exp_anotacao = exp_anotacao;
    }

    public boolean isExpVoluntario() {
        return exp_voluntario;
    }

    public void setExpVoluntario(boolean exp_voluntario) {
        this.exp_voluntario = exp_voluntario;
    }
    
}
