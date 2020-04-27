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
    private String estado;

    public Revision(Vehiculo vehiculo, Date fecha, Time hora, Tecnico tecnico, String tipoRevision, String observacione, String estado) {
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.hora = hora;
        this.tecnico = tecnico;
        this.tipoRevision = tipoRevision;
        this.observacione = observacione;
        this.estado = estado;
    }
    
    public Revision(Vehiculo vehiculo, Date fecha, Time hora, Tecnico tecnico, String observacione,String estado) {
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.hora = hora;
        this.tecnico = tecnico;
        this.observacione = observacione;
        this.estado = estado;
    }
    
    public Revision(Date fecha, Time hora, String observacione,String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.observacione = observacione;
        this.estado = estado;
    }
    
    public Revision(Date fecha) {
        this.fecha = fecha;
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

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "<Revision>" + "<Fecha>" + fecha + "</Fecha>" + "<Hora>" + hora + "</Hora>" + "<TipoDeRevision>" + tipoRevision + "</TipoDeRevision>" + 
                "<Observacione>" + observacione + "</Observacione>" + "<Estado>" + estado + "</Estado>" + "</Revision>";
    }    
}
