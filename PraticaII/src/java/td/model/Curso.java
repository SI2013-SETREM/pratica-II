package td.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="trd_curso")
public class Curso implements Serializable{
    
    public static final String sTitle = "Curso";
    public static final String pTitle = "Cursos";
    
    @Id
    @SequenceGenerator(name="trd_curso_pk_sequence", sequenceName="trd_curso_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="trd_curso_pk_sequence")
    private int cur_codigo;
    private String cur_nome;

    public int getCur_codigo() {
        return cur_codigo;
    }

    public void setCur_codigo(int cur_codigo) {
        this.cur_codigo = cur_codigo;
    }

    public String getCur_nome() {
        return cur_nome;
    }

    public void setCur_nome(String cur_nome) {
        this.cur_nome = cur_nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.cur_codigo;
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
        final Curso other = (Curso) obj;
        if (this.cur_codigo != other.cur_codigo) {
            return false;
        }
        return true;
    }


}
