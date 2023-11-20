/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import hotel.pojo.Tipo;
import hotel.dao.TipoDAO;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class ModTipoAction extends ActionSupport implements SessionAware{
  
  private int pidTipo;
  private Tipo tipo;
  private TipoDAO tipoDAO;
  
  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }
  

  public int getPidTipo() {
    return pidTipo;
  }

  public void setPidTipo(int pidTipo) {
    this.pidTipo = pidTipo;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public TipoDAO getTipoDAO() {
    return tipoDAO;
  }

  public void setTipoDAO(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
  }
  
  
  
  public ModTipoAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    
    tipo = tipoDAO.devTipo(pidTipo);
    return SUCCESS;
  }
  
}
