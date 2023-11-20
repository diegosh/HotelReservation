/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.ArrayList;
import java.util.Map;

import hotel.dao.TipoDAO;
import hotel.pojo.Tipo;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class GestionTiposAction extends ActionSupport implements SessionAware {
  
  private TipoDAO tipoDAO;
  private ArrayList<Tipo> tipos;
  
  private Map<String,Object> sesion;
    
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }

  public Map<String,Object> getSesson() {
    return this.sesion;
  }
    

  public TipoDAO getTipoDAO() {
    return tipoDAO;
  }

  public void setTipoDAO(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
  }

  public ArrayList<Tipo> getTipos() {
    return tipos;
  }

  public void setTipos(ArrayList<Tipo> tipos) {
    this.tipos = tipos;
  }
  
  
  

  public GestionTiposAction(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
  }
  
  public GestionTiposAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    tipos = tipoDAO.listadotipos();
    return SUCCESS;
  }
  
}
