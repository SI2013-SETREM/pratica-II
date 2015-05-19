
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
@SequenceGenerator (name= "genFaixa_inss", sequenceName= "segFaixa_inss", allocationSize = 1)
public class Faixa_inss implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genFaixa_inss")
    private int fai_codigo;
    private double fai_sal_ini;
    private double fai_sal_fin;
    private double fai_aliquota;
    private double fai_ab_imp_renda;

    public int getFai_codigo() {
        return fai_codigo;
    }

    public void setFai_codigo(int fai_codigo) {
        this.fai_codigo = fai_codigo;
    }

    public double getFai_sal_ini() {
        return fai_sal_ini;
    }

    public void setFai_sal_ini(double fai_sal_ini) {
        this.fai_sal_ini = fai_sal_ini;
    }

    public double getFai_sal_fin() {
        return fai_sal_fin;
    }

    public void setFai_sal_fin(double fai_sal_fin) {
        this.fai_sal_fin = fai_sal_fin;
    }

    public double getFai_aliquota() {
        return fai_aliquota;
    }

    public void setFai_aliquota(double fai_aliquota) {
        this.fai_aliquota = fai_aliquota;
    }

    public double getFai_ab_imp_renda() {
        return fai_ab_imp_renda;
    }

    public void setFai_ab_imp_renda(double fai_ab_imp_renda) {
        this.fai_ab_imp_renda = fai_ab_imp_renda;
    }
    
    
}
