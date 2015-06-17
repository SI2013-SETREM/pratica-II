package rs.model;

import cfg.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Dinei A. Rockenbach
 */
@Entity
@Table(name = "rec_recrutamento")
public class Recrutamento implements Serializable {

    public static final String sTitle = "Recrutamento";
    public static final String pTitle = "Recrutamentos";
    @Id
    @SequenceGenerator(name = "recrutamento_pk_sequence", sequenceName = "seq_rs_recrutamento")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "recrutamento_pk_sequence")
    private int rec_codigo;
    private String rec_titulo;
    private int rec_tipo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rec_inicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rec_fim;
    private int rec_status;
    private List<Pessoa> pessoas;

    public Recrutamento() {
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void addPessoa(Pessoa p) {
        if (this.pessoas == null) {
            this.pessoas = new ArrayList<>();
        }
        this.pessoas.add(p);
    }

    public int getRecCodigo() {
        return rec_codigo;
    }

    public void setRecCodigo(int rec_codigo) {
        this.rec_codigo = rec_codigo;
    }

    public String getRecTitulo() {
        return rec_titulo;
    }

    public void setRecTitulo(String rec_titulo) {
        this.rec_titulo = rec_titulo;
    }

    public int getRecTipo() {
        return rec_tipo;
    }

    public void setRecTipo(int rec_tipo) {
        this.rec_tipo = rec_tipo;
    }

    public Date getRecInicio() {
        return rec_inicio;
    }

    public void setRecInicio(Date rec_inicio) {
        this.rec_inicio = rec_inicio;
    }

    public Date getRecFim() {
        return rec_fim;
    }

    public void setRecFim(Date rec_fim) {
        this.rec_fim = rec_fim;
    }

    public int getRecStatus() {
        return rec_status;
    }

    public void setRecStatus(int rec_status) {
        this.rec_status = rec_status;
    }
}
