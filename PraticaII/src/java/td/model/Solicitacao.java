package td.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="trd_solicitacao")
public class Solicitacao implements Serializable{
    
    @Id
    @SequenceGenerator(name="trd_solicitacao_pk_sequence", sequenceName="trd_solicitacao_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="trd_solicitacao_pk_sequence")
    private int sol_codigo;
    private String sol_descricao;
    private Date sol_data;
    private int sol_prioridade;

    public int getSol_codigo() {
        return sol_codigo;
    }

    public void setSol_codigo(int sol_codigo) {
        this.sol_codigo = sol_codigo;
    }

    public String getSol_descricao() {
        return sol_descricao;
    }

    public void setSol_descricao(String sol_descricao) {
        this.sol_descricao = sol_descricao;
    }

    public Date getSol_data() {
        return sol_data;
    }

    public void setSol_data(Date sol_data) {
        this.sol_data = sol_data;
    }

    public Integer getSol_prioridade() {
        return sol_prioridade;
    }

    public void setSol_prioridade(Integer sol_prioridade) {
        this.sol_prioridade = sol_prioridade;
    }
}
