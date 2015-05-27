package csb.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_graduacoes_pessoa")
@IdClass(GraduacoesPessoa.GraduacoesPessoaPK.class)
public class GraduacoesPessoa implements Serializable {

    public static final String sTitle = "Graduação";
    public static final String pTitle = "Graduações";

    @Id
    @ManyToOne
    @JoinColumn(name = "grd_codigo", referencedColumnName = "grd_codigo")
    private Graduacao grd_codigo;
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pes_codigo;
    private boolean grd_status;

    public class GraduacoesPessoaPK implements Serializable {

        protected Graduacao graduacao;
        protected Pessoa pessoa;

        public GraduacoesPessoaPK() {
        }

        public GraduacoesPessoaPK(Graduacao graduacao, Pessoa pessoa) {
            this.graduacao = graduacao;
            this.pessoa = pessoa;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.graduacao);
            hash = 17 * hash + Objects.hashCode(this.pessoa);
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
            final GraduacoesPessoaPK other = (GraduacoesPessoaPK) obj;
            if (!Objects.equals(this.graduacao, other.graduacao)) {
                return false;
            }
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            return true;
        }

    }

    public GraduacoesPessoa() {
    }

    public Graduacao getGrd_codigo() {
        return grd_codigo;
    }

    public void setGrd_codigo(Graduacao grd_codigo) {
        this.grd_codigo = grd_codigo;
    }

    public Pessoa getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(Pessoa pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public boolean isGrd_status() {
        return grd_status;
    }

    public void setGrd_status(boolean grd_status) {
        this.grd_status = grd_status;
    }

}
