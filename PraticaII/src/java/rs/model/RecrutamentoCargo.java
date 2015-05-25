
package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rec_recrutamento_cargo")
//@IdClass(RecrutamentoCargo.RecrutamentoCargoPK.class)
public class RecrutamentoCargo implements Serializable {
    
    public static final String sTitle = "Cargo";
    public static final String pTitle = "Cargos";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo")
    private Recrutamento recrutamento;
    
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "car_codigo", referencedColumnName = "car_codigo")
//    private Cargo cargo;
    
    @Id
    private int rec_car_codigo;
    
    private int rec_car_quantidade;
    private Float rec_car_expectativasalario;
    private String rec_car_descricao;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class RecrutamentoCargoPK implements Serializable {
        protected Recrutamento recrutamento;
//        protected Cargo cargo;
        protected int rec_car_codigo;
        
        public RecrutamentoCargoPK() {}

    }

    public RecrutamentoCargo() {
    }

    public Recrutamento getRecrutamento() {
        return recrutamento;
    }

    public void setRecrutamento(Recrutamento recrutamento) {
        this.recrutamento = recrutamento;
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

    public Float getRecCarExpectativasalario() {
        return rec_car_expectativasalario;
    }

    public void setRecCarExpectativasalario(Float rec_car_expectativasalario) {
        this.rec_car_expectativasalario = rec_car_expectativasalario;
    }

    public String getRecCarDescricao() {
        return rec_car_descricao;
    }

    public void setRecCarDescricao(String rec_car_descricao) {
        this.rec_car_descricao = rec_car_descricao;
    }

    
}
