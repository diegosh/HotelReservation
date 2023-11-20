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

import hotel.dao.PreciosDAO;
import hotel.dao.TemporadaDAO;
import hotel.dao.TipoDAO;
import hotel.dao.RegimenDAO;

import hotel.pojo.Precio;
import hotel.pojo.Temporada;
import hotel.pojo.Tipo;
import hotel.pojo.Regimen;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class ModPrecioAction extends ActionSupport implements SessionAware{
  
  private int pidPrecio;
  private Precio precio;
  private PreciosDAO preciosDAO;
  private TemporadaDAO temporadaDAO;
  private RegimenDAO regimenDAO;
  private TipoDAO tipoDAO;
  
  private ArrayList<Temporada> temporadas;
  private ArrayList<Tipo> tipos;
  private ArrayList<Regimen> regimenes;
  
  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }

  public int getPidPrecio() {
    return pidPrecio;
  }

  public void setPidPrecio(int pidPrecio) {
    this.pidPrecio = pidPrecio;
  }

  public Precio getPrecio() {
    return precio;
  }

  public void setPrecio(Precio precio) {
    this.precio = precio;
  }

  public PreciosDAO getPreciosDAO() {
    return preciosDAO;
  }

  public void setPreciosDAO(PreciosDAO preciosDAO) {
    this.preciosDAO = preciosDAO;
  }

  public TemporadaDAO getTemporadaDAO() {
    return temporadaDAO;
  }

  public void setTemporadaDAO(TemporadaDAO temporadaDAO) {
    this.temporadaDAO = temporadaDAO;
  }

  public RegimenDAO getRegimenDAO() {
    return regimenDAO;
  }

  public void setRegimenDAO(RegimenDAO regimenDAO) {
    this.regimenDAO = regimenDAO;
  }

  public ArrayList<Temporada> getTemporadas() {
    return temporadas;
  }

  public void setTemporadas(ArrayList<Temporada> temporadas) {
    this.temporadas = temporadas;
  }

  public ArrayList<Tipo> getTipos() {
    return tipos;
  }

  public void setTipos(ArrayList<Tipo> tipos) {
    this.tipos = tipos;
  }

  public ArrayList<Regimen> getRegimenes() {
    return regimenes;
  }

  public void setRegimenes(ArrayList<Regimen> regimenes) {
    this.regimenes = regimenes;
  }

  public TipoDAO getTipoDAO() {
    return tipoDAO;
  }

  public void setTipoDAO(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
  }
  
  
  
  
  public ModPrecioAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    
    precio = preciosDAO.devPrecio(pidPrecio);
    tipos = tipoDAO.listadotipos();
    regimenes = regimenDAO.listadoregimen();
    temporadas = temporadaDAO.listadotemporadas();
    
    return SUCCESS;
  }
  
}
