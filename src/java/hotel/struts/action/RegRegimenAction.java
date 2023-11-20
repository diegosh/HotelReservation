/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import hotel.pojo.Regimen;
import hotel.dao.RegimenDAO;
/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class RegRegimenAction extends ActionSupport implements SessionAware{
  
  private RegimenDAO regimenDAO;
  private Regimen regimen;
  
  private String idRegimen;
  
  private Map<String,Object> sesion;
  
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }

  public RegimenDAO getRegimenDAO() {
    return regimenDAO;
  }

  public void setRegimenDAO(RegimenDAO regimenDAO) {
    this.regimenDAO = regimenDAO;
  }

  public Regimen getRegimen() {
    return regimen;
  }

  public void setRegimen(Regimen regimen) {
    this.regimen = regimen;
  }

  public String getIdRegimen() {
    return idRegimen;
  }

  public void setIdRegimen(String idRegimen) {
    this.idRegimen = idRegimen;
  }
  
  
  public RegRegimenAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    if(regimenDAO.update(regimen)){
      idRegimen = regimen.getIdRegimen();
    }
    
    return SUCCESS;
  }
  
}
