package cfg.controller;

import cfg.dao.BairroDAO;
import cfg.dao.LogDAO;
import cfg.model.Bairro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class BairroBean {

    private final String sTitle = Bairro.sTitle;
    private final String pTitle = Bairro.pTitle;

    private Bairro bairro = new Bairro();
    private BairroDAO dao = new BairroDAO();
    private DataModel bairros;

    public BairroBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public DataModel getBairros() {
        this.bairros = new ListDataModel(dao.findAll());
        return bairros;
    }

    public void setBairros(DataModel idiomas) {
        this.bairros = bairros;
    }

    public String insert() {
        dao.insert(bairro);
        return "bairrolst";
    }

    public String edit(Bairro i) {
        bairro = (Bairro) bairros.getRowData();
        return "bairrofrm";
    }

    public String update() {
        dao.update(bairro);
        return "bairrolst";
    }

    public String delete(Bairro i) {
        dao.delete(i);
        LogDAO.insert("Bairro", "Deletou bairro código: " + i.getBai_codigo() + ", descrição: " + i.getBai_descricao());
        return "bairrolst";
    }

    public String salvar() {
        if (bairro.getBai_codigo() > 0) {
            dao.update(bairro);
            LogDAO.insert("Bairro", "Alterou bairro código: " + bairro.getBai_codigo() +
                    ", descrição: " + bairro.getBai_descricao());
        } else {
            dao.insert(bairro);
            LogDAO.insert("Bairro", "Cadastrou bairro código: " + bairro.getBai_codigo() +
                    ", descrição: " + bairro.getBai_descricao());
        }

        return "bairrolst";
    }

    public String listar() {
        return "bairrolst";
    }

}
