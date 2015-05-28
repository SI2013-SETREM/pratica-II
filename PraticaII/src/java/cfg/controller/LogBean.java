
package cfg.controller;

import cfg.dao.LogDAO;
import cfg.model.Log;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class LogBean {
    
    private final String sTitle = Log.sTitle;
    private final String pTitle = Log.pTitle;
    
    private Log log = new Log();
    private LogDAO dao = new LogDAO();
    private DataModel logs;
    
    public LogBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }
    
    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log= log;
    }

    public DataModel getLogs() {
        this.logs = new ListDataModel(dao.findAll());
        return logs;
    }

    public void setLogs(DataModel idiomas) {
        this.logs= logs;
    }
    
    public String insert() {
        dao.insert(log);
        return "loglst";
    }
    
    public String edit(Log i) {
        log= (Log) logs.getRowData();
        return "logfrm";
    }
    
    public String update() {
        dao.update(log);
        return "loglst";
    }
    
    public String delete(Log i) {
        dao.delete(i);
        return "loglst";
    }
    
    public String salvar() {
        if (log.getLog_codigo()> 0)
            dao.update(log);
        else 
            dao.insert(log);
        
        return "loglst";
    }
    
    public String listar() {
        return "loglst";
    }
    
    
}
