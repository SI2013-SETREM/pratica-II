package ad.controller;

import ad.dao.HistoricoAvaliacaoDAO;
import ad.model.Historico_avaliacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class HistoricoAvaliacaoBean {

    private Historico_avaliacao avaliacao = new Historico_avaliacao();
    private HistoricoAvaliacaoDAO dao = new HistoricoAvaliacaoDAO();
    private DataModel avaliacoes;

    public HistoricoAvaliacaoBean() {
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
