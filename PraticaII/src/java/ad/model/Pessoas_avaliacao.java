package ad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Table(name = "pessoa_avaliacao")
public class Pessoas_avaliacao implements Serializable {

   
//    @ManyToOne
//    @JoinColumn(name = "codpessoa")
//    private Pessoa pessoa;
//
//    @ManyToOne
//    @JoinColumn(name = "codavaliador")
//    private Pessoa pessoa;
//
    @ManyToOne
    @JoinColumn(name = "codavaiacao")
    private Avaliacao avaliacao;    
    
    private double pea_media;
    private String pea_observacao;
    private Date pea_data_criacao;

    public Pessoas_avaliacao() {
    }
    
    
}