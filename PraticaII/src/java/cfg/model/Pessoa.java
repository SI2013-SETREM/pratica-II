package cfg.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    public static final String sTitle = "Pessoa";
    public static final String pTitle = "Pessoas";

    @Id
    @SequenceGenerator(name = "pes_codigo", sequenceName = "pes_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pes_codigo")
    
    private int pes_codigo;
    
    @ManyToOne
    @JoinColumn(name = "bai_codigo")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "end_codigo")
    private Endereco endereco;
    
    
}
