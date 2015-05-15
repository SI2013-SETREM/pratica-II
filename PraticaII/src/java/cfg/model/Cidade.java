/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade implements Serializable{
    public static final String sTitle = "Cidade";
    public static final String pTitle = "Cidades";
     @Id
    @SequenceGenerator(name="cid_cep", sequenceName="cid_cep")
    private String cid_cep;
    private String cid_nome;
    private String cid_uf;

    public Cidade() {
    }

    public Cidade(String cid_cep, String cid_nome, String cid_uf) {
        this.cid_cep = cid_cep;
        this.cid_nome = cid_nome;
        this.cid_uf = cid_uf;
    }

    public String getCid_cep() {
        return cid_cep;
    }

    public void setCid_cep(String cid_cep) {
        this.cid_cep = cid_cep;
    }

    public String getCid_nome() {
        return cid_nome;
    }

    public void setCid_nome(String cid_nome) {
        this.cid_nome = cid_nome;
    }

    public String getCid_uf() {
        return cid_uf;
    }

    public void setCid_uf(String cid_uf) {
        this.cid_uf = cid_uf;
    }
    
    
}
