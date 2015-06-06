/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.controller;

import fp.dao.FaixaINSSDAO;
import fp.dao.TabINSSDAO;
import fp.model.FaixaINSS;
import fp.model.TabelaINSS;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Kelvin
 */
@ManagedBean
@RequestScoped
public class FaixaINSSBean {
    
    private final String sTitle = FaixaINSS.sTitle;
    private final String pTitle = FaixaINSS.pTitle;
    
    private FaixaINSS faixainss = new FaixaINSS();
    private FaixaINSSDAO dao = new FaixaINSSDAO();
    private DataModel faixainsss;
    
    
    private List<TabelaINSS> lsttabelaINSS;
    private TabelaINSS tabelainss = new TabelaINSS();
    private TabINSSDAO tabelainssdao = new TabINSSDAO();
        
    public FaixaINSSBean(){
        
    }
    
     public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public FaixaINSS getFaixainss() {
        return faixainss;
    }

    public void setFaixainss(FaixaINSS faixainss) {
        this.faixainss = faixainss;
    }

    public FaixaINSSDAO getDao() {
        return dao;
    }

    public void setDao(FaixaINSSDAO dao) {
        this.dao = dao;
    }

    public DataModel getFaixainsss() {
        this.faixainsss = new ListDataModel(dao.findAll());
        return faixainsss;
    }

    public void setFaixainsss(DataModel faixainsss) {
        this.faixainsss = faixainsss;
    }

    public List<TabelaINSS> getLsttabelaINSS() {
        return lsttabelaINSS;
    }

    public void setLsttabelaINSS(List<TabelaINSS> lsttabelaINSS) {
        this.lsttabelaINSS = lsttabelaINSS;
    }

    public TabelaINSS getTabelainss() {
        return tabelainss;
    }

    public void setTabelainss(TabelaINSS tabelainss) {
        this.tabelainss = tabelainss;
    }

    public TabINSSDAO getTabelainssdao() {
        return tabelainssdao;
    }

    public void setTabelainssdao(TabINSSDAO tabelainssdao) {
        this.tabelainssdao = tabelainssdao;
    }
    
    
    public String insert() {
        dao.insert(faixainss);
        return "tabelainsslst";
    }
    
    public String edit(FaixaINSS i) {
        faixainss = (FaixaINSS) faixainsss.getRowData();
        return "faixainssfrm";
    }
    
    public String update() {
        dao.update(faixainss);
        return "tabelainsslst";
    }
    
    public String delete(FaixaINSS i) {
        dao.delete(i);
        return "tabelainsslst";
    }
    
   public String salvar() {
        if (faixainss.getFai_codigo()> 0)
            dao.update(faixainss);
        else 
            dao.insert(faixainss);
        
        return "tabelainsslst";
    }
    
    public String listar() {
        return "tabelainsslst";
    }
    
    
     public List<TabelaINSS> getLstTabelaINSS() {
        lsttabelaINSS = tabelainssdao.findAll();
        return lsttabelaINSS;
    }

    public void setLstTabelaINSS(List<TabelaINSS> i) {
        this.lsttabelaINSS = i;
    }
    
    
}
