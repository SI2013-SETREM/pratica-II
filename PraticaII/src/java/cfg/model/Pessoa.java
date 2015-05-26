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

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    public static final String sTitle = "Pessoa";
    public static final String pTitle = "Pessoas";

    @Id
    @SequenceGenerator(name = "pes_codigo", sequenceName = "pes_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pes_codigo")

    private int pes_codigo;

    @ManyToOne
    @JoinColumn(name = "rep_codigo_foto")
    private Repositorio repositorio;

    @ManyToOne
    @JoinColumn(name = "bai_codigo")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "cid_cep")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "cid_cep_nasc")
    private Cidade cidadenasc;

    private String pes_nome;
    private String pes_cpf;
    private int pes_rg;
    private Date pes_datanasc;
    private int pen_numeroend;
    private String pes_complementoend;
    private String pes_telefone;
    private String pes_email;
    private String pes_pai;
    private String pes_mae;
    private int pes_tipo;
    private int pes_estadocivil;
    private String pes_observacoes;
    private Boolean pes_necessidadeespecial;
    private String pes_necessidadeespecialdsc;
    private Date pes_datacadastro;
    private String pes_cur_resumo;
    private Date pes_cur_dataatualizado;
    private Double pes_cur_pretensaosalarial;

    public Pessoa() {
    }

    public Pessoa(int pes_codigo, Repositorio repositorio, Bairro bairro, Cidade cidade, Cidade cidadenasc, String pes_nome, String pes_cpf, int pes_rg, Date pes_datanasc, int pen_numeroend, String pes_complementoend, String pes_telefone, String pes_email, String pes_pai, String pes_mae, int pes_tipo, int pes_estadocivil, String pes_observacoes, Boolean pes_necessidadeespecial, String pes_necessidadeespecialdsc, Date pes_datacadastro, String pes_cur_resumo, Date pes_cur_dataatualizado, Double pes_cur_pretensaosalarial) {
        this.pes_codigo = pes_codigo;
        this.repositorio = repositorio;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cidadenasc = cidadenasc;
        this.pes_nome = pes_nome;
        this.pes_cpf = pes_cpf;
        this.pes_rg = pes_rg;
        this.pes_datanasc = pes_datanasc;
        this.pen_numeroend = pen_numeroend;
        this.pes_complementoend = pes_complementoend;
        this.pes_telefone = pes_telefone;
        this.pes_email = pes_email;
        this.pes_pai = pes_pai;
        this.pes_mae = pes_mae;
        this.pes_tipo = pes_tipo;
        this.pes_estadocivil = pes_estadocivil;
        this.pes_observacoes = pes_observacoes;
        this.pes_necessidadeespecial = pes_necessidadeespecial;
        this.pes_necessidadeespecialdsc = pes_necessidadeespecialdsc;
        this.pes_datacadastro = pes_datacadastro;
        this.pes_cur_resumo = pes_cur_resumo;
        this.pes_cur_dataatualizado = pes_cur_dataatualizado;
        this.pes_cur_pretensaosalarial = pes_cur_pretensaosalarial;
    }

    public int getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(int pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cidade getCidadenasc() {
        return cidadenasc;
    }

    public void setCidadenasc(Cidade cidadenasc) {
        this.cidadenasc = cidadenasc;
    }

    public String getPes_nome() {
        return pes_nome;
    }

    public void setPes_nome(String pes_nome) {
        this.pes_nome = pes_nome;
    }

    public String getPes_cpf() {
        return pes_cpf;
    }

    public void setPes_cpf(String pes_cpf) {
        this.pes_cpf = pes_cpf;
    }

    public int getPes_rg() {
        return pes_rg;
    }

    public void setPes_rg(int pes_rg) {
        this.pes_rg = pes_rg;
    }

    public Date getPes_datanasc() {
        return pes_datanasc;
    }

    public void setPes_datanasc(Date pes_datanasc) {
        this.pes_datanasc = pes_datanasc;
    }

    public int getPen_numeroend() {
        return pen_numeroend;
    }

    public void setPen_numeroend(int pen_numeroend) {
        this.pen_numeroend = pen_numeroend;
    }

    public String getPes_complementoend() {
        return pes_complementoend;
    }

    public void setPes_complementoend(String pes_complementoend) {
        this.pes_complementoend = pes_complementoend;
    }

    public String getPes_telefone() {
        return pes_telefone;
    }

    public void setPes_telefone(String pes_telefone) {
        this.pes_telefone = pes_telefone;
    }

    public String getPes_email() {
        return pes_email;
    }

    public void setPes_email(String pes_email) {
        this.pes_email = pes_email;
    }

    public String getPes_pai() {
        return pes_pai;
    }

    public void setPes_pai(String pes_pai) {
        this.pes_pai = pes_pai;
    }

    public String getPes_mae() {
        return pes_mae;
    }

    public void setPes_mae(String pes_mae) {
        this.pes_mae = pes_mae;
    }

    public int getPes_tipo() {
        return pes_tipo;
    }

    public void setPes_tipo(int pes_tipo) {
        this.pes_tipo = pes_tipo;
    }

    public int getPes_estadocivil() {
        return pes_estadocivil;
    }

    public void setPes_estadocivil(int pes_estadocivil) {
        this.pes_estadocivil = pes_estadocivil;
    }

    public String getPes_observacoes() {
        return pes_observacoes;
    }

    public void setPes_observacoes(String pes_observacoes) {
        this.pes_observacoes = pes_observacoes;
    }

    public Boolean getPes_necessidadeespecial() {
        return pes_necessidadeespecial;
    }

    public void setPes_necessidadeespecial(Boolean pes_necessidadeespecial) {
        this.pes_necessidadeespecial = pes_necessidadeespecial;
    }

    public String getPes_necessidadeespecialdsc() {
        return pes_necessidadeespecialdsc;
    }

    public void setPes_necessidadeespecialdsc(String pes_necessidadeespecialdsc) {
        this.pes_necessidadeespecialdsc = pes_necessidadeespecialdsc;
    }

    public Date getPes_datacadastro() {
        return pes_datacadastro;
    }

    public void setPes_datacadastro(Date pes_datacadastro) {
        this.pes_datacadastro = pes_datacadastro;
    }

    public String getPes_cur_resumo() {
        return pes_cur_resumo;
    }

    public void setPes_cur_resumo(String pes_cur_resumo) {
        this.pes_cur_resumo = pes_cur_resumo;
    }

    public Date getPes_cur_dataatualizado() {
        return pes_cur_dataatualizado;
    }

    public void setPes_cur_dataatualizado(Date pes_cur_dataatualizado) {
        this.pes_cur_dataatualizado = pes_cur_dataatualizado;
    }

    public Double getPes_cur_pretensaosalarial() {
        return pes_cur_pretensaosalarial;
    }

    public void setPes_cur_pretensaosalarial(Double pes_cur_pretensaosalarial) {
        this.pes_cur_pretensaosalarial = pes_cur_pretensaosalarial;
    }
    
    
}
