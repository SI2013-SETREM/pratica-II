package td.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trd_instrutores_treinamento")
public class InstrutoresTreinamento implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo") 
    private Pessoa pessoa;

    @Id
    @ManyToOne
    @JoinColumn(name = "tre_codigo", referencedColumnName = "tre_codigo")
    private Treinamento treinamento;
    
     public InstrutoresTreinamento() {
    }
     
     public InstrutoresTreinamento(Treinamento treinamento, Pessoa pessoa){
         this.treinamento = treinamento;
         this.pessoa = pessoa;
     }
/*
    public static class InstrutoresTreinamentoPK implements Serializable {

        protected Pessoa pessoa;
        protected Treinamento treinamento;

        public InstrutoresTreinamentoPK(Pessoa pessoa, Treinamento treinamento) {
            this.pessoa = pessoa;
            this.treinamento = treinamento;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.pessoa);
            hash = 97 * hash + Objects.hashCode(this.treinamento);
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
            final InstrutoresTreinamentoPK other = (InstrutoresTreinamentoPK) obj;
            if (!Objects.equals(this.pessoa, other.pessoa)) {
                return false;
            }
            if (!Objects.equals(this.treinamento, other.treinamento)) {
                return false;
            }
            return true;
        }

    }*/

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }
}
