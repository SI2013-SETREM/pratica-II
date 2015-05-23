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

}
