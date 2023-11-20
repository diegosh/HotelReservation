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
public class RegTemporadaAction extends ActionSupport implements SessionAware{

    private TemporadaDAO temporadaDAO;
    private Temporada temporada;
    
    private int idTemporada;
    
    private Map<String,Object> sesion;
  
    public void setSession(Map<String,Object> sesion) {
      this.sesion = sesion;
    }
    public Map<String,Object> getSession() {
      return this.sesion;
    }
  

    public TemporadaDAO getTemporadaDAO() {
        return temporadaDAO;
    }

    public void setTemporadaDAO(TemporadaDAO temporadaDAO) {
        this.temporadaDAO = temporadaDAO;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public int getIdTemporada() {
      return idTemporada;
    }

    public void setIdTemporada(int idTemporada) {
      this.idTemporada = idTemporada;
    }
    
    
    
    public RegTemporadaAction() {
    }
    
    public String execute() throws Exception {
      if(sesion.get("admin") == null) {
      return ERROR;
      }
      
      if(temporada.getIdTemporada() !=null) {
          if(temporadaDAO.update(temporada)){
            idTemporada = temporada.getIdTemporada();
          }
      }
      else
      {
          idTemporada = temporadaDAO.save(temporada);
      }
      return SUCCESS;
    }
    
}
