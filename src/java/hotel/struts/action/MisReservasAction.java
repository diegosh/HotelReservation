/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import hotel.dao.*;
import hotel.pojo.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;
import java.util.List;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class MisReservasAction extends ActionSupport implements SessionAware {
  
 private ReservasDAO reservasDAO;
 private List<Reserva> misreservas;
 private Map<String,Object> sesion;
 
 public void setSession(Map<String,Object> sesion) {
   this.sesion = sesion;
 }
 public Map<String,Object> getSession() {
   return this.sesion;
 }

  public void setMisreservas(List<Reserva> misreservas) {
    this.misreservas = misreservas;
  }

  public void setReservasDAO(ReservasDAO reservasDAO) {
    this.reservasDAO = reservasDAO;
  }

  public ReservasDAO getReservasDAO() {
    return reservasDAO;
  }

  public List<Reserva> getMisreservas() {
    return misreservas;
  }
 
  
  public String execute() throws Exception {
    if(sesion.get("IdClienteSesion") != null) {
        int IdCliente = (Integer)sesion.get("IdClienteSesion");
        misreservas = reservasDAO.misReservas(IdCliente);
        return SUCCESS;
    }
    else {
      return ERROR;
    }
  }
  
}
