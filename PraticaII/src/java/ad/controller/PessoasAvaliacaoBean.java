package ad.controller;

import ad.dao.PessoasAvaliacaoDAO;
import ad.model.Avaliacao;
import ad.model.PessoasAvaliacao;
import java.util.ArrayList;
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
    private DataModel avaliacoes;
    private int user = 3;
    private List<PessoasAvaliacao> lsPessoasAvaliacao;
    private int idAvaliacao;

    public PessoasAvaliacaoBean() {
    }

    public PessoasAvaliacao getPessoas_avaliacao() {
        return pessoas_avaliacao;
    }

    public DataModel getAvaliacoes() {
        List<PessoasAvaliacao> lsAvaliacaoPessoas = dao.GetListPessoasAvaliacao(0, 0, user, true);
        List<Avaliacao> lsAvaliacao = new ArrayList<>();
        List<Integer> lsCod = new ArrayList<>();
        for (PessoasAvaliacao pa : lsAvaliacaoPessoas) {
            if (!lsCod.contains(pa.getAvaliacao().getAva_codigo())) {
                lsCod.add(pa.getAvaliacao().getAva_codigo());
                lsAvaliacao.add(pa.getAvaliacao());
            }
        }
        avaliacoes = new ListDataModel(lsAvaliacao);
        return avaliacoes;
    }

    public void setAvaliacoes(DataModel avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setPessoas_avaliacao(PessoasAvaliacao pessoas_avaliacao) {
        this.pessoas_avaliacao = pessoas_avaliacao;
    }

    public DataModel getPessoaAvaliacoes() {
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
        lsPessoasAvaliacao = dao.GetListPessoasAvaliacao(ava_id, pes_codigo, pes_codigo_avaliador, false);
        return lsPessoasAvaliacao;
    }

    public void getListPessoaAvaliacoes() {
        this.pessoas_avaliacoes = new ListDataModel(dao.GetListPessoasAvaliacao(idAvaliacao, 0, 0, false));
       // return "pessoasavaliacaolst";
    }

    public void getDetails() {
        this.pessoas_avaliacoes = new ListDataModel(dao.GetListPessoasAvaliacao(idAvaliacao, 0, 0, false));
        //return "pessoasavaliacaodls";
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

////////////
    public String GetAvaliacoesPendentes() {
        List<PessoasAvaliacao> lsAvaliacaoPessoas = dao.GetListPessoasAvaliacao(0, 0, user, true);
        List<Avaliacao> lsAvaliacao = new ArrayList<>();
        for (PessoasAvaliacao pa : lsAvaliacaoPessoas) {
            lsAvaliacao.add(pa.getAvaliacao());
        }
        avaliacoes = new ListDataModel(lsAvaliacao);
        return "avaliacoespendenteslst";
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

}
