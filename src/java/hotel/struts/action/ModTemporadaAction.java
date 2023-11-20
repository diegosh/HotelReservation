/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import hotel.dao.TemporadaDAO;
import hotel.pojo.Temporada;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class ModTemporadaAction extends ActionSupport implements SessionAware{
  
  private int pidTemporada;
  private Temporada temporada;
  private TemporadaDAO temporadaDAO;
  
  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }

  public int getPidTemporada() {
    return pidTemporada;
  }

  public void setPidTemporada(int pidTemporada) {
    this.pidTemporada = pidTemporada;
  }

  public Temporada getTemporada() {
    return temporada;
  }

  public void setTemporada(Temporada temporada) {
    this.temporada = temporada;
  }

  public TemporadaDAO getTemporadaDAO() {
    return temporadaDAO;
  }

  public void setTemporadaDAO(TemporadaDAO temporadaDAO) {
    this.temporadaDAO = temporadaDAO;
  }
  
  
  
  public ModTemporadaAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    
    temporada = temporadaDAO.devTemporada(pidTemporada);
    return SUCCESS;
  }
  
}
