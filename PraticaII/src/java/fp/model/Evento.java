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
@SequenceGenerator(name = "genEvento", sequenceName = "genEvento", allocationSize = 1)
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genEvento")
    private int eve_codigo;
    private String eve_descricao;
    private double eve_indice;
    private boolean eve_imprimir;
    private boolean eve_tributar_irrf;
    private boolean eve_tributar_inss;
    private boolean eve_tributar_fgts;
    private boolean eve_calcular_media_agregada13;
    private boolean eve_acumular_horas_n;
    private boolean eve_acumular_rais_base;
    private boolean eve_acumular_rais_horas;
    private boolean eve_horas_dias;

}
