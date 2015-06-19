package fp.controller;

import cfg.dao.LogDAO;
import csb.dao.BeneficioDAO;
import csb.model.Beneficio;
import fp.dao.EventoDAO;
import fp.dao.EventoPadraoDAO;
import fp.dao.FormulaDAO;
import fp.dao.SerieEventoDAO;
import fp.dao.TabelaINSSDAO;
import fp.dao.TabelaIRRFDAO;
import fp.dao.TipoEventoDAO;
import fp.model.Evento;
import fp.model.EventoPadrao;
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
    private TabelaINSSDAO tabinssdao = new TabelaINSSDAO();
    
    private List<TabelaIRRF> lsttabirrf;
    private TabelaIRRF tabelairrf = new TabelaIRRF();
    private TabelaIRRFDAO tabelairrfdao = new TabelaIRRFDAO();
    
    private List<Formula> lstformula;
    private Formula formula = new Formula();
    private FormulaDAO formuladao = new FormulaDAO();
    
    private Evento evento = new Evento();
    private EventoDAO dao = new EventoDAO();
    private DataModel eventos;
    
     private List<Beneficio> lstbeneficio;
    private Beneficio beneficio = new Beneficio();
    private BeneficioDAO beneficiodao = new BeneficioDAO();
    
    private EventoPadrao eventoPadrao = new EventoPadrao();
    private EventoPadraoDAO eventoPadraoDAO = new EventoPadraoDAO();
    
    public EventoBean() {
        
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
    
    public DataModel<Evento> getEventos() {
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
  //      LogDAO.insert("Evento", "Deletou evento código: " + i.getEve_codigo() + ", descrição: " + i.getEve_descricao()+
  //      ", índice: "+i.getEve_indice()+", código benefício: "+i.getBeneficio().getBen_codigo()+", fórmula: "+i.getFormula()+
  //      ", série evento: "+i.getSerieevento()+", código tabela inss: "+i.getTabelainss().getTbs_codigo()+
  //      ", código tabela irrf: "+i.getTabelairrf().getTif_codigo());
        return "eventolst";
    }
    
    public String salvar() {
        if (evento.getEve_codigo() > 0) {
            dao.update(evento);
   //         LogDAO.insert("Evento", "Alterou evento código: " + evento.getEve_codigo() + ", descrição: " + evento.getEve_descricao()+
   //     ", índice: "+evento.getEve_indice()+", código benefício: "+evento.getBeneficio().getBen_codigo()+", fórmula: "+evento.getFormula()+
   //     ", série evento: "+evento.getSerieevento()+", código tabela inss: "+evento.getTabelainss().getTbs_codigo()+
    //    ", código tabela irrf: "+evento.getTabelairrf().getTif_codigo());
        } else {
            dao.insert(evento);
    //            LogDAO.insert("Evento", "Cadastrou evento código: " + evento.getEve_codigo() + ", descrição: " + evento.getEve_descricao()+
    //    ", índice: "+evento.getEve_indice()+", código benefício: "+evento.getBeneficio().getBen_codigo()+", fórmula: "+evento.getFormula()+
     //   ", série evento: "+evento.getSerieevento()+", código tabela inss: "+evento.getTabelainss().getTbs_codigo()+
     //   ", código tabela irrf: "+evento.getTabelairrf().getTif_codigo());
        }
        
        return "eventolst";
    }

    public String salvarEventoPad(EventoPadrao e) {
        
        eventoPadraoDAO.insert(e);      
        return "folhapagfrm";
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
      public List<Beneficio> getLstBeneficio() {
        lstbeneficio = beneficiodao.findAll();
        return lstbeneficio;
    }
}
