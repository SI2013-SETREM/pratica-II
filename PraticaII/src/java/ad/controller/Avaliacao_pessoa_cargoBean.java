/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad.controller;

import ad.dao.Avaliacao_pessoa_cargoDAO;
import ad.model.Avaliacao_pessoa_cargo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class Avaliacao_pessoa_cargoBean {

    private Avaliacao_pessoa_cargo avaliacaoPessoaCargo = new Avaliacao_pessoa_cargo();
    private Avaliacao_pessoa_cargoDAO dao = new Avaliacao_pessoa_cargoDAO();
    private DataModel avaliacaoPessoasCargos;

    public Avaliacao_pessoa_cargoBean() {
    }

    public Avaliacao_pessoa_cargo getAvaliacao_pessoa_cargo() {
        return avaliacaoPessoaCargo;
    }

    public void setAvaliacao_pessoa_cargo(Avaliacao_pessoa_cargo avaliacaoPessoaCargo) {
        this.avaliacaoPessoaCargo = avaliacaoPessoaCargo;
    }

    public DataModel getAvaliacao_pessoa_cargos() {
        this.avaliacaoPessoasCargos = new ListDataModel(dao.findAll());
        return avaliacaoPessoasCargos;
    }

    public void setAvaliacao_pessoa_cargos(DataModel avaliacaoPessoaCargos) {
        this.avaliacaoPessoasCargos = avaliacaoPessoaCargos;
    }

    public String insert() {
        dao.insert(avaliacaoPessoaCargo);
        return "avaliacaoPessoaCargolst";
    }

    public String edit(Avaliacao_pessoa_cargo i) {
        avaliacaoPessoaCargo = (Avaliacao_pessoa_cargo) avaliacaoPessoasCargos.getRowData();
        return "avaliacaoPessoaCargofrm";
    }

    public String update() {
        dao.update(avaliacaoPessoaCargo);
        return "avaliacaoPessoaCargolst";
    }

    public String delete(Avaliacao_pessoa_cargo i) {
        dao.delete(i);
        return "avaliacaoPessoaCargolst";
    }

    public String salvar() {
        if (avaliacaoPessoaCargo.getApc_codigo() > 0 && avaliacaoPessoaCargo.getAvaliacao().getAva_codigo() > 0) {
            dao.update(avaliacaoPessoaCargo);
        } else {
            dao.insert(avaliacaoPessoaCargo);
        }

        return "avaliacaoPessoaCargolst";
    }

}
