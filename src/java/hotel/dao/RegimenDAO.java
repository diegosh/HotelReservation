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

public class RegimenDAO {
  public ArrayList<Regimen> listadoregimen() throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Regimen> listaregimen = new ArrayList<Regimen>();
  try {
    tx = session.beginTransaction();
    String query = "from Regimen";  
    listaregimen = (ArrayList<Regimen>)session.createQuery(query).list();
    
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return listaregimen;
  }
  
  public String regimen(String IdRegimen) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Regimen> listaregimen = new ArrayList<Regimen>();
  String regimen ="";
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Regimen.class);
    criteria.add(Property.forName("idRegimen").eq(IdRegimen));
    listaregimen = (ArrayList<Regimen>)criteria.list();
    if(listaregimen.size() >0){
      Regimen reg = (Regimen)listaregimen.get(0);
      regimen = reg.getRegimen();
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return regimen;
  }
  
  public Regimen devRegimen(String IdRegimen) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Regimen> listaregimen = new ArrayList<Regimen>();
  Regimen regimen =null;
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Regimen.class);
    criteria.add(Property.forName("idRegimen").eq(IdRegimen));
    listaregimen = (ArrayList<Regimen>)criteria.list();
    if(listaregimen.size() >0){
      regimen = (Regimen)listaregimen.get(0);
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return regimen;
  }
  
public boolean delete(String idRegimen) {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      Regimen regimen=(Regimen)sesion.get(Regimen.class, idRegimen);
      sesion.delete(regimen);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}
  
public boolean update(Regimen regimen) throws Exception {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      sesion.saveOrUpdate(regimen);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}

public String save(Regimen regimen)  throws Exception {
    String Id="";
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
        session.save(regimen);
        Id = regimen.getIdRegimen();
         tx.commit();
        }catch (HibernateException e) {
          e.printStackTrace();
          if (tx!=null) tx.rollback(); 
        }
        finally { session.close(); }
    return Id;
}

}
