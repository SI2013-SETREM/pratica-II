/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bairro")
public class Bairro implements Serializable {

    public static final String sTitle = "Bairro";
    public static final String pTitle = "Bairros";

    @Id
    @SequenceGenerator(name = "bai_codigo", sequenceName = "bai_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bai_codigo")
 
    private int bai_codigo;
    private String bai_descricao;

    public Bairro() {
    }

    public Bairro(int bai_codigo, String bai_descricao) {
        this.bai_codigo = bai_codigo;
        this.bai_descricao = bai_descricao;
    }

    public int getBai_codigo() {
        return bai_codigo;
    }

    public void setBai_codigo(int bai_codigo) {
        this.bai_codigo = bai_codigo;
    }

    public String getBai_descricao() {
        return bai_descricao;
    }

    public void setBai_descricao(String bai_descricao) {
        this.bai_descricao = bai_descricao;
    }

    
}
