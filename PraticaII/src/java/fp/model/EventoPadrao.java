
package fp.model;

import cfg.model.Pessoa;
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
@Table(name = "ffp_evento_padrao")
public class EventoPadrao implements Serializable {
    
    
    public static final String sTitle = "Evento Padrão";
    public static final String pTitle = "Eventos Padrões";

 
    @Id
    @SequenceGenerator (name= "genEventoPadrao", sequenceName= "segEventoPadrao", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genEventoPadrao")
    private int evp_codigo;
    @ManyToOne
    @JoinColumn(name = "eve_codigo", referencedColumnName = "eve_codigo")
    private Evento eve_codigo;
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;

    public int getEvp_codigo() {
        return evp_codigo;
    }

    public void setEvp_codigo(int evp_codigo) {
        this.evp_codigo = evp_codigo;
    }

    public Evento getEve_codigo() {
        return eve_codigo;
    }

    public void setEve_codigo(Evento eve_codigo) {
        this.eve_codigo = eve_codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
   public static String getsTitle() {
        return sTitle;
    }

    public static String getpTitle() {
        return pTitle;
    }



    
}
