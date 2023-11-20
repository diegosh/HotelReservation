package hotel.pojo;
// Generated 02-dic-2016 0:37:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Temporada generated by hbm2java
 */
public class Temporada  implements java.io.Serializable {


     private Integer idTemporada;
     private String temporada;
     private String periodoInicio;
     private String periodoFin;
     private Set precios = new HashSet(0);

    public Temporada() {
    }

	
    public Temporada(String temporada, String periodoInicio, String periodoFin) {
        this.temporada = temporada;
        this.periodoInicio = periodoInicio;
        this.periodoFin = periodoFin;
    }
    public Temporada(String temporada, String periodoInicio, String periodoFin, Set precios) {
       this.temporada = temporada;
       this.periodoInicio = periodoInicio;
       this.periodoFin = periodoFin;
       this.precios = precios;
    }
   
    public Integer getIdTemporada() {
        return this.idTemporada;
    }
    
    public void setIdTemporada(Integer idTemporada) {
        this.idTemporada = idTemporada;
    }
    public String getTemporada() {
        return this.temporada;
    }
    
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
    public String getPeriodoInicio() {
        return this.periodoInicio;
    }
    
    public void setPeriodoInicio(String periodoInicio) {
        this.periodoInicio = periodoInicio;
    }
    public String getPeriodoFin() {
        return this.periodoFin;
    }
    
    public void setPeriodoFin(String periodoFin) {
        this.periodoFin = periodoFin;
    }
    public Set getPrecios() {
        return this.precios;
    }
    
    public void setPrecios(Set precios) {
        this.precios = precios;
    }




}

