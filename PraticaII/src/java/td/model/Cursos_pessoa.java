package td.model;

import cfg.model.Empresa;
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

@Entity
@Table(name="trd_cursos_pessoa")
public class Cursos_pessoa implements Serializable {
    
    public static final String sTitle = "Cursos por Pessoa";
    public static final String pTitle = "Cursos por Pessoas";
    
    @Id
    @SequenceGenerator(name="trd_cursos_pessoa_pk_sequence", sequenceName="trd_cursos_pessoa_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="trd_cursos_pessoa_pk_sequence")
    
    private int crp_observacao;
    private int crp_carga_horaria;
    private Date crp_data_inicio;
    private Date crp_data_fim;
    private Date crp_data_validade;
    private int crp_status_validade;
    @ManyToOne
    @JoinColumn(name = "codigo_curso")
    private Curso curso;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "emp_codigo")
    private Empresa empresa;

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
    
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getCrp_observacao() {
        return crp_observacao;
    }

    public void setCrp_observacao(int crp_observacao) {
        this.crp_observacao = crp_observacao;
    }

    public int getCrp_carga_horaria() {
        return crp_carga_horaria;
    }

    public void setCrp_carga_horaria(int crp_carga_horaria) {
        this.crp_carga_horaria = crp_carga_horaria;
    }

    public Date getCrp_data_inicio() {
        return crp_data_inicio;
    }

    public void setCrp_data_inicio(Date crp_data_inicio) {
        this.crp_data_inicio = crp_data_inicio;
    }

    public Date getCrp_data_fim() {
        return crp_data_fim;
    }

    public void setCrp_data_fim(Date crp_data_fim) {
        this.crp_data_fim = crp_data_fim;
    }

    public Date getCrp_data_validade() {
        return crp_data_validade;
    }

    public void setCrp_data_validade(Date crp_data_validade) {
        this.crp_data_validade = crp_data_validade;
    }

    public int getCrp_status_validade() {
        return crp_status_validade;
    }

    public void setCrp_status_validade(int crp_status_validade) {
        this.crp_status_validade = crp_status_validade;
    }
   
    
}
