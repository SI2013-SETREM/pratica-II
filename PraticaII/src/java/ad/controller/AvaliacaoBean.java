package ad.controller;

import ad.dao.AvaliacaoDAO;
import ad.model.Avaliacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class AvaliacaoBean {

    private Avaliacao avaliacao = new Avaliacao();
    private AvaliacaoDAO dao = new AvaliacaoDAO();
    private DataModel avaliacoes;

    public AvaliacaoBean() {
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public DataModel getAvaliacoes() {
        this.avaliacoes = new ListDataModel(dao.findAll());
        return avaliacoes;
    }

    public void setAvaliacoes(DataModel avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public String insert() {
        dao.insert(avaliacao);
        return "avaliacaolst";
    }

    public String edit(Avaliacao i) {
        avaliacao = (Avaliacao) avaliacoes.getRowData();
        return "avaliacaofrm";
    }

    public String update() {
        dao.update(avaliacao);
        return "avaliacaolst";
    }

    public String delete(Avaliacao i) {
        dao.delete(i);
        return "avaliacoeslst";
    }

    public String salvar() {
        if (true) {
            dao.update(avaliacao);
        } else {
            dao.insert(avaliacao);
        }

        return "avaliacoeslst";
    }

    public String listar() {
        return "avaliacoeslst";
    }

}
