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
@Table(name = "empresa")
public class Empresa implements Serializable {

    public static final String sTitle = "Empresa";
    public static final String pTitle = "Empresas";

    @Id
    @SequenceGenerator(name = "emp_codigo", sequenceName = "emp_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "emp_codigo")
 
    private int emp_codigo;
    private String emp_nome;

}
