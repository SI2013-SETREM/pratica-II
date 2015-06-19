package ad.controller;

import ad.dao.PessoasAvaliacaoDAO;
import ad.model.Avaliacao;
import ad.model.PessoasAvaliacao;
import cfg.controller.LoginBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import util.Utilidades;

@ManagedBean
public class PessoasAvaliacaoBean {

//    @ManagedProperty("#{loginBean}")
//    private LoginBean loginBean;
    private final String sTitle = PessoasAvaliacao.getsTitle();
    private final String pTitle = PessoasAvaliacao.getpTitle();

    private PessoasAvaliacao pessoas_avaliacao = new PessoasAvaliacao();
    private PessoasAvaliacaoDAO dao = new PessoasAvaliacaoDAO();
    private DataModel pessoas_avaliacoes;
    private DataModel avaliacoes;
    private LoginBean loginB = (LoginBean) Utilidades.getSessionObject("loginBean");
    private int userId = UserCod();
    private List<PessoasAvaliacao> lsPessoasAvaliacao;
    private int idAvaliacao;

    private int UserCod() {
        if (loginB != null && loginB.getUsuario() != null && loginB.getUsuario().getPessoa() != null) {
            return loginB.getUsuario().getPessoa().getPes_codigo();
        } else {
            return -1;
        }
    }

    public PessoasAvaliacaoBean() {
    }

    public PessoasAvaliacao getPessoas_avaliacao() {
        return pessoas_avaliacao;
    }

    public DataModel getAvaliacoes() {
        List<PessoasAvaliacao> lsAvaliacaoPessoas = dao.GetListPessoasAvaliacao(0, 0, userId, true);
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
        List<Integer> ids = new ArrayList<>();
        List<PessoasAvaliacao> lsPesA = new ArrayList<>();
        List<PessoasAvaliacao> lsPesA2 = dao.GetListPessoasAvaliacao(idAvaliacao, 0, 0, false);
        if (lsPesA2 != null && !lsPesA2.isEmpty()) {
            for (PessoasAvaliacao pessoaA : lsPesA2) {
                int id = pessoaA.getColaboradorAvaliado().getPes_codigo();
                if (!ids.contains(id)) {
                    ids.add(id);
                    double mediaG = 0;
                    int size = 0;
                    for (PessoasAvaliacao pesB : lsPesA2) {
                        if (pesB.getPea_datahora_resposta() != null && pesB.getPea_media() != 0 && pesB.getColaboradorAvaliado().getPes_codigo() == id) {
                            mediaG += pesB.getPea_media();
                            size++;
                        }
                    }
                    pessoaA.setPea_media(mediaG / size);
                    lsPesA.add(pessoaA);
                }
            }
        }
        this.pessoas_avaliacoes = new ListDataModel(lsPesA);

    }

    public void getDetails() {
        this.pessoas_avaliacoes = new ListDataModel(dao.GetListPessoasAvaliacao(idAvaliacao, 0, 0, false));
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

////////////
//    public String GetAvaliacoesPendentes() {
//        List<PessoasAvaliacao> lsAvaliacaoPessoas = dao.GetListPessoasAvaliacao(0, 0, user, true);
//        List<Avaliacao> lsAvaliacao = new ArrayList<>();
//        for (PessoasAvaliacao pa : lsAvaliacaoPessoas) {
//            lsAvaliacao.add(pa.getAvaliacao());
//        }
//        avaliacoes = new ListDataModel(lsAvaliacao);
//        return "avaliacoespendenteslst";
//    }
    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

}
