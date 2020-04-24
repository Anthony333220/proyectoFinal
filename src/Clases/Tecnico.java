package Clases;

import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Tecnico {
   
    private int cedula;
    private String nombre;

    private Date fechaNacimiento;
    private int telefono;
    private String correoElectronico;
    private double salario;

    public Tecnico(int cedula, String nombre, Date fechaNacimiento, int telefono, String correoElectronico, double salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.salario = salario;
    }
     public Tecnico(){
        this.cedula = 0;
        this.nombre = null;
        this.fechaNacimiento = null;
        this.telefono = 0;
        this.correoElectronico= null;
        this.salario = 0;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int  getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectrónico() {
        return correoElectronico;
    }

    public void setCorreoElectrónico(String correoElectrónico) {
        this.correoElectronico = correoElectrónico;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    

    
    
    
}