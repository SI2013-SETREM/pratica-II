package ad.controller;
//////172.20.143.90 --- ip interno da Setrem pra servidor, Blz

import ad.dao.AvaliacaoDAO;
import ad.dao.AvaliacaoPessoaCargoDAO;
import ad.dao.PessoasAvaliacaoDAO;
import ad.model.Avaliacao;
import cfg.dao.PessoaDAO;
import ad.model.AvaliacaoPessoaCargo;
import ad.model.PessoasAvaliacao;
import cfg.dao.LogDAO;
import cfg.model.Pessoa;
import csb.dao.CargoDAO;
import csb.dao.CargosPessoaDAO;
import csb.model.Cargo;
import csb.model.CargosPessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rs.dao.QuestionarioDAO;
import rs.model.Questionario;
import td.dao.AlunosTurmaDAO;
import td.dao.TurmaDAO;
import td.model.AlunosTurma;
import td.model.Turma;

@ManagedBean
public class AvaliacaoBean {

    private final String sTitle = Avaliacao.sTitle;
    private final String pTitle = Avaliacao.pTitle;
    private String Title = "Dados da " + sTitle;
    private String ErroMsg = "";
    private boolean bautoava = false;
    private boolean bcomp = false;
    private List<Cargo> lsCargoAvaliador;
    private List<Cargo> lsCargoColaborador;
    private List<Pessoa> lsPessoaAvaliador;
    private List<Pessoa> lsPessoaColaborador;
    private List<Questionario> lsQuestionario;
    private QuestionarioDAO questDAO = new QuestionarioDAO();
    private CargoDAO cargodao = new CargoDAO();
    private PessoaDAO pessoadao = new PessoaDAO();
    private List<AvaliacaoPessoaCargo> lsAvPesCargo;
    private int idTurma;
    private TurmaDAO turmaDAO = new TurmaDAO();
    private AlunosTurmaDAO alunoTurmaDAO = new AlunosTurmaDAO();
    private Avaliacao avaliacao;
    private AvaliacaoDAO dao = new AvaliacaoDAO();
    private AvaliacaoPessoaCargoDAO avaliacaoPessoaCargoDAO = new AvaliacaoPessoaCargoDAO();
    private PessoasAvaliacaoDAO pessoaAvaliacaoDAO = new PessoasAvaliacaoDAO();
    private CargosPessoaDAO cargosPessoaDAO = new CargosPessoaDAO();
    private DataModel avaliacoes;

    private TimeZone timeZone = TimeZone.getDefault();

    private List<AvaliacaoPessoaCargo> lsAvaliacaoPessoaCargo;
    private List<PessoasAvaliacao> lsPessoasAvaliacao;///Lista de PessoasAvaliação

    public AvaliacaoBean() {
    }

    public String avaliacaoTurma(int id) {
        avaliacao = getAvaliacao();
        idTurma = id;
        Turma turma = turmaDAO.findById(idTurma);
        avaliacao.setTurma(turma);
        List<AlunosTurma> LsAlunosTurma = alunoTurmaDAO.GetAlunosTurma(idTurma, 0); //SELECIONO TODOS OS ALUNOS DAQUELA TURMA
        for (AlunosTurma aluno : LsAlunosTurma) {
            lsPessoaColaborador.add(aluno.getPessoa()); //PASSO PRA LISTA :-/, BLZ?
        }
        Title = "Avaliação da Turma do Treinamento \"" + turma.getTreinamento().getTre_descricao() + "\"";
        return "/faces/view/ad/avaliacaofrm";
    }

    public List<Cargo> completeCargo(String query) {
        List<Cargo> lsC = cargodao.searchCargo(query);
        return lsC;
    }

    public List<Pessoa> completePessoa(String query) {
        return pessoadao.searchPessoa(query);
    }

    public Avaliacao getAvaliacao() {
        if (avaliacao == null) {
            avaliacao = new Avaliacao();
            avaliacao.setAva_dataInicial(new Date());
            avaliacao.setAva_dataFinal(new Date());
            avaliacao.setAva_status(0);
        }
        if (lsPessoaColaborador == null) {
            lsPessoaColaborador = new ArrayList();
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
        if (lsCargoAvaliador == null) {
            lsCargoAvaliador = new ArrayList();
        }
        if (lsCargoColaborador == null) {
            lsCargoColaborador = new ArrayList();
        }
        if (lsPessoaAvaliador == null) {
            lsPessoaAvaliador = new ArrayList();
        }
        if (lsPessoaColaborador == null) {
            lsPessoaColaborador = new ArrayList();
        }
        List<AvaliacaoPessoaCargo> lsPesCar = avaliacaoPessoaCargoDAO.SelectListAva(avaliacao.getAva_codigo(), null, 0);
        if (lsPesCar != null && !lsPesCar.isEmpty()) {
            for (AvaliacaoPessoaCargo APC : lsPesCar) {
                if (APC.getApc_status() == 1) {
                    if (APC.getPessoa() == null) {
                        lsCargoColaborador.add(APC.getCargo());
                    } else {
                        lsPessoaColaborador.add(APC.getPessoa());
                    }
                } else if (APC.getApc_status() == 2) {
                    if (APC.getPessoa() == null) {
                        lsCargoAvaliador.add(APC.getCargo());
                    } else {
                        lsPessoaAvaliador.add(APC.getPessoa());
                    }
                }
            }
        }
        if (avaliacao.getTurma() != null && avaliacao.getTurma().getTur_codigo() != 0) {
            Turma turma = avaliacao.getTurma();
            idTurma = turma.getTur_codigo();
            if (turma.getTreinamento() != null && turma.getTreinamento().getTre_codigo() != 0) {
                Title = "Avaliação da Turma do Treinamento \"" + turma.getTreinamento().getTre_descricao() + "\"";
            }
        }
        return "avaliacaofrm";
    }

    public String update() {
        dao.update(avaliacao);
        return "avaliacaolst";
    }

    public String delete(Avaliacao i) {
        //dao.delete(i);
        i.setAva_status(5);
        dao.update(i);
        LogDAO.insert("Avaliacao", "Deletou Avaliacao código: " + i.getAva_codigo() + ", nome: " + i.getAva_nome());
        return "avaliacaolst";
    }

    public String salvar() {
        if (avaliacao.getAva_dataFinal().after(avaliacao.getAva_dataInicial())) {
            if (avaliacao.getAva_codigo() > 0) {
                dao.update(avaliacao);
                LogDAO.insert("Avaliacao", "Alterou Avaliacao código: " + avaliacao.getAva_codigo() + ", nome: " + avaliacao.getAva_nome());
                return "avaliacaolst";
            } else {
                if (ValidaDados()) {
                    if (idTurma != 0) {
                        Turma turma = turmaDAO.findById(idTurma);
                        avaliacao.setTurma(turma);
                        LogDAO.insert("Avaliacao", "Cadastrou Avaliacao nome: " + avaliacao.getAva_nome());
                    }
                    dao.insert(avaliacao);
                    try {
                        if (SalvaListas()) {
                            return "avaliacaolst";
                        }
                    } catch (Exception e) {
                        avaliacao.setAva_status(5);
                        dao.update(avaliacao);
                        avaliacao.setAva_status(1);
                    }
                }
            }
        } else {
            ErroMsg = "A Data Final não pode ser Menor que a Data Inicial!";
        }
        return "avaliacaofrm";
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

    public String getTitle() {
        return Title;
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

    public boolean isBcomp() {
        return bcomp;
    }

    public void setBautoava(boolean bautoava) {
        this.bautoava = bautoava;
    }

    public void setBcomp(boolean bcomp) {
        this.bcomp = bcomp;
    }

//-----------------------MAPEAR
    public String getTaxa(Avaliacao i) {
        List<PessoasAvaliacao> lsPessoaAvaliacao = pessoaAvaliacaoDAO.GetListPessoasAvaliacao(i.getAva_codigo(), 0, 0, false, false);
        if (lsPessoaAvaliacao != null && !lsPessoaAvaliacao.isEmpty()) {
            int sizeAll = lsPessoaAvaliacao.size();
            int size = 0;
            int taxa = 0;
            for (PessoasAvaliacao pa : lsPessoaAvaliacao) {
                if (pa != null && pa.getPea_datahora_resposta() != null) {
                    size += 1;
                }
            }
            taxa = (int) ((size * 100) / sizeAll);
            return taxa + "%";
        }
        return "0%";
    }

    private boolean SalvaListas() {
        try {
            SalvarAvaPesCargo(filtraCargos(lsCargoColaborador), filtraPessoas(lsPessoaColaborador), 1);//filtraPessoas(
            SalvarAvaPesCargo(filtraCargos(lsCargoAvaliador), lsPessoaAvaliador, 2);
            SalvarPesAval(JuntarCargosComPessoas(lsCargoAvaliador, lsPessoaAvaliador), JuntarCargosComPessoas(lsCargoColaborador, lsPessoaColaborador));
            return true;
        } catch (Exception e) {
            Title = e.toString();
        }
        return false;
    }

    private boolean ValidaDados() {//Verifica as Listas se não estão vazias
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
        if (lsCargoColaborador.isEmpty() && lsPessoaColaborador.isEmpty()) {//Não pode ter uma lista vazia de colaboradores
            ErroMsg = "Os colaboradores são obrigatórios! Selecione um cargo ou uma pessoa ao menos!";
            return false;
        }
        if (!bautoava && lsCargoAvaliador.isEmpty() && lsPessoaAvaliador.isEmpty()) {//Se não é autoavaliação não podem faltar os avaliadores
            ErroMsg = "Os avaliadores são obrigatórios quando não tem auto avaliação! Selecione um cargo ou uma pessoa ao menos!";
            return false;
        }
        return true;
    }

    private void SalvarPesAval(List<Pessoa> lsAva, List<Pessoa> lsCol) {//Salva e relação entre avaliador e colaborador avaliado ,basta passar as duas listas de pessoas
        List<Integer> lsAval = new ArrayList<>();
        if (!lsAva.isEmpty() && !lsCol.isEmpty()) {
            for (Pessoa a : lsAva) {
                lsAval.add(a.getPes_codigo());
                for (Pessoa c : lsCol) {
                    PessoasAvaliacao pessoaAvaliacao = new PessoasAvaliacao();
                    pessoaAvaliacao.setAvaliacao(avaliacao);
                    pessoaAvaliacao.setAvaliador(a);
                    pessoaAvaliacao.setColaboradorAvaliado(c);
                    pessoaAvaliacaoDAO.insert(pessoaAvaliacao);
                    LogDAO.insert("PessoasAvaliacao", "Cadastrou Pessoas Avaliacao");
                }
            }
        }
        if (bautoava && !lsCol.isEmpty()) {
            for (Pessoa c : lsCol) {
                if (!lsAval.contains(c.getPes_codigo())) {
                    PessoasAvaliacao pessoaAvaliacao = new PessoasAvaliacao();
                    pessoaAvaliacao.setAvaliacao(avaliacao);
                    pessoaAvaliacao.setAvaliador(c);
                    pessoaAvaliacao.setColaboradorAvaliado(c);
                    pessoaAvaliacaoDAO.insert(pessoaAvaliacao);
                    LogDAO.insert("PessoasAvaliacao", "Cadastrou Pessoas Avaliacao");
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
                //AvaPesCarg.setCargo(new Cargo());
                AvaPesCarg.setPessoa(p);
                avaliacaoPessoaCargoDAO.insert(AvaPesCarg);
                LogDAO.insert("AvaliacaoPessoaCargo", "Cadastrou Avaliacao Pessoa Cargo");
            }
        }
        if (!lsCargos.isEmpty()) {
            for (Cargo c : lsCargos) {
                AvaliacaoPessoaCargo AvaPesCarg = new AvaliacaoPessoaCargo();
                AvaPesCarg.setApc_status(status);
                AvaPesCarg.setAvaliacao(avaliacao);
                AvaPesCarg.setCargo(c);
                //AvaPesCarg.setPessoa(new Pessoa());
                avaliacaoPessoaCargoDAO.insert(AvaPesCarg);
                LogDAO.insert("AvaliacaoPessoaCargo", "Cadastrou Avaliacao Pessoa Cargo");
            }
        }
    }

    private List<Cargo> filtraCargos(List<Cargo> lsCargos) {//Filtra Lista de cargos, para não repetir um cargo ao salvar
        List<Integer> lsCod = new ArrayList<>();
        List<Cargo> lsItens = new ArrayList<>();
        if (!lsCargos.isEmpty()) {
            for (Cargo c : lsCargos) {
                if (c != null && !lsCod.contains(c.getCar_codigo())) {
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
                if (p != null && !lsCod.contains(p.getPes_codigo())) {
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

    public List<Questionario> getLsQuestionario() {
        lsQuestionario = questDAO.findAll();
        return lsQuestionario;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getErroMsg() {
        return ErroMsg;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
