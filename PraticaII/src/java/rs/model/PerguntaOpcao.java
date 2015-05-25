
package rs.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_pergunta_opcao")
@IdClass(PerguntaOpcao.PerguntaOpcaoPK.class)
public class PerguntaOpcao implements Serializable {
    
    // Eu tenho que ter essas opção, ou eu posso ter a minha própria opção?
    public static final String sTitle = "Opção";
    public static final String pTitle = "Opções";
    
    @Id
    @ManyToOne
    @JoinColumns( {
        @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo"),
        @JoinColumn(name = "prg_codigo", referencedColumnName = "prg_codigo")
    })
    private Pergunta pergunta;
    
    @Id
    private int opc_codigo;
    
    private String opc_nome;
    private String opc_descricao;
    private int opc_pontuacao;
    
    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class PerguntaOpcaoPK implements Serializable {
        protected Pergunta pergunta;
        protected int opc_codigo;

        public PerguntaOpcaoPK() {}

        public PerguntaOpcaoPK(Pergunta pergunta, int opc_codigo) {
            this.pergunta = pergunta;
            this.opc_codigo = opc_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 23 * hash + Objects.hashCode(this.pergunta);
            hash = 23 * hash + this.opc_codigo;
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
            final PerguntaOpcaoPK other = (PerguntaOpcaoPK) obj;
            if (!Objects.equals(this.pergunta, other.pergunta)) {
                return false;
            }
            if (this.opc_codigo != other.opc_codigo) {
                return false;
            }
            return true;
        }

    }

    public PerguntaOpcao() {
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public int getOpcCodigo() {
        return opc_codigo;
    }

    public void setOpcCodigo(int opc_codigo) {
        this.opc_codigo = opc_codigo;
    }

    public String getOpcNome() {
        return opc_nome;
    }

    public void setOpcNome(String opc_nome) {
        this.opc_nome = opc_nome;
    }

    public String getOpcDescricao() {
        return opc_descricao;
    }

    public void setOpcDescricao(String opc_descricao) {
        this.opc_descricao = opc_descricao;
    }

    public int getOpcPontuacao() {
        return opc_pontuacao;
    }

    public void setOpcPontuacao(int opc_pontuacao) {
        this.opc_pontuacao = opc_pontuacao;
    }

    
    
}
