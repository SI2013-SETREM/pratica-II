package ad.model;

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
//@Table(name = "avaliacao_pessoa_cargo")
public class AvaliacaoPessoaCargo implements Serializable {

    @Id
    @SequenceGenerator(name = "avaliacao_pessoa_cargo_pk_sequence", sequenceName = "avaliacao_pessoa_cargo_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "avaliacao_pessoa_cargo_pk_sequence")
    private int apc_codigo;
    @ManyToOne
    @JoinColumn(name = "codavaliacao")
    private Avaliacao avaliacao;
//@ManyToOne
//@JoinColumn(name = "cargo")
//private Cargo cargo;

//@ManyToOne
//@JoinColumn(name = "pessoa")
//private Pessoa pessoa;
    private int apc_status;

    public AvaliacaoPessoaCargo() {
    }

}
