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
import hotel.dao.RegimenDAO;
import hotel.dao.TemporadaDAO;
import hotel.dao.TipoDAO;

import hotel.pojo.Precio;
import hotel.pojo.Regimen;
import hotel.pojo.Temporada;
import hotel.pojo.Tipo;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class GestionPreciosAction extends ActionSupport implements SessionAware{
  private PreciosDAO preciosDAO;
  private TipoDAO tipoDAO;
  private TemporadaDAO temporadaDAO;
  private RegimenDAO regimenDAO;
  private ArrayList<Precio> precios;
  private ArrayList<Tipo> tipos;
  private ArrayList<Temporada> temporadas;
  private ArrayList<Regimen> regimenes;
  
  private Map<String,Object> sesion;
    
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }

  public Map<String,Object> getSesson() {
    return this.sesion;
  }

  public PreciosDAO getPreciosDAO() {
    return preciosDAO;
  }

  public void setPreciosDAO(PreciosDAO preciosDAO) {
    this.preciosDAO = preciosDAO;
  }

  public ArrayList<Precio> getPrecios() {
    return precios;
  }

  public void setPrecios(ArrayList<Precio> precios) {
    this.precios = precios;
  }

  public TipoDAO getTipoDAO() {
    return tipoDAO;
  }

  public void setTipoDAO(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
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

  public ArrayList<Tipo> getTipos() {
    return tipos;
  }

  public void setTipos(ArrayList<Tipo> tipos) {
    this.tipos = tipos;
  }

  public ArrayList<Temporada> getTemporadas() {
    return temporadas;
  }

  public void setTemporadas(ArrayList<Temporada> temporadas) {
    this.temporadas = temporadas;
  }

  public ArrayList<Regimen> getRegimenes() {
    return regimenes;
  }

  public void setRegimenes(ArrayList<Regimen> regimenes) {
    this.regimenes = regimenes;
  }
  
  
  
  public GestionPreciosAction() {
  }
  
  public String execute() throws Exception {
    if(sesion.get("admin") == null) {
      return ERROR;
    }
    precios    = preciosDAO.listaPrecios();
    temporadas = temporadaDAO.listadotemporadas();
    tipos      = tipoDAO.listadotipos();
    regimenes    = regimenDAO.listadoregimen();
    
    return SUCCESS;
  }
  
}
