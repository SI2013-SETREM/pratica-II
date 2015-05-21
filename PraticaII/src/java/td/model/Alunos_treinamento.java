package td.model;

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
@Table(name="trd_alunos_treinamento")
public class Alunos_treinamento implements Serializable {
    
    @Id
    @SequenceGenerator(name="trd_alunos_treinamento_pk_sequence", sequenceName="trd_alunos_treinamento_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="trd_alunos_treinamento_pk_sequence")
    private int tra_aprovado;
    private double tra_frequencia;
    private String tra_observacao;
    @ManyToOne
    @JoinColumn(name = "tre_codigo")
    private Treinamento treinamento;
    /* 
    @ManyToOne
    @JoinColumn(name = "pes_codigo_aluno")
    private Pessoa pessoa;
    
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    */

    public int getTra_aprovado() {
        return tra_aprovado;
    }

    public void setTra_aprovado(int tra_aprovado) {
        this.tra_aprovado = tra_aprovado;
    }

    public double getTra_frequencia() {
        return tra_frequencia;
    }

    public void setTra_frequencia(double tra_frequencia) {
        this.tra_frequencia = tra_frequencia;
    }

    public String getTra_observacao() {
        return tra_observacao;
    }

    public void setTra_observacao(String tra_observacao) {
        this.tra_observacao = tra_observacao;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }
}
