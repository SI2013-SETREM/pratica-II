
package rs.model;

import cfg.model.Pessoa;
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



/**
 * @author Dinei A. Rockenbach
 */
@Entity
@Table(name = "rec_areainteresse")
public class AreaInteresse implements Serializable {
    
    public static final String sTitle = "Idioma";
    public static final String pTitle = "Idiomas";
    
    @Id
    @SequenceGenerator(name="areainteresse_pk_sequence", sequenceName="seq_rs_areainteresse")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="areainteresse_pk_sequence")
    private int ari_codigo;
    
    private String ari_descricao;
    
    @ManyToMany
    @JoinTable(name = "rec_pessoa_areainteresse")
    private List<Pessoa> pessoas;
    
    public AreaInteresse() {
    }

    public int getAriCodigo() {
        return ari_codigo;
    }

    public void setAriCodigo(int ari_codigo) {
        this.ari_codigo = ari_codigo;
    }

    public String getAriDescricao() {
        return ari_descricao;
    }

    public void setAriDescricao(String ari_descricao) {
        this.ari_descricao = ari_descricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
}
