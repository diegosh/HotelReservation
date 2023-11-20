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
import hotel.pojo.Planta;
import hotel.dao.PlantaDAO;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class GestionPlantasAction extends ActionSupport implements SessionAware {
  private PlantaDAO plantaDAO;
  private ArrayList<Planta> plantas;
  private Planta planta;
  
  private Map<String,Object> sesion;
    
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }

  public Map<String,Object> getSesson() {
    return this.sesion;
  }
  
  public GestionPlantasAction() {
  }

  public PlantaDAO getPlantaDAO() {
    return plantaDAO;
  }

  public void setPlantaDAO(PlantaDAO plantaDAO) {
    this.plantaDAO = plantaDAO;
  }

  public ArrayList<Planta> getPlantas() {
    return plantas;
  }

  public void setPlantas(ArrayList<Planta> plantas) {
    this.plantas = plantas;
  }

  public Planta getPlanta() {
    return planta;
  }

  public void setPlanta(Planta planta) {
    this.planta = planta;
  }
  
  
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    plantas = plantaDAO.listadoplanta();
    planta = new Planta();
    return SUCCESS;
  }
  
}
