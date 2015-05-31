package ad.controller;
//////172.20.143.90 --- ip interno da Setrem pra servidor, Blz

import ad.dao.AvaliacaoDAO;
import ad.dao.AvaliacaoPessoaCargoDAO;
import ad.dao.PessoasAvaliacaoDAO;
import ad.model.Avaliacao;
import cfg.dao.PessoaDAO;
import ad.model.AvaliacaoPessoaCargo;
import ad.model.PessoasAvaliacao;
import cfg.model.Pessoa;
import csb.dao.CargoDAO;
import csb.dao.CargosPessoaDAO;
import csb.model.Cargo;
import csb.model.CargosPessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import td.dao.TreinamentoDAO;
import td.model.Treinamento;

@ManagedBean
public class AvaliacaoBean {

    private final String sTitle = Avaliacao.sTitle;
    private final String pTitle = Avaliacao.pTitle;
    private boolean bautoava;
    private boolean bcomp;
    private char ctipo;
    private char caval;
    private List<Cargo> lsCargoAvaliador;
    private List<Cargo> lsCargoColaborador;
    private List<Pessoa> lsPessoaAvaliador;
    private List<Pessoa> lsPessoaColaborador;
    private CargoDAO cargodao = new CargoDAO();
    private PessoaDAO pessoadao = new PessoaDAO();
    private List<AvaliacaoPessoaCargo> lsAvPesCargo;
    private List<Treinamento> lstreinamento;
    private TreinamentoDAO treinDAO = new TreinamentoDAO();

    private Avaliacao avaliacao;
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
        return cargodao.searchCargo(query);
    }

    public List<Pessoa> completePessoa(String query) {
        return pessoadao.searchPessoa(query);
    }

    public Avaliacao getAvaliacao() {
        if (avaliacao == null) {
            avaliacao = new Avaliacao();
            avaliacao.setAva_dataInicial(new Date());
            avaliacao.setAva_dataFinal(new Date());
            ctipo = 0;
            avaliacao.setAva_status(0);
        }
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
//        lsAvaliacaoPessoaCargo = avaliacaoPessoaCargoDAO.getListAvaliacaoPessoaCargo(avaliacao.getAva_codigo(), 0, 0);
//
//        for (int j = 0; j < lsAvaliacaoPessoaCargo.size(); j++) {
//            AvaliacaoPessoaCargo VPC = new AvaliacaoPessoaCargo();
//            VPC = lsAvaliacaoPessoaCargo.get(j);
//            if (VPC.getApc_status() == 2) {// verifica se é AVALIADOR
//                if (VPC.getCargo() != null && VPC.getCargo().getCar_codigo() != 0) {
//                    lsCargoAvaliador.add(VPC.getCargo());
//                } else {
//                    lsPessoaAvaliador.add(VPC.getPessoa());
//                }
//            } else {///Se não, ele é COLABORADOR AVALIADO
//                if (VPC.getCargo() != null && VPC.getCargo().getCar_codigo() != 0) {
//                    lsCargoColaborador.add(VPC.getCargo());
//                } else {
//                    lsPessoaColaborador.add(VPC.getPessoa());
//                }
//            }
//        }

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
            if (caval == 1) {
                avaliacao.setTreinamento(null);
            }
            if (avaliacao.getStatus() != null) {
                dao.insert(avaliacao);
            }
            if (SalvaListas()) {
                return "questionariofrm";
            } else {
                return "avaliacaofrm";
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

    public List<Cargo> getLsCargoAvaliador() {
        return lsCargoAvaliador;
    }

    public void setLsCargoAvaliador(List<Cargo> lsCargoAvaliador) {
        this.lsCargoAvaliador = lsCargoAvaliador;
    }

    public List<Cargo> getLsCargoColaborador() {
        return lsCargoColaborador;
    }

    public void setLsCargoColaborador(List<Cargo> lsCargoColaborador) {
        this.lsCargoColaborador = lsCargoColaborador;
    }

    public List<Pessoa> getLsPessoaAvaliador() {
        return lsPessoaAvaliador;
    }

    public void setLsPessoaAvaliador(List<Pessoa> lsPessoaAvaliador) {
        this.lsPessoaAvaliador = lsPessoaAvaliador;
    }

    public List<Pessoa> getLsPessoaColaborador() {
        return lsPessoaColaborador;
    }

    public void setLsPessoaColaborador(List<Pessoa> lsPessoaColaborador) {
        this.lsPessoaColaborador = lsPessoaColaborador;
    }

    public boolean isBautoava() {
        return bautoava;
    }

    public void setBautoava(boolean bautoava) {
        this.bautoava = bautoava;
    }

    public boolean isBcomp() {
        return bcomp;
    }

    public void setBcomp(boolean bcomp) {
        this.bcomp = bcomp;
    }

    public char getCtipo() {
        return ctipo;
    }

    public void setCtipo(char ctipo) {
        this.ctipo = ctipo;
    }

    public List<Treinamento> getLstreinamento() {
        lstreinamento = treinDAO.findAll();
        return lstreinamento;
    }

    public char getCaval() {
        return caval;
    }

    public void setCaval(char caval) {
        this.caval = caval;
    }

    private boolean SalvaListas() {
        if (lsCargoAvaliador == null) {
            lsCargoAvaliador = new ArrayList<>();
        }
        if (lsPessoaAvaliador == null) {
            lsPessoaAvaliador = new ArrayList<>();
        }
        if (lsCargoColaborador == null) {
            lsCargoColaborador = new ArrayList<>();
        }
        if (lsPessoaColaborador == null) {
            lsPessoaColaborador = new ArrayList<>();
        }
        if (ValidaListas()) {
            try {
                SalvarAvaPesCargo(filtraCargos(lsCargoColaborador), filtraPessoas(lsPessoaColaborador), 1);
                SalvarAvaPesCargo(filtraCargos(lsCargoAvaliador), filtraPessoas(lsPessoaAvaliador), 2);
                SalvarPesAval(JuntarCargosComPessoas(lsCargoAvaliador, lsPessoaAvaliador), JuntarCargosComPessoas(lsCargoColaborador, lsPessoaColaborador));
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private boolean ValidaListas() {//Verifica as Listas se não estão vazias
        if (lsCargoColaborador.isEmpty() && lsPessoaColaborador.isEmpty()) {//Não pode ter uma lista vazia de colaboradores
            return false;
        }
        if (!bautoava && lsCargoAvaliador.isEmpty() && lsPessoaAvaliador.isEmpty()) {//Se não é autoavaliação não podem faltar os avaliadores
            return false;
        }
        return true;
    }

    private void SalvarPesAval(List<Pessoa> lsAva, List<Pessoa> lsCol) {//Salva e relação entre avaliador e colaborador avaliado ,basta passar as duas listas de pessoas
        if (!lsAva.isEmpty() && !lsCol.isEmpty()) {
            for (Pessoa a : lsAva) {
                for (Pessoa c : lsCol) {
                    PessoasAvaliacao pessoaAvaliacao = new PessoasAvaliacao();
                    pessoaAvaliacao.setAvaliacao(avaliacao);
                    pessoaAvaliacao.setAvaliador(c);
                    pessoaAvaliacao.setColaboradorAvaliado(c);
                    pessoaAvaliacao.setPea_media(0);
                    pessoaAvaliacaoDAO.insert(pessoaAvaliacao);
                }
            }
        }
    }

    private void SalvarAvaPesCargo(List<Cargo> lsCargos, List<Pessoa> lsPessoa, int status) {//Salva a lista de cargos e pessoas que fazem parte da avlaiação, basta passar a lista de Cargos e Pessoas e o Tipo (Colaborador= 1 ou Avaliador = 2)
        if (!lsPessoa.isEmpty()) {
            for (Pessoa p : lsPessoa) {
                AvaliacaoPessoaCargo AvaPesCarg = new AvaliacaoPessoaCargo();
                AvaPesCarg.setApc_status(status);
                AvaPesCarg.setAvaliacao(avaliacao);
                AvaPesCarg.setCargo(null);
                AvaPesCarg.setPessoa(p);
                avaliacaoPessoaCargoDAO.insert(AvaPesCarg);
            }
        }
        if (!lsCargos.isEmpty()) {
            for (Cargo c : lsCargos) {
                AvaliacaoPessoaCargo AvaPesCarg = new AvaliacaoPessoaCargo();
                AvaPesCarg.setApc_status(status);
                AvaPesCarg.setAvaliacao(avaliacao);
                AvaPesCarg.setCargo(c);
                AvaPesCarg.setPessoa(null);
                avaliacaoPessoaCargoDAO.insert(AvaPesCarg);
            }
        }
    }

    private List<Cargo> filtraCargos(List<Cargo> lsCargos) {//Filtra Lista de cargos, para não repetir um cargo ao salvar
        List<Integer> lsCod = new ArrayList<>();
        List<Cargo> lsItens = new ArrayList<>();
        if (!lsCargos.isEmpty()) {
            for (Cargo c : lsCargos) {
                if (!lsCod.contains(c.getCar_codigo())) {
                    lsCod.add(c.getCar_codigo());
                    lsItens.add(c);
                }
            }
        }
        return lsItens;
    }

    private List<Pessoa> filtraPessoas(List<Pessoa> lsPessoas) {//Filtra Lista de pessoas, para não repetir uma pessoa ao salvar
        List<Integer> lsCod = new ArrayList<>();
        List<Pessoa> lsItens = new ArrayList<>();
        if (!lsPessoas.isEmpty()) {
            for (Pessoa p : lsPessoas) {
                if (!lsCod.contains(p.getPes_codigo())) {
                    lsCod.add(p.getPes_codigo());
                    lsItens.add(p);
                }
            }
        }
        return lsItens;
    }

    private List<Pessoa> JuntarCargosComPessoas(List<Cargo> lsCargos, List<Pessoa> lsPessoas) {//Junta as pessoas dos cargos as listas de pessoas
        if (!lsCargos.isEmpty()) {
            for (Cargo c : lsCargos) {
                List<CargosPessoa> lscargosPessoa = cargosPessoaDAO.GetListCargoPessoa(0, c.getCar_codigo());
                for (CargosPessoa cp : lscargosPessoa) {
                    lsPessoas.add(cp.getPessoa());
                }
            }
        }
        return filtraPessoas(lsPessoas);
    }

//    
//        if (1 == 0) {
//                dao.insert(avaliacao);
//        for (int i = 0; i < lsCargoAvaliador.size(); i++) { ///realiza for para "pegar" todas as pessoas dos cargos relacionados
//            AvaliacaoPessoaCargo VPC = new AvaliacaoPessoaCargo();/// Objeto AvaliacaoPessoaCargo, utilizado para verificar quais são os avaliados e avaliadores da Avaliação
//            List<CargosPessoa> lscargosPessoa = cargosPessoaDAO.GetListCargoPessoa(0, lsCargoAvaliador.get(i).getCar_codigo());///Pega as pessoas daquele cargo
//            for (int x = 0; x < lscargosPessoa.size(); x++) {
//                lsPessoaAvaliador.add(lscargosPessoa.get(x).getPessoa());
//            }
//            VPC.setCargo(lsCargoAvaliador.get(i));
//            VPC.setAvaliacao(avaliacao);
//            VPC.setApc_status(2);//2 = status do Avaliadores
//            lsAvaliacaoPessoaCargo.add(VPC);
//        }
//
//        for (int j = 0; j < lsCargoColaborador.size(); j++) {
//            AvaliacaoPessoaCargo VPCAavaliados = new AvaliacaoPessoaCargo();
//            List<CargosPessoa> lscargosPessoa = cargosPessoaDAO.GetListCargoPessoa(0, lsCargoColaborador.get(j).getCar_codigo());///Pega as pessoas daquele cargo
//            for (int z = 0; z < lscargosPessoa.size(); z++) {
//                lsPessoaColaborador.add(lscargosPessoa.get(z).getPessoa());
//            }
//            VPCAavaliados.setCargo(lsCargoColaborador.get(j));
//            VPCAavaliados.setAvaliacao(avaliacao);
//            VPCAavaliados.setApc_status(1);//1 = status do Colaboradores, ou seja, os avaliados
//            lsAvaliacaoPessoaCargo.add(VPCAavaliados);
//        }
//        //Até aki esta criado todas as AvaliaçõesPessoaCargo, e Agora deve-se cadastrar as PessoasAvaliações, Blz
//
//        for (int y = 0; y < lsPessoaAvaliador.size(); y++) {
//            Pessoa Avaliador = lsPessoaAvaliador.get(y);
//            for (int b = 0; b < lsPessoaColaborador.size(); b++) {
//                Pessoa Colaborador = lsAvaliacaoPessoaCargo.get(b).getPessoa();
//                PessoasAvaliacao pessoaAvaliacao = new PessoasAvaliacao();
//                pessoaAvaliacao.setAvaliacao(avaliacao);
//                pessoaAvaliacao.setAvaliador(Avaliador);
//                pessoaAvaliacao.setColaboradorAvaliado(Colaborador);
//                pessoaAvaliacao.setPea_media(0);
//                lsPessoasAvaliacao.add(pessoaAvaliacao);
//            }
//        }
/////Hora de Inserir :0
//        dao.insert(avaliacao);//inseri a Avaliação
//        for (int b = 0; b < lsAvaliacaoPessoaCargo.size(); b++) {
//            avaliacaoPessoaCargoDAO.insert(lsAvaliacaoPessoaCargo.get(b)); //inseri a AvaliacaoPessoaCargo
//        }
//        for (int c = 0; c < lsPessoasAvaliacao.size(); c++) {
//            pessoaAvaliacaoDAO.insert(lsPessoasAvaliacao.get(c));
//        }
//    }
//              for (int i = 0; i < lsCargoAvaliador.size(); i++) { ///realiza for para "pegar" todas as pessoas dos cargos relacionados
//                    AvaliacaoPessoaCargo VPC = new AvaliacaoPessoaCargo();/// Objeto AvaliacaoPessoaCargo, utilizado para verificar quais são os avaliados e avaliadores da Avaliação
//                    List<CargosPessoa> lscargosPessoa = cargosPessoaDAO.GetListCargoPessoa(0, lsCargoAvaliador.get(i).getCar_codigo());///Pega as pessoas daquele cargo
//                    for (int x = 0; x < lscargosPessoa.size(); x++) {
//                        lsPessoaAvaliador.add(lscargosPessoa.get(x).getPessoa());
//                    }
//                    VPC.setCargo(lsCargoAvaliador.get(i));
//                    VPC.setAvaliacao(avaliacao);
//                    VPC.setApc_status(2);//2 = status do Avaliadores
//                    lsAvaliacaoPessoaCargo.add(VPC);
}
