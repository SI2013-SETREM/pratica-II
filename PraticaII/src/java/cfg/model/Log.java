package cfg.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "log")
public class Log implements Serializable {

    public static final String sTitle = "Log";
    public static final String pTitle = "Logs";

    @Id
    @SequenceGenerator(name = "log_codigo", sequenceName = "log_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "log_codigo")
    
    private int log_codigo;
    
    @ManyToOne
    @JoinColumn(name = "usu_login")
    private Usuario usuario;

    private String log_tabela;
    private String log_operacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date log_datahora;

    public Log() {
    }

    public Log(int log_codigo, Usuario usuario, String log_tabela, String log_operacao, Date log_datahora) {
        this.log_codigo = log_codigo;
        this.usuario = usuario;
        this.log_tabela = log_tabela;
        this.log_operacao = log_operacao;
        this.log_datahora = log_datahora;
    }

    public int getLog_codigo() {
        return log_codigo;
    }

    public void setLog_codigo(int log_codigo) {
        this.log_codigo = log_codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getLog_tabela() {
        return log_tabela;
    }

    public void setLog_tabela(String log_tabela) {
        this.log_tabela = log_tabela;
    }

    public String getLog_operacao() {
        return log_operacao;
    }

    public void setLog_operacao(String log_operacao) {
        this.log_operacao = log_operacao;
    }

    public Date getLog_datahora() {
        return log_datahora;
    }

    public void setLog_datahora(Date log_datahora) {
        this.log_datahora = log_datahora;
    }
    
    
    
}
