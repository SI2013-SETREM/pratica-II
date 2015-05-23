package ad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private Date pea_datahora_resposta;

    public Pessoas_avaliacao() {
    }
    
    
}