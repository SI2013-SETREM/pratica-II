package fp.controller;

import cfg.dao.PessoaDAO;
import fp.dao.EventoDAO;
import fp.dao.EventoPadraoDAO;
import fp.model.EventoPadrao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class EventoPadraoBean {

    public final String sTitle = EventoPadrao.sTitle;
    public final String pTitle = EventoPadrao.pTitle;

    private EventoPadrao eventopadrao = new EventoPadrao();
    private EventoPadraoDAO dao = new EventoPadraoDAO();
    private PessoaDAO daoPessoa = new PessoaDAO();
    private EventoDAO daoEvento = new EventoDAO();
    private DataModel eventospadroes;
    //private int parametro;

    public EventoPadraoBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public EventoPadrao getEventoPadrao() {

        return eventopadrao;
    }

    public void setFormula(EventoPadrao eventopadrao) {
        this.eventopadrao = eventopadrao;
    }

    public EventoPadraoDAO getDao() {
        return dao;
    }

    public void setDao(EventoPadraoDAO dao) {
        this.dao = dao;
    }

    public DataModel<EventoPadrao> getEventosPadroes() {
        this.eventospadroes = new ListDataModel(dao.findAll());
        return eventospadroes;
    }

    public void setEventosPadroes(DataModel eventospadroes) {
        this.eventospadroes = eventospadroes;
    }

    public String insert() {
        dao.insert(eventopadrao);
        return "eventopadlst";
    }

    public String insert2(Integer eve_codigo, Integer _pes_codigo) {
        EventoPadrao f = new EventoPadrao();
        f.setPessoa(daoPessoa.findById(_pes_codigo));
        f.setEve_codigo(daoEvento.findById(eve_codigo));
       
        dao.insert(f);
        return "eventopadlst";
    }

    public String edit(EventoPadrao ep) {
        eventopadrao = (EventoPadrao) eventospadroes.getRowData();
        return "eventopadfrm";
    }

    public String update() {
        dao.update(eventopadrao);
        return "eventopadlst";
    }

    public String delete(EventoPadrao f) {
        dao.delete(f);
    //    LogDAO.insert("Formula", "Deletou fórmula código: " + f.getFor_codigo() + ", taxa: " + f.getFor_taxa()
        //            + ", horas: " + f.getFor_horas() + ", horas mais: " + f.getFor_horasmais() + ", nome: " + f.getFor_nome());
        return "eventopadlst";
    }

    public String salvar() {
        if (eventopadrao.getEvp_codigo() > 0) {
            dao.update(eventopadrao);
      //      LogDAO.insert("Formula", "Alterou fórmula código: " + formula.getFor_codigo() + ", taxa: " + formula.getFor_taxa()
            //              + ", horas: " + formula.getFor_horas() + ", horas mais: " + formula.getFor_horasmais() + ", nome: " + formula.getFor_nome());
        } else {
            dao.insert(eventopadrao);
       //     LogDAO.insert("Formula", "Cadastrou fórmula código: " + formula.getFor_codigo() + ", taxa: " + formula.getFor_taxa()
            //             + ", horas: " + formula.getFor_horas() + ", horas mais: " + formula.getFor_horasmais() + ", nome: " + formula.getFor_nome());
        }

        return "eventopadlst";
    }

    public String listar() {
        return "eventopadlst";
    }

//    public int getParametro() {
//        return parametro;
//    }
//
//    public void setParametro(int parametro) {
//        this.parametro = parametro;
//    }

//    public void inicia() {
//        this.eventospadroes = new ListDataModel <> (dao.EventoPessoa(getParametro()));
//        eventopadrao = (EventoPadrao) eventospadroes.getRowData();
//        eventopadrao = (EventoPadrao) dao.EventoPessoa(eventopadrao.getPessoa().getPes_codigo());
//    }
}
