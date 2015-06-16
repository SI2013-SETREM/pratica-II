package csb.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_setor")
public class Setor implements Serializable {

    public static final String sTitle = "Setor";
    public static final String pTitle = "Setores";

    @Id
    @SequenceGenerator(name = "setor_pk_sequence", sequenceName = "seq_csb_setor")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "setor_pk_sequence")
    private int set_codigo;
    private String set_descricao;

    @ManyToMany
    @JoinTable(name = "csb_episetor")
    private List<Epi> epis;

    public Setor() {
    }

    public int getSet_codigo() {
        return set_codigo;
    }

    public void setSet_codigo(int set_codigo) {
        this.set_codigo = set_codigo;
    }

    public String getSet_descricao() {
        return set_descricao;
    }

    public void setSet_descricao(String set_descricao) {
        this.set_descricao = set_descricao;
    }

    public List<Epi> getEpis() {
        return epis;
    }

    public void setEpis(List<Epi> epis) {
        this.epis = epis;
    }  
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.set_codigo;
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
        final Setor other = (Setor) obj;
        if (this.set_codigo != other.set_codigo) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return this.getSet_descricao();
    }

}
