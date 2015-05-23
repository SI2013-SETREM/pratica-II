package fp.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Max
 */
@Entity
@SequenceGenerator(name = "genHistoricoFolha", sequenceName = "genHistoricoFolha", allocationSize = 1)
public class HistoricoFolha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genHistoricoFolha")
    private int hif_codigo;
    @ManyToOne
    private Pessoa pessoa;
    private double hif_valor_acre;
    private double hif_valor_desc;
    @Column(nullable = false)
    private double hif_salario_base;
    @Column(nullable = false)
    private Date hif_data;
    @Column(nullable = false)
    private double hif_valor_liquido;

    public int getHif_codigo() {
        return hif_codigo;
    }

    public void setHif_codigo(int hif_codigo) {
        this.hif_codigo = hif_codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getHif_valor_acre() {
        return hif_valor_acre;
    }

    public void setHif_valor_acre(double hif_valor_acre) {
        this.hif_valor_acre = hif_valor_acre;
    }

    public double getHif_valor_desc() {
        return hif_valor_desc;
    }

    public void setHif_valor_desc(double hif_valor_desc) {
        this.hif_valor_desc = hif_valor_desc;
    }

    public double getHif_salario_base() {
        return hif_salario_base;
    }

    public void setHif_salario_base(double hif_salario_base) {
        this.hif_salario_base = hif_salario_base;
    }

    public Date getHif_data() {
        return hif_data;
    }

    public void setHif_data(Date hif_data) {
        this.hif_data = hif_data;
    }

    public double getHif_valor_liquido() {
        return hif_valor_liquido;
    }

    public void setHif_valor_liquido(double hif_valor_liquido) {
        this.hif_valor_liquido = hif_valor_liquido;
    }
    
    

}
