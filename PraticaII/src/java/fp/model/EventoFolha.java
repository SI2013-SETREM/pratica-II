
package fp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Kelvin
 */
@Entity
@Table(name = "ffp_evento_folha")
public class EventoFolha implements Serializable {
    @Id
    @ManyToOne
    private Evento eve_evento;
    @Id
    @ManyToOne
    private HistoricoFolha hif_codigo;
    private double evf_valor;
    private String evf_indice;
    private boolean evf_imprimir;
    private String evf_descricao;
    
    private int evf_serv_codigo;
 
    private int evf_tpe_codigo;
    
    private int evf_ben_codigo;
    private int evf_for_godigo;
    private int evf_tif_codigo;
    private int evs_tbs_codigo;



    public double getEvf_valor() {
        return evf_valor;
    }

    public void setEvf_valor(double evf_valor) {
        this.evf_valor = evf_valor;
    }

    public String getEvf_indice() {
        return evf_indice;
    }

    public void setEvf_indice(String evf_indice) {
        this.evf_indice = evf_indice;
    }

    public boolean isEvf_imprimir() {
        return evf_imprimir;
    }

    public void setEvf_imprimir(boolean evf_imprimir) {
        this.evf_imprimir = evf_imprimir;
    }

    public String getEvf_descricao() {
        return evf_descricao;
    }

    public void setEvf_descricao(String evf_descricao) {
        this.evf_descricao = evf_descricao;
    }

    public int getEvf_serv_codigo() {
        return evf_serv_codigo;
    }

    public void setEvf_serv_codigo(int evf_serv_codigo) {
        this.evf_serv_codigo = evf_serv_codigo;
    }

    public int getEvf_tpe_codigo() {
        return evf_tpe_codigo;
    }

    public void setEvf_tpe_codigo(int evf_tpe_codigo) {
        this.evf_tpe_codigo = evf_tpe_codigo;
    }

    public int getEvf_ben_codigo() {
        return evf_ben_codigo;
    }

    public void setEvf_ben_codigo(int evf_ben_codigo) {
        this.evf_ben_codigo = evf_ben_codigo;
    }

    public int getEvf_for_godigo() {
        return evf_for_godigo;
    }

    public void setEvf_for_godigo(int evf_for_godigo) {
        this.evf_for_godigo = evf_for_godigo;
    }

    public int getEvf_tif_codigo() {
        return evf_tif_codigo;
    }

    public void setEvf_tif_codigo(int evf_tif_codigo) {
        this.evf_tif_codigo = evf_tif_codigo;
    }

    public int getEvs_tbs_codigo() {
        return evs_tbs_codigo;
    }

    public void setEvs_tbs_codigo(int evs_tbs_codigo) {
        this.evs_tbs_codigo = evs_tbs_codigo;
    }

    public Evento getEve_evento() {
        return eve_evento;
    }

    public void setEve_evento(Evento eve_evento) {
        this.eve_evento = eve_evento;
    }

    public HistoricoFolha getHif_codigo() {
        return hif_codigo;
    }

    public void setHif_codigo(HistoricoFolha hif_codigo) {
        this.hif_codigo = hif_codigo;
    }
    
    
}
