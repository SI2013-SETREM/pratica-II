package ad.controller;

import ad.dao.AvaliacaoDAO;
import ad.dao.CargoDAO;
import ad.dao.TipoCompetenciaDAO;
import ad.model.Avaliacao;
import ad.model.TipoCompetencia;
import csb.model.Cargo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
public class AvaliacaoBean {

    private final String sTitle = Avaliacao.sTitle;
    private final String pTitle = Avaliacao.pTitle;
    private List<Cargo> lsavaliadores;
    private CargoDAO cargodao = new CargoDAO();
    private List<Cargo> lsavaliados;
    private Avaliacao avaliacao = new Avaliacao();
    private AvaliacaoDAO dao = new AvaliacaoDAO();
    private DataModel avaliacoes;

    public AvaliacaoBean() {
    }

    public List<Cargo> completeCargo(String query) {
        return cargodao.findAll(query);
        //      List<Cargo> allCargos = cargodao.findAll();
//        List<Cargo> filteredThemes = new ArrayList<Cargo>();
//
//        for (int i = 0; i < allCargos.size(); i++) {
//            Cargo skin = allCargos.get(i);
//            if (skin.getCar_descricao().toLowerCase().startsWith(query)) {
//                filteredThemes.add(skin);
//            }
//        }
//        return filteredThemes;
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
        avaliacoes = new ListDataModel(dao.findAll());
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
            for(int i= 0; i < lsavaliadores.size(); i++){
            
            }
        }
        return "avaliacaolst";
    }

    public String listar() {
        return "avaliacaolst";
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public List<Cargo> getLsavaliadores() {
        return lsavaliadores;
    }

    public void setLsavaliadores(List<Cargo> lsavaliadores) {
        this.lsavaliadores = lsavaliadores;
    }

    public List<Cargo> getLsavaliados() {
        return lsavaliados;
    }

    public void setLsavaliados(List<Cargo> lsavaliados) {
        this.lsavaliados = lsavaliados;
    }

}
