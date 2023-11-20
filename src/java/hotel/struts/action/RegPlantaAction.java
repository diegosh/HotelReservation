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
import hotel.pojo.Planta;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class RegPlantaAction extends ActionSupport implements SessionAware{
  private PlantaDAO plantaDAO;
  private Planta planta;
  private int idPlanta;

  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }
  
  public PlantaDAO getPlantaDAO() {
    return plantaDAO;
  }

  public void setPlantaDAO(PlantaDAO plantaDAO) {
    this.plantaDAO = plantaDAO;
  }

  public Planta getPlanta() {
    return planta;
  }

  public void setPlanta(Planta planta) {
    this.planta = planta;
  }

  public int getIdPlanta() {
    return idPlanta;
  }

  public void setIdPlanta(int idPlanta) {
    this.idPlanta = idPlanta;
  }
  
  
  
  public RegPlantaAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    
    if(planta.getIdPlanta() != null) {
        if(plantaDAO.update(planta)){
          idPlanta = planta.getIdPlanta();
        }
    }
    else
    {
        idPlanta = plantaDAO.save(planta);
    }
    return SUCCESS;
  }
  
}
