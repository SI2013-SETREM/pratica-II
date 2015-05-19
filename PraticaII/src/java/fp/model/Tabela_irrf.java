
package fp.model;

import java.io.Serializable;
import java.util.Date;
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
@SequenceGenerator (name= "genTabela_irrf", sequenceName= "segTabela_irrf", allocationSize = 1)
public class Tabela_irrf implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genTabela_irrf")
    private int tif_codigo;
    private Date tif_dataincial;
    private Date tif_datafinal;
    private double tif_valor_deducao;
    private double tif_valor_min_darf;
    private double tif_por_pis_pasep;

    public int getTif_codigo() {
        return tif_codigo;
    }

    public void setTif_codigo(int tif_codigo) {
        this.tif_codigo = tif_codigo;
    }

    public Date getTif_dataincial() {
        return tif_dataincial;
    }

    public void setTif_dataincial(Date tif_dataincial) {
        this.tif_dataincial = tif_dataincial;
    }

    public Date getTif_datafinal() {
        return tif_datafinal;
    }

    public void setTif_datafinal(Date tif_datafinal) {
        this.tif_datafinal = tif_datafinal;
    }

    public double getTif_valor_deducao() {
        return tif_valor_deducao;
    }

    public void setTif_valor_deducao(double tif_valor_deducao) {
        this.tif_valor_deducao = tif_valor_deducao;
    }

    public double getTif_valor_min_darf() {
        return tif_valor_min_darf;
    }

    public void setTif_valor_min_darf(double tif_valor_min_darf) {
        this.tif_valor_min_darf = tif_valor_min_darf;
    }

    public double getTif_por_pis_pasep() {
        return tif_por_pis_pasep;
    }

    public void setTif_por_pis_pasep(double tif_por_pis_pasep) {
        this.tif_por_pis_pasep = tif_por_pis_pasep;
    }
    
}