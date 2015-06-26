/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 *
 * @author NADINE
 */
public class EntrevistaPK implements Serializable {

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo"),
        @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    })
    private RecrutamentoPessoa recrutamentoPessoa;
    
    private int ent_codigo;

    public EntrevistaPK() {
    }

    public EntrevistaPK(RecrutamentoPessoa recrutamentoPessoa, int ent_codigo) {
        this.recrutamentoPessoa = recrutamentoPessoa;
        this.ent_codigo = ent_codigo;
    }

    public RecrutamentoPessoa getRecrutamentoPessoa() {
        return recrutamentoPessoa;
    }

    public void setRecrutamentoPessoa(RecrutamentoPessoa recrutamentoPessoa) {
        this.recrutamentoPessoa = recrutamentoPessoa;
    }

    public int getEntCodigo() {
        return ent_codigo;
    }

    public void setEntCodigo(int ent_codigo) {
        this.ent_codigo = ent_codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.recrutamentoPessoa);
        hash = 97 * hash + this.ent_codigo;
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
        final EntrevistaPK other = (EntrevistaPK) obj;
        if (!Objects.equals(this.recrutamentoPessoa, other.recrutamentoPessoa)) {
            return false;
        }
        if (this.ent_codigo != other.ent_codigo) {
            return false;
        }
        return true;
    }

  

}
