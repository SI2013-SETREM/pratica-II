
package fp.controller;

import fp.dao.SerieEventoDAO;
import fp.model.SerieEvento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class SerieEventoBean {
    
    private final String sTitle = SerieEvento.sTitle;
    private final String pTitle = SerieEvento.pTitle;
    
    private SerieEvento serieevento = new SerieEvento();
    private SerieEventoDAO dao = new SerieEventoDAO();
    private DataModel serieeventos;
    
    public SerieEventoBean(){
    
}
    
    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public SerieEvento getSerieEvento() {
        return serieevento;
    }

    public void setSerieEvento(SerieEvento serieevento) {
        this.serieevento = serieevento;
    }

    public DataModel getSerieEventos() {
        this.serieeventos = new ListDataModel(dao.findAll());
        return serieeventos;
    }

    public void setSerieEventos(DataModel serieeventos) {
        this.serieeventos = serieeventos;
    }
    
    public String insert() {
        dao.insert(serieevento);
        return "serieeventoslst";
    }
    
    public String edit(SerieEvento i) {
        serieevento = (SerieEvento) serieeventos.getRowData();
        return "serieeventofrm";
    }
   
    
    public String update() {
        dao.update(serieevento);
        return "serieeventolst";
    }
    
    public String delete(SerieEvento i) {
        dao.delete(i);
        return "serieeventolst";
    }
    
    public String salvar() {
        if (serieevento.getSev_codigo()> 0)
            dao.update(serieevento);
        else 
            dao.insert(serieevento);
        
        return "serieeventolst";
    }
    
    public String listar() {
        return "serieeventolst";
    }
    
    
    
    
    
}
