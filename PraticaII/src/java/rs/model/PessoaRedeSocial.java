
package rs.model;

import cfg.model.Pessoa;
import cfg.model.RedeSocial;
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
@Table(name="rec_pessoa_redesocial")
public class PessoaRedeSocial implements Serializable {
    
    public static final String sTitle = "Rede Social";
    public static final String pTitle = "Redes Sociais";
    
    @Id
    @SequenceGenerator(name = "pesredesocial_pk_sequence", sequenceName = "seq_rs_pessoa_redesocial")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pesredesocial_pk_sequence")
    private int pes_rsc_codigo;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "rsc_codigo", referencedColumnName = "rsc_codigo")
    private RedeSocial redeSocial;
    
    private String pes_rsc_usuario;
    private String pes_rsc_descricao;
    private String pes_rsc_url;

    public PessoaRedeSocial() {
    }

    public int getPesRscCodigo() {
        return pes_rsc_codigo;
    }

    public void setPesRscCodigo(int pes_rsc_codigo) {
        this.pes_rsc_codigo = pes_rsc_codigo;
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
