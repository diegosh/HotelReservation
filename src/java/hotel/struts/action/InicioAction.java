/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.dao.*;
import hotel.pojo.*;
import hotel.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Date;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class InicioAction extends ActionSupport {
  
  private RegimenDAO regimenDAO;
  private ArrayList<Regimen> listaregimen;
  private TipoDAO selectTipoDAO;
  private ArrayList<Tipo> listatipos;
  private EdadDAO edadDAO;
  private ArrayList<Edad> listaedad;
  private PaxDAO paxDAO;
  private ArrayList<Pax> listapax;
  private String fechaInicio;
  private String fechaFin;
  private int selectTipo;
  private HabitacionDAO habitacionDAO;
  private int disponibles;
  private int IdTipo;
  private PreciosDAO preciosDAO;
  private TemporadaDAO temporadaDAO;
  private ArrayList<Precio> listaprecios;
  private Tipo tipo;
  private int noches =1;

  public TipoDAO getSelectTipoDAO() {
    return selectTipoDAO;
  }

  public String getFechaInicio() {
    return fechaInicio;
  }

  public String getFechaFin() {
    return fechaFin;
  }

  public int getSelectTipo() {
    return selectTipo;
  }

  public void setSelectTipoDAO(TipoDAO selectTipoDAO) {
    this.selectTipoDAO = selectTipoDAO;
  }

  public void setFechaInicio(String fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public void setFechaFin(String fechaFin) {
    this.fechaFin = fechaFin;
  }

  public void setSelectTipo(int selectTipo) {
    this.selectTipo = selectTipo;
  }
  
  public void setDisponibles(int disponibles) {
    this.disponibles = disponibles;
  }
  
  public int getDisponibles() {
    return disponibles;
  }
  

  public void setEdadDAO(EdadDAO edadDAO) {
    this.edadDAO = edadDAO;
  }

  public void setListaedad(ArrayList<Edad> listaedad) {
    this.listaedad = listaedad;
  }

  public void setPaxDAO(PaxDAO paxDAO) {
    this.paxDAO = paxDAO;
  }

  public void setListapax(ArrayList<Pax> listapax) {
    this.listapax = listapax;
  }

  public EdadDAO getEdadDAO() {
    return edadDAO;
  }

  public ArrayList<Edad> getListaedad() {
    return listaedad;
  }

  public PaxDAO getPaxDAO() {
    return paxDAO;
  }

  public ArrayList<Pax> getListapax() {
    return listapax;
  }
  

  public TipoDAO getTipoDAO() {
    return selectTipoDAO;
  }

  public ArrayList<Tipo> getListatipos() {
    return listatipos;
  }

  public void setTipoDAO(TipoDAO selectTipoDAO) {
    this.selectTipoDAO = selectTipoDAO;
  }

  public void setListatipos(ArrayList<Tipo> listatipos) {
    this.listatipos = listatipos;
  }
  
  
  public void setRegimenDAO(RegimenDAO regimenDAO) {
    this.regimenDAO = regimenDAO;
  }

  public void setListaregimen(ArrayList<Regimen> listaregimen) {
    this.listaregimen = listaregimen;
  }

  public RegimenDAO getRegimenDAO() {
    return regimenDAO;
  }

  public ArrayList<Regimen> getListaregimen() {
    return listaregimen;
  }

  public HabitacionDAO getHabitacionDAO() {
    return habitacionDAO;
  }

  public void setHabitacionDAO(HabitacionDAO habitacionDAO) {
    this.habitacionDAO = habitacionDAO;
  }

  public PreciosDAO getPreciosDAO() {
    return preciosDAO;
  }

  public ArrayList<Precio> getListaprecios() {
    return listaprecios;
  }

  public void setPreciosDAO(PreciosDAO preciosDAO) {
    this.preciosDAO = preciosDAO;
  }

  public void setListaprecios(ArrayList<Precio> listaprecios) {
    this.listaprecios = listaprecios;
  }

  public int getIdTipo() {
    return IdTipo;
  }

  public void setIdTipo(int IdTipo) {
    this.IdTipo = IdTipo;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public int getNoches() {
    return noches;
  }

  public void setNoches(int noches) {
    this.noches = noches;
  }

    public TemporadaDAO getTemporadaDAO() {
        return temporadaDAO;
    }

    public void setTemporadaDAO(TemporadaDAO temporadaDAO) {
        this.temporadaDAO = temporadaDAO;
    }
  
  
  
  public String execute() throws Exception {
    listaregimen = regimenDAO.listadoregimen();
    listatipos = selectTipoDAO.listadotipos();
    listaedad  = edadDAO.listadoedad();
    listapax   = paxDAO.listadopax();
    Date entrada = null;
    Date salida = null;
      if(fechaInicio!=null && fechaFin!=null) {
        entrada = DateUtil.ConvertStringtoDate(fechaInicio);
        salida = DateUtil.ConvertStringtoDate(fechaFin);
    }
    else
    {
        Calendar ce = Calendar.getInstance();
        Calendar cs = Calendar.getInstance();
        cs.add(Calendar.DAY_OF_MONTH,1);
        entrada = ce.getTime();
        salida = cs.getTime();
    }
    if(fechaFin==null) {
        Calendar fs = Calendar.getInstance();
        fechaFin = String.valueOf(fs.get(Calendar.DAY_OF_MONTH)+1) + "/" 
                + String.valueOf((fs.get(Calendar.MONTH)+1))  + "/" 
                + String.valueOf(fs.get(Calendar.YEAR));
    }
    disponibles = habitacionDAO.numHabDisponibles(entrada, salida, selectTipo);
    listaprecios = preciosDAO.listaPreciosTemporada(temporadaDAO.getTemporada(salida), selectTipo);
    tipo = selectTipoDAO.devTipo(selectTipo);
    if(tipo!=null) {
      IdTipo = tipo.getIdTipo();
    }
    if(entrada!=null && salida!=null) {
      noches = DateUtil.diasEntreFechas(entrada, salida);
    }
    else {
      noches = 1;
    }
    
    return SUCCESS;
  }
  
}
