package cfg.controller;

import antlr.ByteBuffer;
import cfg.dao.LogDAO;
import cfg.dao.RepositorioDAO;
import cfg.model.Repositorio;
import cfg.model.Repositorio;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@ManagedBean
@RequestScoped
public class RepositorioBean {

    private final String sTitle = Repositorio.sTitle;
    private final String pTitle = Repositorio.pTitle;

    private Repositorio repositorio = new Repositorio();
    private RepositorioDAO dao = new RepositorioDAO();
    private DataModel repositorios;

    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public RepositorioBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public DataModel getRepositorios() {
        this.repositorios = new ListDataModel(dao.findAll());
        return repositorios;
    }

    public void setRepositorio(DataModel repositorios) {
        this.repositorios = repositorios;
    }

    public String insert() {
        dao.insert(repositorio);
        return "repositoriolst";
    }

    public String edit(Repositorio i) {
        repositorio = (Repositorio) repositorios.getRowData();
        return "repositoriofrm";
    }

    public String update() {
        dao.update(repositorio);
        return "repositoriolst";
    }

    public String delete(Repositorio i) {
        dao.delete(i);
        LogDAO.insert("Repositório", "Deletou repositório código: " + repositorio.getRep_codigo() + ", nome: " + repositorio.getRep_nome()
                + ", nome arquivo: " + repositorio.getRep_nomearquivo() + ", extesão: " + repositorio.getRep_extensao() + ", tipo: " + repositorio.getRep_tipo() + ", data: " + repositorio.getRep_data());
        return "repositoriolst";
    }

    public String salvar() {
        repositorio = new Repositorio(file);
        
        if (repositorio.getRep_codigo() > 0) {
            dao.update(repositorio);
            LogDAO.insert("Repositório", "Alterou repositório código: " + repositorio.getRep_codigo() + ", nome: " + repositorio.getRep_nome()
                    + ", nome arquivo: " + repositorio.getRep_nomearquivo() + ", extesão: " + repositorio.getRep_extensao() + ", tipo: " + repositorio.getRep_tipo() + ", data: " + repositorio.getRep_data());
        } else {
            dao.insert(repositorio);
            LogDAO.insert("Repositório", "Cadastrou repositório código: " + repositorio.getRep_codigo() + ", nome: " + repositorio.getRep_nome()
                    + ", nome arquivo: " + repositorio.getRep_nomearquivo() + ", extesão: " + repositorio.getRep_extensao() + ", tipo: " + repositorio.getRep_tipo() + ", data: " + repositorio.getRep_data());
        }
        
        return "repositoriolst";
    }

    public String listar() {
        return "repositoriolst";
    }

    public void download(Repositorio r) {
        try {
            HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            hsr.setHeader("Content-Disposition", "attachment");
            hsr.setHeader("Content-Description", "File Transfer");
            switch(r.getRep_extensao().toLowerCase()) {
                case "jpg":
                case "jpeg":
                case "png":
                    hsr.setContentType("image/" + r.getRep_extensao().toLowerCase());
                    break;
                case "zip":
                    hsr.setContentType("application/x-compressed");
                    break;
                case "pdf":
                    hsr.setContentType("application/pdf");
                    break;
                case "txt":
                    hsr.setContentType("text/plain");
                    break;
                default:
                    hsr.setContentType("application/octet-stream");
                    break;
            }
            hsr.setHeader("Content-Disposition", "attachment; filename=" + r.getRep_nomearquivo()+ "." + r.getRep_extensao());
            hsr.setHeader("Content-Transfer-Encoding", "binary");
            hsr.setHeader("Expires", "0");
            hsr.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            hsr.setHeader("Pragma", "public");
            hsr.setHeader("Content-Length", String.valueOf(r.getRep_arquivo().length));
            hsr.getOutputStream().write(r.getRep_arquivo());
            hsr.getOutputStream().flush();
            hsr.getOutputStream().close();
        } catch (IOException ex) {
            Logger.getLogger(RepositorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void show() {
        HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        hsr.setContentType("image/jpg");
    }
    
}
