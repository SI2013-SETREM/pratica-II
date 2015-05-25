
package cfg.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="alias")
public class Alias implements Serializable {
    
    public static final String sTitle = "Apelido";
    public static final String pTitle = "Apelidos";
    
    @Id
    @SequenceGenerator(name="alias_pk_sequence", sequenceName="seq_cfg_alias")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="alias_pk_sequence")
    private int als_codigo;
    
    private String als_nome;
    private int als_status;

    @ManyToMany
    @JoinTable(name = "als_pes")
    private List<Pessoa> pessoas;
    
    @ManyToMany
    @JoinTable(name = "cnv_als")
    private List<Conversa> conversas;
    
    @ManyToMany
    @JoinTable(name = "als_msg")
    private List<Mensagem> mensagens;
    
    public Alias() {
    }

    public int getAlsCodigo() {
        return als_codigo;
    }

    public void setAlsCodigo(int als_codigo) {
        this.als_codigo = als_codigo;
    }

    public String getAlsNome() {
        return als_nome;
    }

    public void setAlsNome(String als_nome) {
        this.als_nome = als_nome;
    }

    public int getAlsStatus() {
        return als_status;
    }

    public void setAlsStatus(int als_status) {
        this.als_status = als_status;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Conversa> getConversas() {
        return conversas;
    }

    public void setConversas(List<Conversa> conversas) {
        this.conversas = conversas;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

}
