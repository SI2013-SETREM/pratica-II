
package rs.model;

import cfg.model.Idioma;
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
@Table(name="rec_pessoa_idioma")
public class PessoaIdioma implements Serializable {
    
    public static final String sTitle = "Idioma";
    public static final String pTitle = "Idiomas";
    
    @Id
    @SequenceGenerator(name = "pesidioma_pk_sequence", sequenceName = "seq_rs_pessoa_idioma")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pesidioma_pk_sequence")
    private int pes_idi_codigo;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "idi_codigo", referencedColumnName = "idi_codigo")
    private Idioma idioma;
    
    /**
     * 1 - Básico 
     * 2 - Básico a Intermediário 
     * 3 - Intermediário 
     * 4 - Avançado 
     * 5 - Fluente 
     */
    private int pes_idi_nivelfala;
    private int pes_idi_nivelescrita;

    private String[] niveis = {
        "", //0 não existe
        "Básico", //1
        "Básico a Intermediário", //2
        "Intermediário", //3
        "Avançado", //4
        "Fluente", //5
    };
    
    public PessoaIdioma() {
    }

    public int getPesIdiCodigo() {
        return pes_idi_codigo;
    }

    public void setPesIdiCodigo(int pes_idi_codigo) {
        this.pes_idi_codigo = pes_idi_codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public int getPesIdiNivelfala() {
        return pes_idi_nivelfala;
    }

    public void setPesIdiNivelfala(int pes_idi_nivelfala) {
        this.pes_idi_nivelfala = pes_idi_nivelfala;
    }

    public int getPesIdiNivelescrita() {
        return pes_idi_nivelescrita;
    }

    public void setPesIdiNivelescrita(int pes_idi_nivelescrita) {
        this.pes_idi_nivelescrita = pes_idi_nivelescrita;
    }
    
    public String getNivelDsc(int nivel) {
        if (nivel > 1 && nivel < this.niveis.length) {
            return this.niveis[nivel];
        } else {
            return this.niveis[0];
        }
    }
    
}
