/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import hotel.dao.PlantaDAO;
import hotel.pojo.Planta;

import java.util.Map;


/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class ModPlantaAction extends ActionSupport implements SessionAware{
  
  private int pidPlanta;
  private Planta planta;
  private PlantaDAO plantaDAO;

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

  public Planta getPlanta() {
    return planta;
  }

  public void setPlanta(Planta planta) {
    this.planta = planta;
  }

  public PlantaDAO getPlantaDAO() {
    return plantaDAO;
  }

  public void setPlantaDAO(PlantaDAO plantaDAO) {
    this.plantaDAO = plantaDAO;
  }
  
  
  
  public ModPlantaAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    
    planta = plantaDAO.devPlanta(pidPlanta);
    return SUCCESS;
  }
  
}
