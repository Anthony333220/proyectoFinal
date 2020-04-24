
package Clases;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Cita  {
    
    private int id;
    private Date fecha;
    private String hora;
    private Vehiculo vehiculo; 
   
    public Cita(int id, Date fecha, String hora, Vehiculo vehiculo) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.vehiculo = vehiculo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }
     public boolean comprobarCitas() {
        
        return this.fecha!=null && this.hora!=null && this.vehiculo!=null;
    }
    
    

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
      public Cita() {
    
        this.fecha = null;
        this.hora = null;
        this.vehiculo = null;
       
        
    }
    
    
    
    
    
}