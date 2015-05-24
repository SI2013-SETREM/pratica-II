
package fp.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Id
    @SequenceGenerator (name= "genEventoPadrao", sequenceName= "segEventoPadrao", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genEventoPadrao")
    private int evp_codigo;
    @ManyToOne
    private Evento evento;
    @ManyToOne
    private Pessoa pessoa;

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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
