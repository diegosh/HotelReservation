/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */
public class HibernateUtil {

  private static StandardServiceRegistry serviceRegistry; 
  private static SessionFactory sessionFactory = null;

  public static SessionFactory getSessionFactory() {
    if(sessionFactory==null){
      createSessionFactory();
    }
    return sessionFactory;
  }
  private synchronized static void createSessionFactory(){
    if(sessionFactory==null){
      Configuration conf = new Configuration().configure();
      StandardServiceRegistryBuilder builder = 
        new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
      sessionFactory = conf.buildSessionFactory(builder.build());
    }
  }
}
