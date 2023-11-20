package hotel.pojo;
// Generated 02-dic-2016 0:37:51 by Hibernate Tools 4.3.1



/**
 * Precio generated by hbm2java
 */
public class Precio  implements java.io.Serializable {


     private Integer idPrecio;
     private Temporada temporada;
     private Tipo tipo;
     private double precio;
     private String idRegimen;

    public Precio() {
    }

	
    public Precio(Temporada temporada, Tipo tipo, double precio) {
        this.temporada = temporada;
        this.tipo = tipo;
        this.precio = precio;
    }
    public Precio(Temporada temporada, Tipo tipo, double precio, String idRegimen) {
       this.temporada = temporada;
       this.tipo = tipo;
       this.precio = precio;
       this.idRegimen = idRegimen;
    }
   
    public Integer getIdPrecio() {
        return this.idPrecio;
    }
    
    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }
    public Temporada getTemporada() {
        return this.temporada;
    }
    
    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
    public Tipo getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getIdRegimen() {
        return this.idRegimen;
    }
    
    public void setIdRegimen(String idRegimen) {
        this.idRegimen = idRegimen;
    }




}

