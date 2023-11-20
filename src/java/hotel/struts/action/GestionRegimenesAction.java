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

import hotel.dao.RegimenDAO;
import hotel.pojo.Regimen;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class GestionRegimenesAction extends ActionSupport implements SessionAware{
  
  private RegimenDAO regimenDAO;
  private ArrayList<Regimen> regimenes;

  private Map<String,Object> sesion;
    
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }

  public Map<String,Object> getSesson() {
    return this.sesion;
  }
    
  public RegimenDAO getRegimenDAO() {
    return regimenDAO;
  }

  public void setRegimenDAO(RegimenDAO regimenDAO) {
    this.regimenDAO = regimenDAO;
  }

  public ArrayList<Regimen> getRegimenes() {
    return regimenes;
  }

  public void setRegimenes(ArrayList<Regimen> regimenes) {
    this.regimenes = regimenes;
  }
  
  
  
  public GestionRegimenesAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    regimenes = regimenDAO.listadoregimen();
    return SUCCESS;
  }
  
}
