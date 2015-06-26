package td.controller;

import cfg.dao.LogDAO;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import td.dao.AlunosTurmaDAO;
import td.dao.TreinamentoDAO;
import td.dao.TurmaDAO;
import td.model.AlunosTurma;
import td.model.Treinamento;
import td.model.Turma;

@ManagedBean
@RequestScoped
public class TurmaBean {

    private final String sTitle = Turma.sTitle;

    private final String pTitle = Turma.pTitle;
    
    private Turma turma = new Turma();
    private TurmaDAO dao = new TurmaDAO();
    private DataModel turmas;
  
    private List<Treinamento> lsttreinamento;
    private Treinamento treinamento = new Treinamento();
    private TreinamentoDAO treinamentodao = new TreinamentoDAO();
    
    private PessoaDAO pessoadao = new PessoaDAO();
    private List<Pessoa> lstpessoa;
    private AlunosTurmaDAO atdao = new AlunosTurmaDAO();
    private AlunosTurmaBean atbean = new AlunosTurmaBean();
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
     public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public DataModel getTurmas() {
        this.turmas = new ListDataModel(dao.findAll());
        return turmas;
    }

    public void setTurmas(DataModel turmas) {
        this.turmas = turmas;
    }

    public List<Treinamento> getLsttreinamento() {
        lsttreinamento = treinamentodao.findAll();
        return lsttreinamento;
    }

    public void setLsttreinamento(List<Treinamento> lsttreinamento) {
        this.lsttreinamento = lsttreinamento;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }
    
    public String insert() {
        dao.insert(turma);
        return "turmalst";
    }
    
    public String edit(Turma i) {
        turma = (Turma) turmas.getRowData();
        return "turmafrm";
    }

    public String update() {
        dao.update(turma);
        return "turmalst";
    }
    
    public String delete(Turma i) {
        dao.delete(i);
        LogDAO.insert("Turma", "Deletou turma código: " + i.getTur_codigo()+
                    ", data fim: " + i.getTur_data_fim()+", data início:"+i.getTur_data_inicio()+
                    ", status turma: "+i.getTur_status_turma()+", carga horária: "+i.getTur_cargahoraria_secao()+", limite de alunos: "+i.getTur_limite_alunos());
        return "turmalst";
    }
    
    public String salvar() {
        if (turma.getTur_codigo()> 0){
            if (ValidaDados()) {
                dao.update(turma);
                LogDAO.insert("Turma", "Alterou turma código: " + turma.getTur_codigo()+
                    ", data fim: " + turma.getTur_data_fim()+", data início:"+turma.getTur_data_inicio()+
                    ", status turma: "+turma.getTur_status_turma()+", carga horária: "+turma.getTur_cargahoraria_secao()+", limite de alunos: "+turma.getTur_limite_alunos());
                if (SalvaListas()) {
                    return "turmalst";
                } else {
                    return "turmalst";
                }
            }
        } else {
            if (ValidaDados()) {
                dao.insert(turma);
                LogDAO.insert("Turma", "Cadastrou turma código: " + turma.getTur_codigo()+
                    ", data fim: " + turma.getTur_data_fim()+", data início:"+turma.getTur_data_inicio()+
                    ", status turma: "+turma.getTur_status_turma()+", carga horária: "+turma.getTur_cargahoraria_secao()+", limite de alunos: "+turma.getTur_limite_alunos());
                if (SalvaListas()) {
                    return "turmalst";
                } else {
                    return "turmalst";
                }
            } else {
                return "turmafrm";
            }
        }
        return "turmalst";
    }

    public String listar() {
        return "turmalst";
    }
    
    public List<Pessoa> getLstpessoa() {
        int i = turma.getTur_codigo();
        if(i > 0){
            pessoadao.id = i;
            lstpessoa = pessoadao.findPesTur();
        }
        return lstpessoa;
    }

    public void setLstpessoa(List<Pessoa> lstpessoa) {
        this.lstpessoa = lstpessoa;
    }
    
    public List<Pessoa> completePessoa(String query) {
        return pessoadao.searchPessoa(query);
    }
    
    private boolean ValidaDados() {//Verifica as Listas se não estão vazias
        if (lstpessoa == null) {
            lstpessoa = new ArrayList<>();
        }
        return true;
    }
    
    private boolean SalvaListas() {
        int i = turma.getTur_codigo();
        if (i == 0){
            try {
                SalvarAlunosTurmaNovo(filtraPessoas(lstpessoa));
                return true;
            } catch (Exception e) {
                //Title = e.toString();
            }
        }else{
            try {
                SalvarAlunosTurmaExistente(filtraPessoas(lstpessoa));
                return true;
            } catch (Exception e) {
               // Title = e.toString();
            }
        }
        return true;
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
    
    private void SalvarAlunosTurmaNovo(List<Pessoa> lsPessoa) {
        if (!lsPessoa.isEmpty()) {
            for (Pessoa p : lsPessoa) {
                AlunosTurma at = new AlunosTurma();
                at.setPessoa(p);
                at.setTurma(turma);
                atdao.insert(at);
            }
        }
   }
    
    private void SalvarAlunosTurmaExistente(List<Pessoa> lsPessoa) {
         int i = turma.getTur_codigo();
         atdao.idTur = i;
         atdao.deletaAlunosTurma();
        if (!lsPessoa.isEmpty()) {
            for (Pessoa p : lsPessoa) {
                AlunosTurma at = new AlunosTurma();
                at.setPessoa(p);
                at.setTurma(turma);
                atdao.insert(at);
            }
        }
    }
}
