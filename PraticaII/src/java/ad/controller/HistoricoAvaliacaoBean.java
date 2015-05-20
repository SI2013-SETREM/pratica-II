package ad.controller;

import ad.dao.HistoricoAvaliacaoDAO;
import ad.model.HistoricoAvaliacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class HistoricoAvaliacaoBean {

    private HistoricoAvaliacao avaliacao = new HistoricoAvaliacao();
    private HistoricoAvaliacaoDAO dao = new HistoricoAvaliacaoDAO();
    private DataModel avaliacoes;

    public HistoricoAvaliacaoBean() {
    }

    public HistoricoAvaliacao getHistorico_Avaliacao() {
        return avaliacao;
    }

    public void setHistorico_Avaliacao(HistoricoAvaliacao avaliacao) {
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

    public String edit(HistoricoAvaliacao i) {
        avaliacao = (HistoricoAvaliacao) avaliacoes.getRowData();
        return "avaliacaofrm";
    }

    public String update() {
        dao.update(avaliacao);
        return "avaliacaolst";
    }

    public String delete(HistoricoAvaliacao i) {
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
