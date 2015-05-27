package rs.model;

import csb.model.Cargo;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rec_recrutamento_cargo")
@IdClass(RecrutamentoCargo.RecrutamentoCargoPK.class)
public class RecrutamentoCargo implements Serializable {

    public static final String sTitle = "Cargo";
    public static final String pTitle = "Cargos";

    @Id
    @ManyToOne
    @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo")
    private Recrutamento recrutamento;
    @Id
    @ManyToOne
    @JoinColumn(name = "car_codigo", referencedColumnName = "car_codigo")
     private Cargo cargo;

    @Id
    private int rec_car_codigo;
    private int rec_car_quantidade;
    private double rec_car_expectativasalario;
    private String rec_car_descricao;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class RecrutamentoCargoPK implements Serializable {

        protected Recrutamento recrutamento;
        protected Cargo cargo;
        protected int rec_car_codigo;

        public RecrutamentoCargoPK() {
        }

        public RecrutamentoCargoPK(Recrutamento recrutamento, Cargo cargo, int rec_car_codigo) {
            this.recrutamento = recrutamento;
            this.cargo = cargo;
            this.rec_car_codigo = rec_car_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + Objects.hashCode(this.recrutamento);
            hash = 79 * hash + Objects.hashCode(this.cargo);
            hash = 79 * hash + this.rec_car_codigo;
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
            final RecrutamentoCargoPK other = (RecrutamentoCargoPK) obj;
            if (!Objects.equals(this.recrutamento, other.recrutamento)) {
                return false;
            }
            if (!Objects.equals(this.cargo, other.cargo)) {
                return false;
            }
            if (this.rec_car_codigo != other.rec_car_codigo) {
                return false;
            }
            return true;
        }
        

    }

    public RecrutamentoCargo() {
    }

    public Recrutamento getRecrutamento() {
        return recrutamento;
    }

    public void setRecrutamento(Recrutamento recrutamento) {
        this.recrutamento = recrutamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getRecCarCodigo() {
        return rec_car_codigo;
    }

    public void setRecCarCodigo(int rec_car_codigo) {
        this.rec_car_codigo = rec_car_codigo;
    }

    public int getRecCarQuantidade() {
        return rec_car_quantidade;
    }

    public void setRecCarQuantidade(int rec_car_quantidade) {
        this.rec_car_quantidade = rec_car_quantidade;
    }

    public double getRecCarExpectativasalario() {
        return rec_car_expectativasalario;
    }

    public void setRecCarExpectativasalario(double rec_car_expectativasalario) {
        this.rec_car_expectativasalario = rec_car_expectativasalario;
    }

    public String getRecCarDescricao() {
        return rec_car_descricao;
    }

    public void setRecCarDescricao(String rec_car_descricao) {
        this.rec_car_descricao = rec_car_descricao;
    }

}
