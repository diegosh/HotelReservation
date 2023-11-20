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

public class PaxDAO {
  public ArrayList<Pax> listadopax() throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Pax> listapax = new ArrayList<Pax>();
  try {
    tx = session.beginTransaction();
    String query = "from Pax";  
    listapax = (ArrayList<Pax>)session.createQuery(query).list();
    
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return listapax;
  }
  
  public String pax(String IdPax) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Pax> listapax = new ArrayList<Pax>();
  String pax ="";
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Pax.class);
    criteria.add(Property.forName("idPax").eq(IdPax));
    listapax = (ArrayList<Pax>)criteria.list();
    if(listapax.size() >0){
      Pax pax1 = (Pax)listapax.get(0);
      pax = pax1.getPax();
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return pax;
  }
  
  public Pax getPax(String IdPax) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Pax> listapax = new ArrayList<Pax>();
  Pax pax = null;
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Pax.class);
    criteria.add(Property.forName("idPax").eq(IdPax));
    listapax = (ArrayList<Pax>)criteria.list();
    if(listapax.size() >0){
      pax = (Pax)listapax.get(0);
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return pax;
  }
}
