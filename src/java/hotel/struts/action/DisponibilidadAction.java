/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

import hotel.dao.HabitacionDAO;
import hotel.pojo.Habitacion;
import hotel.util.DateUtil;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class DisponibilidadAction extends ActionSupport {
  
  private HabitacionDAO habitacionDAO;
  private ArrayList<Habitacion> habitaciones;
  private String fechaInicio;
  private String fechaFin;

  public HabitacionDAO getHabitacionDAO() {
    return habitacionDAO;
  }

  public void setHabitacionDAO(HabitacionDAO habitacionDAO) {
    this.habitacionDAO = habitacionDAO;
  }

  public ArrayList<Habitacion> getHabitaciones() {
    return habitaciones;
  }

  public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
    this.habitaciones = habitaciones;
  }

  public String getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(String fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public String getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(String fechaFin) {
    this.fechaFin = fechaFin;
  }
  
  
  
  public DisponibilidadAction() {
  }
  
  public String execute() throws Exception {
    Date entrada = null;
    Date salida = null;
      if(fechaInicio!=null && fechaFin!=null) {
        entrada = DateUtil.ConvertStringtoDate(fechaInicio);
        salida = DateUtil.ConvertStringtoDate(fechaFin);
    }
    else
    {
        Calendar ce = Calendar.getInstance();
        Calendar cs = Calendar.getInstance();
        cs.add(Calendar.DAY_OF_MONTH,1);
        entrada = ce.getTime();
        salida = cs.getTime();
    }
    habitaciones = habitacionDAO.HabDisponibles(entrada, salida);
    return SUCCESS;
  }
  
}
