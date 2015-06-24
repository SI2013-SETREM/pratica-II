package fp.controller;

import cfg.model.Pessoa;
import csb.dao.SalarioDAO;
import csb.model.Salario;
import fp.dao.FaixaINSSDAO;
import fp.dao.FaixaIRRFDAO;
import fp.dao.TabelaINSSDAO;
import fp.dao.TabelaIRRFDAO;
import fp.model.Evento;
import fp.model.FaixaINSS;
import fp.model.FaixaIRRF;
import fp.model.TabelaIRRF;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;

public class calculoFolha {

    private Evento evento = new Evento();

    private FaixaINSS faixainss = new FaixaINSS();
    private FaixaINSSDAO dao = new FaixaINSSDAO();
    private List<FaixaINSS> Listfaixainss;
    
    private FaixaIRRF faixaIRRF = new FaixaIRRF();
    private FaixaIRRFDAO faixaIRRFDAO = new FaixaIRRFDAO();
     private List<FaixaIRRF> Listfaixairrf;
    

    public double calculaDesconto(Evento objD, double salario) {
        double desconto = 0;
        // fgts
        if (objD.isEve_tributar_fgts()) {
            desconto = salario * 0.08;
            // irrf
        } else if (objD.isEve_tributar_irrf()) {

            Listfaixairrf = faixaIRRFDAO.findAll();
            List<FaixaIRRF> lista = new ArrayList<FaixaIRRF>();

            for (FaixaIRRF t : Listfaixairrf) {

                if (t.getTabelairrf().equals(objD.getTabelairrf())) {
                    lista.add(t);
                }

            }
            for (FaixaIRRF l : lista) {
                if (salario > l.getFrf_salario_inicial() && salario < l.getFrf_salario_final()) {
                    desconto = salario * l.getFrf_aliquota();
                    break;
                }

            }
            
            //inss
        } else if (objD.isEve_tributar_inss()) {
            Listfaixainss = dao.findAll();
            List<FaixaINSS> lista = new ArrayList<FaixaINSS>();

            for (FaixaINSS f : Listfaixainss) {

                if (f.getTabelainss().equals(objD.getTabelainss())) {
                    lista.add(f);
                }

            }
            for (FaixaINSS l : lista) {
                if (salario > l.getFai_sal_ini() && salario < l.getFai_sal_fin()) {

                    desconto = salario * l.getFai_aliquota();
                    break;
                }

            }
        }

        return desconto;
    }

    public double calculaAcrescimo(Evento objA, double salario) {
        double acrescimo = 0;
        double valorHora = salario / 220;
        // salario base
        if (objA.getTipoevento().getTpe_codigo() == 1) {

            acrescimo = salario;
            // valor   
        } else if (objA.getTipoevento().getTpe_codigo() == 2) {
            acrescimo = objA.getEve_indice();
            //horas
        } else if (objA.getTipoevento().getTpe_codigo() == 3) {
            acrescimo = valorHora * 20 * objA.getEve_indice();

            // beneficio
        } else if (objA.getTipoevento().getTpe_codigo() == 4) {
            acrescimo = objA.getBeneficio().getBen_valor();
            //formula
        } else if (objA.getTipoevento().getTpe_codigo() == 5) {

        }

        return acrescimo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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

    public List<FaixaINSS> getListfaixainss() {
        return Listfaixainss;
    }

    public void setListfaixainss(List<FaixaINSS> Listfaixainss) {
        this.Listfaixainss = Listfaixainss;
    }

 

}
