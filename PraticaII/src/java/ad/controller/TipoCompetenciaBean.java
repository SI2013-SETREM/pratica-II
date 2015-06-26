package ad.controller;

import ad.dao.TipoCompetenciaDAO;
import ad.model.TipoCompetencia;
import cfg.dao.LogDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
public class TipoCompetenciaBean {

    private final String sTitle = TipoCompetencia.sTitle;
    private final String pTitle = TipoCompetencia.pTitle;
    private String ErroMsg = "";
    private TipoCompetencia tipocompetencia = new TipoCompetencia();
    private TipoCompetenciaDAO dao = new TipoCompetenciaDAO();
    private DataModel tipocompetencias;

    public TipoCompetenciaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public TipoCompetencia getTipoCompetencia() {
        return tipocompetencia;
    }

    public void setIdioma(TipoCompetencia i) {
        this.tipocompetencia = i;
    }

    public DataModel getTipoCompetencias() {
        this.tipocompetencias = new ListDataModel(dao.findAll());
        return tipocompetencias;
    }

    public void setTipoCompetencias(DataModel i) {
        this.tipocompetencias = i;
    }

    public String insert() {
        dao.insert(tipocompetencia);
        return "tipocompetencialst";
    }

    public String edit(TipoCompetencia i) {
        tipocompetencia = (TipoCompetencia) tipocompetencias.getRowData();
        return "tipocompetenciafrm";
    }

    public String update() {
        dao.update(tipocompetencia);
        return "tipocompetencialst";
    }

    public String delete(TipoCompetencia i) {
        try {
            dao.delete(i);
            LogDAO.insert("TipoCompetencia", "Deletou Tipo de Competência código: " + i.getTcp_codigo() + ", nome: " + i.getTcp_descricao());
        } catch (Exception e) {
            ErroMsg = "Não é possível excluir este Tipo de Competência!";
        }
        return "tipocompetencialst";
    }

    public String salvar() {
        if (tipocompetencia.getTcp_codigo() > 0) {
            dao.update(tipocompetencia);
            LogDAO.insert("TipoCompetencia", "Alterou Tipo de Competência código: " + tipocompetencia.getTcp_codigo() + ", nome: " + tipocompetencia.getTcp_descricao());
        } else {
            dao.insert(tipocompetencia);
            LogDAO.insert("TipoCompetencia", "Cadastrou Tipo de Competência nome: " + tipocompetencia.getTcp_descricao());
        }
        return "tipocompetencialst";
    }

    public String listar() {
        return "tipocompetencialst";
    }

    public String getErroMsg() {
        return ErroMsg;
    }

    public void setErroMsg(String ErroMsg) {
        this.ErroMsg = ErroMsg;
    }

}
