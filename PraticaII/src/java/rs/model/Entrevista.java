
package rs.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="rec_entrevista")
@IdClass(EntrevistaPK.class)
public class Entrevista implements Serializable {
    
    public static final String sTitle = "Entrevista";
    public static final String pTitle = "Entrevistas";
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo"),
        @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    })
    private RecrutamentoPessoa recrutamentoPessoa;
    
    @Id
    private int ent_codigo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ent_datahora;
    private String ent_resumo_entrevista;
    
   

    public Entrevista() {
    }

    public RecrutamentoPessoa getRecrutamentoPessoa() {
        return recrutamentoPessoa;
    }

    public void setRecrutamentoPessoa(RecrutamentoPessoa recrutamentoPessoa) {
        this.recrutamentoPessoa = recrutamentoPessoa;
    }
    
    public int getEntCodigo() {
        return ent_codigo;
    }

    public void setEntCodigo(int ent_codigo) {
        this.ent_codigo = ent_codigo;
    }

    public Date getEntDatahora() {
        return ent_datahora;
    }

    public void setEntDatahora(Date ent_datahora) {
        this.ent_datahora = ent_datahora;
    }

    public String getEnt_resumo_entrevista() {
        return ent_resumo_entrevista;
    }

    public void setEnt_resumo_entrevista(String ent_resumo_entrevista) {
        this.ent_resumo_entrevista = ent_resumo_entrevista;
    }
    
}
