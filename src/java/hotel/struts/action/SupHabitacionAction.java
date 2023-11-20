/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


import hotel.dao.HabitacionDAO;
import hotel.pojo.Habitacion;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class SupHabitacionAction extends ActionSupport implements SessionAware{
  private HabitacionDAO habitacionDAO;
  private int pidHabitacion = -1;
  
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

  public int getPidHabitacion() {
    return pidHabitacion;
  }

  public void setPidHabitacion(int pidHabitacion) {
    this.pidHabitacion = pidHabitacion;
  }

  public int getIdHabitacion() {
    return idHabitacion;
  }

  public void setIdHabitacion(int idHabitacion) {
    this.idHabitacion = idHabitacion;
  }
  
  

  public SupHabitacionAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    if(habitacionDAO.delete(pidHabitacion)){
      idHabitacion = pidHabitacion;
    }
    return SUCCESS;
  }
  
}
