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
import javax.persistence.ManyToOne;
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
    @ManyToOne
    private Tab_inss tab_inss;
    @ManyToOne
    private Tabela_irrf tabela_irrf;
    @ManyToOne
    private Tipo_evento tipo_evento;
    @ManyToOne
    private Serie_evento serie_evento;
    @ManyToOne
    private Formula formula;
    
    //@ManyToOne
    //private Beneficio beneficio;

    public int getEve_codigo() {
        return eve_codigo;
    }

    public void setEve_codigo(int eve_codigo) {
        this.eve_codigo = eve_codigo;
    }

    public String getEve_descricao() {
        return eve_descricao;
    }

    public void setEve_descricao(String eve_descricao) {
        this.eve_descricao = eve_descricao;
    }

    public double getEve_indice() {
        return eve_indice;
    }

    public void setEve_indice(double eve_indice) {
        this.eve_indice = eve_indice;
    }

    public boolean isEve_imprimir() {
        return eve_imprimir;
    }

    public void setEve_imprimir(boolean eve_imprimir) {
        this.eve_imprimir = eve_imprimir;
    }

    public boolean isEve_tributar_irrf() {
        return eve_tributar_irrf;
    }

    public void setEve_tributar_irrf(boolean eve_tributar_irrf) {
        this.eve_tributar_irrf = eve_tributar_irrf;
    }

    public boolean isEve_tributar_inss() {
        return eve_tributar_inss;
    }

    public void setEve_tributar_inss(boolean eve_tributar_inss) {
        this.eve_tributar_inss = eve_tributar_inss;
    }

    public boolean isEve_tributar_fgts() {
        return eve_tributar_fgts;
    }

    public void setEve_tributar_fgts(boolean eve_tributar_fgts) {
        this.eve_tributar_fgts = eve_tributar_fgts;
    }

    public boolean isEve_calcular_media_agregada13() {
        return eve_calcular_media_agregada13;
    }

    public void setEve_calcular_media_agregada13(boolean eve_calcular_media_agregada13) {
        this.eve_calcular_media_agregada13 = eve_calcular_media_agregada13;
    }

    public boolean isEve_acumular_horas_n() {
        return eve_acumular_horas_n;
    }

    public void setEve_acumular_horas_n(boolean eve_acumular_horas_n) {
        this.eve_acumular_horas_n = eve_acumular_horas_n;
    }

    public boolean isEve_acumular_rais_base() {
        return eve_acumular_rais_base;
    }

    public void setEve_acumular_rais_base(boolean eve_acumular_rais_base) {
        this.eve_acumular_rais_base = eve_acumular_rais_base;
    }

    public boolean isEve_acumular_rais_horas() {
        return eve_acumular_rais_horas;
    }

    public void setEve_acumular_rais_horas(boolean eve_acumular_rais_horas) {
        this.eve_acumular_rais_horas = eve_acumular_rais_horas;
    }

    public boolean isEve_horas_dias() {
        return eve_horas_dias;
    }

    public void setEve_horas_dias(boolean eve_horas_dias) {
        this.eve_horas_dias = eve_horas_dias;
    }

    public Tab_inss getTab_inss() {
        return tab_inss;
    }

    public void setTab_inss(Tab_inss tab_inss) {
        this.tab_inss = tab_inss;
    }

    public Tabela_irrf getTabela_irrf() {
        return tabela_irrf;
    }

    public void setTabela_irrf(Tabela_irrf tabela_irrf) {
        this.tabela_irrf = tabela_irrf;
    }

    public Tipo_evento getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(Tipo_evento tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public Serie_evento getSerie_evento() {
        return serie_evento;
    }

    public void setSerie_evento(Serie_evento serie_evento) {
        this.serie_evento = serie_evento;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }
    
;
}
