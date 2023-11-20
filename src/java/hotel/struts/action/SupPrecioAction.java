/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import hotel.dao.PreciosDAO;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class SupPrecioAction extends ActionSupport implements SessionAware{
  
  private int pidPrecio;
  private PreciosDAO preciosDAO;
  
  private int idPrecio;
  
  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }
  
  

  public int getPidPrecio() {
    return pidPrecio;
  }

  public void setPidPrecio(int pidPrecio) {
    this.pidPrecio = pidPrecio;
  }

  public PreciosDAO getPreciosDAO() {
    return preciosDAO;
  }

  public void setPreciosDAO(PreciosDAO preciosDAO) {
    this.preciosDAO = preciosDAO;
  }

  public int getIdPrecio() {
    return idPrecio;
  }

  public void setIdPrecio(int idPrecio) {
    this.idPrecio = idPrecio;
  }
  
  
  
  public SupPrecioAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    if(preciosDAO.delete(pidPrecio)) {
      idPrecio = pidPrecio;
    }
    
    return SUCCESS;
  }
  
}
