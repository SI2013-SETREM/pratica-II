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
    @SequenceGenerator(name = "end_codigo", sequenceName = "end_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "end_codigo")
    private int end_codigo;
    private String end_descricao;
    private String end_cep;

    public Endereco() {
    }

    public Endereco(int end_codigo, String end_descricao, String end_cep) {
        this.end_codigo = end_codigo;
        this.end_descricao = end_descricao;
        this.end_cep = end_cep;
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

    public String getEnd_cep() {
        return end_cep;
    }

    public void setEnd_cep(String end_cep) {
        this.end_cep = end_cep;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.end_codigo;
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
        final Endereco other = (Endereco) obj;
        if (this.end_codigo != other.end_codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getEnd_descricao();
    }

}
