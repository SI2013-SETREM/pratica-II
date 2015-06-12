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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "redesocial")
public class RedeSocial implements Serializable {

    public static final String sTitle = "Rede Social";
    public static final String pTitle = "Redes Sociais";

    @Id
    @SequenceGenerator(name = "rsc_codigo", sequenceName = "rsc_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "rsc_codigo")
 
    private int rsc_codigo;
    private String rsc_nome;
    private String rsc_url;
    private String rsc_urlperfil;
    
    @ManyToOne
    @JoinColumn(name = "rep_codigo_icone")
    private Repositorio repositorio;

    public RedeSocial() {
    }

    public RedeSocial(int rsc_codigo, String rsc_nome, String rsc_url, String rsc_urlperfil, Repositorio repositorio) {
        this.rsc_codigo = rsc_codigo;
        this.rsc_nome = rsc_nome;
        this.rsc_url = rsc_url;
        this.rsc_urlperfil = rsc_urlperfil;
        this.repositorio = repositorio;
    }

    public int getRsc_codigo() {
        return rsc_codigo;
    }

    public void setRsc_codigo(int rsc_codigo) {
        this.rsc_codigo = rsc_codigo;
    }

    public String getRsc_nome() {
        return rsc_nome;
    }

    public void setRsc_nome(String rsc_nome) {
        this.rsc_nome = rsc_nome;
    }

    public String getRsc_url() {
        return rsc_url;
    }

    public void setRsc_url(String rsc_url) {
        this.rsc_url = rsc_url;
    }

    public String getRsc_urlperfil() {
        return rsc_urlperfil;
    }

    public void setRsc_urlperfil(String rsc_urlperfil) {
        this.rsc_urlperfil = rsc_urlperfil;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.rsc_codigo;
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
        final RedeSocial other = (RedeSocial) obj;
        if (this.rsc_codigo != other.rsc_codigo) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return getRsc_nome();
    }
}
