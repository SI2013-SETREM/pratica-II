package ad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import rs.model.Questionario;
import td.model.Turma;

@Entity
@Table(name = "avd_avaliacao")
public class Avaliacao implements Serializable {

    public static final String sTitle = "Avaliação";
    public static final String pTitle = "Avaliações";

    @Id
    @SequenceGenerator(name = "avaliacao_pk_sequence", sequenceName = "avaliacao_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "avaliacao_pk_sequence")
    private int ava_codigo;
    @ManyToOne
    @JoinColumn(name = "tur_codigo", referencedColumnName = "tur_codigo")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo")
    private Questionario questionario;

    private int ava_status;
    private String ava_nome;
    private String ava_observacao;
    private Date ava_dataInicial;
    private Date ava_dataFinal;

    public Avaliacao() {
    }

    public int getAva_codigo() {
        return ava_codigo;
    }

    public void setAva_codigo(int ava_codigo) {
        this.ava_codigo = ava_codigo;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public int getAva_status() {
        return ava_status;
    }

    public void setAva_status(int ava_status) {
        this.ava_status = ava_status;
    }

    public String getAva_nome() {
        return ava_nome;
    }

    public void setAva_nome(String ava_nome) {
        this.ava_nome = ava_nome;
    }

    public String getAva_observacao() {
        return ava_observacao;
    }

    public void setAva_observacao(String ava_observacao) {
        this.ava_observacao = ava_observacao;
    }

    public Date getAva_dataInicial() {
        return ava_dataInicial;
    }

    public void setAva_dataInicial(Date ava_dataInicial) {
        this.ava_dataInicial = ava_dataInicial;
    }

    public Date getAva_dataFinal() {
        return ava_dataFinal;
    }

    public void setAva_dataFinal(Date ava_dataFinal) {
        this.ava_dataFinal = ava_dataFinal;
    }

    public static String getsTitle() {
        return sTitle;
    }

    public static String getpTitle() {
        return pTitle;
    }

    public String getStatus() {
        switch (ava_status) {
            case 1:
                return "Aguardando Início";
            case 2:
                return "Em Andamento";
            case 3:
                return "Concluída";
            case 4:
                return "Cancelada";
            case 5:
                return "Deletada";
            default:
                return "Nenhum";
        }
    }

    public String getTipoAva() {
        if (turma != null && turma.getTur_codigo() != 0) {
            return "De Treinamento";
        } else {
            return "De Desempenho";
        }
    }
}
