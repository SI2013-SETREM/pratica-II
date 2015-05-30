package ad.controller;

import ad.dao.AvaliacaoDAO;
import ad.dao.AvaliacaoPessoaCargoDAO;
import ad.dao.CargoDAO;
import ad.dao.PessoasAvaliacaoDAO;
import ad.model.Avaliacao;
import ad.model.AvaliacaoPessoaCargo;
import ad.model.PessoasAvaliacao;
import cfg.model.Pessoa;
import csb.dao.CargosPessoaDAO;
import csb.model.Cargo;
import csb.model.CargosPessoa;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
public class AvaliacaoBean {

    private final String sTitle = Avaliacao.sTitle;
    private final String pTitle = Avaliacao.pTitle;
    private List<Cargo> lsavaliadoresCargo;
    private CargoDAO cargodao = new CargoDAO();
    private List<Cargo> lsavaliados;
    private Avaliacao avaliacao = new Avaliacao();
    private AvaliacaoDAO dao = new AvaliacaoDAO();
    private AvaliacaoPessoaCargoDAO avaliacaoPessoaCargoDAO = new AvaliacaoPessoaCargoDAO();
    private PessoasAvaliacaoDAO pessoaAvaliacaoDAO = new PessoasAvaliacaoDAO();
    private CargosPessoaDAO cargosPessoaDAO = new CargosPessoaDAO();
    private DataModel avaliacoes;

    private List<AvaliacaoPessoaCargo> lsAvaliacaoPessoaCargo;
    private List<PessoasAvaliacao> lsPessoasAvaliacao;///Lista de PessoasAvaliação

    public AvaliacaoBean() {
    }

    public List<Cargo> completeCargo(String query) {
        return cargodao.searchCargos(query);
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

            for (int i = 0; i < lsavaliadoresCargo.size(); i++) { ///realiza for para "pegar" todas as pessoas dos cargos relacionados
                AvaliacaoPessoaCargo VPC = new AvaliacaoPessoaCargo();
                List<CargosPessoa> lscargosPessoa = cargosPessoaDAO.GetListCargoPessoa(0, lsavaliadoresCargo.get(i).getCar_codigo());///Pega as pessoas daquele cargo
                for (int x = 0; x < lscargosPessoa.size(); x++) {
                    VPC.setPessoa(lscargosPessoa.get(x).getPessoa());
                    VPC.setCargo(lscargosPessoa.get(x).getCargo());
                }
                VPC.setAvaliacao(avaliacao);
                VPC.setApc_status(2);//2 = status do Avaliadores
                lsAvaliacaoPessoaCargo.add(VPC);
            }
            for (int j = 0; j < lsavaliados.size(); j++) {

                AvaliacaoPessoaCargo VPCAavaliados = new AvaliacaoPessoaCargo();
                List<CargosPessoa> lscargosPessoa = cargosPessoaDAO.GetListCargoPessoa(0, lsavaliadoresCargo.get(j).getCar_codigo());///Pega as pessoas daquele cargo
                for (int z = 0; z < lscargosPessoa.size(); z++) {
                    VPCAavaliados.setPessoa(lscargosPessoa.get(z).getPessoa());
                    VPCAavaliados.setCargo(lscargosPessoa.get(z).getCargo());
                }
                VPCAavaliados.setAvaliacao(avaliacao);
                VPCAavaliados.setApc_status(1);//1 = status do Colaboradores, ou seja, os avaliados
                lsAvaliacaoPessoaCargo.add(VPCAavaliados);
            }
            //Até aki esta criado todas as AvaliaçõesPessoaCargo, e Agora deve-se cadastrar as PessoasAvaliações, Blz

            for (int y = 0; y < 10; y++) {
                if (lsAvaliacaoPessoaCargo.get(y).getApc_status() == 1) {///Verifica se é AVALIADOR
                    Pessoa Avaliador = lsAvaliacaoPessoaCargo.get(y).getPessoa();
                    for (int b = 0; b < 10; b++) {
                        if (lsAvaliacaoPessoaCargo.get(b).getApc_status() == 2) {//Verifica se é COLABORADOR
                            Pessoa Colaborador = lsAvaliacaoPessoaCargo.get(b).getPessoa();

                            //crio as PessoasAvaliacao
                            PessoasAvaliacao pessoaAvaliacao = new PessoasAvaliacao();
                            pessoaAvaliacao.setAvaliacao(avaliacao);
                            pessoaAvaliacao.setAvaliador(Avaliador);
                            pessoaAvaliacao.setColaboradorAvaliado(Colaborador);
                            pessoaAvaliacao.setPea_media(0);
                            lsPessoasAvaliacao.add(pessoaAvaliacao);
                        }
                    }
                }
            }
///Hora de Inserir :0
            dao.insert(avaliacao);//inseri a Avaliação
            for (int b = 0; b < lsAvaliacaoPessoaCargo.size(); b++) {
                avaliacaoPessoaCargoDAO.insert(lsAvaliacaoPessoaCargo.get(b)); //inseri a AvaliacaoPessoaCargo
            }
            for (int c = 0; c < lsPessoasAvaliacao.size(); c++) {
                pessoaAvaliacaoDAO.insert(lsPessoasAvaliacao.get(c));

                dao.insert(avaliacao);
            }
            return "avaliacaolst";
        }
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
        return lsavaliadoresCargo;
    }

    public void setLsavaliadores(List<Cargo> lsavaliadoresCargo) {
        this.lsavaliadoresCargo = lsavaliadoresCargo;
    }

    public List<Cargo> getLsavaliados() {
        return lsavaliados;
    }

    public void setLsavaliados(List<Cargo> lsavaliados) {
        this.lsavaliados = lsavaliados;
    }

}
