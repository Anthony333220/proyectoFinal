package Clases;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Revision{
    
    private Vehiculo vehiculo;
    private Date fecha;
    private Time hora;
    private Tecnico tecnico;
    private String tipoRevision;
    private String observacione;
    private boolean estado;

    public Revision(Vehiculo vehiculo, Date fecha, Time hora, Tecnico tecnico, String tipoRevision, String observacione, boolean estado) {
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.hora = hora;
        this.tecnico = tecnico;
        this.tipoRevision = tipoRevision;
        this.observacione = observacione;
        this.estado = estado;
    }
    
    public Revision(Date fecha) {
        this.fecha = fecha;
    }
    
    public Revision(Vehiculo vehiculo, Date fecha, Time hora, Tecnico tecnico, String observacione, boolean estado) {
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.hora = hora;
        this.tecnico = tecnico;
        this.observacione = observacione;
        this.estado = estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(String tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public String getObservacione() {
        return observacione;
    }

    public void setObservacione(String observacione) {
        this.observacione = observacione;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Revision{" + "vehiculo=" + vehiculo + ", fecha=" + fecha + ", hora=" + hora + ", tecnico=" + tecnico + ", tipoRevision=" + tipoRevision + ", observacione=" + observacione + ", estado=" + estado + '}';
    }    
}
