package td.controller;

import ad.dao.CompetenciaDAO;
import ad.model.Competencia;
import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import td.dao.TreinamentoDAO;
import td.model.Treinamento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import td.dao.CompetenciasTreinamentoDAO;
import td.dao.CursoDAO;
import td.model.CompetenciasTreinamento;
import td.dao.InstrutoresTreinamentoDAO;
import td.dao.LocalDAO;
import td.model.Curso;
import td.model.InstrutoresTreinamento;
import td.model.Local;

@ManagedBean
@RequestScoped
public class TreinamentoBean {

    private final String sTitle = Treinamento.sTitle;
    private final String pTitle = Treinamento.pTitle;
    private String Title = "Dados da " + sTitle;
    
    private List<Competencia> lstcompetencia;
    private List<Pessoa> lstpessoa;
    
    private List<Local> lstlocal;
    private Local local = new Local();
    private LocalDAO localdao = new LocalDAO();
    
    private List<Curso> lstcurso;
    private Curso curso = new Curso();
    private CursoDAO cursodao = new CursoDAO();
    
    private PessoaDAO pessoadao = new PessoaDAO();
    private CompetenciaDAO compdao = new CompetenciaDAO();
    private CompetenciasTreinamentoDAO compTreDao = new CompetenciasTreinamentoDAO();
    private InstrutoresTreinamentoDAO insTreDao = new InstrutoresTreinamentoDAO();
    
    private Treinamento treinamento = new Treinamento();
    private TreinamentoDAO dao = new TreinamentoDAO();
    private DataModel treinamentos;

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }

    public DataModel getTreinamentos() {
        this.treinamentos = new ListDataModel(dao.findAll());
        return treinamentos;
    }

    public void setTreinamentos(DataModel treinamentos) {
        this.treinamentos = treinamentos;
    }
    
    public List<Pessoa> completePessoa(String query) {
        return pessoadao.searchPessoaTre(query);
    }
    
    public List<Competencia> completeCompetencia(String query) {
        return compdao.searchCompetencia(query);
    }
    
    public String insert() {
        dao.insert(treinamento);
        return "treinamentolst";
    }
    
    public String edit(Treinamento i) {
        treinamento = (Treinamento) treinamentos.getRowData();
        return "treinamentofrm";
    }

    public String update() {
        dao.update(treinamento);
        return "treinamentolst";
    }
    
    public String delete(Treinamento i) {
        dao.delete(i);
        return "treinamentolst";
    }
    
    public String salvar() {
        if (treinamento.getTre_codigo()> 0){
           // dao.update(solicitacao);
            if (ValidaDados()) {
                dao.update(treinamento);
                if (SalvaListas()) {
                    return "treinamentolst";
                } else {
                    return "treinamentolst";
                }
            }
        } else {
            if (ValidaDados()) {
                dao.insert(treinamento);
                if (SalvaListas()) {
                    return "treinamentolst";
                } else {
                    return "treinamentolst";
                }
            } else {
                return "treinamentofrm";
            }
        }
        return "treinamentolst";
    }
    
    public String listar() {
        return "treinamentolst";
    }
    
    public List<Local> getLstlocal() {
        lstlocal = localdao.findAll();
        return lstlocal;
    }

    public void setLstlocal(List<Local> i) {
        this.lstlocal = i;
    }
    
    public List<Curso> getLstcurso() {
        lstcurso = cursodao.findAll();
        return lstcurso;
    }

    public void setLstcurso(List<Curso> lstcurso) {
        this.lstcurso = lstcurso;
    }
    
    public List<Competencia> getLstcompetencia() {
        int i = treinamento.getTre_codigo();
        if(i > 0){
            compdao.idSol = i;
            lstcompetencia = compdao.findCompTre();
        }
        return lstcompetencia;
    }

    public void setLstcompetencia(List<Competencia> lstcompetencia) {
        this.lstcompetencia = lstcompetencia;
    }

    public List<Pessoa> getLstpessoa() {
        int i = treinamento.getTre_codigo();
        if(i > 0){
            pessoadao.id = i;
            lstpessoa = pessoadao.findPesTre();
        }
        return lstpessoa;
    }

    public void setLstpessoa(List<Pessoa> lstpessoa) {
        this.lstpessoa = lstpessoa;
    }
    
    private boolean ValidaDados() {//Verifica as Listas se não estão vazias
        if (lstpessoa == null) {
            lstpessoa = new ArrayList<>();
        }
        if (lstcompetencia == null) {
            lstcompetencia = new ArrayList<>();
        }
        return true;
    }
    private boolean SalvaListas() {
        int i = treinamento.getTre_codigo();
        if (i == 0){
            try {
                SalvarPesCompNovo(filtraCompetencia(lstcompetencia),filtraPessoas(lstpessoa));
                return true;
            } catch (Exception e) {
                Title = e.toString();
            }
        }else{
            try {
                SalvarPesCompExistente(filtraCompetencia(lstcompetencia),filtraPessoas(lstpessoa));
                return true;
            } catch (Exception e) {
                Title = e.toString();
            }
        }
        return true;
    }
    
    private List<Competencia> filtraCompetencia(List<Competencia> lstCompetencia) {
        List<Integer> lsCod = new ArrayList<>();
        List<Competencia> lsItens = new ArrayList<>();
        if (!lstCompetencia.isEmpty()) {
            for (Competencia c : lstCompetencia) {
                if (c != null && !lsCod.contains(c.getCmp_codigo())) {
                    lsCod.add(c.getCmp_codigo());
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
   
    private void SalvarPesCompNovo(List<Competencia> lsCompetencia, List<Pessoa> lsPessoa) {//Salva a lista de cargos e pessoas que fazem parte da avlaiação, basta passar a lista de Cargos e Pessoas e o Tipo (Colaborador= 1 ou Avaliador = 2)
        if (!lsPessoa.isEmpty()) {
            for (Pessoa p : lsPessoa) {
                InstrutoresTreinamento pes = new InstrutoresTreinamento();
                pes.setPessoa(p);
                pes.setTreinamento(treinamento);
                insTreDao.insert(pes);
            }
        }
        if (!lsCompetencia.isEmpty()) {
            for (Competencia c : lsCompetencia) {
                CompetenciasTreinamento comp = new CompetenciasTreinamento();
                comp.setCompetencia(c);
                comp.setTreinamento(treinamento);
                compTreDao.insert(comp);
            }
        }
   }
      
    
     private void SalvarPesCompExistente(List<Competencia> lsCompetencia, List<Pessoa> lsPessoa) {//Salva a lista de cargos e pessoas que fazem parte da avlaiação, basta passar a lista de Cargos e Pessoas e o Tipo (Colaborador= 1 ou Avaliador = 2)
         int i = treinamento.getTre_codigo();
         compTreDao.idTre = i;
         insTreDao.idTre = i;
         compTreDao.deletaCompTre();
         insTreDao.deletaPesTre();
        if (!lsPessoa.isEmpty()) {
            for (Pessoa p : lsPessoa) {
                InstrutoresTreinamento pes = new InstrutoresTreinamento();
                pes.setPessoa(p);
                pes.setTreinamento(treinamento);
                insTreDao.insert(pes);
            }
        }
        if (!lsCompetencia.isEmpty()) {
            for (Competencia c : lsCompetencia) {
                CompetenciasTreinamento comp = new CompetenciasTreinamento();
                comp.setCompetencia(c);
                comp.setTreinamento(treinamento);
                compTreDao.insert(comp);
            }
        }
   }
}
