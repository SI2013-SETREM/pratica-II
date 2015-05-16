/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Cliente
 */
@Entity
@SequenceGenerator(name = "genTipo_evento", sequenceName = "genTipo_evento", allocationSize = 1)
public class Tipo_evento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genTipo_evento")
    private int tpe_codigo;
    private String tpe_tipo_de_entrada;
    private String tpe_nome;
}
