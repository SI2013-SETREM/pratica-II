package td.model;

import java.io.Serializable;
import java.sql.Time;
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
@Table(name="trd_turma")
public class Turma implements Serializable {
    
    public static final String sTitle = "Turma";
    public static final String pTitle = "Turmas";
    
    @Id
    @SequenceGenerator(name="trd_turma_pk_sequence", sequenceName="trd_turma_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="trd_turma_pk_sequence")
    private int tur_codigo;
    private Date tur_datainicio;
    private Date tur_datafim;
    private int tur_limite_alunos;
    private int tur_status_turma;
    private Time tur_cargahoraria_secao;
    
    @ManyToOne
    @JoinColumn(name = "tre_codigo")
    private Treinamento treinamento;

    
    public int getTur_codigo() {
        return tur_codigo;
    }

    public void setTur_codigo(int tur_codigo) {
        this.tur_codigo = tur_codigo;
    }

    public Date getTur_datainicio() {
        return tur_datainicio;
    }

    public void setTur_datainicio(Date tur_datainicio) {
        this.tur_datainicio = tur_datainicio;
    }

    public Date getTur_datafim() {
        return tur_datafim;
    }

    public void setTur_datafim(Date tur_datafim) {
        this.tur_datafim = tur_datafim;
    }

    public int getTur_limite_alunos() {
        return tur_limite_alunos;
    }

    public void setTur_limite_alunos(int tur_limite_alunos) {
        this.tur_limite_alunos = tur_limite_alunos;
    }

    public int getTur_status_turma() {
        return tur_status_turma;
    }

    public void setTur_status_turma(int tur_status_turma) {
        this.tur_status_turma = tur_status_turma;
    }

    public Time getTur_cargahoraria_secao() {
        return tur_cargahoraria_secao;
    }

    public void setTur_cargahoraria_secao(Time tur_cargahoraria_secao) {
        this.tur_cargahoraria_secao = tur_cargahoraria_secao;
    }
    
    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.tur_codigo;
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
        final Turma other = (Turma) obj;
        if (this.tur_codigo != other.tur_codigo) {
            return false;
        }
        return true;
    }

}
