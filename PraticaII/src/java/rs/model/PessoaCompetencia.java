
package rs.model;

import ad.model.Competencia;
import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="rec_pessoa_competencia")
public class PessoaCompetencia implements Serializable {
    
    public static final String sTitle = "Competência";
    public static final String pTitle = "Competências";
    
    @Id
    @SequenceGenerator(name = "pescompetencia_pk_sequence", sequenceName = "seq_rs_pessoa_competencia")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pescompetencia_pk_sequence")
    private int pes_cmp_codigo;
    
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "cmp_codigo", referencedColumnName = "cmp_codigo")
    private Competencia competencia;
    
    /**
     * 1 - Básico 
     * 2 - Básico a Intermediário 
     * 3 - Intermediário 
     * 4 - Intermediário a Avançado 
     * 5 - Avançado 
     */
    private int pes_cmp_nivel;

    private String[] niveis = {
        "", //0 não existe
        "Básico", //1
        "Básico a Intermediário", //2
        "Intermediário", //3
        "Intermediário a Avançado", //4
        "Avançado", //5
    };

    public PessoaCompetencia() {
    }

    public int getPesCmpCodigo() {
        return pes_cmp_codigo;
    }

    public void setPesCmpCodigo(int pes_cmp_codigo) {
        this.pes_cmp_codigo = pes_cmp_codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public int getPesCmpNivel() {
        return pes_cmp_nivel;
    }

    public void setPesCmpNivel(int pes_cmp_nivel) {
        this.pes_cmp_nivel = pes_cmp_nivel;
    }
    
    public String getNivelDsc() {
        int nivel = this.getPesCmpNivel();
        if (nivel > 1 && nivel < this.niveis.length) {
            return this.niveis[nivel];
        } else {
            return this.niveis[0];
        }
    }
    
}
