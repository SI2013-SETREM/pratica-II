package ad.controller;

import ad.dao.Historico_AvaliacaoDAO;
import ad.model.HistoricoAvaliacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class Historico_AvaliacaoBean {

    private final String sTitle = HistoricoAvaliacao.sTitle;
    private final String pTitle = HistoricoAvaliacao.pTitle;

    private HistoricoAvaliacao avaliacao = new HistoricoAvaliacao();
    private Historico_AvaliacaoDAO dao = new Historico_AvaliacaoDAO();
    private DataModel avaliacoes;

    public Historico_AvaliacaoBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
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
