/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csb.model;

import cfg.model.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "csb_cargo")
public class Cargo implements Serializable {

    public static final String sTitle = "Cargo";
    public static final String pTitle = "Cargos";

    @Id
    @SequenceGenerator(name = "car_codigo", sequenceName = "car_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "car_codigo")
 
    private int car_codigo;
    private String car_descricao;
    private int car_ativo;
    private String car_cbo;
    private Double car_tetosalarial;
    private Double car_pisosalarial;
    private int car_pai;

    public Cargo() {
        
    }

    public Cargo(int car_codigo, String car_descricao, int car_ativo, String car_cbo, Double car_tetosalarial, Double car_pisosalarial, int car_pai) {
        this.car_codigo = car_codigo;
        this.car_descricao = car_descricao;
        this.car_ativo = car_ativo;
        this.car_cbo = car_cbo;
        this.car_tetosalarial = car_tetosalarial;
        this.car_pisosalarial = car_pisosalarial;
        this.car_pai = car_pai;
    }

    public int getCar_codigo() {
        return car_codigo;
    }

    public void setCar_codigo(int car_codigo) {
        this.car_codigo = car_codigo;
    }

    public String getCar_descricao() {
        return car_descricao;
    }

    public void setCar_descricao(String car_descricao) {
        this.car_descricao = car_descricao;
    }

    public int getCar_ativo() {
        return car_ativo;
    }

    public void setCar_ativo(int car_ativo) {
        this.car_ativo = car_ativo;
    }

    public String getCar_cbo() {
        return car_cbo;
    }

    public void setCar_cbo(String car_cbo) {
        this.car_cbo = car_cbo;
    }

    public Double getCar_tetosalarial() {
        return car_tetosalarial;
    }

    public void setCar_tetosalarial(Double car_tetosalarial) {
        this.car_tetosalarial = car_tetosalarial;
    }

    public Double getCar_pisosalarial() {
        return car_pisosalarial;
    }

    public void setCar_pisosalarial(Double car_pisosalarial) {
        this.car_pisosalarial = car_pisosalarial;
    }

    public int getCar_pai() {
        return car_pai;
    }

    public void setCar_pai(int car_pai) {
        this.car_pai = car_pai;
    }
    
    
    
}
