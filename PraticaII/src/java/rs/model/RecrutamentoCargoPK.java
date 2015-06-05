/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.model;

import csb.model.Cargo;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author na14161
 */
 public class RecrutamentoCargoPK implements Serializable {

        protected Recrutamento recrutamento;
        protected Cargo cargo;
        protected int rec_car_codigo;

        public RecrutamentoCargoPK() {
        }

        public RecrutamentoCargoPK(Recrutamento recrutamento, Cargo cargo, int rec_car_codigo) {
            this.recrutamento = recrutamento;
            this.cargo = cargo;
            this.rec_car_codigo = rec_car_codigo;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + Objects.hashCode(this.recrutamento);
            hash = 79 * hash + Objects.hashCode(this.cargo);
            hash = 79 * hash + this.rec_car_codigo;
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
            final RecrutamentoCargoPK other = (RecrutamentoCargoPK) obj;
            if (!Objects.equals(this.recrutamento, other.recrutamento)) {
                return false;
            }
            if (!Objects.equals(this.cargo, other.cargo)) {
                return false;
            }
            if (this.rec_car_codigo != other.rec_car_codigo) {
                return false;
            }
            return true;
        }
        

    }
