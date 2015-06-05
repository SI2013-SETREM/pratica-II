
package rs.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_pergunta_opcao")
@IdClass(PerguntaOpcaoPK.class)
public class PerguntaOpcao implements Serializable {
    
    // Eu tenho que ter essas opção, ou eu posso ter a minha própria opção?
    public static final String sTitle = "Opção";
    public static final String pTitle = "Opções";
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo"),
        @JoinColumn(name = "prg_codigo", referencedColumnName = "prg_codigo")
    })
    private Pergunta pergunta;
    
    @Id
    private int opc_codigo;
    
    private String opc_nome;
    private String opc_descricao;
    private int opc_pontuacao;
    
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
