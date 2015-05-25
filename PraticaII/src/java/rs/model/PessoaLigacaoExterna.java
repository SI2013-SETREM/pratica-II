
package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_pessoa_ligacaoexterna")
@IdClass(PessoaLigacaoExterna.PessoaLigacaoExternaPK.class)
public class PessoaLigacaoExterna implements Serializable {
    
    public static final String sTitle = "Ligação Externa";
    public static final String pTitle = "Ligações Externas";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Id
    private int lex_codigo;
    
    private String lex_titulo;
    private String lex_descricao;
    private String lex_url;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class PessoaLigacaoExternaPK implements Serializable {
        protected Pessoa pessoa;
        protected int lex_codigo;

        public PessoaLigacaoExternaPK() {}

        public PessoaLigacaoExternaPK(Pessoa pessoa, int lex_codigo) {
            this.pessoa = pessoa;
            this.lex_codigo = lex_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 89 * hash + Objects.hashCode(this.pessoa);
            hash = 89 * hash + this.lex_codigo;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final PessoaLigacaoExternaPK other = (PessoaLigacaoExternaPK) obj;
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (this.lex_codigo != other.lex_codigo) {
                return false;
            }
            return true;
        }

    }

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
