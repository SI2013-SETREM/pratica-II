/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csb.model;

import cfg.model.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "csb_beneficio")
public class Beneficio implements Serializable {

    public static final String sTitle = "Benefício";
    public static final String pTitle = "Benefícios";

    @Id
    @SequenceGenerator(name = "ben_codigo", sequenceName = "ben_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ben_codigo")
 
    private int ben_codigo;
    private String ben_descricao;
    private Double ben_valor;
    private Double ben_valorpago;
    private Date ben_datainicio;
    private Boolean ben_situacao;
    private Date ben_datafim;

    public Beneficio() {
        
    }

    public Beneficio(int ben_codigo, String ben_descricao, Double ben_valor, Double ben_valorpago, Date ben_datainicio, Boolean ben_situacao, Date ben_datafim) {
    }

    public int getBen_codigo() {
        return ben_codigo;
    }

    public void setBen_codigo(int ben_codigo) {
        this.ben_codigo = ben_codigo;
    }

    public String getBen_descricao() {
        return ben_descricao;
    }

    public void setBen_descricao(String ben_descricao) {
        this.ben_descricao = ben_descricao;
    }

    public Double getBen_valor() {
        return ben_valor;
    }

    public void setBen_valor(Double ben_valor) {
        this.ben_valor = ben_valor;
    }

    public Double getBen_valorpago() {
        return ben_valorpago;
    }

    public void setBen_valorpago(Double ben_valorpago) {
        this.ben_valorpago = ben_valorpago;
    }

    public Date getBen_datainicio() {
        return ben_datainicio;
    }

    public void setBen_datainicio(Date ben_datainicio) {
        this.ben_datainicio = ben_datainicio;
    }

    public Boolean getBen_situacao() {
        return ben_situacao;
    }

    public void setBen_situacao(Boolean ben_situacao) {
        this.ben_situacao = ben_situacao;
    }

    public Date getBen_datafim() {
        return ben_datafim;
    }

    public void setBen_datafim(Date ben_datafim) {
        this.ben_datafim = ben_datafim;
    }

    
}
