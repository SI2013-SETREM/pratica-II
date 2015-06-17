package rs.model;

import cfg.model.Pessoa;

public class CandidatoRecrutamento {

    private Pessoa pessoa;
    private boolean selecionado;

    public CandidatoRecrutamento() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

}
