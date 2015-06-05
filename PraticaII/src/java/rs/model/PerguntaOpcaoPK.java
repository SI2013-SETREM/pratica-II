package rs.model;

import java.io.Serializable;
import java.util.Objects;

// From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
public class PerguntaOpcaoPK implements Serializable {

    protected Pergunta pergunta;
    protected int opc_codigo;

    public PerguntaOpcaoPK() {}

    public PerguntaOpcaoPK(Pergunta pergunta, int opc_codigo) {
        this.pergunta = pergunta;
        this.opc_codigo = opc_codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.pergunta);
        hash = 23 * hash + this.opc_codigo;
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
        final PerguntaOpcaoPK other = (PerguntaOpcaoPK) obj;
        if (!Objects.equals(this.pergunta, other.pergunta)) {
            return false;
        }
        if (this.opc_codigo != other.opc_codigo) {
            return false;
        }
        return true;
    }

}
