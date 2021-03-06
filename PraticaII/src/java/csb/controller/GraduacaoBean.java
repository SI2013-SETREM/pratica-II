package csb.controller;

import cfg.dao.LogDAO;
import csb.controller.*;
import csb.dao.GraduacaoDAO;
import csb.model.Graduacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class GraduacaoBean {

    private final String sTitle = Graduacao.sTitle;
    private final String pTitle = Graduacao.pTitle;

    private Graduacao graduacao = new Graduacao();
    private GraduacaoDAO dao = new GraduacaoDAO();
    private DataModel graduacoes;

    public GraduacaoBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public DataModel getGraduacoes() {
        this.graduacoes = new ListDataModel(dao.findAll());
        return graduacoes;
    }

    public void setGraduacoes(DataModel graduacoes) {
        this.graduacoes = graduacoes;
    }

    public String insert() {
        dao.insert(graduacao);
        return "graduacaolst";
    }

    public String edit(Graduacao i) {
        graduacao = (Graduacao) graduacoes.getRowData();
        return "graduacaofrm";
    }

    public String update() {
        dao.update(graduacao);
        return "graduacaolst";
    }

    public String delete(Graduacao i) {
        dao.delete(i);
        LogDAO.insert("Graduacao", "Deletou graduação código: " + i.getGrd_codigo() + ", descrição: " + i.getGrd_descricao());
        return "graduacaolst";
    }

    public String salvar() {
        if (graduacao.getGrd_codigo() > 0) {
            dao.update(graduacao);
            LogDAO.insert("Graduacao", "Alterou graduação código: " + graduacao.getGrd_codigo()+ ", descrição: " + graduacao.getGrd_descricao());
        } else {
            dao.insert(graduacao);
            LogDAO.insert("Graduacao", "Cadastrou graduação código: " + graduacao.getGrd_codigo()+ ", descrição: " + graduacao.getGrd_descricao());
        }

        return "graduacaolst";
    }

    public String listar() {
        return "graduacaolst";
    }

}
