/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.hibernate.util.HibernateUtil;
import hotel.pojo.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Iterator;
import java.util.Date;
import java.util.Calendar;

import org.hibernate.criterion.Property;
/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class TemporadaDAO {
  
  public ArrayList<Temporada> listadotemporadas() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    ArrayList<Temporada> temporadas = new ArrayList<Temporada>();
    try {
      tx = session.beginTransaction();
      String query = "from Temporada";  
      temporadas = (ArrayList<Temporada>)session.createQuery(query).list();

      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }
    
    return temporadas;
  }
  
  public int getTemporada(Date fechaFin) {
      int idTemporada =2;
      boolean enc = false;
      
      int dia = 1;
      int mes = 1;
      
      String formatodia ="dd";
      SimpleDateFormat dateFormatdia = new SimpleDateFormat(formatodia);
      dia = Integer.parseInt(dateFormatdia.format(fechaFin));
      
      String formatomes ="MM";
      SimpleDateFormat dateFormatmes = new SimpleDateFormat(formatomes);
      mes = Integer.parseInt(dateFormatmes.format(fechaFin));
      
      
      ArrayList<Temporada> lista = this.listadotemporadas();
      if(lista.size()>0) {
          Iterator it = lista.iterator();
          while(it.hasNext() && !enc) {
              Temporada temporada = (Temporada)it.next();
              String pi = temporada.getPeriodoInicio();
              String pf = temporada.getPeriodoFin();
              String diapi = pi.substring(0, 2);
              String mespi = pi.substring(2, 2);
              String diapf = pf.substring(0, 2);
              String mespf = pf.substring(2, 2);
              
              try {
              if(dia >= Integer.valueOf(diapi)
                && dia <= Integer.valueOf(diapf)
                && mes >= Integer.valueOf(mespi)
                && mes <= Integer.valueOf(mespf)) {
                  
                  enc=true;
                  idTemporada = temporada.getIdTemporada();                  
              }    
              }
              catch(Exception e){
                 e.printStackTrace();
              }
          }
      }
      return idTemporada;
  }
  public Temporada devTemporada(int idTemporada) {
    Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Temporada> listatemporada = new ArrayList<Temporada>();
  Temporada temporada =null;
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Temporada.class);
    criteria.add(Property.forName("idTemporada").eq(idTemporada));
    listatemporada = (ArrayList<Temporada>)criteria.list();
    if(listatemporada.size() >0){
      temporada = (Temporada)listatemporada.get(0);
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return temporada;
  }
  
  public boolean delete(int idTemporada) {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      Temporada temporada=(Temporada)sesion.get(Temporada.class, idTemporada);
      sesion.delete(temporada);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}
  
public boolean update(Temporada temporada) throws Exception {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      sesion.update(temporada);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}

public int save(Temporada temporada)  throws Exception {
    int Id =-1;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
        session.save(temporada);
        Id = temporada.getIdTemporada();
         tx.commit();
        }catch (HibernateException e) {
          e.printStackTrace();
          if (tx!=null) tx.rollback(); 
        }
        finally { session.close(); }
    return Id;
}
  
  
}
