/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import hotel.dao.ClienteDAO;
import hotel.pojo.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.Validateable;


import java.util.Map;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class RegistroClienteAction extends ActionSupport 
        implements SessionAware,Validateable{
  
  private Cliente cliente;          // Datos del formulario
  private ClienteDAO clienteDAO;    // Inyectado por Spring
       
  private Map<String,Object> sesion;
  
  public void setSession(Map<String,Object> sesion){
    this.sesion =sesion;
  }
  public Map<String,Object> getSession(){
    return this.sesion;
  }
  
  public Cliente getCliente() {
    return cliente;
  }
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  public void setClienteDAO(ClienteDAO clienteDAO) {
      this.clienteDAO = clienteDAO;
  }
  
  @Override
 public void validate(){
    if(cliente.getNombre().length()==0){
      addFieldError("cliente.nombre","El campo nombre debe estar relleno");
    }
    if(cliente.getApellidos().length()==0){
      addFieldError("cliente.apellidos","El campo apellidos debe estar relleno");
    }
    if(cliente.getDni().length() == 0){
      addFieldError("cliente.dni","El campo DNI debe estar relleno");
    }
    if(cliente.getClave().length() == 0){
      addFieldError("cliente.clave","El campo clave debe estar relleno");
    }
    if(cliente.getEmail().length()==0){
      addFieldError("cliente.email","El campo email debe estar relleno");
    }
    else if(clienteDAO.emailDuplicado(cliente.getEmail())){
      addFieldError("cliente.email","El email introducido ya existe en nuestra bases de datos");
    }
  }
  public String execute() throws Exception {
    if(clienteDAO.save(cliente) != -1) {
      sesion.put("IdClienteSesion", cliente.getIdCliente());
      sesion.put("clienteSesion",cliente.getNombre() + " " + cliente.getApellidos());
    return SUCCESS;
    }
    else return ERROR;
  }
  
}
