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
public class CursosPessoa implements Serializable {
    
    public static final String sTitle = "Cursos por Pessoa";
    public static final String pTitle = "Cursos por Pessoas";
    
    @Id
    @SequenceGenerator(name="trd_cursos_pessoa_pk_sequence", sequenceName="trd_cursos_pessoa_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="trd_cursos_pessoa_pk_sequence")
    
    private int crp_curpes;
    private String crp_descricao;
    private int crp_carga_horaria;
    private Date crp_data_inicio;
    private Date crp_data_fim;
    private Date crp_data_validade;
    private boolean crp_status_validade;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "cur_codigo")
    private Curso curso;
     
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
    
    public int getCrp_curpes() {
        return crp_curpes;
    }

    public void setCrp_curpes(int crp_curpes) {
        this.crp_curpes = crp_curpes;
    }
    
    public String getCrp_descricao() {
        return crp_descricao;
    }

    public void setCrp_descricao(String crp_descricao) {
        this.crp_descricao = crp_descricao;
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

    public boolean getCrp_status_validade() {
        return crp_status_validade;
    }

    public void setCrp_status_validade(boolean crp_status_validade) {
        this.crp_status_validade = crp_status_validade;
    }
   
    
}
