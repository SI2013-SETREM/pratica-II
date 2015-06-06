
package fp.controller;

import fp.dao.EventoDAO;
import fp.dao.FormulaDAO;
import fp.dao.SerieEventoDAO;
import fp.dao.TabINSSDAO;
import fp.dao.TabelaIRRFDAO;
import fp.dao.TipoEventoDAO;
import fp.model.Evento;
import fp.model.Formula;
import fp.model.SerieEvento;
import fp.model.TabelaINSS;
import fp.model.TabelaIRRF;
import fp.model.TipoEvento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class EventoBean {
    
    private final String sTitle = Evento.sTitle;
    private final String pTitle = Evento.pTitle;
    
    private List<SerieEvento> lstserieevento;
    private SerieEvento serieevento = new SerieEvento();
    private SerieEventoDAO serieeventodao = new SerieEventoDAO();
    
    private List<TipoEvento> lsttipoevento;
    private TipoEvento tipoevento = new TipoEvento();
    private TipoEventoDAO tipoeventodao = new TipoEventoDAO();
    
    private List<TabelaINSS> lsttabinss;
    private TabelaINSS tabinss = new TabelaINSS();
    private TabINSSDAO tabinssdao = new TabINSSDAO();
    
    
    private List<TabelaIRRF> lsttabirrf;
    private TabelaIRRF tabelairrf = new TabelaIRRF();
    private TabelaIRRFDAO tabelairrfdao = new TabelaIRRFDAO();
    
    private List<Formula> lstformula;
    private Formula formula = new Formula();
    private FormulaDAO formuladao = new FormulaDAO();
    
    private Evento evento = new Evento();
    private EventoDAO dao = new EventoDAO();
    private DataModel eventos;
    
    public EventoBean(){
    
}
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public DataModel getEventos() {
        this.eventos = new ListDataModel(dao.findAll());
        return eventos;
    }

    public void setEventos(DataModel eventos) {
        this.eventos = eventos;
    }
    
    public String insert() {
        dao.insert(evento);
        return "eventoslst";
    }
    
    public String edit(Evento i) {
        evento = (Evento) eventos.getRowData();
        return "eventosfrm";
    }
    
    public String update() {
        dao.update(evento);
        return "eventolst";
    }
    
    public String delete(Evento i) {
        dao.delete(i);
        return "eventolst";
    }
    
    public String salvar() {
        if (evento.getEve_codigo()> 0)
            dao.update(evento);
        else 
            dao.insert(evento);
        
        return "eventolst";
    }
    
    public String listar() {
        return "eventolst";
    }
    
    public List<SerieEvento> getLstSerieEvento() {
        lstserieevento = serieeventodao.findAll();
        return lstserieevento;
    }

    public void setLstSerieEvento(List<SerieEvento> i) {
        this.lstserieevento = i;
    }
    
     public List<TipoEvento> getLstTipoEvento() {
        lsttipoevento = tipoeventodao.findAll();
        return lsttipoevento;
    }

    public void setLstTipoEvento(List<TipoEvento> i) {
        this.lsttipoevento = i;
    }
    
      public List<TabelaINSS> getLstTabinss() {
        lsttabinss = tabinssdao.findAll();
        return lsttabinss;
    }
       public List<TabelaIRRF> getLstTabirrf() {
        lsttabirrf = tabelairrfdao.findAll();
        return lsttabirrf;
    }
        public List<Formula> getLstFormula() {
        lstformula = formuladao.findAll();
        return lstformula;
    }
}
