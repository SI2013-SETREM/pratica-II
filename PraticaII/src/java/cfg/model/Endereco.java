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
@Table(name = "endereco")
public class Endereco implements Serializable {
 public static final String sTitle = "Endereço";
    public static final String pTitle = "Endereços";
    
    @Id
    @SequenceGenerator(name="end_codigo", sequenceName="end_codigo")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="end_codigo")
    private int end_codigo;
    private String end_descricao;

    public Endereco() {
    }

    public Endereco(int end_codigo, String end_descricao) {
        this.end_codigo = end_codigo;
        this.end_descricao = end_descricao;
    }

    public int getEnd_codigo() {
        return end_codigo;
    }

    public void setEnd_codigo(int end_codigo) {
        this.end_codigo = end_codigo;
    }

    public String getEnd_descricao() {
        return end_descricao;
    }

    public void setEnd_descricao(String end_descricao) {
        this.end_descricao = end_descricao;
    }
    
    
}
