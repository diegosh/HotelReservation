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

import hotel.pojo.Temporada;
import hotel.dao.TemporadaDAO;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class GestionTemporadasAction extends ActionSupport implements SessionAware {
  
  private TemporadaDAO temporadaDAO;
  private ArrayList<Temporada> temporadas;

  private Map<String,Object> sesion;
    
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }

  public Map<String,Object> getSesson() {
    return this.sesion;
  }
    
  public TemporadaDAO getTemporadaDAO() {
    return temporadaDAO;
  }

  public void setTemporadaDAO(TemporadaDAO temporadaDAO) {
    this.temporadaDAO = temporadaDAO;
  }

  public ArrayList<Temporada> getTemporadas() {
    return temporadas;
  }

  public void setTemporadas(ArrayList<Temporada> temporadas) {
    this.temporadas = temporadas;
  }
  
  
  
  public GestionTemporadasAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    temporadas = temporadaDAO.listadotemporadas();
    return SUCCESS;
  }
  
}
