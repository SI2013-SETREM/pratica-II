package ad.controller;

import ad.dao.PessoasAvaliacaoDAO;
import ad.model.PessoasAvaliacao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
public class PessoasAvaliacaoBean {

    private final String sTitle = PessoasAvaliacao.getsTitle();
    private final String pTitle = PessoasAvaliacao.getpTitle();

    private PessoasAvaliacao pessoas_avaliacao = new PessoasAvaliacao();
    private PessoasAvaliacaoDAO dao = new PessoasAvaliacaoDAO();
    private DataModel pessoas_avaliacoes;

    private List<PessoasAvaliacao> lsPessoasAvaliacao;

    public PessoasAvaliacaoBean() {
    }

    public PessoasAvaliacao getPessoas_avaliacao() {
        return pessoas_avaliacao;
    }

    public void setPessoas_avaliacao(PessoasAvaliacao pessoas_avaliacao) {
        this.pessoas_avaliacao = pessoas_avaliacao;
    }

    public DataModel getPessoaAvaliacoes() {
        this.pessoas_avaliacoes = new ListDataModel(dao.findAll());
        return pessoas_avaliacoes;
    }

    public void setPessoaAvaliacoes(DataModel pessoas_avaliacoes) {
        this.pessoas_avaliacoes = pessoas_avaliacoes;
    }

    public String insert() {
        dao.insert(pessoas_avaliacao);
        return "pessoasavaliacaolst";
    }

    public String edit(PessoasAvaliacao i) {
        pessoas_avaliacao = (PessoasAvaliacao) pessoas_avaliacoes.getRowData();
        return "pessoasavaliacaofrm";
    }

    public String details(PessoasAvaliacao i) {
        pessoas_avaliacao = (PessoasAvaliacao) pessoas_avaliacoes.getRowData();
        return "pessoasavaliacaodls";
    }

    public String update() {
        dao.update(pessoas_avaliacao);
        return "pessoasavaliacaolst";
    }

    public String delete(PessoasAvaliacao i) {
        dao.delete(i);
        return "pessoasavaliacaolst";
    }

    public String salvar() {
        if (true) {
            dao.update(pessoas_avaliacao);
        } else {
            dao.insert(pessoas_avaliacao);
        }

        return "pessoasavaliacaolst";
    }

    public String listar() {

        return "pessoasavaliacaolst";
    }

    ///---------------------------------- MApear
    public List<PessoasAvaliacao> GetListPessoasAvaliacao(int ava_id, int pes_codigo, int pes_codigo_avaliador) {

        lsPessoasAvaliacao = dao.GetListPessoasAvaliacao(ava_id, pes_codigo, pes_codigo_avaliador);
        return lsPessoasAvaliacao;
    }

    public String getListPessoaAvaliacoes(int ava_id) {
        this.pessoas_avaliacoes = new ListDataModel(dao.GetListPessoasAvaliacao(ava_id, 0, 0));
        return "pessoasavaliacaolst";
    }

    public String Details(PessoasAvaliacao item) {
        // pessoas_avaliacao = dao.findById(item.get)
        return "pessoasavaliacaodls";
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

}
