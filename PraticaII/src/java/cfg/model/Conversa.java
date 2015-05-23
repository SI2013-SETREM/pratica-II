
package cfg.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="conversa")
public class Conversa implements Serializable {
    
    public static final String sTitle = "Conversa";
    public static final String pTitle = "Conversas";
    
    @Id
    @SequenceGenerator(name="conversa_pk_sequence", sequenceName="conversa_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="conversa_pk_sequence")
    private int cnv_codigo;
    @ManyToOne
    @JoinColumn(name="pes_codigo_criador", referencedColumnName = "pes_codigo")
    private Pessoa pessoa_criador;
    private String cnv_assunto;

    public Conversa() {
    }

    public int getCnvCodigo() {
        return cnv_codigo;
    }

    public void setCnvCodigo(int cnv_codigo) {
        this.cnv_codigo = cnv_codigo;
    }

    public Pessoa getPessoaCriador() {
        return pessoa_criador;
    }

    public void setPessoaCriador(Pessoa pessoa_criador) {
        this.pessoa_criador = pessoa_criador;
    }

    public String getCnvAssunto() {
        return cnv_assunto;
    }

    public void setCnvAssunto(String cnv_assunto) {
        this.cnv_assunto = cnv_assunto;
    }
    
    
    
    
    
}
