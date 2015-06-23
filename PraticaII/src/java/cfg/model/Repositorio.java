/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "repositorio")
public class Repositorio implements Serializable {

    public static final String sTitle = "Repositorio";
    public static final String pTitle = "Repositorios";

    @Id
    @SequenceGenerator(name = "rep_codigo", sequenceName = "rep_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "rep_codigo")
    private int rep_codigo;
    
    private int rep_tipo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rep_data;
    private String rep_nome;
    private String rep_nomearquivo;
    private String rep_extensao;
    @Lob
    private byte[] rep_arquivo;

    public Repositorio() {
    }

    public Repositorio(int rep_codigo, int rep_tipo, Date rep_data, String rep_nome, String rep_nomearquivo, String rep_extensao, byte[] rep_arquivo) {
        this.rep_codigo = rep_codigo;
        this.rep_tipo = rep_tipo;
        this.rep_data = rep_data;
        this.rep_nome = rep_nome;
        this.rep_nomearquivo = rep_nomearquivo;
        this.rep_extensao = rep_extensao;
        this.rep_arquivo = rep_arquivo;
    }

    public int getRep_codigo() {
        return rep_codigo;
    }

    public void setRep_codigo(int rep_codigo) {
        this.rep_codigo = rep_codigo;
    }

    public int getRep_tipo() {
        return rep_tipo;
    }

    public void setRep_tipo(int rep_tipo) {
        this.rep_tipo = rep_tipo;
    }

    public Date getRep_data() {
        return rep_data;
    }

    public void setRep_data(Date rep_data) {
        this.rep_data = rep_data;
    }

    public String getRep_nome() {
        return rep_nome;
    }

    public void setRep_nome(String rep_nome) {
        this.rep_nome = rep_nome;
    }

    public String getRep_nomearquivo() {
        return rep_nomearquivo;
    }

    public void setRep_nomearquivo(String rep_nomearquivo) {
        this.rep_nomearquivo = rep_nomearquivo;
    }

    public String getRep_extensao() {
        return rep_extensao;
    }

    public void setRep_extensao(String rep_extensao) {
        this.rep_extensao = rep_extensao;
    }

    public byte[] getRep_arquivo() {
        return rep_arquivo;
    }

    public void setRep_arquivo(byte[] rep_arquivo) {
        this.rep_arquivo = rep_arquivo;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.rep_codigo;
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
        final Repositorio other = (Repositorio) obj;
        if (this.rep_codigo != other.rep_codigo) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return getRep_nome();
    }
}
