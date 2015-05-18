package td.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="trd_local")
public class Local implements Serializable{    
    
    @Id
    @SequenceGenerator(name="trd_local_pk_sequence", sequenceName="trd_local_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="trd_local_pk_sequence")
    private int loc_codigo;
    private String loc_descricao;

    public int getLoc_codigo() {
        return loc_codigo;
    }

    public void setLoc_codigo(int loc_codigo) {
        this.loc_codigo = loc_codigo;
    }

    public String getLoc_descricao() {
        return loc_descricao;
    }

    public void setLoc_descricao(String loc_descricao) {
        this.loc_descricao = loc_descricao;
    }
    
}
