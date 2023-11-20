/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import hotel.dao.HabitacionDAO;
import hotel.dao.TipoDAO;
import hotel.dao.PlantaDAO;
import hotel.pojo.Habitacion;
import hotel.pojo.Tipo;
import hotel.pojo.Planta;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class ModHabitacionAction extends ActionSupport implements SessionAware{
  private HabitacionDAO habitacionDAO;
  private TipoDAO tipoDAO;
  private PlantaDAO plantaDAO;
  private ArrayList<Tipo> listatipos;
  private ArrayList<Planta> listaplantas;
  private Habitacion habitacion = null;
  private int pidHabitacion = -1;

  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }
  
  public HabitacionDAO getHabitacionDAO() {
    return habitacionDAO;
  }

  public void setHabitacionDAO(HabitacionDAO habitacionDAO) {
    this.habitacionDAO = habitacionDAO;
  }

  public Habitacion getHabitacion() {
    return habitacion;
  }

  public void setHabitacion(Habitacion habitacion) {
    this.habitacion = habitacion;
  }

  public int getPidHabitacion() {
    return pidHabitacion;
  }

  public void setPidHabitacion(int pidHabitacion) {
    this.pidHabitacion = pidHabitacion;
  }

  public TipoDAO getTipoDAO() {
    return tipoDAO;
  }

  public void setTipoDAO(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
  }

  public ArrayList<Tipo> getListatipos() {
    return listatipos;
  }

  public void setListatipos(ArrayList<Tipo> listatipos) {
    this.listatipos = listatipos;
  }

  public PlantaDAO getPlantaDAO() {
    return plantaDAO;
  }

  public void setPlantaDAO(PlantaDAO plantaDAO) {
    this.plantaDAO = plantaDAO;
  }

  public ArrayList<Planta> getListaplantas() {
    return listaplantas;
  }

  public void setListaplantas(ArrayList<Planta> listaplantas) {
    this.listaplantas = listaplantas;
  }
  
  
  
  
  public ModHabitacionAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    
    listatipos = tipoDAO.listadotipos();
    listaplantas = plantaDAO.listadoplanta();
    habitacion = habitacionDAO.getHabitacion(pidHabitacion);
    return SUCCESS;
  }
  
}
