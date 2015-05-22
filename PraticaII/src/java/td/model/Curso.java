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


}
