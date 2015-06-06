package td.model;

import cfg.model.Cidade;
import cfg.model.Empresa;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="trd_local")
public class Local implements Serializable{    
    
    public static final String sTitle = "Local";
    public static final String pTitle = "Locais";
    
    @Id
    @SequenceGenerator(name="trd_local_pk_sequence", sequenceName="trd_local_id_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="trd_local_pk_sequence")
    private int loc_codigo;
    private String loc_descricao;
    private String loc_infraestrutura;
    @ManyToOne
    @JoinColumn(name = "emp_codigo")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "cid_codigo")
    private Cidade cidade;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getLoc_codigo() {
        return loc_codigo;
    }

    public void setLoc_codigo(int loc_codigo) {
        this.loc_codigo = loc_codigo;
    }

    public String getLoc_descricao() {
        return loc_descricao;
    }

    public void setLoc_descricao(String loc_descricao) {
        this.loc_descricao = loc_descricao;
    }
    
    public String getLoc_infraestrutura() {
        return loc_infraestrutura;
    }

    public void setLoc_infraestrutura(String loc_infraestrutura) {
        this.loc_infraestrutura = loc_infraestrutura;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.loc_codigo;
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
        final Local other = (Local) obj;
        if (this.loc_codigo != other.loc_codigo) {
            return false;
        }
        return true;
    }
    
}
