package fp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "ffp_serie_evento")
public class SerieEvento implements Serializable{
    
    public static final String sTitle = "Serie Evento";
    public static final String pTitle = "Serie Eventos";

    @Id
    @SequenceGenerator(name = "genSerieEvento", sequenceName = "genSerieEvento", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genSerieEvento")
    private int sev_codigo;
    @Column(nullable = false)
    private String sev_descricao;
    private String sev_nome;

    public int getSev_codigo() {
        return sev_codigo;
    }

    public void setSev_codigo(int sev_codigo) {
        this.sev_codigo = sev_codigo;
    }

    public String getSev_descricao() {
        return sev_descricao;
    }

    public void setSev_descricao(String sev_descricao) {
        this.sev_descricao = sev_descricao;
    }

    public String getSev_nome() {
        return sev_nome;
    }

    public void setSev_nome(String sev_nome) {
        this.sev_nome = sev_nome;
    }
    
    @Override
    public int hashCode(){
    int hash = 7;
    hash = 59* hash + this.sev_codigo;
    return hash;
    }
    
    @Override
    public boolean equals (Object obj){
    if (obj == null){
    return false;
    }
    if(getClass() != obj.getClass()){
    return false;
    }
    final SerieEvento other = (SerieEvento) obj;
    if(this.sev_codigo != other.sev_codigo){
    return false;
    }
    return true;
    }
    
    @Override
    public String toString(){
    return getSev_nome();
    }
    
}
