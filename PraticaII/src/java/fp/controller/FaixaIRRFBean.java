package fp.controller;

import cfg.dao.LogDAO;
import fp.dao.FaixaIRRFDAO;
import fp.dao.TabelaIRRFDAO;
import fp.model.FaixaIRRF;
import fp.model.SerieEvento;
import fp.model.TabelaIRRF;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class FaixaIRRFBean {

    private final String sTitle = FaixaIRRF.sTitle;
    private final String pTitle = FaixaIRRF.pTitle;

    private FaixaIRRF faixairrf = new FaixaIRRF();
    private FaixaIRRFDAO dao = new FaixaIRRFDAO();
    private DataModel faixairrfs;

    private List<TabelaIRRF> lsttabelairrf;
    private TabelaIRRF tabelairrf = new TabelaIRRF();
    private TabelaIRRFDAO tabelairrfdao = new TabelaIRRFDAO();

    public FaixaIRRFBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public FaixaIRRF getFaixaIRRF() {
        return faixairrf;
    }

    public void setFaixaIRRF(FaixaIRRF faixairrf) {
        this.faixairrf = faixairrf;
    }

    public DataModel getFaixaIRRFs() {
        this.faixairrfs = new ListDataModel(dao.findAll());
        return faixairrfs;
    }

    public void setFaixaIRRFs(DataModel faixairrfs) {
        this.faixairrfs = faixairrfs;
    }

    public String insert() {
        dao.insert(faixairrf);
        return "tabelairrflst";
    }

    public String edit(FaixaIRRF i) {
        faixairrf = (FaixaIRRF) faixairrfs.getRowData();
        return "faixairrffrm";
    }

    public String update() {
        dao.update(faixairrf);
        return "tabelairrflst";
    }

    public String delete(FaixaIRRF i) {
        dao.delete(i);
    //    LogDAO.insert("FaixaIRRF", "Deletou faixa irrf código: " + i.getFrf_codigo() + ", faixa inicial: " + i.getFrf_salario_inicial()
    //            + ", faixa final: " + i.getFrf_salario_final() + ", faixa aliquota: " + i.getFrf_aliquota() + ", dedução: "
    //            + i.getFrf_deducao() + ", codidog tabela irrf: " + i.getTabelairrf().getTif_codigo());
        return "tabelairrflst";
    }

    public String salvar() {
        if (faixairrf.getFrf_codigo() > 0) {
            dao.update(faixairrf);
       //     LogDAO.insert("FaixaIRRF", "Alterou faixa irrf código: " + faixairrf.getFrf_codigo() + ", faixa inicial: " + faixairrf.getFrf_salario_inicial()
       //             + ", faixa final: " + faixairrf.getFrf_salario_final() + ", faixa aliquota: " + faixairrf.getFrf_aliquota() + ", dedução: "
       //             + faixairrf.getFrf_deducao() + ", codidog tabela irrf: " + faixairrf.getTabelairrf().getTif_codigo());
        } else {
            dao.insert(faixairrf);
      //      LogDAO.insert("FaixaIRRF", "Cadastrou faixa irrf código: " + faixairrf.getFrf_codigo() + ", faixa inicial: " + faixairrf.getFrf_salario_inicial()
      //          + ", faixa final: " + faixairrf.getFrf_salario_final() + ", faixa aliquota: " + faixairrf.getFrf_aliquota() + ", dedução: "
      //          + faixairrf.getFrf_deducao() + ", codidog tabela irrf: " + faixairrf.getTabelairrf().getTif_codigo());
        }

        return "tabelairrflst";
    }

    public String listar() {
        return "tabelairrflst";
    }

    public List<TabelaIRRF> getLstTabelaIRRF() {
        lsttabelairrf = tabelairrfdao.findAll();
        return lsttabelairrf;
    }

    public void setLstTabelaIRRF(List<TabelaIRRF> i) {
        this.lsttabelairrf = i;
    }

}
