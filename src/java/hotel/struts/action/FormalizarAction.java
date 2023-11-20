/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Date;
import java.util.ArrayList; 
import java.util.Iterator;
import java.util.Map;

import hotel.util.DateUtil;
import hotel.dao.ClienteDAO;
import hotel.dao.HabitacionDAO;
import hotel.dao.EdadDAO;
import hotel.dao.PaxDAO;
import hotel.dao.RegimenDAO;
import hotel.dao.ReservasDAO;
import hotel.dao.TipoDAO;
import hotel.dao.PreciosDAO;
import hotel.dao.OcupacionDAO;
import hotel.dao.TemporadaDAO;

import hotel.pojo.Cliente;
import hotel.pojo.Edad;
import hotel.pojo.Habitacion;
import hotel.pojo.Ocupacion;
import hotel.pojo.OcupacionId;
import hotel.pojo.Pax;
import hotel.pojo.Regimen;
import hotel.pojo.Tipo;
import hotel.pojo.Reserva;

public class FormalizarAction extends ActionSupport implements SessionAware {

  
    private ClienteDAO clienteDAO;
    private HabitacionDAO habitacionDAO;
    private EdadDAO edadDAO;
    private PaxDAO paxDAO;
    private RegimenDAO regimenDAO;
    private ReservasDAO reservasDAO;
    private TipoDAO tipoDAO;
    private PreciosDAO preciosDAO;
    private OcupacionDAO ocupacionDAO;
    private TemporadaDAO temporadaDAO;

    private Cliente cliente;
    private Edad edad1;
    private Edad edad2;
    private Edad edad3;
    private Habitacion habitacion;    
    private Pax pax;
    private Regimen regimen;
    private Tipo tipo;
    private Reserva reserva;

    private String cFechaEntrada;
    private String cFechaSalida;
    private int cTipo;
    private String cPAX;
    private String cEdad1;
    private String cEdad2;
    private String cEdad3;
    private String cRegimen;
    private double cTotalConIVA;
    
    private Map<String,Object> sesion;
    
    public void setSession(Map<String,Object> sesion) {
      this.sesion = sesion;
    }
  
    public Map<String,Object> getSesson() {
      return this.sesion;
    }
    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public HabitacionDAO getHabitacionDAO() {
        return habitacionDAO;
    }

    public void setHabitacionDAO(HabitacionDAO habitacionDAO) {
        this.habitacionDAO = habitacionDAO;
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

    public RegimenDAO getRegimenDAO() {
        return regimenDAO;
    }

    public void setRegimenDAO(RegimenDAO regimenDAO) {
        this.regimenDAO = regimenDAO;
    }

    public ReservasDAO getReservasDAO() {
        return reservasDAO;
    }

    public void setReservasDAO(ReservasDAO reservasDAO) {
        this.reservasDAO = reservasDAO;
    }

    public TipoDAO getTipoDAO() {
        return tipoDAO;
    }

    public void setTipoDAO(TipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Edad getEdad1() {
        return edad1;
    }

    public void setEdad1(Edad edad1) {
        this.edad1 = edad1;
    }

    public Edad getEdad2() {
        return edad2;
    }

    public void setEdad2(Edad edad2) {
        this.edad2 = edad2;
    }

    public Edad getEdad3() {
        return edad3;
    }

    public void setEdad3(Edad edad3) {
        this.edad3 = edad3;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Pax getPax() {
        return pax;
    }

    public void setPax(Pax pax) {
        this.pax = pax;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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

    public double getCTotalConIVA() {
        return cTotalConIVA;
    }

    public void setCTotalConIVA(double cTotalConIVA) {
        this.cTotalConIVA = cTotalConIVA;
    }

    public PreciosDAO getPreciosDAO() {
        return preciosDAO;
    }

    public void setPreciosDAO(PreciosDAO preciosDAO) {
        this.preciosDAO = preciosDAO;
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

    public OcupacionDAO getOcupacionDAO() {
        return ocupacionDAO;
    }

    public void setOcupacionDAO(OcupacionDAO ocupacionDAO) {
        this.ocupacionDAO = ocupacionDAO;
    }

    public TemporadaDAO getTemporadaDAO() {
        return temporadaDAO;
    }

    public void setTemporadaDAO(TemporadaDAO temporadaDAO) {
        this.temporadaDAO = temporadaDAO;
    }

    

    
    
    public FormalizarAction() {
    }
    
  
    private void confirmaPrecio(Date entrada,Date salida) {
      //Confirmamos lo datos del precio antes de grabar la reserva ylo mofica si este no esta correcto.
      double precio = preciosDAO.precio(temporadaDAO.getTemporada(salida), cTipo, cRegimen);
      double total = 0;
      int noches = 0 ;
      if(entrada!=null && salida!=null) {
        noches = DateUtil.diasEntreFechas(entrada, salida);
      }
      else {
        noches = 1;
      }
      if(precio > 0) {
        total = precio * noches;
      }
      cTotalConIVA = total;
    }
    public String execute() throws Exception {
        Date entrada = DateUtil.ConvertStringtoDate(cFechaEntrada);
        Date salida = DateUtil.ConvertStringtoDate(cFechaSalida);
        
        confirmaPrecio(entrada,salida);
        reserva = new Reserva();
        regimen = regimenDAO.devRegimen(cRegimen);
        tipo = tipoDAO.devTipo(cTipo);
        habitacion = habitacionDAO.HabDisponible(entrada, salida, cTipo);
        if(cliente != null && cliente.getIdCliente()!=null) {
          clienteDAO.update(cliente);
        }
        else
        {
          if(clienteDAO.save(cliente)==-1)
          {
            //Si ha fallado el proceso de registro abortamos la reserva.
            return INPUT;
          };
          //Añadimos los datos del cliente a la sesion
          
          sesion.put("IdClienteSesion",cliente.getIdCliente());
          sesion.put("clienteSesion", cliente.getNombre() + " " + cliente.getApellidos());
          
        }
        pax = paxDAO.getPax(cPAX);
        reserva.setCliente(cliente);
        reserva.setEdadN1(cEdad1);
        reserva.setEdadN2(cEdad2);
        reserva.setEdadN3(cEdad3);
        reserva.setPax(pax);
        reserva.setRegimen(regimen);
        reserva.setFechaEntrada(entrada);
        reserva.setFechaSalida(salida);
        reserva.setHabitacion(habitacion);
        reserva.setTipo(tipo);
        reserva.setTotalconIva(cTotalConIVA);
        reserva.setConfirmada(true);
        
        reservasDAO.save(reserva);
        
        ArrayList<Date> fechasReserva = DateUtil.fechasEntreFechas(entrada, salida);
        
        Iterator it = fechasReserva.iterator();
        while(it.hasNext()) {
            Date fecha = (Date)it.next();
            ocupacionDAO.save(new Ocupacion(new OcupacionId(habitacion.getIdHabitacion(),fecha),habitacion));
        }
        return SUCCESS;
    }
    
}
