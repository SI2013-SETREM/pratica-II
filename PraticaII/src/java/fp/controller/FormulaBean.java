/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.controller;

import fp.dao.FormulaDAO;
import fp.model.Formula;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
/**
 *
 * @author Edivan
 */
@ManagedBean
@RequestScoped
public class FormulaBean {
    
    public final String sTitle = Formula.sTitle;
    public final String pTitle = Formula.pTitle;
    
    
    private Formula formula = new Formula();
    private FormulaDAO dao = new FormulaDAO();
    private DataModel formulas;
    
    
    public FormulaBean(){
    
    }

       public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public FormulaDAO getDao() {
        return dao;
    }

    public void setDao(FormulaDAO dao) {
        this.dao = dao;
    }

    public DataModel getFormulas() {
        this.formulas = new ListDataModel(dao.findAll());
        return formulas;
    }

    public void setFormulas(DataModel formulas) {
        this.formulas = formulas;
    }
    
    public String insert() {
        dao.insert(formula);
        return "formulalst";
    }
    
    public String edit(Formula f) {
        formula = (Formula) formulas.getRowData();
        return "formulafrm";
    }
    
    public String update() {
        dao.update(formula);
        return "formulalst";
    }
    
    public String delete(Formula f) {
        dao.delete(f);
        return "formulalst";
    }
    
    public String salvar() {
        if (formula.getFor_codigo()> 0)
            dao.update(formula);
        else 
            dao.insert(formula);
        
        return "formulalst";
    }
    
    public String listar() {
        return "formulalst";
    }
}
