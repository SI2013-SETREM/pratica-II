package rs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

@Entity
@Table(name = "rec_questionario")
//@SQLInsert(sql = "insert into rec_questionario (qst_pontuacaomax, qst_pontuacaototal, qst_tipo_questoes, qst_titulo, qst_codigo) values (?, ?, ?, ?, ?)", check = ResultCheckStyle.NONE)
//@SQLUpdate(sql = "UPDATE rec_questionario SET qst_titulo=?,qst_pontuacaototal=?,qst_pontuacaomax=?,qst_tipo_questoes=?,qst_tipo=? WHERE qst_codigo=?", check = ResultCheckStyle.NONE)
public class Questionario implements Serializable {

    public static final String sTitle = "Questionário";
    public static final String pTitle = "Questionários";

    @Id
    @SequenceGenerator(name = "questionario_pk_sequence", sequenceName = "seq_rs_questionario")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "questionario_pk_sequence")
    private int qst_codigo;

    private String qst_titulo;

    /**
     * Pontuação máxima que poderá ser atingida pelo candidato. Para as questões
     * dissertativas soma o valor de qst_pontuacaomax.
     */
    private int qst_pontuacaototal;

    /**
     * Pontuação máxima para cada questão. Por padrão,
     * parametro.par_qst_pontuacaomax_padrao
     */
    private int qst_pontuacaomax;

    /**
     * 1 = Questões descritivas 2 = Questões objetivas 3 = Misto
     */
    private int qst_tipo_questoes = 1;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "qst_codigo", referencedColumnName = "qst_codigo")
    @OrderBy(value = "prg_ordem")
    private List<Pergunta> perguntas;

    public Questionario() {
    }

    public int getQstCodigo() {
        return qst_codigo;
    }

    public void setQstCodigo(int qst_codigo) {
        this.qst_codigo = qst_codigo;
    }

    public String getQstTitulo() {
        return qst_titulo;
    }

    public void setQstTitulo(String qst_titulo) {
        this.qst_titulo = qst_titulo;
    }

    public int getQstPontuacaototal() {
        return qst_pontuacaototal;
    }

    public void setQstPontuacaototal(int qst_pontuacaototal) {
        this.qst_pontuacaototal = qst_pontuacaototal;
    }

    public int getQstPontuacaomax() {
        if (qst_codigo == 0) {
            qst_pontuacaomax = 20;
        }
        return qst_pontuacaomax;
    }

    public void setQstPontuacaomax(int qst_pontuacaomax) {
        this.qst_pontuacaomax = qst_pontuacaomax;
    }

    public int getQstTipoQuestoes() {
        return qst_tipo_questoes;
    }

    public void setQstTipoQuestoes(int qst_tipo_questoes) {
        this.qst_tipo_questoes = qst_tipo_questoes;
    }

    public void setQstTipoQuestoes(List<Pergunta> perguntas) {
        int qstTipoQuestoes = 0;
        if (perguntas != null) {
            for (Pergunta pergunta : perguntas) {
                switch (pergunta.getPrgTipo()) {
                    case 1: //Descritiva
                        if (qstTipoQuestoes == 2) { //Objetivas
                            qstTipoQuestoes = 3; //Misto
                        } else {
                            qstTipoQuestoes = 1; //Descritivas
                        }
                        break;
                    case 2: //Objetiva
                        if (qstTipoQuestoes == 1) { //Descritivas
                            qstTipoQuestoes = 3; //Misto
                        } else {
                            qstTipoQuestoes = 2; //Objetivas
                        }
                        break;
                }
                if (qstTipoQuestoes == 3) { //Misto
                    break;
                }
            }
        }
        this.qst_tipo_questoes = qstTipoQuestoes;
    }

    public List<Pergunta> getPerguntas() {
//        if (perguntas != null && perguntas.size() > 1) {
//            Collections.sort(perguntas);
//        }
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
//        if (perguntas != null && perguntas.size() > 1) {
//            Collections.sort(perguntas);
//        }
        this.perguntas = perguntas;
    }

    public void addPergunta() {
        if (this.perguntas == null) {
            this.perguntas = new ArrayList<>();
        }
        Pergunta p = new Pergunta();
        p.setPrgOrdem(this.perguntas.size()+1);
        if (this.qst_tipo_questoes == 1 || this.qst_tipo_questoes == 2) {
            p.setPrgTipo(qst_tipo_questoes);
        }
        this.perguntas.add(p);
    }

    public void delPergunta(Pergunta p) {
        if (this.perguntas != null) {
            int prgOrdem = p.getPrgOrdem();
            this.perguntas.remove(p);
            for (int i = 0; i < this.perguntas.size(); i++) {
                Pergunta pergunta = this.perguntas.get(i);
                if (pergunta.getPrgOrdem() > prgOrdem) {
                    pergunta.setPrgOrdem(pergunta.getPrgOrdem()-1);
                }
            }
        }
    }
//    public void delPergunta(int prgCodigo, int prgOrdem) {
//        if (this.perguntas != null) {
////            int prgOrdem = p.getPrgOrdem();
////            this.perguntas.remove(p);
//            System.err.println("DELETANDO PERGUNTA: " + prgCodigo + "," + prgOrdem);
//            List<Pergunta> arrPergunta = new ArrayList<>();
//            for (Pergunta pergunta : this.perguntas) {
//                System.err.println("Navegando na pergunta : " + pergunta.getPrgCodigo() + "," + pergunta.getPrgOrdem());
//                if (pergunta.getPrgCodigo() != prgCodigo || pergunta.getPrgOrdem() != prgOrdem) {
//                    System.err.println("PODE ADICIONAR : " + pergunta.getPrgCodigo() + "," + pergunta.getPrgOrdem());
//                    if (pergunta.getPrgOrdem() > prgOrdem) {
//                        pergunta.setPrgOrdem(pergunta.getPrgOrdem()-1);
//                    }
//                    arrPergunta.add(pergunta);
//                }
//            }
//            this.setPerguntas(arrPergunta);
//        }
//    }

    public void moveUpPergunta(Pergunta p) {
        int prgOrdem = p.getPrgOrdem();
        if (this.perguntas != null) {
//            int idx_org = 0;
//            int idx_dst = 0;
            for (int i = 0; i < this.perguntas.size(); i++) {
                Pergunta pergunta = this.perguntas.get(i);
                if (pergunta.getPrgOrdem() == prgOrdem) {
//                    idx_org = i;
                    pergunta.setPrgOrdem(prgOrdem-1);
                } else if (pergunta.getPrgOrdem() == (prgOrdem-1)) {
//                    idx_dst = i;
                    pergunta.setPrgOrdem(prgOrdem);
                }
            }
//            Pergunta per = this.perguntas.set(idx_dst, this.perguntas.get(idx_org));
//            this.perguntas.set(idx_org, per);
            Collections.sort(perguntas);
        }
    }

    public void moveDownPergunta(Pergunta p) {
        int prgOrdem = p.getPrgOrdem();
        if (this.perguntas != null) {
            for (int i = 0; i < this.perguntas.size(); i++) {
                Pergunta pergunta = this.perguntas.get(i);
                if (pergunta.getPrgOrdem() == prgOrdem) {
                    pergunta.setPrgOrdem(prgOrdem+1);
                } else if (pergunta.getPrgOrdem() == (prgOrdem+1)) {
                    pergunta.setPrgOrdem(prgOrdem);
                }
            }
            Collections.sort(perguntas);
        }
    }

    public void addPerguntaOpcao(Pergunta p) {
//        Pergunta pergunta = this.perguntas.get(this.perguntas.indexOf(p));
//        pergunta.addPerguntaOpcao();
        this.perguntas.get(this.perguntas.indexOf(p)).addPerguntaOpcao();
    }

    @Override
    public String toString() {
        return this.qst_titulo;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.qst_codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questionario other = (Questionario) obj;
        if (this.qst_codigo != other.qst_codigo) {
            return false;
        }
        return true;
    }

}
