package Clases;

import java.sql.Date;
import java.time.Year;

/**
 *
 * @author Anthony
 */
public class Vehiculo {
    
    private int placa;
    private String marca;
    private String modelo;
    private String anio;
    private Date fechaInscripcion;
    private String cedula;
    private String nombrePropietario;

    public Vehiculo(int placa, String marca, String modelo, String anio, Date fechaInscripcion, String cedula, String nombrePropietario) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.fechaInscripcion = fechaInscripcion;
        this.cedula = cedula;
        this.nombrePropietario = nombrePropietario;
    }

    public Vehiculo(int placa) {
        this.placa = placa;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", año=" + anio + ", fechaInscripcion=" + fechaInscripcion + ", cedula=" + cedula + ", nombrePropietario=" + nombrePropietario + '}';
    }    
}
