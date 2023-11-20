/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import hotel.dao.PreciosDAO;
import hotel.dao.TipoDAO;
import hotel.dao.RegimenDAO;
import hotel.dao.TemporadaDAO;

import hotel.pojo.Precio;
import hotel.pojo.Tipo;
import hotel.pojo.Regimen;
import hotel.pojo.Temporada;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class RegPrecioAction extends ActionSupport implements SessionAware{
  
  private PreciosDAO preciosDAO;
  private TemporadaDAO temporadaDAO;
  private RegimenDAO regimenDAO;
  private TipoDAO tipoDAO;

  private Precio precio;
  private Tipo tipo;
  private Regimen regimen;
  private Temporada temporada;
  
  private int selectTemporada;
  private int selectTipo;
  private String selectRegimen;
  
  private int idPrecio;
  
  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
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

    public TipoDAO getTipoDAO() {
        return tipoDAO;
    }

    public void setTipoDAO(TipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public int getSelectTemporada() {
        return selectTemporada;
    }

    public void setSelectTemporada(int selectTemporada) {
        this.selectTemporada = selectTemporada;
    }

    public int getSelectTipo() {
        return selectTipo;
    }

    public void setSelectTipo(int selectTipo) {
        this.selectTipo = selectTipo;
    }

    public String getSelectRegimen() {
        return selectRegimen;
    }

    public void setSelectRegimen(String selectRegimen) {
        this.selectRegimen = selectRegimen;
    }

  public int getIdPrecio() {
    return idPrecio;
  }

  public void setIdPrecio(int idPrecio) {
    this.idPrecio = idPrecio;
  }
    
  
  
  
    public RegPrecioAction() {
    }
    
    public String execute() throws Exception {
      if(sesion.get("admin") == null) {
      return ERROR;
      }
      
        Temporada temporada = temporadaDAO.devTemporada(selectTemporada);
        Tipo tipo = tipoDAO.devTipo(selectTipo);
                
        precio.setTipo(tipo);
        precio.setIdRegimen(selectRegimen);
        precio.setTemporada(temporada);
        
        if(precio.getIdPrecio() != null) {
            if(preciosDAO.update(precio)) {
             idPrecio = precio.getIdPrecio();
            }
        }
        else
        {
            idPrecio = preciosDAO.save(precio);
        }
        return SUCCESS;
    }
    
}
