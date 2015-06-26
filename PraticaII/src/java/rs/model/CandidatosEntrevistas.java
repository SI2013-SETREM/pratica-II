/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.model;

import cfg.model.Pessoa;

/**
 *
 * @author NADINE
 */
public class CandidatosEntrevistas {

    private Pessoa pessoa;
    private Entrevista entrevista;
    private boolean marcadaentrevista;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isMarcadaentrevista() {
        return marcadaentrevista;
    }

    public void setMarcadaentrevista(boolean marcadaentrevista) {
        this.marcadaentrevista = marcadaentrevista;
    }

    public Entrevista getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(Entrevista entrevista) {
        this.entrevista = entrevista;
    }

}
