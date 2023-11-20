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

public class EdadDAO {
  public ArrayList<Edad> listadoedad() throws Exception {
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Edad> listaedad = new ArrayList<Edad>();
  try {
    tx = session.beginTransaction();
    String query = "from Edad";  
    listaedad = (ArrayList<Edad>)session.createQuery(query).list();
    
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return listaedad;
  }
  
  public String edad(String IdEdad) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Edad> listaedad = new ArrayList<Edad>();
  String edad ="";
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Edad.class);
    criteria.add(Property.forName("idEdad").eq(IdEdad.charAt(0)));
    listaedad = (ArrayList<Edad>)criteria.list();
    if(listaedad.size() >0){
      Edad edad1 = (Edad)listaedad.get(0);
      edad = edad1.getEdad();
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return edad;
  }
  
  public Edad getEdad(String IdEdad) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Edad> listaedad = new ArrayList<Edad>();
  Edad edad =null;
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Edad.class);
    criteria.add(Property.forName("idEdad").eq(IdEdad.charAt(0)));
    listaedad = (ArrayList<Edad>)criteria.list();
    if(listaedad.size() >0){
      edad = (Edad)listaedad.get(0);      
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return edad;
  }
}
