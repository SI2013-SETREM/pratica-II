package rs.model;

import csb.model.Cargo;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import jdk.nashorn.internal.objects.NativeString;

@Entity
@Table(name = "rec_recrutamento_cargo")
@IdClass(RecrutamentoCargoPK.class)
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
    private String rec_car_descricao_resumida;


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

    public String getRecCarDescricaoResumida() {
        rec_car_descricao_resumida=NativeString.substr(this.rec_car_descricao, 0, 50);
        return rec_car_descricao_resumida;
    }

    public void setRecCarDescricaoResumida(String rec_car_descricao_resumida) {
        this.rec_car_descricao_resumida = rec_car_descricao_resumida;
    }

}
