/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


import hotel.pojo.Habitacion;
import hotel.pojo.Planta;
import hotel.pojo.Tipo;

import hotel.dao.HabitacionDAO;
import hotel.dao.PlantaDAO;
import hotel.dao.TipoDAO;
/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class RegHabitacionAction extends ActionSupport implements SessionAware{
  private HabitacionDAO habitacionDAO;
  private PlantaDAO plantaDAO;
  private TipoDAO tipoDAO;
  private Habitacion habitacion;
  private Planta planta;
  private Tipo Tipo;
  private int selectPlanta;
  private int selectTipo;
  private int idHabitacion;
  
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

  public PlantaDAO getPlantaDAO() {
    return plantaDAO;
  }

  public void setPlantaDAO(PlantaDAO plantaDAO) {
    this.plantaDAO = plantaDAO;
  }

  public TipoDAO getTipoDAO() {
    return tipoDAO;
  }

  public void setTipoDAO(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
  }

  public Planta getPlanta() {
    return planta;
  }

  public void setPlanta(Planta planta) {
    this.planta = planta;
  }

  public Tipo getTipo() {
    return Tipo;
  }

  public void setTipo(Tipo Tipo) {
    this.Tipo = Tipo;
  }

  public int getSelectPlanta() {
    return selectPlanta;
  }

  public void setSelectPlanta(int selectPlanta) {
    this.selectPlanta = selectPlanta;
  }

  public int getSelectTipo() {
    return selectTipo;
  }

  public void setSelectTipo(int selectTipo) {
    this.selectTipo = selectTipo;
  }

  public int getIdHabitacion() {
    return idHabitacion;
  }

  public void setIdHabitacion(int idHabitacion) {
    this.idHabitacion = idHabitacion;
  }

  public Map<String, Object> getSesion() {
    return sesion;
  }

  public void setSesion(Map<String, Object> sesion) {
    this.sesion = sesion;
  }
  
  
  
  public RegHabitacionAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    
    
    Planta planta = plantaDAO.devPlanta(selectPlanta);
    Tipo tipo     = tipoDAO.devTipo(selectTipo);
    
    habitacion.setPlanta(planta);
    habitacion.setTipo(tipo);
    
    if(habitacion.getIdHabitacion() != null) {
      if(habitacionDAO.update(habitacion)){
        idHabitacion = habitacion.getIdHabitacion();
      };
    }
    else
    {
      idHabitacion = habitacionDAO.save(habitacion);  
    }
    return SUCCESS;
  }
  
}
