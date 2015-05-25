
package rs.model;

import cfg.model.Pessoa;
import cfg.model.RedeSocial;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_pessoa_redesocial")
@IdClass(PessoaRedeSocial.PessoaRedeSocialPK.class)
public class PessoaRedeSocial implements Serializable {
    
    public static final String sTitle = "Rede Social";
    public static final String pTitle = "Redes Sociais";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "rsc_codigo", referencedColumnName = "rsc_codigo")
    private RedeSocial redeSocial;
    
    private String pes_rsc_usuario;
    private String pes_rsc_descricao;
    private String pes_rsc_url;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class PessoaRedeSocialPK implements Serializable {
        protected Pessoa pessoa;
        protected RedeSocial redeSocial;

        public PessoaRedeSocialPK() {}

        public PessoaRedeSocialPK(Pessoa pessoa, RedeSocial redeSocial) {
            this.pessoa = pessoa;
            this.redeSocial = redeSocial;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.pessoa);
            hash = 97 * hash + Objects.hashCode(this.redeSocial);
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
            final PessoaRedeSocialPK other = (PessoaRedeSocialPK) obj;
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (!Objects.equals(this.redeSocial, other.redeSocial)) {
                return false;
            }
            return true;
        }

    }

    public PessoaRedeSocial() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public RedeSocial getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(RedeSocial redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getPesRscUsuario() {
        return pes_rsc_usuario;
    }

    public void setPesRscUsuario(String pes_rsc_usuario) {
        this.pes_rsc_usuario = pes_rsc_usuario;
    }

    public String getPesRscDescricao() {
        return pes_rsc_descricao;
    }

    public void setPesRscDescricao(String pes_rsc_descricao) {
        this.pes_rsc_descricao = pes_rsc_descricao;
    }

    public String getPesRscUrl() {
        return pes_rsc_url;
    }

    public void setPesRscUrl(String pes_rsc_url) {
        this.pes_rsc_url = pes_rsc_url;
    }

    
    
}
