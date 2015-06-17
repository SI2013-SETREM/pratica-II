package csb.controller;

import cfg.dao.LogDAO;
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
        LogDAO.insert("Exame", "Deletou exame código: " + e.getExa_codigo() + ", código exame: " + e.getPessoa().getPes_codigo()
                + ", data: " + e.getEps_dataexame() + ", data validade: " + e.getEps_datavalidade() + ", situação: " + e.isEps_situacao()
                + ", observação: " + e.getEps_observacao() + ", código exame: " + e.getExa_codigo());
        return "examepessoalst";
    }

    public String salvar() {
        if (exa.getTipoExame().getEme_codigo() > 0) {
            dao.update(exa);
            LogDAO.insert("Exame", "Alterou exame código: " + exa.getExa_codigo() + ", código exame: " + exa.getPessoa().getPes_codigo()+
                ", data: "+exa.getEps_dataexame()+", data validade: "+exa.getEps_datavalidade()+", situação: "+exa.isEps_situacao()+
                ", observação: "+exa.getEps_observacao()+", código exame: "+exa.getExa_codigo());
        } else {
            dao.insert(exa);
            LogDAO.insert("Exame", "Cadastrou exame código: " + exa.getExa_codigo() + ", código exame: " + exa.getPessoa().getPes_codigo()+
                ", data: "+exa.getEps_dataexame()+", data validade: "+exa.getEps_datavalidade()+", situação: "+exa.isEps_situacao()+
                ", observação: "+exa.getEps_observacao()+", código exame: "+exa.getExa_codigo());
        }

        return "examepessoalst";
    }

    public String listar() {
        return "examepessoalst";
    }

}
