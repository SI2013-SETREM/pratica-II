
package rs.model;

import ad.model.Competencia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

@Entity
@Table(name="rec_pergunta")
@IdClass(PerguntaPK.class)
//@SQLInsert(sql = "insert into rec_pergunta (cmp_codigo, prg_exibircandidato, prg_obrigatoria, prg_opcaooutros, prg_ordem, prg_pergunta, prg_tipo, prg_codigo, qst_codigo)  values (?, ?, ?, ?, ?, ?, ?, ?, ?)", check = ResultCheckStyle.NONE)
//@SQLUpdate(sql = "update rec_pergunta set cmp_codigo=?, prg_exibircandidato=?, prg_obrigatoria=?, prg_opcaooutros=?, prg_ordem=?, prg_pergunta=?, prg_tipo=? where prg_codigo=? and qst_codigo=?", check = ResultCheckStyle.NONE)
public class Pergunta implements Serializable, Comparable<Pergunta> {
    
    public static final String sTitle = "Pergunta";
    public static final String pTitle = "Perguntas";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo")
    private Questionario questionario;
    
//            @Entity public class Employee {
//                ...
//                @TableGenerator(
//                    name="empGen", 
//                    table="ID_GEN", 
//                    pkColumnName="GEN_KEY", 
//                    valueColumnName="GEN_VALUE", 
//                    pkColumnValue="EMP_ID", 
//                    allocationSize=1)
//                @Id
//                @GeneratedValue(strategy=TABLE, generator="empGen")
//                int id;
//                ...
//            }
//
//            Example 2:
//
//            @Entity public class Address {
//                ...
//                @TableGenerator(
//                    name="addressGen", 
//                    table="ID_GEN", 
//                    pkColumnName="GEN_KEY", 
//                    valueColumnName="GEN_VALUE", 
//                    pkColumnValue="ADDR_ID")
//                @Id
//                @GeneratedValue(strategy=TABLE, generator="addressGen")
//                int id;
//                ...
//            }
//    
//    @Id
//    @TableGenerator(
//        name = "prgGen",
//        table = "gerador_id",
//        pkColumnName = "gid_codigo",
//        valueColumnName = "gid_valor",
//        pkColumnValue = "prg_codigo",
//        allocationSize = 1
//    )
//    @GeneratedValue(strategy = TABLE, generator = "prgGen")
    
    @Id
//    @SequenceGenerator(name="pergunta_unique_sequence", sequenceName="seq_rs_pergunta")
//    @GeneratedValue(strategy=GenerationType.AUTO, generator="pergunta_unique_sequence")
    private int prg_codigo;
    
    @ManyToOne
    @JoinColumn(name = "cmp_codigo", referencedColumnName = "cmp_codigo")
    private Competencia competencia;
    
    private String prg_pergunta;
    private int prg_ordem;
    /**
     * 1 = Descritiva
     * 2 = Objetiva
     */
    private int prg_tipo = 1;
    private boolean prg_opcaooutros = true;
    private boolean prg_exibircandidato = true;
    private boolean prg_obrigatoria = true;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumns ({
        @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo"),
        @JoinColumn(name = "prg_codigo", referencedColumnName = "prg_codigo")
    })
    private List<PerguntaOpcao> perguntaOpcoes;
    
    public Pergunta() {
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public int getPrgCodigo() {
        return prg_codigo;
    }

    public void setPrgCodigo(int prg_codigo) {
        this.prg_codigo = prg_codigo;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public String getPrgPergunta() {
        return prg_pergunta;
    }

    public void setPrgPergunta(String prg_pergunta) {
        this.prg_pergunta = prg_pergunta;
    }

    public int getPrgOrdem() {
        return prg_ordem;
    }

    public void setPrgOrdem(int prg_ordem) {
        if (prg_ordem < 0)
            prg_ordem = 0;
        this.prg_ordem = prg_ordem;
    }

    public int getPrgTipo() {
        return prg_tipo;
    }

    public void setPrgTipo(int prg_tipo) {
        this.prg_tipo = prg_tipo;
    }

    public boolean isPrgOpcaooutros() {
        return prg_opcaooutros;
    }

    public void setPrgOpcaooutros(boolean prg_opcaooutros) {
        this.prg_opcaooutros = prg_opcaooutros;
    }

    public boolean isPrgExibircandidato() {
        return prg_exibircandidato;
    }

    public void setPrgExibircandidato(boolean prg_exibircandidato) {
        this.prg_exibircandidato = prg_exibircandidato;
    }

    public boolean isPrgObrigatoria() {
        return prg_obrigatoria;
    }

    public void setPrgObrigatoria(boolean prg_obrigatoria) {
        this.prg_obrigatoria = prg_obrigatoria;
    }

    public List<PerguntaOpcao> getPerguntaOpcoes() {
        return perguntaOpcoes;
    }

    public void setPerguntaOpcoes(List<PerguntaOpcao> perguntaOpcoes) {
        this.perguntaOpcoes = perguntaOpcoes;
    }
    
    public void addPerguntaOpcao() {
        if (this.perguntaOpcoes == null) {
            this.perguntaOpcoes = new ArrayList<>();
        }
        PerguntaOpcao po = new PerguntaOpcao();
        this.perguntaOpcoes.add(po);
    }

    @Override
    public int compareTo(Pergunta o) {
        return this.getPrgOrdem() - o.getPrgOrdem();
    }
    
}
