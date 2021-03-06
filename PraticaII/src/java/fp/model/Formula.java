
package fp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Kelvin
 */
@Entity
@Table(name = "ffp_formula")
public class Formula implements Serializable {
    
    public static final String sTitle = "Fórmula";
    public static final String pTitle = "Fórmulas";
    
    @Id
    @SequenceGenerator (name= "genFormula", sequenceName= "segFormula", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genFormula")
    private int for_codigo;
    private String for_nome;
    private double for_taxa;
    private int for_horas;
    private double for_horasmais;

    public int getFor_codigo() {
        return for_codigo;
    }

    public void setFor_codigo(int for_codigo) {
        this.for_codigo = for_codigo;
    }

    public double getFor_taxa() {
        return for_taxa;
    }

    public void setFor_taxa(double for_taxa) {
        this.for_taxa = for_taxa;
    }

    public int getFor_horas() {
        return for_horas;
    }

    public void setFor_horas(int for_horas) {
        this.for_horas = for_horas;
    }

    public double getFor_horasmais() {
        return for_horasmais;
    }

    public void setFor_horasmais(double for_horasmais) {
        this.for_horasmais = for_horasmais;
    }

    public String getFor_nome() {
        return for_nome;
    }

    public void setFor_nome(String for_nome) {
        this.for_nome = for_nome;
    }
    
    
    
    @Override
    public int hashCode(){
    int hash = 7;
    hash = 59* hash + this.for_codigo;
    return hash;
    }
    
    @Override
    public boolean equals (Object obj){
    if (obj == null){
    return false;
    }
    if(getClass() != obj.getClass()){
    return false;
    }
    final Formula other = (Formula) obj;
    if(this.for_codigo != other.for_codigo){
    return false;
    }
    return true;
    }
    
    @Override
    public String toString(){
    return getFor_nome();
    }
    
    
    
    
    
    
    
}
