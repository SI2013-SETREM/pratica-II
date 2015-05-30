package rs.model;

import java.io.Serializable;
import java.util.Objects;

// From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
public class PerguntaPK implements Serializable {

    protected Questionario questionario;
    protected int prg_codigo;

    public PerguntaPK() {
    }

    public PerguntaPK(Questionario questionario, int prg_codigo) {
        this.questionario = questionario;
        this.prg_codigo = prg_codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.questionario);
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
        if (!Objects.equals(this.questionario, other.questionario)) {
            return false;
        }
        if (this.prg_codigo != other.prg_codigo) {
            return false;
        }
        return true;
    }

}
