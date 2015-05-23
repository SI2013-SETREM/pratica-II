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
@Table(name = "repositorio")
public class Repositorio implements Serializable {

    public static final String sTitle = "Repositorio";
    public static final String pTitle = "Repositorios";

    @Id
    @SequenceGenerator(name = "rep_codigo", sequenceName = "rep_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "rep_codigo")
 
    private int rep_codigo;
    private String rep_nome;

}
