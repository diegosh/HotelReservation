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
import org.hibernate.criterion.Property;

public class ReservasDAO {
  
  public List<Reserva> misReservas(int IdCliente) throws Exception {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    List misreservas = new ArrayList<Reserva>();
    try {
      tx = session.beginTransaction();
      String hql = "from Reserva res WHERE IdCliente=:idcliente";
      hql += " ORDER BY date(res.fechaEntrada) DESC";
      Query query = session.createQuery(hql);
      query.setParameter("idcliente",IdCliente);
      misreservas = query.list();

      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }


    return misreservas;
}
  
  public List<Reserva> ListadoReservas() throws Exception {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    List listareservas = new ArrayList<Reserva>();
    try {
      tx = session.beginTransaction();
      String hql = "from Reserva";
      hql += " ORDER BY fechaEntrada DESC";
      Query query = session.createQuery(hql);      
      listareservas = query.list();

      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }


    return listareservas;
}
  public List<Reserva> ListadoReservas(Date f1,Date f2) throws Exception {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    List listareservas = new ArrayList<Reserva>();
    try {
      tx = session.beginTransaction();
      String hql = "from Reserva where fechaEntrada>=:f1 and fechaSalida <=:f2";
      hql += " ORDER BY fechaEntrada DESC";
      Query query = session.createQuery(hql);
      query.setParameter("f1",f1);
      query.setParameter("f2",f2);
      
      listareservas = query.list();

      tx.commit();

    }catch (HibernateException e) {
      e.printStackTrace();
      if (tx!=null) tx.rollback(); 
    }
    finally { session.close(); }


    return listareservas;
}
  
  public boolean delete(int idReserva) {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      Reserva reserva=(Reserva)sesion.get(Reserva.class, idReserva);
      sesion.delete(reserva);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}
  
  public boolean update(Reserva reserva) throws Exception {
    boolean correcto = true;
    
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
      tx = sesion.beginTransaction();
      sesion.update(reserva);
      tx.commit();

    }catch(HibernateException e){
      e.printStackTrace();
      if(tx!=null) tx.rollback();
      correcto=false;
    }finally{sesion.close();}
    return correcto;
}

  public int save(Reserva reserva)  throws Exception {
    int Id =-1;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
        session.save(reserva);
        Id = reserva.getIdReserva();
         tx.commit();
        }catch (HibernateException e) {
          e.printStackTrace();
          if (tx!=null) tx.rollback(); 
        }
        finally { session.close(); }
    return Id;
}

  public Reserva getReserva(int IdReserva) throws Exception {
  
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = null;
  ArrayList<Reserva> listareserva = new ArrayList<Reserva>();
  Reserva reserva =null;
  try {
    tx = session.beginTransaction();
    Criteria criteria = session.createCriteria(Reserva.class);
    criteria.add(Property.forName("idReserva").eq(IdReserva));
    listareserva = (ArrayList<Reserva>)criteria.list();
    if(listareserva.size() >0){
      reserva = (Reserva)listareserva.get(0);
    }
    tx.commit();
     
  }catch (HibernateException e) {
    e.printStackTrace();
    if (tx!=null) tx.rollback(); 
  }
  finally { session.close(); }
  
  
  return reserva;
  }
}
