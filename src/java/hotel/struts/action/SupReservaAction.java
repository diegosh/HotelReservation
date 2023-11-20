/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import java.util.ArrayList;

import hotel.util.DateUtil;
import hotel.dao.ReservasDAO;
import hotel.dao.OcupacionDAO;
import hotel.pojo.Reserva;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class SupReservaAction extends ActionSupport implements SessionAware{
  private ReservasDAO reservasDAO;
  private OcupacionDAO ocupacionDAO;
  private int pidReserva = -1;
  
  private int idReserva;
  
  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }
  

  public ReservasDAO getReservasDAO() {
    return reservasDAO;
  }

  public void setReservasDAO(ReservasDAO reservaDAO) {
    this.reservasDAO = reservaDAO;
  }

  public int getPidReserva() {
    return pidReserva;
  }

  public void setPidReserva(int pidReserva) {
    this.pidReserva = pidReserva;
  }

    public OcupacionDAO getOcupacionDAO() {
        return ocupacionDAO;
    }

    public void setOcupacionDAO(OcupacionDAO ocupacionDAO) {
        this.ocupacionDAO = ocupacionDAO;
    }

  public int getIdReserva() {
    return idReserva;
  }

  public void setIdReserva(int idReserva) {
    this.idReserva = idReserva;
  }

  
  public SupReservaAction() {
  }
  
  
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    
    
    Reserva reserva = reservasDAO.getReserva(pidReserva);
    if(reserva!=null) {
        int idHabitacion = reserva.getHabitacion().getIdHabitacion();
        ArrayList<Date> fechasReserva = DateUtil.fechasEntreFechas(reserva.getFechaEntrada(), reserva.getFechaSalida());
        Iterator it = fechasReserva.iterator();
        while(it.hasNext()) {
            Date fecha = (Date)it.next();
            ocupacionDAO.delete(idHabitacion,fecha);
        }
    }
    if(reservasDAO.delete(pidReserva)) {
      idReserva = pidReserva;
    }
    
    return SUCCESS;
  }
  
}
