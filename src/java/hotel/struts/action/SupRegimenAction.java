/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import hotel.dao.RegimenDAO;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class SupRegimenAction extends ActionSupport implements SessionAware{
  
  private String pidRegimen;
  private RegimenDAO regimenDAO;
  
  private String idRegimen;
  
  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }
  
  

  public String getPidRegimen() {
    return pidRegimen;
  }

  public void setPidRegimen(String pidRegimen) {
    this.pidRegimen = pidRegimen;
  }

  public RegimenDAO getRegimenDAO() {
    return regimenDAO;
  }

  public void setRegimenDAO(RegimenDAO regimenDAO) {
    this.regimenDAO = regimenDAO;
  }

  public String getIdRegimen() {
    return idRegimen;
  }

  public void setIdRegimen(String idRegimen) {
    this.idRegimen = idRegimen;
  }
  
  
  
  public SupRegimenAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    if(regimenDAO.delete(pidRegimen)){
      idRegimen = pidRegimen;
    }
    
    return SUCCESS;
  }
  
}
