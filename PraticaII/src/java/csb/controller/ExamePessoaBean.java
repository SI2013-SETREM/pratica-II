
package csb.controller;
import csb.controller.*;

import csb.dao.ExamePessoaDAO;
import csb.model.ExamePessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class ExamePessoaBean {
    
    private final String sTitle = ExamePessoa.sTitle;
    private final String pTitle = ExamePessoa.pTitle;
    
    private ExamePessoa exa = new ExamePessoa();
    private ExamePessoaDAO dao = new ExamePessoaDAO();
    private DataModel exames;
    
    public ExamePessoaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public ExamePessoa getExamePessoa() {
        return exa;
    }

    public void setExamePessoa(ExamePessoa exa) {
        this.exa = exa;
    }

    public DataModel getExames() {
        this.exames = new ListDataModel(dao.findAll());
        return exames;
    }

    public void setExames(DataModel exames) {
        this.exames = exames;
    }
    
    public String insert() {
        dao.insert(exa);
        return "examepessoafrm";
    }
    
    public String edit(ExamePessoa e) {
        exa = (ExamePessoa) exames.getRowData();
        return "examepessoafrm";
    }
    
    public String update() {
        dao.update(exa);
        return "examepessoalst";
    }
    
    public String delete(ExamePessoa e) {
        dao.delete(e);
        return "examepessoalst";
    }
    
    public String salvar() {
        if (exa.getTipoExame().getEme_codigo()> 0)
            dao.update(exa);
        else 
            dao.insert(exa);
        
        return "examepessoalst";
    }
    
    public String listar() {
        return "examepessoalst";
    }
    
    
}
