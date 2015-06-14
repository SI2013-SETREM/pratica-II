/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author NADINE
 */
 // From http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
    public class RecrutamentoPessoaPK implements Serializable {
        protected Recrutamento recrutamento;
        protected Pessoa pessoa;

        public RecrutamentoPessoaPK() {}

        public RecrutamentoPessoaPK(Recrutamento recrutamento, Pessoa pessoa) {
            this.recrutamento = recrutamento;
            this.pessoa = pessoa;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.recrutamento);
            hash = 17 * hash + Objects.hashCode(this.pessoa);
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
