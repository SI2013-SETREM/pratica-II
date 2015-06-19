/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author NADINE
 */
 // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
//@Embeddable
public class RecrutamentoPessoaPK implements Serializable {

//    @Column(name = "rec_codigo", nullable = false)
    @ManyToOne
    @JoinColumn(name = "rec_codigo", referencedColumnName = "rec_codigo")
    protected Recrutamento recrutamento;
    
//    @Column(name = "pes_codigo", nullable = false)
    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    protected Pessoa pessoa;

    public RecrutamentoPessoaPK() {
    }

    public RecrutamentoPessoaPK(Recrutamento recrutamento, Pessoa pessoa) {
        this.recrutamento = recrutamento;
        this.pessoa = pessoa;
    }

    public Recrutamento getRecrutamento() {
        return recrutamento;
    }

    public void setRecrutamento(Recrutamento recrutamento) {
        this.recrutamento = recrutamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.recrutamento);
        hash = 73 * hash + Objects.hashCode(this.pessoa);
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
        final RecrutamentoPessoaPK other = (RecrutamentoPessoaPK) obj;
        if (!Objects.equals(this.recrutamento, other.recrutamento)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }
    
}
