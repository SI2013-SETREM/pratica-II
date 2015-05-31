package td.controller;

import java.util.List;
import td.dao.TreinamentoDAO;
import td.model.Treinamento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import td.dao.CursoDAO;
import td.dao.LocalDAO;
import td.model.Curso;
import td.model.Local;

@ManagedBean
@RequestScoped
public class TreinamentoBean {

    private final String sTitle = Treinamento.sTitle;
    private final String pTitle = Treinamento.pTitle;

    private List<Local> lstlocal;
    private Local local = new Local();
    private LocalDAO localdao = new LocalDAO();
    
    private List<Curso> lstcurso;
    private Curso curso = new Curso();
    private CursoDAO cursodao = new CursoDAO();
    
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
        if (treinamento.getTre_codigo()> 0)
            dao.update(treinamento);
        else 
            dao.insert(treinamento);
        
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
}
