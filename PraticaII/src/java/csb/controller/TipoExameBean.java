package csb.controller;

import cfg.dao.LogDAO;
import csb.dao.TipoExameDAO;


import csb.model.TipoExame;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean
@RequestScoped
public class TipoExameBean {

    private final String sTitle = TipoExame.sTitle;
    private final String pTitle = TipoExame.pTitle;

    private TipoExame tipoexame = new TipoExame();
    private TipoExameDAO dao = new TipoExameDAO();
    private DataModel tipoexames;
 
  
    public TipoExameBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public TipoExame getTipoexame() {
        return tipoexame;
    }

    public DataModel getTipoexames() {
        this.tipoexames = new ListDataModel(dao.findAll());
        return tipoexames;
    }

    public void setTipoexames(DataModel datamodel) {
        this.tipoexames = datamodel;
    }

    public void setTipoexame(TipoExame tipoexame) {
        this.tipoexame = tipoexame;
    }

    public String insert() {
        dao.insert(tipoexame);
        return "tipoexamelst";
    }

    public String edit(TipoExame i) {
        tipoexame = (TipoExame) tipoexames.getRowData();
        return "tipoexamefrm";
    }

    public String update() {
        dao.update(tipoexame);
        return "tipoexamelst";
    }

    public String delete(TipoExame i) {
        dao.delete(i);
        LogDAO.insert("TipoExame", "Deletou tipo exame código: " + i.getEme_codigo()+ ", descrição: " + i.getEme_descricao()+
                ", tipo: "+i.getEme_tipo()+", periódico: "+i.isEme_periodico()+", validade: "+i.getEme_validade()+", obrigatório: "+i.isEme_obrigatorio()+
                ", intervalo de repetição: "+i.getEme_intervalorepeticao());
        return "tipoexamelst";
    }

    public String salvar() {
        if (tipoexame.getEme_codigo() > 0) {
            dao.update(tipoexame);
            LogDAO.insert("TipoExame", "Alterou tipo exame código: " + tipoexame.getEme_codigo()+ ", descrição: " + tipoexame.getEme_descricao()+
                ", tipo: "+tipoexame.getEme_tipo()+", periódico: "+tipoexame.isEme_periodico()+", validade: "+tipoexame.getEme_validade()+", obrigatório: "+tipoexame.isEme_obrigatorio()+
                ", intervalo de repetição: "+tipoexame.getEme_intervalorepeticao());
        } else {
            dao.insert(tipoexame);
            LogDAO.insert("TipoExame", "Cadastrou tipo exame código: " + tipoexame.getEme_codigo()+ ", descrição: " + tipoexame.getEme_descricao()+
                ", tipo: "+tipoexame.getEme_tipo()+", periódico: "+tipoexame.isEme_periodico()+", validade: "+tipoexame.getEme_validade()+", obrigatório: "+tipoexame.isEme_obrigatorio()+
                ", intervalo de repetição: "+tipoexame.getEme_intervalorepeticao());
        }
        return "tipoexamelst";
    }

    public String listar() {
        return "tipoexamelst";
    }
    
   
}
