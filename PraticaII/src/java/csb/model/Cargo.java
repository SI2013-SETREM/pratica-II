package csb.model;

import ad.model.Competencia;
import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "csb_cargo")
public class Cargo implements Serializable, Comparable<Cargo> {

    public static final String sTitle = "Cargo";
    public static final String pTitle = "Cargos";

    @Id
    @SequenceGenerator(name = "cargo_pk_sequence", sequenceName = "seq_csb_cargo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cargo_pk_sequence")
    private int car_codigo;
    private String car_descricao;
    private boolean car_ativo;
    private String car_cbo;
    private Double car_tetosalarial;
    private Double car_pisosalarial;
    @ManyToOne
    @JoinColumn(name = "car_pai", referencedColumnName = "car_codigo")
    private Cargo car_pai;

    @ManyToOne
    @JoinColumn(name = "set_codigo")
    private Setor setor;

    @ManyToMany
    @JoinTable(name = "csb_competencias_cargo",
            joinColumns = {
                @JoinColumn(name = "car_codigo")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "cmp_codigo")
            }
    )
    private List<Competencia> Competencias;

    @ManyToMany
    @JoinTable(name = "csb_graduacoes_cargo",
            joinColumns = {
                @JoinColumn(name = "car_codigo")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "grd_codigo")
            }
    )
    private List<Graduacao> Graduacoes;

    @ManyToMany
    @JoinTable(name = "csb_epicargo",
            joinColumns = {
                @JoinColumn(name = "car_codigo")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "epi_codigo")
            }
    )
    private List<Epi> Epis;

    @ManyToMany
    @JoinTable(name = "csb_beneficios_cargo",
            joinColumns = {
                @JoinColumn(name = "car_codigo")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ben_codigo")
            }
    )
    private List<Beneficio> beneficios;

    @ManyToMany
    @JoinTable(name = "rec_interesse_cargo",
            joinColumns = {
                @JoinColumn(name = "car_codigo")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "pes_codigo")
            }
    )
    private List<Pessoa> pessoas;

    public Cargo() {

    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
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

    public boolean isCar_ativo() {
        return car_ativo;
    }

    public void setCar_ativo(boolean car_ativo) {
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

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public List<Competencia> getCompetencias() {
        return Competencias;
    }

    public void setCompetencias(List<Competencia> Competencias) {
        this.Competencias = Competencias;
    }

    public List<Graduacao> getGraduacoes() {
        return Graduacoes;
    }

    public void setGraduacoes(List<Graduacao> Graduacoes) {
        this.Graduacoes = Graduacoes;
    }

    public List<Epi> getEpis() {
        return Epis;
    }

    public void setEpis(List<Epi> Epis) {
        this.Epis = Epis;
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
