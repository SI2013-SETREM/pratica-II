/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Cliente
 */
@Entity
@SequenceGenerator(name = "genTipoEvento", sequenceName = "genTipoEvento", allocationSize = 1)
public class TipoEvento implements Serializable{
 
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genTipoEvento")
    private int tpe_codigo;
    private String tpe_tipo_de_entrada;
    private String tpe_nome;

    public int getTpe_codigo() {
        return tpe_codigo;
    }

    public void setTpe_codigo(int tpe_codigo) {
        this.tpe_codigo = tpe_codigo;
    }

    public String getTpe_tipo_de_entrada() {
        return tpe_tipo_de_entrada;
    }

    public void setTpe_tipo_de_entrada(String tpe_tipo_de_entrada) {
        this.tpe_tipo_de_entrada = tpe_tipo_de_entrada;
    }

    public String getTpe_nome() {
        return tpe_nome;
    }

    public void setTpe_nome(String tpe_nome) {
        this.tpe_nome = tpe_nome;
    }
}
