
package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_entrevista_pessoa")
@IdClass(EntrevistaPessoa.EntrevistaPessoaPK.class)
public class EntrevistaPessoa implements Serializable {
    
    public static final String sTitle = "Entrevista";
    public static final String pTitle = "Entrevista";
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo"),
        @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo"),
        @JoinColumn(name = "ent_codigo", referencedColumnName = "ent_codigo")
    })
    private Entrevista entrevista;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo_funcionario", referencedColumnName = "pes_codigo")
    private Pessoa funcionario;
    
    private String ent_pes_anotacao;
    private int ent_pes_nota;
    
    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class EntrevistaPessoaPK implements Serializable {
        protected Entrevista entrevista;
        protected Pessoa funcionario;

        public EntrevistaPessoaPK() {}

        public EntrevistaPessoaPK(Entrevista entrevista, Pessoa funcionario) {
            this.entrevista = entrevista;
            this.funcionario = funcionario;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 37 * hash + Objects.hashCode(this.entrevista);
            hash = 37 * hash + Objects.hashCode(this.funcionario);
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
            final EntrevistaPessoaPK other = (EntrevistaPessoaPK) obj;
            if (!Objects.equals(this.entrevista, other.entrevista)) {
                return false;
            }
            if (!Objects.equals(this.funcionario, other.funcionario)) {
                return false;
            }
            return true;
        }

    }

    public EntrevistaPessoa() {
    }

    public Entrevista getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(Entrevista entrevista) {
        this.entrevista = entrevista;
    }

    public Pessoa getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    public String getEntPesAnotacao() {
        return ent_pes_anotacao;
    }

    public void setEntPesAnotacao(String ent_pes_anotacao) {
        this.ent_pes_anotacao = ent_pes_anotacao;
    }

    public int getEntPesNota() {
        return ent_pes_nota;
    }

    public void setEntPesNota(int ent_pes_nota) {
        this.ent_pes_nota = ent_pes_nota;
    }

    
}
