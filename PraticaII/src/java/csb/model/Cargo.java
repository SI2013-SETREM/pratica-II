package csb.model;

import ad.model.Competencia;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "csb_cargo")
public class Cargo implements Serializable, Comparable<Cargo> {

    public static final String sTitle = "Cargo";
    public static final String pTitle = "Cargos";

    @Id
    @SequenceGenerator(name = "car_codigo", sequenceName = "car_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "car_codigo")
    private int car_codigo;
    private String car_descricao;
    private int car_ativo;
    private String car_cbo;
    private Double car_tetosalarial;
    private Double car_pisosalarial;
    @OneToOne
    private Cargo car_pai;
    
    @OneToMany
    @JoinTable(name = "csb_competencias_cargo")
    private List<Competencia> Competencia;
    
    @OneToMany
    @JoinTable(name = "csb_graduacoes_cargo")
    private List<Graduacao> Graduacao;

    public Cargo() {

    }

    public Cargo(int car_codigo, String car_descricao, int car_ativo, String car_cbo, Double car_tetosalarial, Double car_pisosalarial, Cargo car_pai) {
        this.car_codigo = car_codigo;
        this.car_descricao = car_descricao;
        this.car_ativo = car_ativo;
        this.car_cbo = car_cbo;
        this.car_tetosalarial = car_tetosalarial;
        this.car_pisosalarial = car_pisosalarial;
        this.car_pai = car_pai;
    }

    public int getCar_codigo() {
        return car_codigo;
    }

    public void setCar_codigo(int car_codigo) {
        this.car_codigo = car_codigo;
    }

    public String getCar_descricao() {
        return car_descricao;
    }

    public void setCar_descricao(String car_descricao) {
        this.car_descricao = car_descricao;
    }

    public int getCar_ativo() {
        return car_ativo;
    }

    public void setCar_ativo(int car_ativo) {
        this.car_ativo = car_ativo;
    }

    public String getCar_cbo() {
        return car_cbo;
    }

    public void setCar_cbo(String car_cbo) {
        this.car_cbo = car_cbo;
    }

    public Double getCar_tetosalarial() {
        return car_tetosalarial;
    }

    public void setCar_tetosalarial(Double car_tetosalarial) {
        this.car_tetosalarial = car_tetosalarial;
    }

    public Double getCar_pisosalarial() {
        return car_pisosalarial;
    }

    public void setCar_pisosalarial(Double car_pisosalarial) {
        this.car_pisosalarial = car_pisosalarial;
    }

    public Cargo getCar_pai() {
        return car_pai;
    }

    public void setCar_pai(Cargo car_pai) {
        this.car_pai = car_pai;
    }

    public List<Competencia> getCompetencia() {
        return Competencia;
    }

    public void setCompetencia(List<Competencia> Competencia) {
        this.Competencia = Competencia;
    }

    public List<Graduacao> getGraduacao() {
        return Graduacao;
    }

    public void setGraduacao(List<Graduacao> Graduacao) {
        this.Graduacao = Graduacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.car_codigo;
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
        final Cargo other = (Cargo) obj;
        if (this.car_codigo != other.car_codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getCar_descricao();
    }

    @Override
    public int compareTo(Cargo o) {
        return this.getCar_descricao().compareTo(o.getCar_descricao());
    }
}
