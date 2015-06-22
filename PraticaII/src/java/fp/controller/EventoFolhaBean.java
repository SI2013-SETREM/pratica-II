package fp.controller;
import fp.dao.EventoFolhaDAO;
import fp.dao.HistoricoFolhaDAO;
import fp.model.EventoFolha;
import fp.model.HistoricoFolha;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;



@ManagedBean
public class EventoFolhaBean {

    private HistoricoFolha historicoFolha = new HistoricoFolha();
    private HistoricoFolhaDAO historicoFolhaDAO = new HistoricoFolhaDAO();
   
    private EventoFolha eventoFolha = new EventoFolha();
    private EventoFolhaDAO eventoFolhaDAO = new EventoFolhaDAO();
    private DataModel<EventoFolha> EveFolhas;

    public EventoFolhaBean() {
    }

    public HistoricoFolha getHistoricoFolha() {
        return historicoFolha;
    }

    public void setHistoricoFolha(HistoricoFolha historicoFolha) {
        this.historicoFolha = historicoFolha;
    }

    public HistoricoFolhaDAO getHistoricoFolhaDAO() {
        return historicoFolhaDAO;
    }

    public void setHistoricoFolhaDAO(HistoricoFolhaDAO historicoFolhaDAO) {
        this.historicoFolhaDAO = historicoFolhaDAO;
    }

    public EventoFolha getEventoFolha() {
        return eventoFolha;
    }

    public void setEventoFolha(EventoFolha eventoFolha) {
        this.eventoFolha = eventoFolha;
    }

    public EventoFolhaDAO getEventoFolhaDAO() {
        return eventoFolhaDAO;
    }

    public void setEventoFolhaDAO(EventoFolhaDAO eventoFolhaDAO) {
        this.eventoFolhaDAO = eventoFolhaDAO;
    }

    public DataModel<EventoFolha> getEveFolhas() {
         this.EveFolhas = new ListDataModel<>(eventoFolhaDAO.EventoFolhas(historicoFolha.getHif_codigo()));
        return EveFolhas;
    }

    public void setEveFolhas(DataModel<EventoFolha> EveFolhas) {
        this.EveFolhas = EveFolhas;
    }

   
}
