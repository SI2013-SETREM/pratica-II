
package fp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Kelvin
 */
@Entity
@Table(name = "ffp_tab_inss")
public class TabINSS implements Serializable{
     
    @Id
    @SequenceGenerator (name= "genTabINSS", sequenceName= "segTabINSS", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "genTabINSS")
    private int tbs_codigo;
    @ManyToOne
    private FaixaINSS fai_codigo;
    private Date tbs_data_inicial;
    private Date tbs_data_final;
    private double tbs_sal_fami_ini;
    private double tbs_sal_fami_fin;
    private double tbs_ab_imp_ini_fin;
    private double tbs_ab_imp_uni;
    private double tbs_sal_fami_uni;
    private double tbs_ali_normal;
    private String tbs_ali_lei1;
    private String tbs_ali_lei2;

    public int getTbs_codigo() {
        return tbs_codigo;
    }

    public void setTbs_codigo(int tbs_codigo) {
        this.tbs_codigo = tbs_codigo;
    }

  

    public Date getTbs_data_inicial() {
        return tbs_data_inicial;
    }

    public void setTbs_data_inicial(Date tbs_data_inicial) {
        this.tbs_data_inicial = tbs_data_inicial;
    }

    public Date getTbs_data_final() {
        return tbs_data_final;
    }

    public void setTbs_data_final(Date tbs_data_final) {
        this.tbs_data_final = tbs_data_final;
    }

    public double getTbs_sal_fami_ini() {
        return tbs_sal_fami_ini;
    }

    public void setTbs_sal_fami_ini(double tbs_sal_fami_ini) {
        this.tbs_sal_fami_ini = tbs_sal_fami_ini;
    }

    public double getTbs_sal_fami_fin() {
        return tbs_sal_fami_fin;
    }

    public void setTbs_sal_fami_fin(double tbs_sal_fami_fin) {
        this.tbs_sal_fami_fin = tbs_sal_fami_fin;
    }

    public double getTbs_ab_imp_ini_fin() {
        return tbs_ab_imp_ini_fin;
    }

    public void setTbs_ab_imp_ini_fin(double tbs_ab_imp_ini_fin) {
        this.tbs_ab_imp_ini_fin = tbs_ab_imp_ini_fin;
    }

    public double getTbs_ab_imp_uni() {
        return tbs_ab_imp_uni;
    }

    public void setTbs_ab_imp_uni(double tbs_ab_imp_uni) {
        this.tbs_ab_imp_uni = tbs_ab_imp_uni;
    }

    public double getTbs_sal_fami_uni() {
        return tbs_sal_fami_uni;
    }

    public void setTbs_sal_fami_uni(double tbs_sal_fami_uni) {
        this.tbs_sal_fami_uni = tbs_sal_fami_uni;
    }

    public double getTbs_ali_normal() {
        return tbs_ali_normal;
    }

    public void setTbs_ali_normal(double tbs_ali_normal) {
        this.tbs_ali_normal = tbs_ali_normal;
    }

    public String getTbs_ali_lei1() {
        return tbs_ali_lei1;
    }

    public void setTbs_ali_lei1(String tbs_ali_lei1) {
        this.tbs_ali_lei1 = tbs_ali_lei1;
    }

    public String getTbs_ali_lei2() {
        return tbs_ali_lei2;
    }

    public void setTbs_ali_lei2(String tbs_ali_lei2) {
        this.tbs_ali_lei2 = tbs_ali_lei2;
    }

    public FaixaINSS getFai_codigo() {
        return fai_codigo;
    }
    
    public void setFai_codigo(FaixaINSS fai_codigo) {
        this.fai_codigo = fai_codigo;
    }
    
}
