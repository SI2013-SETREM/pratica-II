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
@Table(name = "usuario")
public class Usuario implements Serializable {

    public static final String sTitle = "Usuário";
    public static final String pTitle = "Usuários";

    @Id
    @SequenceGenerator(name = "usu_codigo", sequenceName = "usu_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "usu_codigo")
 
    private int usu_codigo;
    private String usu_nome;
    private String usu_senha;
    private int usu_status;

    public Usuario() {
    }

    public Usuario(int usu_codigo, String usu_nome, String usu_senha, int usu_status) {
        this.usu_codigo = usu_codigo;
        this.usu_nome = usu_nome;
        this.usu_senha = usu_senha;
        this.usu_status = usu_status;
    }

    public int getUsu_codigo() {
        return usu_codigo;
    }

    public void setUsu_codigo(int usu_codigo) {
        this.usu_codigo = usu_codigo;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public int getUsu_status() {
        return usu_status;
    }

    public void setUsu_status(int usu_status) {
        this.usu_status = usu_status;
    }

    
}
