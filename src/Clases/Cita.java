package Clases;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Cita extends Vehiculo{
    
    private Date fecha;
    private Time hora;

    public Cita(Date fecha, Time hora, String placa) {
        super(placa);
        this.fecha = fecha;
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Cita{" + "fecha=" + fecha + ", hora=" + hora + '}';
    }
    
    
}
