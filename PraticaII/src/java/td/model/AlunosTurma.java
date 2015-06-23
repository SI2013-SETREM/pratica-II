package td.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="trd_alunos_turma")
public class AlunosTurma implements Serializable {
    
    public static final String sTitle = "Alunos por turma";
    public static final String pTitle = "Alunos por turmas";
    
    @Id
    @SequenceGenerator(name="trd_alunos_turma_pk_sequence", sequenceName="trd_alunos_turma_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="trd_alunos_turma_pk_sequence")
    private int pst_oid;
    private int pst_aprovado;
    private double pst_frequencia;
    private String pst_observacao;

    @ManyToOne
    @JoinColumn(name = "tur_codigo")
    private Turma turma;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pessoa pessoa;
    
   
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getPst_oid() {
        return pst_oid;
    }

    public void setPst_oid(int pst_oid) {
        this.pst_oid = pst_oid;
    }
    
    public int getPst_aprovado() {
        return pst_aprovado;
    }

    public void setPst_aprovado(int pst_aprovado) {
        this.pst_aprovado = pst_aprovado;
    }

    public double getPst_frequencia() {
        return pst_frequencia;
    }

    public void setPst_frequencia(double pst_frequencia) {
        this.pst_frequencia = pst_frequencia;
    }

    public String getPst_observacao() {
        return pst_observacao;
    }

    public void setPst_observacao(String pst_observacao) {
        this.pst_observacao = pst_observacao;
    }
    
    
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public String retornaSituacao(int a){
        if(a == 1){
            return "Aprovado";
        }else
            return "Reprovado";
    }
}
