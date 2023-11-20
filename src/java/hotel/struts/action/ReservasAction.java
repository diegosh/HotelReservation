/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.List;
import java.util.Date;
import java.util.Map;

import hotel.dao.ReservasDAO;
import hotel.pojo.Reserva;
import hotel.util.DateUtil;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class ReservasAction extends ActionSupport implements SessionAware{
  
  private ReservasDAO reservasDAO;
  private List<Reserva> listareservas;
  private String fechaInicio;
  private String fechaFin;
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

    public void setReservasDAO(ReservasDAO reservasDAO) {
        this.reservasDAO = reservasDAO;
    }

    public List<Reserva> getListareservas() {
        return listareservas;
    }

    public void setListareservas(List<Reserva> listareservas) {
        this.listareservas = listareservas;
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
  
    
    
  public ReservasAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    if(fechaInicio != null && fechaFin!=null) {
      Date f1 = DateUtil.ConvertStringtoDate(fechaInicio);
      Date f2 = DateUtil.ConvertStringtoDate(fechaFin);
      listareservas = reservasDAO.ListadoReservas(f1, f2);
    }
    else {
      listareservas = reservasDAO.ListadoReservas();
    }
    
    return SUCCESS;
  }
  
}
