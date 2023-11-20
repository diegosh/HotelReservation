/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.hibernate.util.HibernateUtil;
import hotel.pojo.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class PreciosDAO {
  
  //SELECT IdRegimen,precio FROM precio WHERE IdTipo=? AND IdTemporada=?
  
  public double precio(int temporada,int tipo,String regimen) {
    double precio = 0.0;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    ArrayList<Precio> listaprecios = new ArrayList<Precio>();
  
    try {
      tx = session.beginTransaction();

      Criteria criteria = session.createCriteria(Precio.class);
      criteria.add(Property.forName("tipo.idTipo").eq(tipo));
      criteria.add(Property.forName("temporada.idTemporada").eq(temporada));
      criteria.add(Property.forName("idRegimen").eq(regimen));
      listaprecios = (ArrayList<Precio>)criteria.list();
      if(listaprecios.size() >0) {
          precio = ((Precio)listaprecios.get(0)).getPrecio();
      }
      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }  
    return precio;
  }  
  
  public ArrayList<Precio> listaPreciosTemporada(int temporada,int tipo) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    ArrayList<Precio> listaprecios = new ArrayList<Precio>();
  
    try {
      tx = session.beginTransaction();

      Criteria criteria = session.createCriteria(Precio.class);
      criteria.add(Property.forName("tipo.idTipo").eq(tipo));
      criteria.add(Property.forName("temporada.idTemporada").eq(temporada));
      listaprecios = (ArrayList<Precio>)criteria.list();

      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }  
    return listaprecios;
  }  
  
  public ArrayList<Precio> listaPrecios() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    ArrayList<Precio> listaprecios = new ArrayList<Precio>();
  
    try {
      tx = session.beginTransaction();

      Criteria criteria = session.createCriteria(Precio.class);
      
      listaprecios = (ArrayList<Precio>)criteria.list();

      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }  
    return listaprecios;
  }  

public Precio devPrecio(int IdPrecio) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Precio> listaprecio = new ArrayList<Precio>();
  Precio precio =null;
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Precio.class);
    criteria.add(Property.forName("idPrecio").eq(IdPrecio));
    listaprecio = (ArrayList<Precio>)criteria.list();
    if(listaprecio.size() >0){
      precio = (Precio)listaprecio.get(0);
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return precio;
  }
  public boolean delete(int idPrecio) {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      Precio precio=(Precio)sesion.get(Precio.class, idPrecio);
      sesion.delete(precio);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}
  
public boolean update(Precio precio) throws Exception {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      sesion.update(precio);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}

public int save(Precio precio)  throws Exception {
    int Id =-1;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
        session.save(precio);
        Id = precio.getIdPrecio();
         tx.commit();
        }catch (HibernateException e) {
          e.printStackTrace();
          if (tx!=null) tx.rollback(); 
        }
        finally { session.close(); }
    return Id;
}
}
