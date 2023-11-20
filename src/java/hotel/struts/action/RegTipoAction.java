/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


import hotel.dao.TipoDAO;
import hotel.pojo.Tipo;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class RegTipoAction extends ActionSupport implements SessionAware{
    private TipoDAO tipoDAO;
    private Tipo tipo;
    private int idTipo;
    
    private Map<String,Object> sesion;
  
    public void setSession(Map<String,Object> sesion) {
      this.sesion = sesion;
    }
    public Map<String,Object> getSession() {
      return this.sesion;
    }

    public TipoDAO getTipoDAO() {
        return tipoDAO;
    }

    public void setTipoDAO(TipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getIdTipo() {
      return idTipo;
    }

    public void setIdTipo(int idTipo) {
      this.idTipo = idTipo;
    }
    
    
    
    public RegTipoAction() {
    }
    
    public String execute() throws Exception {
      if(sesion.get("admin") == null) {
        return ERROR;
      }
      if(tipo.getIdTipo() != null) {
        if(tipoDAO.update(tipo)){
          idTipo = tipo.getIdTipo();
        }
      }
      else{
        idTipo = tipoDAO.save(tipo);
      }
        return SUCCESS;
    }
    
}
