package ad.controller;

import ad.dao.AvaliacaoDAO;
import ad.model.Avaliacao;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class AvaliacaoBean {

    private final String sTitle = Avaliacao.sTitle;
    private final String pTitle = Avaliacao.pTitle;

    private Avaliacao avaliacao = new Avaliacao();
    private AvaliacaoDAO dao = new AvaliacaoDAO();
    private DataModel avaliacoes;

    public AvaliacaoBean() {
    }

    public Avaliacao getAvaliacao() {
        avaliacao.setAva_dataInicial(new Date());
        avaliacao.setAva_dataFinal(new Date());
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
        return "avaliacaolst";
    }

    public String salvar() {
        if (avaliacao.getAva_codigo() > 0) {
            dao.update(avaliacao);
        } else {
            dao.insert(avaliacao);
        }

        return "avaliacaolst";
    }

    public String listar() {
        return "avaliacaolst";
    }

}
