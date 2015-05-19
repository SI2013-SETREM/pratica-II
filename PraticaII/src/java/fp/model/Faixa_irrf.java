
package fp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Kelvin
 */

@Entity
@SequenceGenerator (name= "genFaixa_irrf", sequenceName= "segFaixa_irrf", allocationSize = 1)
public class Faixa_irrf implements Serializable {
    
     @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genFaixa_irrf")
    private int frf_codigo;
    private double frf_salario_inicial;
    private double frf_salario_final;
    private double frf_aliquota;
    private double frf_deducao;

    public int getFrf_codigo() {
        return frf_codigo;
    }

    public void setFrf_codigo(int frf_codigo) {
        this.frf_codigo = frf_codigo;
    }

    public double getFrf_salario_inicial() {
        return frf_salario_inicial;
    }

    public void setFrf_salario_inicial(double frf_salario_inicial) {
        this.frf_salario_inicial = frf_salario_inicial;
    }

    public double getFrf_salario_final() {
        return frf_salario_final;
    }

    public void setFrf_salario_final(double frf_salario_final) {
        this.frf_salario_final = frf_salario_final;
    }

    public double getFrf_aliquota() {
        return frf_aliquota;
    }

    public void setFrf_aliquota(double frf_aliquota) {
        this.frf_aliquota = frf_aliquota;
    }

    public double getFrf_deducao() {
        return frf_deducao;
    }

    public void setFrf_deducao(double frf_deducao) {
        this.frf_deducao = frf_deducao;
    }
    
    
}
