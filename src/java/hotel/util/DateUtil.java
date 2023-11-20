/*
 * Copyright (C) 2016 Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package hotel.util;

/**
 *
 * @author Diego Manuel Sánchez Huelva <diegom.sanchez75@gmail.com>
 */

import java.util.Date;
import java.text.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Calendar;
        

public class DateUtil {
  
  public static Date ConvertStringtoDate(String cadenaFecha) {
    Date fecha = null;
    DateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
    try {
      fecha = ff.parse(cadenaFecha);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return fecha;
  }
  
   public static String DatetoMySQLFormat(Date fecha) {
    String cadenaFecha = "";
    DateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
    try {
      cadenaFecha = ff.format(fecha);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return cadenaFecha;
  }
  
  public static int diasEntreFechas(Date f1,Date f2) {
     return (int)(f2.getTime() - f1.getTime() )/ (1000*60*60*24);
  }
  
  public static ArrayList<Date> fechasEntreFechas(Date f1,Date f2) {
    
    ArrayList<Date> fechas = new ArrayList();
    Calendar c = Calendar.getInstance();
    c.setTime(f1);
   
    do {
      fechas.add(f1);
      c.add(Calendar.DAY_OF_YEAR,1);
      f1 = c.getTime();
    }while(f1.getTime() < f2.getTime());
    
    
    return fechas;
  }
   
}
