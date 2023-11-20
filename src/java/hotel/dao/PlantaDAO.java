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

public class PlantaDAO {
  public ArrayList<Planta> listadoplanta() throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Planta> listaplanta = new ArrayList<Planta>();
  try {
    tx = session.beginTransaction();
    String query = "from Planta";  
    listaplanta = (ArrayList<Planta>)session.createQuery(query).list();
    
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return listaplanta;
  }
  
  public String planta(String IdPlanta) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Planta> listaplanta = new ArrayList<Planta>();
  String planta ="";
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Planta.class);
    criteria.add(Property.forName("idPlanta").eq(IdPlanta));
    listaplanta = (ArrayList<Planta>)criteria.list();
    if(listaplanta.size() >0){
      Planta planta1 = (Planta)listaplanta.get(0);
      planta = planta1.getPlanta();
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return planta;
  }
  
  public Planta devPlanta(int IdPlanta) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Planta> listaplanta = new ArrayList<Planta>();
  Planta planta =null;
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Planta.class);
    criteria.add(Property.forName("idPlanta").eq(IdPlanta));
    listaplanta = (ArrayList<Planta>)criteria.list();
    if(listaplanta.size() >0){
      planta = (Planta)listaplanta.get(0);
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return planta;
  }
  
public boolean delete(int idPlanta) {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      Planta planta=(Planta)sesion.get(Planta.class, idPlanta);
      sesion.delete(planta);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}
  
public boolean update(Planta planta) throws Exception {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      sesion.update(planta);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}

public int save(Planta planta)  throws Exception {
    int Id =-1;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
        session.save(planta);
        Id = planta.getIdPlanta();
         tx.commit();
        }catch (HibernateException e) {
          e.printStackTrace();
          if (tx!=null) tx.rollback(); 
        }
        finally { session.close(); }
    return Id;
}

}
