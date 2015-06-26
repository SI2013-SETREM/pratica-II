package csb.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Juliano Pires
 */
@Entity
@Table(name = "csb_planejamentocarreira")
public class PlanejamentoCarreira implements Serializable {
    public static final String sTitle = "Plano de Carreira";
    public static final String pTitle = "Planos de Carreiras";
    
    @Id
    @SequenceGenerator(name = "plano_pk_sequence", sequenceName = "seq_csb_planejamentocarreira")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "plano_pk_sequence")
    private int pla_codigo;
    private String pla_descricao;
    private boolean pla_status;

    public PlanejamentoCarreira() {
    }

    public int getPla_codigo() {
        return pla_codigo;
    }

    public void setPla_codigo(int pla_codigo) {
        this.pla_codigo = pla_codigo;
    }

    public String getPla_descricao() {
        return pla_descricao;
    }

    public void setPla_descricao(String pla_descricao) {
        this.pla_descricao = pla_descricao;
    }

    public boolean isPla_status() {
        return pla_status;
    }

    public void setPla_status(boolean pla_status) {
        this.pla_status = pla_status;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.pla_codigo);
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
        final PlanejamentoCarreira other = (PlanejamentoCarreira) obj;
        if (!Objects.equals(this.pla_codigo, other.pla_codigo)) {
            return false;
        }
        return true;
    }
}
