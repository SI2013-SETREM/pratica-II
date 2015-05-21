package ad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "tipo_competencias")
public class Competencias_pessoa implements Serializable {
    // @ManyToOne
    //@JoinColumn(name = "codpessoa")
    //private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "codcompetencia")
    private Competencia competencia;
    private String pcp_observacao;
    private Date pcp_datahora_criacao;
    private Date pcp_datahora_alteracao;

    public Competencias_pessoa() {
    }
}
