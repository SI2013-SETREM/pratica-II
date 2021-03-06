package td.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trd_treinamento")
public class Treinamento implements Serializable {

    public static final String sTitle = "Treinamento";
    public static final String pTitle = "Treinamentos";

    @Id
    @SequenceGenerator(name = "trd_treinamento_pk_sequence", sequenceName = "trd_treinamento_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "trd_treinamento_pk_sequence")
    private int tre_codigo;
    private String tre_descricao;
    private Date tre_cargahoraria;
    private Double tre_custototal;
    private int tre_status;
    @ManyToOne
    @JoinColumn(name = "loc_codigo")
    private Local local;
    @ManyToOne
    @JoinColumn(name = "cur_codigo")
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getTre_codigo() {
        return tre_codigo;
    }

    public void setTre_codigo(int tre_codigo) {
        this.tre_codigo = tre_codigo;
    }

    public String getTre_descricao() {
        return tre_descricao;
    }

    public void setTre_descricao(String tre_descricao) {
        this.tre_descricao = tre_descricao;
    }

    public Date getTre_cargahoraria() {
        return tre_cargahoraria;
    }

    public void setTre_cargahoraria(Date tre_cargahoraria) {
        this.tre_cargahoraria = tre_cargahoraria;
    }

    public Double getTre_custototal() {
        return tre_custototal;
    }

    public void setTre_custototal(Double tre_custototal) {
        this.tre_custototal = tre_custototal;
    }

    public int getTre_status() {
        return tre_status;
    }

    public void setTre_status(int tre_status) {
        this.tre_status = tre_status;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.tre_codigo;
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
        final Treinamento other = (Treinamento) obj;
        if (this.tre_codigo != other.tre_codigo) {
            return false;
        }
        return true;
    }
    
}
