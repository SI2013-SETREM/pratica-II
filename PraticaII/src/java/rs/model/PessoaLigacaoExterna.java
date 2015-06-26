
package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
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

@Entity
@Table(name="rec_pessoa_ligacaoexterna")
public class PessoaLigacaoExterna implements Serializable {
    
    public static final String sTitle = "Ligação Externa";
    public static final String pTitle = "Ligações Externas";
    
    @Id
    @SequenceGenerator(name = "pesligacaoexterna_pk_sequence", sequenceName = "seq_rs_pessoa_ligacaoexterna")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pesligacaoexterna_pk_sequence")
    private int lex_codigo;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    private String lex_titulo;
    private String lex_descricao;
    private String lex_url;

    public PessoaLigacaoExterna() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getLexCodigo() {
        return lex_codigo;
    }

    public void setLexCodigo(int lex_codigo) {
        this.lex_codigo = lex_codigo;
    }

    public String getLexTitulo() {
        return lex_titulo;
    }

    public void setLexTitulo(String lex_titulo) {
        this.lex_titulo = lex_titulo;
    }

    public String getLexDescricao() {
        return lex_descricao;
    }

    public void setLexDescricao(String lex_descricao) {
        this.lex_descricao = lex_descricao;
    }

    public String getLexUrl() {
        return lex_url;
    }

    public void setLexUrl(String lex_url) {
        this.lex_url = lex_url;
    }

    
    
}
