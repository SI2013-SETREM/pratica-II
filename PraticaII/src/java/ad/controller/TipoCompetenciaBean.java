package ad.controller;

import ad.dao.TipoCompetenciaDAO;
import ad.model.TipoCompetencia;
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
        } catch (Exception e) {
            ErroMsg = "Não é possível excluir este Tipo de Competência!";
        }
        return "tipocompetencialst";
    }

    public String salvar() {
        if (tipocompetencia.getTcp_codigo() > 0) {
            dao.update(tipocompetencia);
        } else {
            dao.insert(tipocompetencia);
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
