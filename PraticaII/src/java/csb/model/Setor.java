package csb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name="csb_setor")
public class Setor implements Serializable{
    public static final String sTitle = "Setor";
    public static final String pTitle = "Setores";
    
    @Id
    @SequenceGenerator(name="setor_pk_sequence", sequenceName="seq_csb_setor")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="setor_pk_sequence")
    private int set_codigo;
    private String set_descricao;
    @OneToMany
    private List<Epi> Epi;
    @OneToMany
    private List<Cargo> Cargo;
    

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

    public List<Epi> getEpi() {
        return Epi;
    }

    public void setEpi(List<Epi> Epi) {
        this.Epi = Epi;
    }    

    public List<Cargo> getCargo() {
        return Cargo;
    }

    public void setCargo(List<Cargo> Cargo) {
        this.Cargo = Cargo;
    }
}
