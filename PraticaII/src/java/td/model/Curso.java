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
    private int codigo_curso;
    private String nome_curso;

    public int getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(int codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }
}
