
package rs.model;

import cfg.model.Idioma;
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
@Table(name="rec_pessoa_idioma")
@IdClass(PessoaIdioma.PessoaIdiomaPK.class)
public class PessoaIdioma implements Serializable {
    
    public static final String sTitle = "Idioma";
    public static final String pTitle = "Idiomas";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idi_codigo", referencedColumnName = "idi_codigo")
    private Idioma idioma;
    
    private int pes_idi_nivelfala;
    private int pes_idi_nivelescrita;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class PessoaIdiomaPK implements Serializable {
        protected Pessoa pessoa;
        protected Idioma idioma;

        public PessoaIdiomaPK() {}

        public PessoaIdiomaPK(Pessoa pessoa, Idioma idioma) {
            this.pessoa = pessoa;
            this.idioma = idioma;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 41 * hash + Objects.hashCode(this.pessoa);
            hash = 41 * hash + Objects.hashCode(this.idioma);
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
            final PessoaIdiomaPK other = (PessoaIdiomaPK) obj;
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (!Objects.equals(this.idioma, other.idioma)) {
                return false;
            }
            return true;
        }
        
    }

    public PessoaIdioma() {
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

    
    
    
    
}
