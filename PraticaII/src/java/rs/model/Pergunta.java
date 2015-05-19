
package rs.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="rec_pergunta")
@IdClass(Pergunta.PerguntaPK.class)
public class Pergunta implements Serializable {
    
    public static final String sTitle = "Pergunta";
    public static final String pTitle = "Perguntas";
    
    @Id
    private Questionario qst_codigo;
    @Id
    private int prg_codigo;
    private String prg_pergunta;
    private int prg_ordem;
    private int prg_tipo;
    private boolean prg_opcaooutros;
    private boolean prg_exibircandidato;

    // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class PerguntaPK implements Serializable {
        protected Questionario qst_codigo;
        protected int prg_codigo;

        public PerguntaPK() {}

        public PerguntaPK(Questionario qst_codigo, int prg_codigo) {
            this.qst_codigo = qst_codigo;
            this.prg_codigo = prg_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 19 * hash + Objects.hashCode(this.qst_codigo);
            hash = 19 * hash + this.prg_codigo;
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
            final PerguntaPK other = (PerguntaPK) obj;
            if (!Objects.equals(this.qst_codigo, other.qst_codigo)) {
                return false;
            }
            if (this.prg_codigo != other.prg_codigo) {
                return false;
            }
            return true;
        }

    }

    public Pergunta() {
    }

    public Questionario getQst_codigo() {
        return qst_codigo;
    }

    public void setQst_codigo(Questionario qst_codigo) {
        this.qst_codigo = qst_codigo;
    }

    public int getPrg_codigo() {
        return prg_codigo;
    }

    public void setPrg_codigo(int prg_codigo) {
        this.prg_codigo = prg_codigo;
    }

    public String getPrg_pergunta() {
        return prg_pergunta;
    }

    public void setPrg_pergunta(String prg_pergunta) {
        this.prg_pergunta = prg_pergunta;
    }

    public int getPrg_ordem() {
        return prg_ordem;
    }

    public void setPrg_ordem(int prg_ordem) {
        this.prg_ordem = prg_ordem;
    }

    public int getPrg_tipo() {
        return prg_tipo;
    }

    public void setPrg_tipo(int prg_tipo) {
        this.prg_tipo = prg_tipo;
    }

    public boolean isPrg_opcaooutros() {
        return prg_opcaooutros;
    }

    public void setPrg_opcaooutros(boolean prg_opcaooutros) {
        this.prg_opcaooutros = prg_opcaooutros;
    }

    public boolean isPrg_exibircandidato() {
        return prg_exibircandidato;
    }

    public void setPrg_exibircandidato(boolean prg_exibircandidato) {
        this.prg_exibircandidato = prg_exibircandidato;
    }
    
    
}
