package ad.model;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import rs.model.Pergunta;
import rs.model.Questionario;

//@Table(name = "avaliacao_pessoa_cargo")
public class PerguntaPessoaAvaliacao implements Serializable {

//    @ManyToOne
//    @JoinColumn(name = "codpessoa")
//    private Pessoa pessoa;

//    @ManyToOne
//    @JoinColumn(name = "codavaliador")
//    private Pessoa avaliador;

    @ManyToOne
    @JoinColumn(name = "codavaiacao")
    private Avaliacao avaliacao;

    @ManyToOne
    @JoinColumn(name = "codquestionario")
    private Questionario questionario;

    @ManyToOne
    @JoinColumn(name = "codpergunta")
    private Pergunta pergunta;

    private String ppa_resposta;
    private double ppa_valor;

    public PerguntaPessoaAvaliacao() {
    }

}
