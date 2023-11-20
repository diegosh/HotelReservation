/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Map;
import hotel.dao.*;
import hotel.pojo.*;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class ConfirmarAction extends ActionSupport implements SessionAware {
  
  public ConfirmarAction() {
  }
  private Map<String,Object> sesion;
  private RegimenDAO regimenDAO;
  private TipoDAO selectTipoDAO;
  private EdadDAO edadDAO;
  private PaxDAO paxDAO;
  private ClienteDAO clienteDAO;
  private TipoDAO tipoDAO;
  
  private String cFechaEntrada;
  private String cFechaSalida;
  private int cTipo;
  private String cPAX;
  private String cEdad1;
  private String cEdad2;
  private String cEdad3;
  private String cRegimen;
  private double cTotalConIVA;
  
  private Cliente cliente;
  private String cTipodesc;
  private String cPAXdesc;
  private String cEdad1desc;
  private String cEdad2desc;
  private String cEdad3desc;
  private String cRegimendesc;
  
  private ArrayList<Tipo> listatipos;
  private ArrayList<Pax> listapax;
  private ArrayList<Edad> listaedad1;
  private ArrayList<Edad> listaedad2;
  private ArrayList<Edad> listaedad3;
  private ArrayList<Regimen> listaregimenes;
  

  public void setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  
  public Map<String,Object> getSesson() {
    return this.sesion;
  }
  // Getter and setter methods must follow Camel conventions
  // getCRegimen 
  
  public RegimenDAO getRegimenDAO() {
    return regimenDAO;
  }

  public void setRegimenDAO(RegimenDAO regimenDAO) {
    this.regimenDAO = regimenDAO;
  }

  public TipoDAO getSelectTipoDAO() {
    return selectTipoDAO;
  }

  public void setSelectTipoDAO(TipoDAO selectTipoDAO) {
    this.selectTipoDAO = selectTipoDAO;
  }

  public EdadDAO getEdadDAO() {
    return edadDAO;
  }

  public void setEdadDAO(EdadDAO edadDAO) {
    this.edadDAO = edadDAO;
  }

  public PaxDAO getPaxDAO() {
    return paxDAO;
  }

  public void setPaxDAO(PaxDAO paxDAO) {
    this.paxDAO = paxDAO;
  }

  public ClienteDAO getClienteDAO() {
    return clienteDAO;
  }

  public void setClienteDAO(ClienteDAO clienteDAO) {
    this.clienteDAO = clienteDAO;
  }

  public String getCFechaEntrada() {
    return cFechaEntrada;
  }

  public void setCFechaEntrada(String cFechaEntrada) {
    this.cFechaEntrada = cFechaEntrada;
  }

  public String getCFechaSalida() {
    return cFechaSalida;
  }

  public void setCFechaSalida(String cFechaSalida) {
    this.cFechaSalida = cFechaSalida;
  }

  public int getCTipo() {
    return cTipo;
  }

  public void setCTipo(int cTipo) {
    this.cTipo = cTipo;
  }

  public String getCPAX() {
    return cPAX;
  }

  public void setCPAX(String cPAX) {
    this.cPAX = cPAX;
  }

  public String getCEdad1() {
    return cEdad1;
  }

  public void setCEdad1(String cEdad1) {
    this.cEdad1 = cEdad1;
  }

  public String getCEdad2() {
    return cEdad2;
  }

  public void setCEdad2(String cEdad2) {
    this.cEdad2 = cEdad2;
  }

  public String getCEdad3() {
    return cEdad3;
  }

  public void setCEdad3(String cEdad3) {
    this.cEdad3 = cEdad3;
  }

  public String getCRegimen() {
    return cRegimen;
  }

  public void setCRegimen(String cRegimen) {
    this.cRegimen = cRegimen;
  }

  public double getCTotalConIVA() {
    return cTotalConIVA;
  }

  public void setCTotalConIVA(double cTotalConIVA) {
    this.cTotalConIVA = cTotalConIVA;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public String getCTipodesc() {
    return cTipodesc;
  }

  public void setCTipodesc(String cTipodesc) {
    this.cTipodesc = cTipodesc;
  }

  public String getCPAXdesc() {
    return cPAXdesc;
  }

  public void setCPAXdesc(String cPAXdesc) {
    this.cPAXdesc = cPAXdesc;
  }

  public String getCEdad1desc() {
    return cEdad1desc;
  }

  public void setCEdad1desc(String cEdad1desc) {
    this.cEdad1desc = cEdad1desc;
  }

  public String getCEdad2desc() {
    return cEdad2desc;
  }

  public void setCEdad2desc(String cEdad2desc) {
    this.cEdad2desc = cEdad2desc;
  }

  public String getCEdad3desc() {
    return cEdad3desc;
  }

  public void setCEdad3desc(String cEdad3desc) {
    this.cEdad3desc = cEdad3desc;
  }

  public String getCRegimendesc() {
    return cRegimendesc;
  }

  public void setCRegimendesc(String cRegimendesc) {
    this.cRegimendesc = cRegimendesc;
  }

  public TipoDAO getTipoDAO() {
    return tipoDAO;
  }

  public void setTipoDAO(TipoDAO tipoDAO) {
    this.tipoDAO = tipoDAO;
  }

    public ArrayList<Tipo> getListatipos() {
        return listatipos;
    }

    public void setListatipos(ArrayList<Tipo> listatipos) {
        this.listatipos = listatipos;
    }

    public ArrayList<Pax> getListapax() {
        return listapax;
    }

    public void setListapax(ArrayList<Pax> listapax) {
        this.listapax = listapax;
    }

    public ArrayList<Edad> getListaedad1() {
        return listaedad1;
    }

    public void setListaedad1(ArrayList<Edad> listaedad1) {
        this.listaedad1 = listaedad1;
    }

    public ArrayList<Edad> getListaedad2() {
        return listaedad2;
    }

    public void setListaedad2(ArrayList<Edad> listaedad2) {
        this.listaedad2 = listaedad2;
    }

    public ArrayList<Edad> getListaedad3() {
        return listaedad3;
    }

    public void setListaedad3(ArrayList<Edad> listaedad3) {
        this.listaedad3 = listaedad3;
    }

    public ArrayList<Regimen> getListaregimenes() {
        return listaregimenes;
    }

    public void setListaregimenes(ArrayList<Regimen> listaregimenes) {
        this.listaregimenes = listaregimenes;
    }
 
  public String execute() throws Exception {
    
    cRegimendesc = regimenDAO.regimen(cRegimen);
    listaregimenes = regimenDAO.listadoregimen();
    cTipodesc = tipoDAO.tipo(cTipo);
    listatipos = tipoDAO.listadotipos();
    cPAXdesc  = paxDAO.pax(cPAX);
    listapax = paxDAO.listadopax();
    cEdad1desc = edadDAO.edad(cEdad1);
    listaedad1 = edadDAO.listadoedad();
    cEdad2desc = edadDAO.edad(cEdad2);
    listaedad2 = edadDAO.listadoedad();
    cEdad3desc = edadDAO.edad(cEdad3);
    listaedad3 = edadDAO.listadoedad();
    
    // Comprobamos si el cliente esta ya logado para cargar el objeto Cliente desde la sesión.
    //Map sesion = ActionContext.getContext().getSession();
    if(sesion.get("IdClienteSesion")!=null) {
        int idCliente = (Integer)sesion.get("IdClienteSesion");
        cliente = clienteDAO.getCliente(idCliente);
    }
     
    return SUCCESS;
  }
  
}
