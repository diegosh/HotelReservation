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

import hotel.hibernate.util.HibernateUtil;
import hotel.pojo.*;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.List;
import org.hibernate.criterion.Property;

public class TipoDAO {
  public ArrayList<Tipo> listadotipos() throws Exception {
  
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    ArrayList<Tipo> listatipos = new ArrayList<Tipo>();
    try {
      tx = session.beginTransaction();
      String query = "from Tipo";  
      listatipos = (ArrayList<Tipo>)session.createQuery(query).list();

      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }


    return listatipos;
  }
  
  public String tipo(int IdTipo) throws Exception {
  
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    ArrayList<Tipo> listatipo = new ArrayList<Tipo>();
    String tipo ="";
    try {
      tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Tipo.class);
      criteria.add(Property.forName("idTipo").eq(IdTipo));
      listatipo = (ArrayList<Tipo>)criteria.list();
      if(listatipo.size() >0){
        Tipo tipo1 = (Tipo)listatipo.get(0);
        tipo = tipo1.getTipo();
      }
      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }


    return tipo;
    }
  
  public Tipo devTipo(int IdTipo) throws Exception {
  
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    ArrayList<Tipo> listatipo = new ArrayList<Tipo>();
    Tipo tipo =null;
    try {
      tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Tipo.class);
      criteria.add(Property.forName("idTipo").eq(IdTipo));
      listatipo = (ArrayList<Tipo>)criteria.list();
      if(listatipo.size() >0){
        tipo = (Tipo)listatipo.get(0);
      }
      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }


    return tipo;
    }
  
  public boolean delete(int idTipo) {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      Tipo tipo=(Tipo)sesion.get(Tipo.class, idTipo);
      sesion.delete(tipo);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}
  
public boolean update(Tipo tipo) throws Exception {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      sesion.update(tipo);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}

public int save(Tipo tipo)  throws Exception {
    int Id =-1;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
        session.save(tipo);
        Id = tipo.getIdTipo();
         tx.commit();
        }catch (HibernateException e) {
          e.printStackTrace();
          if (tx!=null) tx.rollback(); 
        }
        finally { session.close(); }
    return Id;
}
}
