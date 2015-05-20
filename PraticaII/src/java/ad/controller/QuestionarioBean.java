package ad.controller;

import ad.dao.Historico_AvaliacaoDAO;
import ad.model.Historico_Avaliacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class QuestionarioBean {

    private final String sTitle = Historico_Avaliacao.sTitle;
    private final String pTitle = Historico_Avaliacao.pTitle;

    private Historico_Avaliacao avaliacao = new Historico_Avaliacao();
    private Historico_AvaliacaoDAO dao = new Historico_AvaliacaoDAO();
    private DataModel avaliacoes;

    public QuestionarioBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Historico_Avaliacao getHistorico_Avaliacao() {
        return avaliacao;
    }

    public void setHistorico_Avaliacao(Historico_Avaliacao avaliacao) {
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

    public String edit(Historico_Avaliacao i) {
        avaliacao = (Historico_Avaliacao) avaliacoes.getRowData();
        return "avaliacaofrm";
    }

    public String update() {
        dao.update(avaliacao);
        return "avaliacaolst";
    }

    public String delete(Historico_Avaliacao i) {
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
