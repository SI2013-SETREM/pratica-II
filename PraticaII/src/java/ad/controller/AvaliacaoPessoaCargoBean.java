package ad.controller;

import ad.dao.AvaliacaoPessoaCargoDAO;
import ad.model.AvaliacaoPessoaCargo;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


@ManagedBean
public class AvaliacaoPessoaCargoBean {

    private AvaliacaoPessoaCargo avaliacaoPessoaCargo = new AvaliacaoPessoaCargo();
    private AvaliacaoPessoaCargoDAO dao = new AvaliacaoPessoaCargoDAO();
    private DataModel avaliacaoPessoasCargos;

    public AvaliacaoPessoaCargoBean() {
    }

    public AvaliacaoPessoaCargo getAvaliacao_pessoa_cargo() {
        return avaliacaoPessoaCargo;
    }

    public void setAvaliacao_pessoa_cargo(AvaliacaoPessoaCargo avaliacaoPessoaCargo) {
        this.avaliacaoPessoaCargo = avaliacaoPessoaCargo;
    }

    public DataModel getAvaliacao_pessoa_cargos() {
        this.avaliacaoPessoasCargos = new ListDataModel(dao.findAll());
        return avaliacaoPessoasCargos;
    }

    public void setAvaliacao_pessoa_cargos(DataModel avaliacaoPessoaCargos) {
        this.avaliacaoPessoasCargos = avaliacaoPessoaCargos;
    }

    public String insert() {
        dao.insert(avaliacaoPessoaCargo);
        return "avaliacaoPessoaCargolst";
    }

    public String edit(AvaliacaoPessoaCargo i) {
        avaliacaoPessoaCargo = (AvaliacaoPessoaCargo) avaliacaoPessoasCargos.getRowData();
        return "avaliacaoPessoaCargofrm";
    }

    public String update() {
        dao.update(avaliacaoPessoaCargo);
        return "avaliacaoPessoaCargolst";
    }

    public String delete(AvaliacaoPessoaCargo i) {
        dao.delete(i);
        return "avaliacaoPessoaCargolst";
    }

    public String salvar() {
        if (avaliacaoPessoaCargo.getApc_codigo() > 0 && avaliacaoPessoaCargo.getAvaliacao().getAva_codigo() > 0) {
            dao.update(avaliacaoPessoaCargo);
        } else {
            dao.insert(avaliacaoPessoaCargo);
        }

        return "avaliacaoPessoaCargolst";
    }

}
