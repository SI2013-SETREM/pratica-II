package ad.model;

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
@Table(name = "avaliacao_pessoa_cargo")
public class Avaliacao_pessoa_cargo implements Serializable {
//acho q nau precisa do sTitle aki, pois aqui n'ao vai ter nenhuma tela

    @Id
    @SequenceGenerator(name = "avaliacao_pessoa_cargo_pk_sequence", sequenceName = "avaliacao_pessoa_cargo_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "avaliacao_pessoa_cargo_pk_sequence")
    private int apc_codigo;
    @ManyToOne
    @JoinColumn(name = "ava_codigo")
    private Avaliacao avaliacao;

//    @ManyToOne
//    @JoinColumn(name = "cargo")
//    private Cargo cargo;
    @ManyToOne
    @JoinColumn(name = "pes_codigo")
    private Pessoa pessoa;

    private int apc_status;

    public Avaliacao_pessoa_cargo() {
    }

    public int getApc_codigo() {
        return apc_codigo;
    }

    public void setApc_codigo(int apc_codigo) {
        this.apc_codigo = apc_codigo;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getApc_status() {
        return apc_status;
    }

    public void setApc_status(int apc_status) {
        this.apc_status = apc_status;
    }

}
