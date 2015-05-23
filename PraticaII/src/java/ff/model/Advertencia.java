package ff.model;

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
@SequenceGenerator(name = "genAdvertencia", sequenceName = "genAdvertencia", allocationSize = 1)
public class Advertencia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genAdvertencia")
    private int adv_codigo;
    @ManyToOne
    private FichaFuncional ficha_funcional;
    private String adv_descricao;
    @Column(nullable = false)
    private Date adv_data;
    private String adv_observacao;
    @Column(nullable = false)
    private String adv_motivo;
    private String adv_advertencia;

    public int getAdv_codigo() {
        return adv_codigo;
    }

    public void setAdv_codigo(int adv_codigo) {
        this.adv_codigo = adv_codigo;
    }

    public FichaFuncional getFicha_funcional() {
        return ficha_funcional;
    }

    public void setFicha_funcional(FichaFuncional ficha_funcional) {
        this.ficha_funcional = ficha_funcional;
    }

    public String getAdv_descricao() {
        return adv_descricao;
    }

    public void setAdv_descricao(String adv_descricao) {
        this.adv_descricao = adv_descricao;
    }

    public Date getAdv_data() {
        return adv_data;
    }

    public void setAdv_data(Date adv_data) {
        this.adv_data = adv_data;
    }

    public String getAdv_observacao() {
        return adv_observacao;
    }

    public void setAdv_observacao(String adv_observacao) {
        this.adv_observacao = adv_observacao;
    }

    public String getAdv_motivo() {
        return adv_motivo;
    }

    public void setAdv_motivo(String adv_motivo) {
        this.adv_motivo = adv_motivo;
    }

    public String getAdv_advertencia() {
        return adv_advertencia;
    }

    public void setAdv_advertencia(String adv_advertencia) {
        this.adv_advertencia = adv_advertencia;
    }
}
