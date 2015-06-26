package fp.controller;

import cfg.dao.LogDAO;

import cfg.dao.PessoaDAO;
import cfg.model.Pessoa;
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

    private int pes_codigo;
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

    private int idPessoa;
    private ListDataModel pessoalst;
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO pessoadao = new PessoaDAO();

    public EventoBean() {

    }

    public int getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(int pes_codigo) {
        this.pes_codigo = pes_codigo;
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
        return "eventofrm";
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

        //int serie = evento.getSerieevento().getSev_codigo();
        if (evento.getEve_codigo() > 0) {

            if (evento.getSerieevento().getSev_codigo() == 1) {
                evento.setEve_tributar_fgts(false);
                evento.setEve_tributar_inss(false);
                evento.setEve_tributar_irrf(false);
                evento.setTabelairrf(null);
                evento.setTabelainss(null);
            } else if (evento.getSerieevento().getSev_codigo() == 2) {

                evento.setEve_indice(0);
                evento.setBeneficio(null);
                evento.setEve_calcular_media_agregada13(false);
            }
            
            if(evento.getTipoevento().getTpe_codigo() == 1){
                evento.setEve_indice(0);
                evento.setFormula(null);
                evento.setBeneficio(null);
            } else if (evento.getTipoevento().getTpe_codigo() == 2){
                evento.setFormula(null);
                evento.setBeneficio(null);
            } else if (evento.getTipoevento().getTpe_codigo() == 3){
                evento.setFormula(null);
                evento.setBeneficio(null);
            }else if (evento.getTipoevento().getTpe_codigo() == 4){
               evento.setEve_indice(0);
                evento.setFormula(null); 
            }else if (evento.getTipoevento().getTpe_codigo() == 5){
                evento.setEve_indice(0);
                evento.setBeneficio(null);
            }
            

            if (!evento.isEve_tributar_irrf()) {
                evento.setTabelairrf(null);
            }
            if (!evento.isEve_tributar_inss()) {
                evento.setTabelainss(null);
            }
            dao.update(evento);
   //         LogDAO.insert("Evento", "Alterou evento código: " + evento.getEve_codigo() + ", descrição: " + evento.getEve_descricao()+
            //     ", índice: "+evento.getEve_indice()+", código benefício: "+evento.getBeneficio().getBen_codigo()+", fórmula: "+evento.getFormula()+
            //     ", série evento: "+evento.getSerieevento()+", código tabela inss: "+evento.getTabelainss().getTbs_codigo()+
            //    ", código tabela irrf: "+evento.getTabelairrf().getTif_codigo());
        } else {

            if (evento.getSerieevento().getSev_codigo() == 1) {
                evento.setEve_tributar_fgts(false);
                evento.setEve_tributar_inss(false);
                evento.setEve_tributar_irrf(false);
                evento.setTabelairrf(null);
                evento.setTabelainss(null);
            } else if (evento.getSerieevento().getSev_codigo() == 2) {

                evento.setEve_indice(0);
                evento.setBeneficio(null);
                evento.setEve_calcular_media_agregada13(false);
            }
            
            if(evento.getTipoevento().getTpe_codigo() == 1){
                evento.setEve_indice(0);
                evento.setFormula(null);
                evento.setBeneficio(null);
            } else if (evento.getTipoevento().getTpe_codigo() == 2){
                evento.setFormula(null);
                evento.setBeneficio(null);
            } else if (evento.getTipoevento().getTpe_codigo() == 3){
                evento.setFormula(null);
                evento.setBeneficio(null);
            }else if (evento.getTipoevento().getTpe_codigo() == 4){
               evento.setEve_indice(0);
                evento.setFormula(null); 
            }else if (evento.getTipoevento().getTpe_codigo() == 5){
                evento.setEve_indice(0);
                evento.setBeneficio(null);
            }

            if (!evento.isEve_tributar_irrf()) {
                evento.setTabelairrf(null);
            }
            if (!evento.isEve_tributar_inss()) {
                evento.setTabelainss(null);
            }

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

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void iniciaPessoa() {
        this.pessoalst = new ListDataModel<>(pessoadao.findByPessoaId(getIdPessoa()));
        pessoa = (Pessoa) pessoalst.getRowData();
        pessoa = pessoadao.findById(pessoa.getPes_codigo());
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaDAO getPessoadao() {
        return pessoadao;
    }

    public void setPessoadao(PessoaDAO pessoadao) {
        this.pessoadao = pessoadao;
    }

    public ListDataModel getPessoalst() {
        return pessoalst;
    }

    public void setPessoalst(ListDataModel pessoalst) {
        this.pessoalst = pessoalst;
    }

}
