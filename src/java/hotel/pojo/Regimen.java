package hotel.pojo;
// Generated 02-dic-2016 0:37:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Regimen generated by hbm2java
 */
public class Regimen  implements java.io.Serializable {


     private String idRegimen;
     private String regimen;
     private Set reservas = new HashSet(0);

    public Regimen() {
    }

	
    public Regimen(String idRegimen, String regimen) {
        this.idRegimen = idRegimen;
        this.regimen = regimen;
    }
    public Regimen(String idRegimen, String regimen, Set reservas) {
       this.idRegimen = idRegimen;
       this.regimen = regimen;
       this.reservas = reservas;
    }
   
    public String getIdRegimen() {
        return this.idRegimen;
    }
    
    public void setIdRegimen(String idRegimen) {
        this.idRegimen = idRegimen;
    }
    public String getRegimen() {
        return this.regimen;
    }
    
    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }
    public Set getReservas() {
        return this.reservas;
    }
    
    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }




}


