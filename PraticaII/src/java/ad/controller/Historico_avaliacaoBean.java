package ad.controller;

import ad.dao.Historico_avaliacaoDAO;
import ad.model.Historico_avaliacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class Historico_avaliacaoBean {

    private Historico_avaliacao avaliacao = new Historico_avaliacao();
    private Historico_avaliacaoDAO dao = new Historico_avaliacaoDAO();
    private DataModel avaliacoes;

    public Historico_avaliacaoBean() {
    }

    public Historico_avaliacao getHistorico_Avaliacao() {
        return avaliacao;
    }

    public void setHistorico_Avaliacao(Historico_avaliacao avaliacao) {
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

    public String edit(Historico_avaliacao i) {
        avaliacao = (Historico_avaliacao) avaliacoes.getRowData();
        return "avaliacaofrm";
    }

    public String update() {
        dao.update(avaliacao);
        return "avaliacaolst";
    }

    public String delete(Historico_avaliacao i) {
        dao.delete(i);
        return "avaliacoeslst";
    }

    public String salvar() {
//        if (avaliacao.getAva_codigo() > 0) {
//            dao.update(avaliacao);
//        } else {
//            dao.insert(avaliacao);
//        }

        return "avaliacoeslst";
    }

    public String listar() {
        return "avaliacoeslst";
    }

}
