/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg.model;

import ad.model.Competencia;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    public static final String sTitle = "Empresa";
    public static final String pTitle = "Empresas";

    @Id
    @SequenceGenerator(name = "emp_codigo", sequenceName = "emp_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "emp_codigo")
 
    private int emp_codigo;
    private String emp_nome;
    
    @ManyToOne
    @JoinColumn(name = "rep_codigo", referencedColumnName = "rep_codigo")
    private Repositorio repositorio;

    @ManyToOne
    @JoinColumn(name = "cid_codigo", referencedColumnName = "cid_codigo")
    private Cidade cidade;
    
    @ManyToOne
    @JoinColumn(name = "bai_codigo", referencedColumnName = "bai_codigo")
    private Bairro bairro;
    
    @ManyToOne
    @JoinColumn(name = "end_codigo", referencedColumnName = "end_codigo")
    private Endereco endereco;
    
    private int emp_tipo;
    private int emp_tamanho;
    private String emp_descricao;
    private String emp_website;
    private String emp_numeroendereco;
    private int emp_sede;
    private int emp_empresa_sistema;

    public Empresa() {
    }

    public Empresa(int emp_codigo, String emp_nome, Repositorio repositorio, Cidade cidade, Bairro bairro, Endereco endereco, int emp_tipo, int emp_tamanho, String emp_descricao, String emp_website, String emp_numeroendereco, int emp_sede, int emp_empresa_sistema) {
        this.emp_codigo = emp_codigo;
        this.emp_nome = emp_nome;
        this.repositorio = repositorio;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.emp_tipo = emp_tipo;
        this.emp_tamanho = emp_tamanho;
        this.emp_descricao = emp_descricao;
        this.emp_website = emp_website;
        this.emp_numeroendereco = emp_numeroendereco;
        this.emp_sede = emp_sede;
        this.emp_empresa_sistema = emp_empresa_sistema;
    }

    public int getEmp_codigo() {
        return emp_codigo;
    }

    public void setEmp_codigo(int emp_codigo) {
        this.emp_codigo = emp_codigo;
    }

    public String getEmp_nome() {
        return emp_nome;
    }

    public void setEmp_nome(String emp_nome) {
        this.emp_nome = emp_nome;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getEmp_tipo() {
        return emp_tipo;
    }

    public void setEmp_tipo(int emp_tipo) {
        this.emp_tipo = emp_tipo;
    }

    public int getEmp_tamanho() {
        return emp_tamanho;
    }

    public void setEmp_tamanho(int emp_tamanho) {
        this.emp_tamanho = emp_tamanho;
    }

    public String getEmp_descricao() {
        return emp_descricao;
    }

    public void setEmp_descricao(String emp_descricao) {
        this.emp_descricao = emp_descricao;
    }

    public String getEmp_website() {
        return emp_website;
    }

    public void setEmp_website(String emp_website) {
        this.emp_website = emp_website;
    }

    public String getEmp_numeroendereco() {
        return emp_numeroendereco;
    }

    public void setEmp_numeroendereco(String emp_numeroendereco) {
        this.emp_numeroendereco = emp_numeroendereco;
    }

    public int getEmp_sede() {
        return emp_sede;
    }

    public void setEmp_sede(int emp_sede) {
        this.emp_sede = emp_sede;
    }

    public int getEmp_empresa_sistema() {
        return emp_empresa_sistema;
    }

    public void setEmp_empresa_sistema(int emp_empresa_sistema) {
        this.emp_empresa_sistema = emp_empresa_sistema;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.emp_codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (this.emp_codigo != other.emp_codigo) {
            return false;
        }
        return true;
    }
    
    
}
