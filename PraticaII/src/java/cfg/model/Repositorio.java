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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
    private Date rep_data;
    private String rep_nome;
    private String rep_nomearquivo;
    private String rep_extensao;

    public Repositorio() {
    }

    public Repositorio(int rep_codigo, int rep_tipo, Date rep_data, String rep_nome, String rep_nomearquivo, String rep_extensao) {
        this.rep_codigo = rep_codigo;
        this.rep_tipo = rep_tipo;
        this.rep_data = rep_data;
        this.rep_nome = rep_nome;
        this.rep_nomearquivo = rep_nomearquivo;
        this.rep_extensao = rep_extensao;
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
    
    
    

}
