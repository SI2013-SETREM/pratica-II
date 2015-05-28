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

    public Empresa() {
    }

    public Empresa(int emp_codigo, String emp_nome) {
        this.emp_codigo = emp_codigo;
        this.emp_nome = emp_nome;
    }

    public int getEmp_codigo() {
        return emp_codigo;
    }

    public void setEmp_codigo(int emp_codigo) {
        this.emp_codigo = emp_codigo;
    }

    public String getEmp_nome() {
        return emp_nome;
    }

    public void setEmp_nome(String emp_nome) {
        this.emp_nome = emp_nome;
    }
    
    

}
