/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import hotel.dao.*;
import hotel.pojo.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class GestionHabitacionesAction extends ActionSupport implements SessionAware {
  
  private HabitacionDAO habitacionDAO;
  private List<Habitacion> habitaciones;

  private TipoDAO tipoDAO;
  private PlantaDAO plantaDAO;
  private ArrayList<Tipo> listatipos;
  private ArrayList<Planta> listaplantas;
  private Habitacion habitacion = null;
  
  private Map<String,Object> sesion;
    
    public void setSession(Map<String,Object> sesion) {
      this.sesion = sesion;
    }
  
    public Map<String,Object> getSesson() {
      return this.sesion;
    }
  
  public void setHabitacionDAO(HabitacionDAO habitacionDAO) {
    this.habitacionDAO = habitacionDAO;
  }

  public void setHabitaciones(List<Habitacion> habitaciones) {
    this.habitaciones = habitaciones;
  }

  public List<Habitacion> getHabitaciones() {
    return habitaciones;
  }

  public TipoDAO getTipoDAO() {
    return tipoDAO;
  }

  public void setTipoDAO(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
  }

  public PlantaDAO getPlantaDAO() {
    return plantaDAO;
  }

  public void setPlantaDAO(PlantaDAO plantaDAO) {
    this.plantaDAO = plantaDAO;
  }

  public ArrayList<Tipo> getListatipos() {
    return listatipos;
  }

  public void setListatipos(ArrayList<Tipo> listatipos) {
    this.listatipos = listatipos;
  }

  public ArrayList<Planta> getListaplantas() {
    return listaplantas;
  }

  public void setListaplantas(ArrayList<Planta> listaplantas) {
    this.listaplantas = listaplantas;
  }

  public Habitacion getHabitacion() {
    return habitacion;
  }

  public void setHabitacion(Habitacion habitacion) {
    this.habitacion = habitacion;
  }
  
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
      
    habitaciones = habitacionDAO.listado();
    listatipos = tipoDAO.listadotipos();
    listaplantas = plantaDAO.listadoplanta();
    habitacion = new Habitacion();
    return SUCCESS; 
  }
  
}
