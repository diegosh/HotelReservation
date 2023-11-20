/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import hotel.dao.PlantaDAO;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class SupPlantaAction extends ActionSupport implements SessionAware{
  
  private int pidPlanta;
  private PlantaDAO plantaDAO;
  
  private int idPlanta;
  
  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }
  

  public int getPidPlanta() {
    return pidPlanta;
  }

  public void setPidPlanta(int pidPlanta) {
    this.pidPlanta = pidPlanta;
  }

  public PlantaDAO getPlantaDAO() {
    return plantaDAO;
  }

  public void setPlantaDAO(PlantaDAO plantaDAO) {
    this.plantaDAO = plantaDAO;
  }

  public int getIdPlanta() {
    return idPlanta;
  }

  public void setIdPlanta(int idPlanta) {
    this.idPlanta = idPlanta;
  }
  
  
  
  public SupPlantaAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    if(plantaDAO.delete(pidPlanta)){
      idPlanta = pidPlanta;
    }
    
    return SUCCESS;
  }
  
}
