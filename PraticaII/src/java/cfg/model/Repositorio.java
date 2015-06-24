/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg.model;

import cfg.controller.RepositorioBean;
import cfg.dao.LogDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.servlet.http.Part;

@Entity
@Table(name = "repositorio")
public class Repositorio implements Serializable {

    public static final String sTitle = "Repositorio";
    public static final String pTitle = "Repositorios";

    @Id
    @SequenceGenerator(name = "rep_codigo", sequenceName = "rep_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "rep_codigo")
    private int rep_codigo;
    
    private int rep_tipo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rep_data;
    private String rep_nome;
    private String rep_nomearquivo;
    private String rep_extensao;
    @Lob
    private byte[] rep_arquivo;

    public Repositorio() {
    }
    
    public Repositorio(Part file) {
        this.upload(file);
        
        this.parseFilename(file.getSubmittedFileName());
        
        this.setRep_data(new Date());
    }

    public Repositorio(int rep_codigo, int rep_tipo, Date rep_data, String rep_nome, String rep_nomearquivo, String rep_extensao, byte[] rep_arquivo) {
        this.rep_codigo = rep_codigo;
        this.rep_tipo = rep_tipo;
        this.rep_data = rep_data;
        this.rep_nome = rep_nome;
        this.rep_nomearquivo = rep_nomearquivo;
        this.rep_extensao = rep_extensao;
        this.rep_arquivo = rep_arquivo;
    }

    public int getRep_codigo() {
        return rep_codigo;
    }

    public void setRep_codigo(int rep_codigo) {
        this.rep_codigo = rep_codigo;
    }

    public int getRep_tipo() {
        return rep_tipo;
    }

    public void setRep_tipo(int rep_tipo) {
        this.rep_tipo = rep_tipo;
    }

    public Date getRep_data() {
        return rep_data;
    }

    public void setRep_data(Date rep_data) {
        this.rep_data = rep_data;
    }

    public String getRep_nome() {
        return rep_nome;
    }

    public void setRep_nome(String rep_nome) {
        this.rep_nome = rep_nome;
    }

    public String getRep_nomearquivo() {
        return rep_nomearquivo;
    }

    public void setRep_nomearquivo(String rep_nomearquivo) {
        this.rep_nomearquivo = rep_nomearquivo;
    }

    public String getRep_extensao() {
        return rep_extensao;
    }

    public void setRep_extensao(String rep_extensao) {
        this.rep_extensao = rep_extensao;
    }

    public byte[] getRep_arquivo() {
        return rep_arquivo;
    }

    public void setRep_arquivo(byte[] rep_arquivo) {
        this.rep_arquivo = rep_arquivo;
    }
    
    public void upload(Part file) {
        byte[] RepArquivo = new byte[1048576];
        try {
            InputStream fileContent = file.getInputStream();
            final byte[] fileByte = new byte[1024];
            int currentOffset = 0;
            while (fileContent.read(fileByte) != -1) {
                System.arraycopy(
                    fileByte, 0,
                    RepArquivo, currentOffset,
                    fileByte.length
                );
                currentOffset += fileByte.length;
            }
            fileContent.close();
        } catch (IOException ex) {
            LogDAO.insert("Repositório", "Falha no upload do arquivo: " + file.getSubmittedFileName() + ". Detalhes da falha: " + ex.getMessage());
        }
        this.setRep_arquivo(RepArquivo);
    }
    
    public void parseFilename(String filename) {
        int index = filename.indexOf(".");
        if (index != -1) {
            this.setRep_nomearquivo(filename.substring(0, index));
            this.setRep_extensao(filename.substring(index + 1, filename.length()));
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.rep_codigo;
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
        final Repositorio other = (Repositorio) obj;
        if (this.rep_codigo != other.rep_codigo) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return getRep_nome();
    }
}
