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
@Table(name = "parametro")
public class Parametro implements Serializable {

    public static final String sTitle = "Parâmetro";
    public static final String pTitle = "Parâmetros";

    @Id
    @SequenceGenerator(name = "par_codigo", sequenceName = "par_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "par_codigo")
 
    private int par_codigo;

}
