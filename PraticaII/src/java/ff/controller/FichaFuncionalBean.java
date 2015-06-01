package ff.controller;

import cfg.model.Pessoa;
import csb.dao.BeneficiosPessoaDAO;
import csb.model.BeneficiosPessoa;
import ff.dao.FichaFuncionalDAO;
import ff.model.FichaFuncional;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class FichaFuncionalBean {


    
    private FichaFuncional fichaFuncional = new FichaFuncional();
    private List<BeneficiosPessoa> beneficios;

    public List<BeneficiosPessoa> getBeneficios() {
        return beneficios;
    }
    
    private List<Pessoa> pessoas;
    private final FichaFuncionalDAO fichaFuncionalDAO = new FichaFuncionalDAO();
    private final BeneficiosPessoaDAO beneficiosPessoaDAO = new BeneficiosPessoaDAO();
    private DataModel<FichaFuncional> fichas;
 

    public FichaFuncionalBean() {
    }

    public String visualizar() {
        return "fichafunfrm";
    }

    public String manutecao() {
        return "fichafunfrm";
    }

    public String insert() {
        fichaFuncionalDAO.insert(fichaFuncional);
        return "fichafunlst";
    }

    public String select() {
        fichaFuncional = fichas.getRowData();
        fichaFuncional = fichaFuncionalDAO.findById(fichaFuncional.getFfu_codigo());
        if (fichaFuncional != null && fichaFuncional.getPessoa() != null) {
            beneficios = beneficiosPessoaDAO.findByPessoaId(fichaFuncional.getPessoa().getPes_codigo());
        } else {
            beneficios = new ArrayList<>();
        }
        return "fichafunfrm";
    }

    public String editar() {
        fichaFuncionalDAO.update(fichaFuncional);
        return "fichafunlst";
    }

    public String salvar() {
        if (fichaFuncional.getFfu_codigo() > 0) {
            fichaFuncionalDAO.update(fichaFuncional);
        } else {
            fichaFuncionalDAO.insert(fichaFuncional);
        }
        return "fichafunlst";
    }
     
    public DataModel<FichaFuncional> getFichas() {
        fichas = new ListDataModel<>(fichaFuncionalDAO.finAll());
        return fichas;
    }

    public void setFichas(DataModel<FichaFuncional> fichas) {
        this.fichas = fichas;
    }

    public FichaFuncional getFichaFuncional() {
        return fichaFuncional;
    }

    public void setFichaFuncional(FichaFuncional fichaFuncional) {
        this.fichaFuncional = fichaFuncional;
    }

    public FichaFuncionalDAO getFichaFuncionalDAO() {
        return fichaFuncionalDAO;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
