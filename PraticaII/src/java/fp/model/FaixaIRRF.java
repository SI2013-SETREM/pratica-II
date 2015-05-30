
package fp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Kelvin
 */

@Entity
@Table(name = "ffp_faixa_irrf")
public class FaixaIRRF implements Serializable {
    
    public static final String sTitle = "Faixa IRRF";
    public static final String pTitle = "Faixa IRRFS";
    
    @Id
    @SequenceGenerator (name= "genFaixaIRRF", sequenceName= "segFaixaIRRF", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genFaixaIRRF")
    private int frf_codigo;
    private double frf_salario_inicial;
    private double frf_salario_final;
    private double frf_aliquota;
    private double frf_deducao;
   
     @ManyToOne
    @JoinColumn(name = "tif_codigo", referencedColumnName = "tif_codigo")
    private TabelaIRRF tabelairrf;
    

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

    public TabelaIRRF getTabelairrf() {
        return tabelairrf;
    }

    public void setTabelairrf(TabelaIRRF tabelairrf) {
        this.tabelairrf = tabelairrf;
    }

 
    
    
    
}
