
package fp.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "ffp_tabela_irrf")
public class TabelaIRRF implements Serializable{
    
    public static final String sTitle = "Tabela IRRF";
    public static final String pTitle = "Tabela IRRFS";
     
    @Id
    @SequenceGenerator (name= "genTabelaIRRF", sequenceName= "segTabelaIRRF", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genTabelaIRRF")
    private int tif_codigo;
    private String tif_nome;
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

    public String getTif_nome() {
        return tif_nome;
    }

    public void setTif_nome(String tif_nome) {
        this.tif_nome = tif_nome;
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
