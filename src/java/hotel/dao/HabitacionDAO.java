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
import java.util.Date;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

public class HabitacionDAO {
  public List<Habitacion> listado() throws Exception {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    List habitaciones = new ArrayList<Habitacion>();
    try {
      tx = session.beginTransaction();
      String query = "from Habitacion";  
      habitaciones = session.createQuery(query).list();

      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }
  
  
  return habitaciones;
}
  
public int numHabDisponibles(Date entrada,Date salida,int tipo) {
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  List habitaciones = new ArrayList<Habitacion>();
  int numHabitaciones = 0;
  try {
    tx = session.beginTransaction();
    
    Criteria criteria = session.createCriteria(Habitacion.class);
    criteria.add(Property.forName("tipo.idTipo").eq(tipo));
    DetachedCriteria detachedcriteria = DetachedCriteria.forClass(Ocupacion.class); 
    detachedcriteria.add(Property.forName("id.fecha").ge(entrada));
    detachedcriteria.add(Property.forName("id.fecha").lt(salida));
    detachedcriteria.setProjection(Property.forName("id.idHabitacion"));
    criteria.add(Property.forName("idHabitacion").notIn(detachedcriteri‌​a));
    Query query2 = session.createQuery("from Habitacion");
    habitaciones = criteria.list();
    
  /*String hql = "from Habitacion WHERE IdTipo=:tipo ";
  hql+= "AND idHabitacion NOT IN ";            
  hql+= "(select idHabitacion from Ocupacion WHERE fecha >=:entrada ";
  hql += "AND fecha <:salida)";
  */
  
  
  
  numHabitaciones = habitaciones.size();
  tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }  
  return numHabitaciones;
}  
public ArrayList<Habitacion> HabDisponibles(Date entrada,Date salida) {
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
  
  try {
    tx = session.beginTransaction();
    
    Criteria criteria = session.createCriteria(Habitacion.class);
    DetachedCriteria detachedcriteria = DetachedCriteria.forClass(Ocupacion.class); 
    detachedcriteria.add(Property.forName("id.fecha").ge(entrada));
    detachedcriteria.add(Property.forName("id.fecha").lt(salida));
    detachedcriteria.setProjection(Property.forName("id.idHabitacion"));
    criteria.add(Property.forName("idHabitacion").notIn(detachedcriteri‌​a));
    Query query2 = session.createQuery("from Habitacion");
    habitaciones = (ArrayList<Habitacion>)criteria.list();
    
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }  
  return habitaciones;
}
public Habitacion HabDisponible(Date entrada,Date salida,int tipo) {
  // Devuelve una habitación para asignarla a una reserva
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  List habitaciones = new ArrayList<Habitacion>();
  Habitacion habitacion = null;
  try {
    tx = session.beginTransaction();
    
    Criteria criteria = session.createCriteria(Habitacion.class);
    criteria.add(Property.forName("tipo.idTipo").eq(tipo));
    DetachedCriteria detachedcriteria = DetachedCriteria.forClass(Ocupacion.class); 
    detachedcriteria.add(Property.forName("id.fecha").ge(entrada));
    detachedcriteria.add(Property.forName("id.fecha").lt(salida));
    detachedcriteria.setProjection(Property.forName("id.idHabitacion"));
    criteria.add(Property.forName("idHabitacion").notIn(detachedcriteri‌​a));
    
    
    habitaciones = criteria.list();
    
  if(habitaciones.size() >0){
   habitacion = (Habitacion)habitaciones.get(0);
  } 
  tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }  
  return habitacion;
}  

public Habitacion getHabitacion(int idHabitacion) throws Exception {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    List habitaciones = new ArrayList<Habitacion>();
    Habitacion habitacion = null;
    try {
      tx = session.beginTransaction();
      String hql = "from Habitacion where idHabitacion=:idHabitacion";  
      Query query = session.createQuery(hql);
      query.setParameter("idHabitacion",idHabitacion);
      
      habitaciones = query.list();
      habitacion =(Habitacion)habitaciones.get(0);
      tx.commit();
    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }
  
  
  return habitacion;
}

public boolean delete(int idHabitacion) {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      Habitacion habitacion=(Habitacion)sesion.get(Habitacion.class, idHabitacion);
      sesion.delete(habitacion);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}
  
public boolean update(Habitacion habitacion) throws Exception {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      sesion.update(habitacion);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}

public int save(Habitacion habitacion)  throws Exception {
    int Id =-1;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
        session.save(habitacion);
        Id = habitacion.getIdHabitacion();
         tx.commit();
        }catch (HibernateException e) {
          e.printStackTrace();
          if (tx!=null) tx.rollback(); 
        }
        finally { session.close(); }
    return Id;
}


}
