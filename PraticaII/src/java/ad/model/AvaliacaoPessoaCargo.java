package ad.model;

import cfg.model.Pessoa;
import csb.model.Cargo;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "avd_avaliacao_pessoa_cargo")
@IdClass(AvaliacaoPessoaCargo.AvaliacaoPessoaCargoPK.class)
public class AvaliacaoPessoaCargo implements Serializable {
//acho q nau precisa do sTitle aki, pois aqui n'ao vai ter nenhuma tela

    @Id
    @SequenceGenerator(name = "avaliacao_pessoa_cargo_pk_sequence", sequenceName = "avaliacao_pessoa_cargo_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "avaliacao_pessoa_cargo_pk_sequence")
    private int apc_codigo;
    private int apc_status;
    @Id
    @ManyToOne
    @JoinColumn(name = "ava_codigo", referencedColumnName = "ava_codigo")
    private Avaliacao avaliacao;
    @ManyToOne
    @JoinColumn(name = "car_codigo", referencedColumnName = "car_codigo")
    private Cargo cargo;
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;

    public AvaliacaoPessoaCargo() {
    }

    public static class AvaliacaoPessoaCargoPK implements Serializable {

        protected Avaliacao avaliacao;
        protected int apc_codigo;

        public AvaliacaoPessoaCargoPK() {
        }

        public AvaliacaoPessoaCargoPK(Avaliacao avaliacao, int apc_codigo) {
            this.avaliacao = avaliacao;
            this.apc_codigo = apc_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 19 * hash + Objects.hashCode(this.avaliacao);
            hash = 19 * hash + this.apc_codigo;
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
            final AvaliacaoPessoaCargoPK other = (AvaliacaoPessoaCargoPK) obj;
            if (!Objects.equals(this.avaliacao, other.avaliacao)) {
                return false;
            }
            if (this.apc_codigo != other.apc_codigo) {
                return false;
            }
            return true;
        }
    }

    public int getApc_codigo() {
        return apc_codigo;
    }

    public void setApc_codigo(int apc_codigo) {
        this.apc_codigo = apc_codigo;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getApc_status() {
        return apc_status;
    }

    public void setApc_status(int apc_status) {
        this.apc_status = apc_status;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
