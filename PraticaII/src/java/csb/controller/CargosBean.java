package csb.controller;

import cfg.dao.LogDAO;

import csb.dao.CargoDAO;
import csb.dao.GraduacaoDAO;
import csb.dao.SetorDAO;
import csb.model.Cargo;
import csb.model.Graduacao;
import csb.model.Setor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class CargosBean {

    private final String sTitle = Cargo.sTitle;
    private final String pTitle = Cargo.pTitle;

    private Cargo cargo = new Cargo();
    private CargoDAO dao = new CargoDAO();
    private DataModel cargos;


    /* PARA FAZER A COMBO DE CARGOS */
    private DataModel lsCargosParents;
    private List<Cargo> lsCargo;
    
    /* PARA FAZER A COMBO DE CARGOS */
    private DataModel lsCargosNext;
    private List<Cargo> lsCargoNext;

    /* PARA FAZER A COMBO DE SETORES */
    private List<Setor> lstsetor;
    private Setor setor = new Setor();
    private SetorDAO setordao = new SetorDAO();

    /* PARA FAZER O AUTOCOMPLETE DE GRADUAÇÕES */
    private List<Graduacao> lsGraduacao;
    private Graduacao graduacao = new Graduacao();
    private GraduacaoDAO graduacaodao = new GraduacaoDAO();

    public CargosBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public DataModel getCargos() {
        this.cargos = new ListDataModel(dao.findAll());
        return cargos;
    }

    public void setCargos(DataModel cargos) {
        this.cargos = cargos;
    }

    public DataModel getLsCargosParents() {
        this.lsCargosParents = new ListDataModel(dao.findAllParents());
        return this.lsCargosParents;
    }

    public void setLsCargosParents(DataModel lsCargosParents) {
        this.lsCargosParents = lsCargosParents;
    }

    public DataModel getLsCargosNext() {
        this.lsCargosNext = new ListDataModel(dao.findAll());
        return lsCargosNext;
    }

    public void setLsCargosNext(DataModel lsCargosNext) {
        this.lsCargosNext = lsCargosNext;
    }
    
    public String insert() {
        dao.insert(cargo);
        return "cargolst";
    }

    public String edit(Cargo c) {
        cargo = (Cargo) cargos.getRowData();
        return "cargofrm";
    }

    public String update() {
        dao.update(cargo);
        return "cargolst";
    }

    public String delete(Cargo c) {
        dao.delete(c);
        LogDAO.insert("Cargo", "Deletou cargo código: " + c.getCar_codigo() + ", descrição: " + c.getCar_descricao()
                + ", ativo: " + c.isCar_ativo() + ", cbo: " + c.getCar_cbo() + ", teto salarial: " + c.getCar_tetosalarial()
                + ", piso salarial: " + c.getCar_pisosalarial() + ", código cargo pai: 0"
                + ", ordem: " + c.getCar_ordem() + ", código setor: " + c.getSetor().getSet_codigo());
        return "cargolst";
    }

    public String salvar() {
        if (cargo.getCar_codigo() > 0) {
            dao.update(cargo);
            LogDAO.insert("Cargo", "Alterou cargo código: " + cargo.getCar_codigo() + ", descrição: " + cargo.getCar_descricao()
                    + ", ativo: " + cargo.isCar_ativo() + ", cbo: " + cargo.getCar_cbo() + ", teto salarial: " + cargo.getCar_tetosalarial()
                    + ", piso salarial: " + cargo.getCar_pisosalarial() + ", código cargo pai: 0"
                    + ", ordem: " + cargo.getCar_ordem() + ", código setor: " + cargo.getSetor().getSet_codigo());

        } else {
            dao.insert(cargo);
            LogDAO.insert("Cargo", "Cadastrou cargo código: " + cargo.getCar_codigo() + ", descrição: " + cargo.getCar_descricao()
                    + ", ativo: " + cargo.isCar_ativo() + ", cbo: " + cargo.getCar_cbo() + ", teto salarial: " + cargo.getCar_tetosalarial()
                    + ", piso salarial: " + cargo.getCar_pisosalarial() + ", código cargo pai: 0"
                    + ", ordem: " + cargo.getCar_ordem() + ", código setor: " + cargo.getSetor().getSet_codigo());
        }

        return "cargolst";
    }

    public String listar() {
        return "cargolst";
    }

    public List<Setor> getLstsetor() {
        lstsetor = setordao.findAll();
        return lstsetor;
    }

    public void setLstsetor(List<Setor> lstsetor) {
        this.lstsetor = lstsetor;
    }

    public List<Cargo> getLscargo() {
        lsCargo = dao.findAllParents();
        return lsCargo;
    }

    public void setLscargo(List<Cargo> lscargo) {
        this.lsCargo = lscargo;
    }

    public List<Cargo> getLsCargoNext() {
        lsCargoNext = dao.findAll();
        return lsCargoNext;
    }

    public void setLsCargoNext(List<Cargo> lsCargoNext) {
        this.lsCargoNext = lsCargoNext;
    }  

    public List<Graduacao> getLsGraduacao() {
        lsGraduacao = graduacaodao.findAll();
        return lsGraduacao;
    }

    public void setLsGraduacao(List<Graduacao> lsgraduacao) {
        this.lsGraduacao = lsgraduacao;
    }
}
