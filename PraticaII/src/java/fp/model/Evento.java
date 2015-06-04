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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Kelvin
 */
@Entity
@Table(name = "ffp_evento")
public class Evento implements Serializable {
    
    public static final String sTitle = "Evento";
    public static final String pTitle = "Eventos";

    @Id
    @SequenceGenerator(name = "genEvento", sequenceName = "genEvento", allocationSize = 1)
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
    @JoinColumn(name = "tbs_codigo", referencedColumnName = "tbs_codigo")
    private TabINSS tabelainss;
    @ManyToOne
    @JoinColumn(name = "tif_codigo", referencedColumnName = "tif_codigo")
    private TabelaIRRF tabelairrf;
    @ManyToOne
    @JoinColumn(name = "tpe_codigo", referencedColumnName = "tpe_codigo")
    private TipoEvento tipoevento;
    @ManyToOne
    @JoinColumn(name = "sev_codigo", referencedColumnName = "sev_codigo")
    private SerieEvento serieevento;
    @ManyToOne
    @JoinColumn(name = "for_codigo", referencedColumnName = "for_codigo")
    private Formula formula;

    
    //@ManyToOne
    //private Beneficio ben_codigo;

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

    public SerieEvento getSerieevento() {
        return serieevento;
    }

    public void setSerieevento(SerieEvento serieevento) {
        this.serieevento = serieevento;
    }

    public TabINSS getTabelainss() {
        return tabelainss;
    }

    public void setTabelainss(TabINSS tabelainss) {
        this.tabelainss = tabelainss;
    }

    public TabelaIRRF getTabelairrf() {
        return tabelairrf;
    }

    public void setTabelairrf(TabelaIRRF tabelairrf) {
        this.tabelairrf = tabelairrf;
    }

    public TipoEvento getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(TipoEvento tipoevento) {
        this.tipoevento = tipoevento;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

}
