package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rec_recrutamento_pessoa")
@IdClass(RecrutamentoPessoaPK.class)
public class RecrutamentoPessoa implements Serializable {

    public static final String sTitle = "Pessoa do Recrutamento";
    public static final String pTitle = "Pessoas do Recrutamento";

    @Id
    @ManyToOne
    @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo")
    private Recrutamento recrutamento;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;
    
//    @EmbeddedId
//    private RecrutamentoPessoaPK recrutamentoPessoaPK;

    /**
     * 1 - Aguardando avaliação 2 - Em avaliação 3 - Eliminado 4 - Selecionado
     */
    private int rec_pes_status;

    public RecrutamentoPessoa() {
    }

    public Recrutamento getRecrutamento() {
        return recrutamento;
    }

    public void setRecrutamento(Recrutamento recrutamento) {
        this.recrutamento = recrutamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

//    public RecrutamentoPessoaPK getRecrutamentoPessoaPK() {
//        return recrutamentoPessoaPK;
//    }
//
//    public void setRecrutamentoPessoaPK(RecrutamentoPessoaPK recrutamentoPessoaPK) {
//        this.recrutamentoPessoaPK = recrutamentoPessoaPK;
//    }
    
    public int getRecPesStatus() {
        return rec_pes_status;
    }

    public void setRecPesStatus(int rec_pes_status) {
        this.rec_pes_status = rec_pes_status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.recrutamento);
        hash = 67 * hash + Objects.hashCode(this.pessoa);
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
        final RecrutamentoPessoa other = (RecrutamentoPessoa) obj;
        if (!Objects.equals(this.recrutamento, other.recrutamento)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }
    
}
