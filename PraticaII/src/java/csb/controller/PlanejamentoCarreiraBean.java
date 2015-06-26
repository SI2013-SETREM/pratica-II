package csb.controller;

import cfg.dao.LogDAO;
import csb.dao.CargoDAO;
import csb.dao.PlanejamentoCargosDAO;
import csb.dao.PlanejamentoCarreiraDAO;
import csb.model.Cargo;
import csb.model.PlanejamentoCargos;
import csb.model.PlanejamentoCarreira;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Juliano Pires
 */
@ManagedBean
@RequestScoped
public class PlanejamentoCarreiraBean {

    private final String sTitle = PlanejamentoCarreira.sTitle;
    private final String pTitle = PlanejamentoCarreira.pTitle;

    private PlanejamentoCarreira planejamento = new PlanejamentoCarreira();
    private PlanejamentoCarreiraDAO dao = new PlanejamentoCarreiraDAO();
    private DataModel planejamentos;

    private PlanejamentoCargos planocargo = new PlanejamentoCargos();
    private PlanejamentoCargosDAO daoPC = new PlanejamentoCargosDAO();
    private DataModel planocargos;

    private List<Cargo> lstCargo;
    private Cargo cargo = new Cargo();
    private CargoDAO cargoDAO = new CargoDAO();

    public PlanejamentoCarreiraBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public DataModel getPlanocargos(PlanejamentoCarreira p) {
        if (p != null) {
            List<PlanejamentoCargos> lstPC = daoPC.findByPlanejamento(p.getPla_codigo());
            this.planocargos = new ListDataModel(lstPC);
            return planocargos;
        } else {
            List<PlanejamentoCargos> lstPC = daoPC.findAll();
            this.planocargos = new ListDataModel(lstPC);
            return planocargos;
        }
    }

    public void setPlanocargos(DataModel planocargos) {
        this.planocargos = planocargos;
    }

    public List<Cargo> getLstCargo() {
        lstCargo = cargoDAO.findAllChildrens();
        return lstCargo;
    }

    public void setLstCargo(List<Cargo> lstCargo) {
        this.lstCargo = lstCargo;
    }

    public PlanejamentoCargos getPlanocargo() {
        return planocargo;
    }

    public void setPlanocargo(PlanejamentoCargos planocargo) {
        this.planocargo = planocargo;
    }

    public PlanejamentoCarreira getPlanejamento() {
        return planejamento;
    }

    public void setPlanejamento(PlanejamentoCarreira planejamento) {
        this.planejamento = planejamento;
    }

    public DataModel getPlanejamentos() {
        List<PlanejamentoCarreira> lst = dao.findAll();
        this.planejamentos = new ListDataModel(lst);
        return planejamentos;
    }

    public void setPlanejamentos(DataModel planejamentos) {
        this.planejamentos = planejamentos;
    }

    public String insert() {
        dao.insert(planejamento);
        return "planejamentocarreiralst";
    }

    public String edit(PlanejamentoCarreira i) {
        planejamento = (PlanejamentoCarreira) planejamentos.getRowData();
        return "planejamentocarreirafrm";
    }

    public String manager(PlanejamentoCarreira p) {
        this.planocargo.setPlanejamento(p);
        return "planejamentocarreiramanager";
    }

    public String update() {
        dao.update(planejamento);
        return "planejamentocarreiralst";
    }

    public String delete(PlanejamentoCarreira i) {
        dao.delete(i);
        LogDAO.insert("PlanejamentoCarreira", "Deletou PlanejamentoCarreira código: " + i.getPla_codigo() + ", descrição: " + i.getPla_descricao());
        return "planejamentocarreiralst";
    }

    public String deletePC(PlanejamentoCargos p) {
        daoPC.delete(p);
        return manager(p.getPlanejamento());
    }

    public String salvar() {
        if (planejamento.getPla_codigo() > 0) {
            dao.update(planejamento);
            LogDAO.insert("PlanejamentoCarreira", "Alterou PlanejamentoCarreira código: " + planejamento.getPla_codigo() + ", descrição: " + planejamento.getPla_descricao());
        } else {
            dao.insert(planejamento);
            LogDAO.insert("MotivoAlteracaoSalarial", "Cadastrou PlanejamentoCarreira código: " + planejamento.getPla_codigo() + ", descrição: " + planejamento.getPla_descricao());
        }
        return "planejamentocarreiralst";
    }

    public String saveUniquePlanoCargo() {
        if (planocargo.getPln_codigo() > 0) {
            daoPC.update(planocargo);
        } else {
            List<PlanejamentoCargos> lsConfirm = daoPC.findByPlanejamentoCargo(planocargo.getPlanejamento().getPla_codigo(), planocargo.getCargo().getCar_codigo());
            if (lsConfirm == null || lsConfirm.isEmpty()) {
                daoPC.insert(planocargo);
            } else {
                throw new Error("Desculpe, este registro nao pode ser inserido pois este cargo já pertence ao planejamento!");
            }
        }
        return manager(planocargo.getPlanejamento());
    }

    public String listar() {
        return "planejamentocarreiralst";
    }
}
