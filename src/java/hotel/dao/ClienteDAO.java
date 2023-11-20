/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
import hotel.pojo.*;
import org.hibernate.*;
/*import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;*/
import hotel.hibernate.util.*;
import hotel.hibernate.util.HibernateUtil;
import java.util.List;

public class ClienteDAO {
  public int save(Cliente cliente)  throws Exception {
    int Id =-1;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null; boolean acceso = false;
    try{
      tx = session.beginTransaction();
            
                session.save(cliente);
                Id = cliente.getIdCliente();
                 tx.commit();
            }catch (HibernateException e) {
              e.printStackTrace();
              if (tx!=null) tx.rollback(); 
            }
            finally { session.close(); }
            return Id;
        }
  public boolean update(Cliente cliente) throws Exception {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      sesion.update(cliente);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
  }
  public Cliente checkLogin(String email,String password) {
    Cliente cliente = null;
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    
    try {
      tx = session.beginTransaction();
      String hql = "from Cliente WHERE email=:email AND clave=:clave";
      
      Query query = session.createQuery(hql);
      query.setParameter("email",email);
      query.setParameter("clave",password);
      List clientes = query.list(); 
      if(clientes.size() > 0) {
        cliente = (Cliente)clientes.get(0);
      }
      tx.commit();
    }
    catch(HibernateException e){
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally {session.close();}
    
    return cliente;
  }
  
  public Cliente getCliente(int IdCliente) {
    Cliente cliente = null;
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    
    try {
      tx = session.beginTransaction();
      String hql = "from Cliente WHERE idCliente=:IdCliente";
      
      Query query = session.createQuery(hql);
      query.setParameter("IdCliente",IdCliente);
      List clientes = query.list();
      if(clientes.size()>0) {
        cliente = (Cliente)clientes.get(0);
      }
      tx.commit();
    }
    catch(HibernateException e){
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally {session.close();}
    
    return cliente;
  }
  
  public boolean emailDuplicado(String email) {
    boolean existe = false;
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    
    try {
      tx = session.beginTransaction();
      String hql = "from Cliente WHERE email=:email";
      
      Query query = session.createQuery(hql);
      query.setParameter("email",email);
      List clientes = query.list();
      existe = clientes.size()>0;
      tx.commit();
    }
    catch(HibernateException e){
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally {session.close();}
    
    return existe;
  }
}
