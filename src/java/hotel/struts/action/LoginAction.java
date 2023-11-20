/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import hotel.dao.ClienteDAO;
import hotel.pojo.Cliente;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class LoginAction extends ActionSupport implements SessionAware {
  private ClienteDAO clienteDAO;
  private String email;
  private String password;
  private Map<String,Object> sesion;
  
  public void  setSession(Map<String,Object> sesion) {
    this.sesion = sesion;
  }
  public Map<String,Object> getSession() {
    return this.sesion;
  }

  public ClienteDAO getClienteDAO() {
    return clienteDAO;
  }

  public void setClienteDAO(ClienteDAO clienteDAO) {
    this.clienteDAO = clienteDAO;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
  
  public LoginAction() {
  }
  
  public String execute() throws Exception {
    boolean acceso=false;
    //Map sesion = ActionContext.getContext().getSession();
    if(email.equals("admin") && password.equals("admin")){
      sesion.put("admin","admin");
      acceso = true;
    }
    else {
      Cliente cliente = clienteDAO.checkLogin(email, password);
      if(cliente != null) {
        sesion.put("IdClienteSesion",cliente.getIdCliente());
        sesion.put("clienteSesion",cliente.getNombre() + " " + cliente.getApellidos());       
        acceso = true;
      }
      else {
        return INPUT;
      }
    }
   
    return SUCCESS;
  }
  
}
