
package fp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Kelvin
 */
@Entity
@SequenceGenerator (name= "genEventoPadrao", sequenceName= "segEventoPadrao", allocationSize = 1)
public class EventoPadrao implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genEventoPadrao")
    private int evp_codigo;
    @ManyToOne
    private Evento evento;
    //@ManyToOne
    //private Pessoa pessoa;

    public int getEvp_codigo() {
        return evp_codigo;
    }

    public void setEvp_codigo(int evp_codigo) {
        this.evp_codigo = evp_codigo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
}