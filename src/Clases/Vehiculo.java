package Clases;

import java.time.Year;

/**
 *
 * @author Anthony
 */
public class Vehiculo {
    
    private String placa;
    private String marca;
    private String modelo;
    private Year anio;
    private String fechaInscripcion;
    private String cedula;
    private String nombrePropietario;

    public Vehiculo(String placa, String marca, String modelo, Year anio, String fechaInscripcion, String cedula, String nombrePropietario) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.fechaInscripcion = fechaInscripcion;
        this.cedula = cedula;
        this.nombrePropietario = nombrePropietario;
    }

    public Vehiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
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

    public Year getAnio() {
        return anio;
    }

    public void setAnio(Year anio) {
        this.anio = anio;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
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
