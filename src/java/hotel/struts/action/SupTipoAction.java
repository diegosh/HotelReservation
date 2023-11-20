/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import hotel.dao.TipoDAO;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class SupTipoAction extends ActionSupport implements SessionAware{
  private int pidTipo;
  private TipoDAO tipoDAO;
  
  private int idTipo;

  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }
  
  public int getPidTipo() {
    return pidTipo;
  }

  public void setPidTipo(int pidTipo) {
    this.pidTipo = pidTipo;
  }

  public TipoDAO getTipoDAO() {
    return tipoDAO;
  }

  public void setTipoDAO(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
  }

  public int getIdTipo() {
    return idTipo;
  }

  public void setIdTipo(int idTipo) {
    this.idTipo = idTipo;
  }
  
  
  
  public SupTipoAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    if(tipoDAO.delete(pidTipo)){
      idTipo = pidTipo;
    }
    
    return SUCCESS;
  }
  
}
