
package rs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="rec_entrevista")
@IdClass(Entrevista.EntrevistaPK.class)
public class Entrevista implements Serializable {
    
    public static final String sTitle = "Entrevista";
    public static final String pTitle = "Entrevista";
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo"),
        @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    })
    private RecrutamentoPessoa recrutamentoPessoa;
    
    @Id
    private int ent_codigo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ent_datahora;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class EntrevistaPK implements Serializable {
        protected RecrutamentoPessoa recrutamentoPessoa;
        protected int ent_codigo;

        public EntrevistaPK() {}

        public EntrevistaPK(RecrutamentoPessoa recrutamentoPessoa, int ent_codigo) {
            this.recrutamentoPessoa = recrutamentoPessoa;
            this.ent_codigo = ent_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 11 * hash + Objects.hashCode(this.recrutamentoPessoa);
            hash = 11 * hash + this.ent_codigo;
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
            final EntrevistaPK other = (EntrevistaPK) obj;
            if (!Objects.equals(this.recrutamentoPessoa, other.recrutamentoPessoa)) {
                return false;
            }
            if (this.ent_codigo != other.ent_codigo) {
                return false;
            }
            return true;
        }

    }

    public Entrevista() {
    }

    public RecrutamentoPessoa getRecrutamentoPessoa() {
        return recrutamentoPessoa;
    }

    public void setRecrutamentoPessoa(RecrutamentoPessoa recrutamentoPessoa) {
        this.recrutamentoPessoa = recrutamentoPessoa;
    }
    
    public int getEntCodigo() {
        return ent_codigo;
    }

    public void setEntCodigo(int ent_codigo) {
        this.ent_codigo = ent_codigo;
    }

    public Date getEntDatahora() {
        return ent_datahora;
    }

    public void setEntDatahora(Date ent_datahora) {
        this.ent_datahora = ent_datahora;
    }
    
}
