/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ben_datainicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ben_datafim;

    public Beneficio() {

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

    public Date getBen_datainicio() {
        return ben_datainicio;
    }

    public void setBen_datainicio(Date ben_datainicio) {
        this.ben_datainicio = ben_datainicio;
    }

    public Date getBen_datafim() {
        return ben_datafim;
    }

    public String getBen_dataToString(Date data) {
        return util.Utilidades.getDataString(data);
    }

    public void setBen_datafim(Date ben_datafim) {
        this.ben_datafim = ben_datafim;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.ben_codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Beneficio other = (Beneficio) obj;
        if (this.ben_codigo != other.ben_codigo) {
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        return getBen_descricao();
    }

}
